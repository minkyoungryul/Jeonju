package com.example.mkr.jeonju_bus.search.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by minkr on 2017-09-02.
 */

@Root(name = "list", strict = false)
public class BusStopList {
    @Element(name = "list")
    private BusStopData list;


}
