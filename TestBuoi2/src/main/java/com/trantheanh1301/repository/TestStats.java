/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.repository;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LAPTOP
 */
public class TestStats {
    public static void main(String[] args) throws ParseException {
        StatsRepository stats = new StatsRepository(); // 
        Map<String ,String> params = new HashMap<>();// Tìm kiếm thì để LinkedMap ???
        
//        params.put("fromDate", "2020-11-16");
//        params.put("toDate", "2020-11-18");

//Qúy 1 năm 2020
        params.put("quarter", "2");
        params.put("year", "2020");
        stats.stats(params).forEach(v-> System.out.printf("%d-%s-%d\n",v[0],v[1],v[2]));
    }
    
}
