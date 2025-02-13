/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.trantheanh;

/**
 *
 * @author LAPTOP
 */ 
public class DaLuongTest implements Runnable   {  //Cách 2 : extends Thread
    private String name;
    private int times;
    public DaLuongTest(String name, int times) {
    this.name = name;
    this.times = times;
}

    @Override   // dưới vẫn giống vậy
    public void run() {
        for (int i = 0; i < this.times; i++)
        System.out.print(this.name); 
    }
    
}
