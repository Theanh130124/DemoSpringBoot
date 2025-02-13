/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.trantheanh;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPTOP
 */
public class VietNamHello implements Hello {

    @Override
    public void show(String name) {
        System.out.println("XinChao"); 
    //Xong rồi đi hiện thực 
    }
     public static void main(String[] args) {
//         Hello vien = new VietNamHello(); // Viết như thế để thể hiện được tính Đa hình
//         //Có thẻ Hello frren = new FrenHello ... 
//        
//         vien.show();
//         
         
//         Hiện thực hóa interface có 1 tham số. () 
         Hello h = (name) -> System.out.println("Xin chào"+name);
         h.show("ThếAnh");
     }
         
          //Lớp mật danh cũng có thể hiện thực interface (nghĩa là nó có phần thân thôi không có tên -> không cần tách class VietNamHello này ) -> hay dùng
//          Hello vien2 = new Hello() {
//             @Override
//             public void show() {
//               System.out.println("XinChao")  ; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//             }
     
//          }
//           vien2.show();       
     

     }



