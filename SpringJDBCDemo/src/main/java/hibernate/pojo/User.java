/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private int id;
    private String firstName;
    private String lasrName;
    private String email;
    private String phone ;
    private String username;
}
