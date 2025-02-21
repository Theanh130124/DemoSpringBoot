/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernationdemo;

import hibernate.pojo.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author LAPTOP
 */
public class TesterLab2 {
    public static void main(String[] args) {
        try(Session session = hibernationUtils.getFACTORY().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> rootP = query.from(Product.class);
            String kw = "";
            
            
    }
    
}
}
