/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.trantheanh1301.springjdbcdemo;

import com.trantheanh1301.services.QuestionServices;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


/**
 *
 * @author LAPTOP
 */
public class SpringJDBCDemo {

    public static void main(String[] args) throws SQLException {
        
        
        Scanner sc = new Scanner(System.in);
        
        
        //Dùng Spring JDBC thay vì JDBC  vì giảm tải các câu lệnh ( ví dụ như các câu lệnh kết nối hoặc đóng kết nối , hỗ trợ xử lý ngoại lệ ) 
   
        //JDBC Template là lớp quan trọng nhất để dùng tương tác vs Spring JDBC (nó cung cấp các API)
        
        //Cấu hình bean trước
     
        try(Connection conn = JDBCUtils.getConn()){
//                //Vì mình dùng stored procudureser -> nên mình gọi CallableStatement
//                CallableStatement stm = conn.prepareCall("{CALL getQuestion(?)}");
//                stm.setString(1,"Wishing");  // trả ra danh sách nên trả ra ResultSet -> dùng executeQuerry -> còn out á thì dùng execute ;
//                ResultSet  res = stm.executeQuery();
//                while(res.next()){
//                    
//                   String content =  res.getString("content");
//                    System.out.println(content);
//                }
//                CallableStatement stm2 = conn.prepareCall("{CALL getCountQuestionbyCate(?,?) }");
//                
//                stm2.setInt(1, 3);// truyền vào cateId là 2 -> nữa cho người dùng truyền vào
//                stm2.registerOutParameter(2, Types.INTEGER);
//                //truyền out nên lấy execute
//                stm2.execute();
//                //trả về count nên in ra luôn
//                int rs = stm2.getInt(2);//OUT mình truyền vào số 2
//                System.out.println("Số lương câu hỏi theo danh mục 2 là "+rs);
                

///Test CALL getCountQuestionbycateName

       CallableStatement stm = conn.prepareCall("{CALL getCountQuestionbycateName(?)}");
       stm.setString(1, "Verb");
       ResultSet res = stm.executeQuery();
       while(res.next()){
           System.out.printf("%d - %s -  So luong question : %d\n",res.getInt("id"),res.getString("name"),res.getInt("SL_Question"));
       }

               }








//List nên mình phải in ra

   //getQuestion truyền 2 để chỉ lấy 2 câu
//                QuestionServices.getQuestion(2).forEach(v->{
//                    System.out.println(v.getContent());
//                    for ( int i = 0 ; i < v.getChoices().size() ; i++)
//                    {
//                        System.out.printf("%d-%s\n",i+1,v.getChoices().get(i).getContent()); //get(i) để lấy từng đối tượng / 
//                    }
//                    
//                       System.out.println("Lua chon cua ban la :");
//                
//                int index = sc.nextInt();
//                
//                if(v.getChoices().get(index-1).isCorrect()==true){
//                    System.out.println("BAN TRA LOI DUNG !!!");
//                    
//                }
//                else {
//                    System.out.println("BAN TRA LOI SAI !!!");
//                }
//                }); //trả ra là đối tượng có thể toString hoặc là getContent -> dùngGetter
             
                
        }
    
    }
//}
