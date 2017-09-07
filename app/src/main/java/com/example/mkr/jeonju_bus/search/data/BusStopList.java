package com.example.mkr.jeonju_bus.search.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by minkr on 2017-09-02.
 */

@Root(name = "routeList", strict = false)
public class BusStopList {
    @ElementList(name = "list")
    private List<BusStopData> list;

//    public BusStopData getObject() {
//
//        return object;
//    }
//
//    public void setObject(BusStopData object) {
//        this.object = object;
//    }

    @Override
    public String toString() {
        return "BusStopList{" +
                "list=" + list +
                '}';
    }
}
