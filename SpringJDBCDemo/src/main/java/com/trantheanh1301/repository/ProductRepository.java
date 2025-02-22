/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.repository;

import hibernate.pojo.Product;
import hibernationdemo.hibernationUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author LAPTOP
 */
public class ProductRepository {
    //Tìm kím theo tên sản phẩm  -> map để gửi như API
    public List<Product> getProducts(Map<String,String> params){
        try(Session session = hibernationUtils.getFACTORY().openSession())
        {
            CriteriaBuilder builder  =session.getCriteriaBuilder();
            CriteriaQuery<Product> q = builder.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);
            
            //Lọc theo tên 
            if(params != null){   // để tránh bị lỗi là cần ktra null trc
                //Do neu co nhieu where thi nó sẽ bị đè nhau vd như cái này không cần đk kia
                
                //nên tách ra List
                
                List<Predicate> predicates = new ArrayList<>();
                
                
            String kw = params.get("kw");
            if(kw!=null && !kw.isEmpty())
            {
                //Cũ
//                Predicate p1 = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
//                q.where(p1);
                
                //Đã add vào List
                
                predicates.add(builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw)));
               
            }
            
            
            //Khoang gia lon 
                String fromPrice = params.get("fromPrice");
            if(fromPrice!=null && !fromPrice.isEmpty())
            {
                predicates.add(builder.greaterThan(root.get("price").as(Double.class), Double.valueOf(fromPrice))); //Vì bên map value mình truyền String nên cần parse về double
            }
            
            //Khoang gia nho
            String toPrice = params.get("toPrice");
            if(toPrice!=null && !toPrice.isEmpty())
            {
                predicates.add(builder.lessThan(root.get("price").as(Double.class), Double.valueOf(toPrice))); 
            }
            
            //theo Cate
            String cateId = params.get("cateId");
             if(cateId!=null && !cateId.isEmpty())
            {
                predicates.add(builder.equal(root.get("category").as(Integer.class), Integer.valueOf(cateId))); //get("category chứ không có id vì là minhf tương tác với biến của POJO")
            }
             
             //Tới đây mới add vào where add về mảng
             
             q.where(predicates.toArray(Predicate[]::new));
             
            
             
            
            
            }
             q.orderBy(builder.desc(root.get("id")));
            
            
            
            Query query = session.createQuery(q);
            
            return query.getResultList();
            
        }
        
            
    }
    
}
