/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAPTOP
 */

//3 điều kiện để là persistentClass -> có getter setter , Constructor 0 tham số , k đc kế thừa lớp nòa

@Getter
@Setter

//Gán này để biết nó là 1 persistentClass tên name là tên của bảng dưới CSDL
@Entity
@Table(name="category") //phải luôn có implements Serializer cho mọi pojo -> để truyền khai internet đc
public class Category implements Serializable {
    @Id   // dưới nó để biết là khóa chính 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // chỉ định nếu như Id tự tặng Auto Incretment
//    @Column(name="id") //Chỉ để biết cột nào
    private int id;
//    @Column(name="name", length = 100 , nullable = false)
    private String name;
//    @Column(name="description")
    private String description;

    //Nhưng kể từ hibernate 5. trở đi là nếu name = " " trúng với dưới bản thì khỏi cần column
    
    //Cần cấu hình bên One-to-Many lại để nó biết 2 bảng lk
    //mappeBy sẽ link tới tên của ManyToOne bên kia 
    @OneToMany(mappedBy ="category" ) // mặc định thằng này là LAZY - Khác với ManyToOne là ERGER
    private Set<Product> products ;//mappedBy tên mình dùng trên code là category chứ không phải category_id nha
    public Category() {
    }
    
    
    
}
