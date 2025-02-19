/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAPTOP
 */
@Getter
@Setter
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;
    private String email;
    private String phone ;
    private String username;
    private String password;
    private boolean active;
    //Coi co de enum khong
    @Column(name="user_role")
    private String userRole;
    //File ?
    private String avatar;
    
    
        //1 USER cos nhieu don hang
    @OneToMany(mappedBy = "user")
    private Set<SaleOrder> saleOders;
}
