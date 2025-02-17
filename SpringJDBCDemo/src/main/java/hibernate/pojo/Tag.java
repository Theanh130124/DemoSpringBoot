/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAPTOP
 */
@Setter
@Getter
@Entity
@Table(name="Tag")
public class Tag implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    private String name;
    private String tagcol;
    //Many-to-many
    @ManyToMany(mappedBy = "tags") // mappedBy của nó hơi khác là tên của thằng thuộc tính mình code
    private Set<Product> products;
}
