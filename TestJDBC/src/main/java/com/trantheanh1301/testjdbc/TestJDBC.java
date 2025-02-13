/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.trantheanh1301.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author LAPTOP
 */
public class TestJDBC {

    public static void main(String[] args) throws ClassNotFoundException, SQLException { //phải cài ngoại lệ ở đây
        //B1: Nạp driver

        Class.forName("com.mysql.cj.jdbc.Driver");  //java.lang.ClassNotFoundException ngoại lệ nó sẽ quăng ra nếu không kết nối  đc
        //B3: Thực hiện truy vấn -> Xác định loại truy vấn gì để tạo Statement
        try ( //B2: Chuỗi kết nối  - cũng phải thêm ngoại lệ SQLException
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost/saleapp",
                        "root", "123456")) {
            //B3: Thực hiện truy vấn -> Xác định loại truy vấn gì để tạo Statement
//            Statement stm = conn.createStatement();
//            String query = "INSERT INTO category (name) VALUES ('DIENTHOAI') " ; // tại id tự tăng rồi khổi truyền
//            int resultset = stm.executeUpdate(query);
//            System.out.println("Kết quả chèn"+resultset);
            //b4: đống kết nối
            //là try () nguyên hàm luôn hoặc conn.close()
            
            
            Statement stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); //cho cussor tiến và chỉ cho đọc - là tham số đầu
            ResultSet resultset =  stm.executeQuery("SELECT * FROM category"); // truy vấn thao tác thì sẽ trả ra resultset còn truy vấn đn thì ra int
            
            // xuất kq ( cussor) -> nghĩa là nó sẽ đi từng dòng trong kq select
            while (resultset.next()){ // ngoài next() còn có last() , first() ... xem trong tài liệu trang 26 JDBC
                int id  = resultset.getInt("id");// hoặc lấy 1 bắt đầu từ 1 chứ không phải 9
                String name = resultset.getString("name"); // 
                System.out.printf("%d - %s\n",id,name);
            }
            
            
            //Dùng PerparedStatement -> khi cần truyền đối số và đối số truyền vào phải là ? ( cực kỳ lưu ý) -> không là bị SQL Injection
            //không cần createStatement như Statement -> gắn thằng vào conn luôn
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO receipt(create_date,user_id) VALUES(?,?)",ResultSet.TYPE_SCROLL_INSENSITIVE); // không cần truyền id  - cho tiến hoặc lùi và nhạy cảm
            //Thêm đối số vào thì cần setString , hoặc set trường nào thì set đó
            pstm.setTimestamp(1, Timestamp.valueOf("2024-11-18 01:38:27")); //vị trí bắt đầu luôn từ 1 -> giống resultset
            pstm.setInt(2, 2);
            int res = pstm.executeUpdate(); // số dòng bị ảnh hưởng còn nếu executeQuery() thì phải duyệt như trên
            System.out.println(res); //1 dòng  
            
            
            
        }
        
    }
}
