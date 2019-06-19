package com.g452.www.glocation.utils;

/**
 * Created by wangmh on 2018/2/7.
 * 定位的几个基本信息
 */

public class LocateInfo {
    private double longitude;
    private double Latitude;
    private boolean isChina;

    public LocateInfo() {

    }

    public LocateInfo(double longitude, double latitude) {
        this.longitude = longitude;
        Latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public boolean isChina() {
        return isChina;
    }

    public void setChina(boolean china) {
        isChina = china;
    }
}
