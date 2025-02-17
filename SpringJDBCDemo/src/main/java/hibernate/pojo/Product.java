/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate.pojo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAPTOP
 */

@Getter
@Setter
@Entity
@Table(name="product")
public class Product implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String manufacturer;
    private BigDecimal price ; // lưu đc số double lớn
    @Column(name="created_date")
    @Temporal(TemporalType.DATE) // Chỉ lưu ngày
    private Date createdDate;//không có gạch dưới
    private boolean active;
    //Mặc định của ManyToOne là ERGER còn OneToMany là LAZY
    @ManyToOne(cascade = CascadeType.REMOVE)    //Cấu hình khóa ngoại -- Có fetch là EAGER thì nó tự LÊFT OUTER JOIN
    //còn muốn vẫn lấy cate -> thì cứ .getCategory()
    //cascade = CascadeType.REMOVE -> thì xóa cate thì thằng product bị xóa hết
    @JoinColumn(name="category_id") // tên khóa ngoại dưới CSDL category_id 
    private Category category; // đây là khóa ngoại là 1 đối tượng (1-n)
    @ManyToMany()//Mặc đinh là LAZY
    @JoinTable(//ManyToMany là JoinTable chứ không còn JoinColum 
     name = "prod_tag"
    , joinColumns ={@JoinColumn(name="product_id")},
    inverseJoinColumns = {@JoinColumn(name="tag_id")}) // name trong JoinTable là tên của bảng trung gian của 2 thằng dưới CSDL
    //Còn name trong JoinColumn là tên của 1 là của khóa bảng hiện tại còn inver là của thằng đối diện
    private Set<Tag> tags;
    
}
