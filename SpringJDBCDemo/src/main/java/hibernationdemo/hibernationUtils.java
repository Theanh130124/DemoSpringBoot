/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernationdemo;

import hibernate.pojo.Category;
import hibernate.pojo.Product;
import hibernate.pojo.SaleOrder;
import hibernate.pojo.Tag;
import hibernate.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author LAPTOP
 */
public class hibernationUtils {
    //final chỉ tạo 1 lần không thay đổi , static để đối tượng nào cũng dùng được
    //nhớ lấy đúng của org.hibernate

    private static final SessionFactory FACTORY;

    //Chỉ chạy duy nhất và lần đầu tiên
    static {
        Configuration conf = new Configuration();

        //Cung cấp thông tin FACTORY
        Properties props = new Properties();

        props.put(Environment.DIALECT,
                "org.hibernate.dialect.MySQLDialect"); // Cho biết đang làm việc vs MySQl
        props.put(Environment.JAKARTA_JDBC_DRIVER,
                "com.mysql.cj.jdbc.Driver");
        props.put(Environment.JAKARTA_JDBC_URL,
                "jdbc:mysql://localhost:3306/saledb");
        props.put(Environment.JAKARTA_JDBC_USER, "root");
        props.put(Environment.JAKARTA_JDBC_PASSWORD, "123456");
        props.put(Environment.SHOW_SQL, "true"); // bật này để tự show câu truy vấn nó sẽ thayas đc câu truy vấn 
        //Hibernate: insert into category (description,name) values (?,?)

        conf.setProperties(props);
        
        //Sao khi đã định nghĩa pojo nhớ thêm này vào
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(User.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()) // Áp dụng cấu hình Hibernate
                .build();

        FACTORY = conf.buildSessionFactory(registry); // cung cấp thông tin cho factory
    }

    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

}
