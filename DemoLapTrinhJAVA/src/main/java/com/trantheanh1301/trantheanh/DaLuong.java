/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.trantheanh;

/**
 *
 * @author LAPTOP
 */
public class DaLuong {
    
    public static void main(String[] args) {
            Runnable task1 = new DaLuongTest("a", 50);
            Thread thread1 = new Thread(task1);
            Runnable task2 = new DaLuongTest("b", 50);
            Thread thread2 = new Thread(task2);
            thread1.start();
            thread2.start();
}
    
    // Tạo pool với 2 thread cố định
//ExecutorService executor = Executors.newFixedThreadPool(2);
    
//    
//    Nếu còn trống có Thread -> Task dùng luôn không cần chờ
//    ExecutorService executor = Executors.newCachedThreadPool();
//    
//    
//    // Phương thức synchronized để đảm bảo chỉ một thread truy cập tại một thời điểm
//    public synchronized void increment() {
//        count++;
//    }
//
//    public synchronized int getCount() {
//        return count;
    
    
    
    //Dùng khi extends Thread
    
    
//    Thread thread1 = new MyTask("a", 50);
//Thread thread2 = new MyTask("b", 50);
//thread1.start();
//thread2.start();
}
