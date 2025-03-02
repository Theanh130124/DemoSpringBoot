/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.repository;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LAPTOP
 */
public class Test {
    public static void main(String[] args) {
                //Tao param 
        
        Map<String , String> params = new HashMap<>();
//        params.put("kw","iPhone"); // "kw" phai giong vs ben kia
//        params.put("fromPrice","10000000");
//        params.put("toPrice","20000000");
//        params.put("cateId", "1");
        
        ProductRepository p = new ProductRepository();
        p.getProducts(params).forEach(v->System.out.printf("%d-%s-%.1f\n",v.getId(),v.getName(),v.getPrice()));
    }
    }
    

