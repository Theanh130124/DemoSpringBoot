/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernationdemo;

import hibernate.pojo.SaleOrder;
import hibernate.pojo.User;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author LAPTOP
 */
public class hibernationTesterv2 {
    public static void main(String[] args) {
        
    
    Session session = hibernationUtils.getFACTORY().openSession();
//    SaleOrder s = new SaleOrder();
//    s.setCreateDate(new Date(2020-02-05));
//    User u = session.get(User.class,2);
//    u.setFirstName("TheAnh");
//    u.setLastName("Tran");
//    u.setEmail("Theanhtran13012004@gmail.com");
//    u.setPhone("0933033801");
//    u.setUsername("theanh1301");
//    u.setPassword("123456");
//    u.setUserRole("ROLE_ADMIN");

//Tim kiem SaleOder theo user 7 

    User u = session.get(User.class, 7);
    u.getSaleOders().forEach(v->System.err.printf("%d - %s\n",v.getId(),v.getCreateDate()));
    
        
    
    
    session.close();
            }
}
