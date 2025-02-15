/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAPTOP
 */

@Getter
@Setter
public class Question {
    private String id; //UUID
    private String content;
    private int category_id;
    
}
