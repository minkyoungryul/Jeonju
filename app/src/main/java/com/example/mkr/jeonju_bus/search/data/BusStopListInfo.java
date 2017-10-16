package com.example.mkr.jeonju_bus.search.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by minkr on 2017-09-02.
 */
@Root(name = "RFC30", strict = false)
public class BusStopListInfo {
    @Element(name = "code")
    private String code;
    @Element(name = "msg")
    private String msg;
    @ElementList(data = false, inline = false, required = false)
    public List<BusStopList> routeList;

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

//    public List<RoutList> getRouteList() {
//        return routeList;
//    }
//
//    public void setRouteList(List<RoutList> routeList) {
//        this.routeList = routeList;
//    }

    @Override
    public String toString() {
        return "BusStopListInfo{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", routeList=" + routeList +
                '}';
    }
}
