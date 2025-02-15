/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.services;

import com.trantheanh1301.pojo.Question;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author LAPTOP
 */
public class QuestionServices {
    
//    Làm việc với Spring JDBC
    
    
    //Lấy gỗ lên
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    //ClassPathXml .... là nó lấy trong target(là tập tin mình build xong) nó sẽ ở classes
    
    private static JdbcTemplate t = (JdbcTemplate) ctx.getBean("t");
    //Cái này đã ép kiểu rồi -> "t" là phải đúng với tên đã đặt trong XML
    public static List<Question> getQuestion(){
        //Do SELECT * FROM question trả về rs và count 
        return t.query("SELECT * FROM question", (rs,count)->{
            Question q = new Question();
            q.setId(rs.getString("id")); // lấy id trong rs mình truy vấn đc để gán vào đối tượng để hiển thị lên
            q.setContent(rs.getString("content"));
            q.setCategory_id(rs.getInt("category_id"));
            return q ; // chỉ cần trả ra q có nhiều q thì List<> nó tự xử không cần trả ra List
        });
    }
    
}
