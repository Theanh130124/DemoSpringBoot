/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trantheanh1301.trantheanh;

/**
 *
 * @author LAPTOP
 */
public class PhanSo {
    private int tu,mau;

    public PhanSo() {
    }

    @Override
    public String toString() {
        return String.format("%d/%d", tu,mau); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    

    public PhanSo(int tu, int mau) {
        this.tu = tu;
        this.mau = mau;
    }

    /**
     * @return the tu
     */
    public int getTu() {
        return tu;
    }

    /**
     * @param tu the tu to set
     */
    public void setTu(int tu) {
        this.tu = tu;
    }

    /**
     * @return the mau
     */
    public int getMau() {
        return mau;
    }

    /**
     * @param mau the mau to set
     */
    public void setMau(int mau) {
        this.mau = mau;
    }

}
