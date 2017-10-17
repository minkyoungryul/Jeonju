package com.example.mkr.jeonju_bus.search.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by minkr on 2017-09-02.
 */

@Root(name = "routeList", strict = false)
public class BusStopList{

    @Element(name = "list")
    private BusStopData list;
}