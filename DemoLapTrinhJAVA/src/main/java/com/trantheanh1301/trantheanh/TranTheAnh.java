/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.trantheanh1301.trantheanh;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author LAPTOP
 */
public class TranTheAnh {

    public static void main(String[] args) {
        List<Integer>  list = Arrays.asList(3,4,2,2,4,5,6,4);
        
        Collections.sort(list); // sắp xếm giảm thêm sau list ,  Collections.reverseOrder()
        list.forEach(v -> System.out.print(v));
        
        System.out.println("Max"+Collections.max(list));
        System.out.println("min"+Collections.min(list));
        
        
        //Xáo trộn
        Collections.shuffle(list);
        list.forEach(v -> System.out.print(v));
        
        //Đếm tần số xuất hiện
        System.out.println( Collections.frequency(list, 2)); //Số lần xuấy hiện của 2 trong danh sách ? 
        
        
        Collections.nCopies(3, 999).forEach(v -> System.out.print(v)); // trả list 3 phần tử đều là 999
        
        //Đặt giá trị vào các phần tử
        
        Collections.fill(list, 1); // Integer thì chỉ thêm int
    
        List<Integer> ds = new LinkedList<>(); // muốn addFist là addLast thì LinkedList<Interger> ds = new ....
        ds.add(5);
        ds.addAll(Arrays.asList(3,4,5));   // addAll chỉ add collection như ArrayList , List ......
        ds.forEach(v->System.out.print(v));
        
        
        Set<Integer> so = new HashSet<>();
        so.add(1);
        so.add(1); // chỉ xuất hiện 1 
        System.out.println(so); // Mảng á nên foreach nhá
        
        Map<String,String> map = new HashMap<>();// Mảng á nên foreach nhá
        map.put("Apple","Táo" );
        //lấy kích thước
        
        System.out.println(map.size());
        
        //lấy ds key
        System.out.println(map.keySet());// Mảng á nên foreach nhá
        //lấy ds values
        System.out.println(map.values());// Mảng á nên foreach nhá
        //Tìm valuues theo key
        
        System.out.println(map.get("Apple"));
        //Xóa theo key
//        System.out.println(map.remove("Apple"));// Mảng á nên foreach nhá
        
        map.forEach((k,v)->{
            System.out.printf("Key = %s , Value = %s\n",k,v);
        });
        
}
    
    
    
   
}
//class PhanSo  implements Comparable<PhanSo> {
////Chỉ nó cách so sánh
//    @Override
//    public int compareTo(PhanSo o) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    }


