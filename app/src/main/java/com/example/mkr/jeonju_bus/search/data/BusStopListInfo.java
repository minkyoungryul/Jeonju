package com.example.mkr.jeonju_bus.search.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;

import java.util.List;

import retrofit2.http.Path;

/**
 * Created by minkr on 2017-09-02.
 */
@Root(name = "RFC30", strict = false)
public class BusStopListInfo {
    @Element(name = "code")
    private String code;
    @Element(name = "msg")
    private String msg;
    @Element(name = "routeList")
    public BusStopList routeList;

    public BusStopListInfo(){}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BusStopListInfo{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", routeList=" + routeList +
                '}';
    }
}

