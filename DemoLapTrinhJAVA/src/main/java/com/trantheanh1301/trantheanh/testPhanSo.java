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
public class testPhanSo {
    public static void main(String[] args) {
            //Test Phân số
        List<PhanSo> ps = new ArrayList<>();
        ps.add(new PhanSo(3,4));
        ps.add(new PhanSo(4,6));
        ps.sort((ps1,ps2)->{
            int t1 = ps1.getTu()*ps2.getMau();
            int t2 = ps1.getMau()*ps2.getTu();
            return t1-t2;
        }
        );
        ps.forEach((PhanSo t)-> System.out.printf("%s\t",t)); // phải có toString bên kia bên class PhanSo
        
          
    }
}
