/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernationdemo;


import hibernate.pojo.Category;
import hibernate.pojo.Product;
import hibernate.pojo.Tag;
import jakarta.persistence.Cache;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author LAPTOP
 */
public class hibernateTester {
    public static void main(String[] args) {
        //sesstion để làm việc với CSDL -> chỉ tồn tại trong thời gian ngắn
        
       try(Session session = hibernationUtils.getFACTORY().openSession()){ // đầy là mình gọi getFactory -> thì đây là lần đầu nó tạo và chỉ tạo duy nhât lần nầy
        
//        Category c = new Category(); // (((transient))) -> khi tạo mới đối tượng nó chưa liên kết với dòng nào dưới CSDL
//        c.setName("IPHONE 16");
//        c.setDescription("TEST HIBERNATEaaa");
//        session.getTransaction().begin(); 
//        session.persist(c);
//        session.getTransaction().commit();

//
//
//
//
//           //cập nhật lại
//           Category c1 = session.get(Category.class, 13); // ((persistent))(đã liên kết với 1 dòng
//           //dưới CSDL -> lúc này lấy lên có câu truy vấn SELECT * ....  (truyền class pojo  ,id )
//           c1.setDescription("DU LIEU DA DUOC CAP NHAT LAI");
//           
//           session.getTransaction().begin();//bật giao tác
//           session.persist(c1); // ở đây thêm 1 câu truy vấn update -> Lưu đệm vẫn chưa lưu xuong -> nào có lện UPDATE table set mới thức sự lưu
//           session.getTransaction().commit();// Thực hiện lưu xuống CSDL
        
//           //Xóa cũng cần transcion (giao tác)
//           Category c3 = session.get(Category.class, 13); //SELECT ....
//        
//           c3.setDescription("DU LIEU DA DUOC CAP NHAT LAI");
//           
//           session.getTransaction().begin();
//           session.remove(c3); 
//           session.getTransaction().commit(); //DELETE .... 
           
//           
//           
//           
//           
//           
//           //HQL -> FROM Category -> Category là pojo (là đối tượng chứ không phải bảng) nhá (mình đã liên kết vs category dưới rồi)
//           Query q = session.createQuery("FROM Category WHERE id = 1 ");
//           List<Category> cates = q.getResultList();
//           cates.forEach(v->System.out.printf("%d-%s\n",v.getId(),v.getName(),c.getDescription()));
//           
//           
//           
//        
//
////================================================
//
////Product
//
////Thêm sản phẩm theo danh mục
//        Product p  = new Product();
//        p.setName("IPAD Pro 2025");//2 thằng này là notnull nên mình bắt buộc phải trueyenf vào
//        p.setPrice(new BigDecimal(22000000));
//        
//        Category c4 = session.get(Category.class, 2); //lấy danh mục -> ở trạng thái persistent
//        
//        p.setCategory(c4);
//        session.getTransaction().begin();
//        session.persist(p);
//        session.getTransaction().commit();
//        session.close();


////Lấy Product lên nếu bên POJO là ERGER Thì nó không lười mỗi lần lấy product nó tự lấy thêm category của product đó
////        Product p = session.get(Product.class, 20);
////        System.out.println(p.getName());
//
//
//
////
//
////Lấy những sản phẩm chỉ thuộc 1 danh mục cụ thể 
////        Category c = session.get(Category.class, 2); //câu select 1
////        c.getProducts().forEach(v->System.err.printf("%d-%s\n",v.getId(),v.getName())); // Chỉ kỉ đã mappeBy mới có được dòng get Products này 
//   
//    //Tạo Product và Thuộc nhiều tag cho ManyToMany -> Nhớ phải bật giao tác
//     Product p1 = new Product();
//     p1.setName("IPHON15 PROMAX");
//     p1.setPrice(new BigDecimal(30000000));
//     
//     Category c5 = session.get(Category.class, 1);//1 câu truy vấn
//     p1.setCategory(c5);
//     
//     Set<Tag> tags = new HashSet<>(); //HashSet là mảng
//     tags.add(session.get(Tag.class, 1)); //1 câu truy vấn INSERT
//     tags.add(session.get(Tag.class, 2));//1 câu truy vấn INSERT
//     p1.setTags(tags);// thêm vào Product
//     session.getTransaction().begin(); //3 câu insert
//     session.persist(p1);
//     session.getTransaction().commit();
//     
//     
//     //Truy vấn ManytoMany từ Tag ngược về để lấy Product
//     Tag  m = session.get(Tag.class, 1);
//     m.getProducts().forEach(v->System.err.println(v.getId()));



//CriteriaBuilderQueryBuilder
//==================================================================================
        //TRUY VẤN WHERR MÀ CÓ ĐIỀU KIỆN GÌ THÌ BỎ VÀO TRONG builder này
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Product> query = builder.createQuery(Product.class);
//        Root root = query.from(Product.class);
//        query.select(root); // để từ giờ thực hiện ảnh hưởng  trên tất cả các bảng
//        
//          
//        //Tạo ra vị từ -> đk so sánh
//        //Lấy những products có chữ IPHONE hoặc Galaxy
//        
//        //Vị từ   .like (   Trường để so sánh , Trường muốn so sánh)
//        Predicate p1 = builder.like(root.get("name").as(String.class), "%Galaxy%");  //as(String.class) nhằm cho biết name trog product là dạng chuỗi
//        
//        Predicate p2 = builder.like(root.get("name").as(String.class),"%Iphone%");
//        
//        Predicate p3 = builder.lessThanOrEqualTo(root.get("pricate").as(BigDecimal.class),100000); // price < 100000
//        
//        query = query.where(builder.or(p1,p2)); //có and có between có lte , gte  , equals
//        
//        
//        
//        
//        //Tạo câu truy vấn câu vấn
//        Query q = session.createQuery(query);
//        
//        //Xuất ra ds
//        List<Product> products = q.getResultList(); //getResultList là lấy hết -> có getSingleList là lấy tahgnwf đầu 
//        products.forEach(v->System.err.printf("%d-%s\n",v.getId(),v.getName()));
        


//Truy van thong ke 
           CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
//        Root root = query.from(Product.class);
//        query = query.multiselect(builder.count(root.get("id").as(Integer.class)), builder.max(root.get("price").as(BigDecimal.class)));
//      
//        Query q = session.createQuery(query);
//        Object [] kq = (Object[]) q.getSingleResult();
//           System.out.println("Count"+kq[0]);
//            System.out.println("Max"+kq[1]);
        Root<Product> rP = query.from(Product.class);
        Root<Category> rC = query.from(Category.class);
        
            //SELECT c.name,  Count(p.id) , Max(p.id)
        query.multiselect(rC.get("name").as(String.class),builder.count(rP.get("id").as(Integer.class)),builder.max(rP.get("price").as(BigDecimal.class)));
        query.where(builder.equal(rP.get("category").as(Integer.class), rC.get("id"))); // FROM Category c INNER JOIN Product p ON c.id = p.category
        query.groupBy(rC.get("name").as(String.class)); // GROUP BY c.name
        query.orderBy(builder.asc(rC.get("name").as(String.class))); // ORDER BY c.name asc 
        Query q = session.createQuery(query);
        
        
        List <Object []> rs = q.getResultList();
        rs.forEach(k->System.out.printf("Name : %s - Count %d - Price %.2f\n",k[0],k[1],k[2]));
    
            
//
        
        

     
    }
    }
}
