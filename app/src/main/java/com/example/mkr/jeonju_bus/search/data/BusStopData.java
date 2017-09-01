package com.example.mkr.jeonju_bus.search.data;

/**
 * Created by mkr on 2017-09-01.
 */

public class BusStopData {
    private String reMark;
    private String searchFld;
    private String searchNm;
    private String stopId;
    private String stopKname;
    private String stopStandardid;
    private String stopX;
    private String stopY;

    public BusStopData(String reMark, String searchFld, String searchNm, String stopId, String stopKname, String stopStandardid, String stopX, String stopY) {
        this.reMark = reMark;
        this.searchFld = searchFld;
        this.searchNm = searchNm;
        this.stopId = stopId;
        this.stopKname = stopKname;
        this.stopStandardid = stopStandardid;
        this.stopX = stopX;
        this.stopY = stopY;
    }

    public BusStopData(){

    }

    public String getReMark() {
        return reMark;
    }

    public void setReMark(String reMark) {
        this.reMark = reMark;
    }

    public String getSearchFld() {
        return searchFld;
    }

    public void setSearchFld(String searchFld) {
        this.searchFld = searchFld;
    }

    public String getSearchNm() {
        return searchNm;
    }

    public void setSearchNm(String searchNm) {
        this.searchNm = searchNm;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopKname() {
        return stopKname;
    }

    public void setStopKname(String stopKname) {
        this.stopKname = stopKname;
    }

    public String getStopStandardid() {
        return stopStandardid;
    }

    public void setStopStandardid(String stopStandardid) {
        this.stopStandardid = stopStandardid;
    }

    public String getStopX() {
        return stopX;
    }

    public void setStopX(String stopX) {
        this.stopX = stopX;
    }

    public String getStopY() {
        return stopY;
    }

    public void setStopY(String stopY) {
        this.stopY = stopY;
    }

    @Override
    public String toString() {
        return "BusStopData{" +
                "reMark='" + reMark + '\'' +
                ", searchFld='" + searchFld + '\'' +
                ", searchNm='" + searchNm + '\'' +
                ", stopId='" + stopId + '\'' +
                ", stopKname='" + stopKname + '\'' +
                ", stopStandardid='" + stopStandardid + '\'' +
                ", stopX='" + stopX + '\'' +
                ", stopY='" + stopY + '\'' +
                '}';
    }
}
