/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.services;

import com.trantheanh1301.pojo.Choice;
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
    public static List<Question> getQuestion(int n){ //để phân trang đi kèm với LIMIT
        //Do SELECT * FROM question trả về rs và count 
        return t.query("SELECT * FROM question LIMIT ?", (rs,count)->{
            Question q = new Question();
            
            //Khi thêm dòng này để kiểu APi nó trả ra các choice của 1 ques theo ques_id
            String id = rs.getString("id"); 
            
            //Phải set vào q để hiện trên API
            
            q.setId(id); // lấy id trong rs mình truy vấn đc để gán vào đối tượng để hiển thị lên
            q.setContent(rs.getString("content"));
            q.setCategory_id(rs.getInt("category_id"));
            
            //đây là list choices theo ques_id đã thêm bên dưới
            q.setChoices(getChoiceByQues(id));
            
            return q ; // chỉ cần trả ra q có nhiều q thì List<> nó tự xử không cần trả ra List
        },n);
        
        //Lấy danh sách lựa chọn của câu hỏi -> dùng thẳng cho cái trên luôn
    }
    public static List<Choice> getChoiceByQues(String question_id){
        return t.query("SELECT * FROM choice WHERE question_id =?",(rs,count) -> {
            Choice c = new Choice();
            c.setId(rs.getString("id"));
            c.setContent(rs.getString("content"));
            c.setCorrect(rs.getBoolean("is_correct"));
            c.setQuestion_id(question_id);                                                                                      // chổ này cho ngta điền nên không gán rs vào
            return c;
        }, question_id );                                                                                              //question_id sẽ tự là ? 
    
    
}
}

