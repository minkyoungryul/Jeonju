package com.example.mkr.jeonju_bus.search.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.NodeMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by minkr on 2017-09-02.
 */
@Root(name = "RFC30", strict = false)
public class BusStopListInfo {
    @Element(name = "code")
    private String code;
    @Element(name = "msg")
    private String msg;

    @ElementList(name = "routeList")
    private List<BusStopList> routeList;

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
