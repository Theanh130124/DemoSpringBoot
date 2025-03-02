/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.repository;

import com.trantheanh1301.hibernate.hibernationUtils;
import com.trantheanh1301.pojo.Category;
import com.trantheanh1301.pojo.OrderDetail;
import com.trantheanh1301.pojo.Product;
import com.trantheanh1301.pojo.SaleOrder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author LAPTOP
 */
public class StatsRepository {
    
    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    
    

    //sesstion để làm việc với CSDL -> chỉ tồn tại trong thời gian ngắn
    // đầy là mình gọi getFactory -> thì đây là lần đầu nó tạo và chỉ tạo duy nhât lần nầy
//Thống kê doanh thu -> của từng dòng sản phẩm ( từng  product)
    // -> nua nho tach thanh 1 ham 
    public List<Object[]> stats(Map<String, String> params) throws ParseException {

        try (Session session = hibernationUtils.getFACTORY().openSession()) {

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

            Root<Product> rP = query.from(Product.class);
            Root<OrderDetail> rD = query.from(OrderDetail.class);
            //Do muốn thống kê thêm theo ngày tháng ( mà ngày tháng thì trên bảng SaleOrder
            Root<SaleOrder> rS = query.from(SaleOrder.class);

            //SELECT Product va tinh tong tien (prod la phep nhan)
            query.multiselect(rP.get("id"), rP.get("name"), builder.sum(builder.prod(rD.get("unitPrice"), rD.get("quantity"))));
//        query.where(builder.equal(rD.get("productId").as(Integer.TYPE), rP.get("id")));

            List<Predicate> predicates = new ArrayList<>();
            //JOIN Product với cả order detail
            predicates.add(builder.equal(rD.get("productId").as(Integer.TYPE), rP.get("id")));
            //JOIN Oderdetail với cả SaleOrder
            predicates.add(builder.equal(rD.get("orderId").as(Integer.class), rS.get("id")));
            
            
            if(params!=null) {
            
            String fd = params.get("fromDate");
            String td = params.get("toDate");
            
            
            
            if(fd !=null && !fd.isEmpty())
            {
                 // gõ xong add ngoại lệ
                predicates.add(builder.greaterThanOrEqualTo(rS.get("createdDate"),FORMAT.parse(fd))); //FORMAT này là do mình tự định nghĩa ở trên
            }
            if(td !=null && !td.isEmpty())
            {
                 // gõ xong add ngoại lệ
                predicates.add(builder.lessThanOrEqualTo(rS.get("createdDate"),FORMAT.parse(td)));
            }
            
            }
            //Thống kê theo quý -> 
            
            //-> mình đang lấy 1 quý gồm có tháng và năm nào (đầu tiên phải có năm trước) .
            //builder.function mình chỉ cần ghi "QUATER" nó tự lấy quý cho mình luôn
            
            String quarter = params.get("quarter");
            if(quarter !=null && !quarter.isEmpty())
            {
                String year = params.get("year");
                if (year !=null && !year.isEmpty())
                {
                    //Trong này mình sẽ so sánh Qúy và năm từ function và mình truyền vào
                    predicates.addAll(Arrays.asList(
                            builder.equal(builder.function("YEAR", Integer.class, rS.get("createdDate")), Integer.valueOf(year)),
                            builder.equal(builder.function("QUARTER", Integer.class, rS.get("createdDate")), Integer.valueOf(quarter))
                    ));
                    
                }
            }
          //builder.function("YEAR", Integer.class, rS.get("createdDate")) LÀ NĂM MÀ FUNCTION LẤY RA
            
            
            
            query.where(predicates.toArray(Predicate[]::new));
            query.groupBy(rP.get("id"));

            Query q = session.createQuery(query);

//
            return q.getResultList();

        }

    }
}
// rs.forEach(k->System.out.printf("Id : %s - Name: %s - Total: %d \n", k[0], k[1], k[2]));
