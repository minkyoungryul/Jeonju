package com.example.mkr.jeonju_bus.util;

/**
 * Created by mkr on 2017-08-21.
 */

public class Variable {
//    public final static String _SERVER_HOST = "http://catchadev.com/";
//    public final static String _SERVER_URL = _SERVER_HOST + "json/query.php";

    public final static String _SERVER_HOST = "http://openapi.jeonju.go.kr/jeonjubus/openApi/traffic/";
    public final static String _SERVICE_KEY = "iFwliBu1jhkPtsNQA1gvnrmONFzxyPQzcTSKFnY8rlgryyZ8scW8wzL6m89bOipf7mBo%2FdptZLTDyvNH1dKCbQ%3D%3D";
    public final static String _SERVER_REQUEST_URL = "bus_location2_stopnm_common.do";
    public final static String _ALL_BUS_STOP_URL = _SERVER_HOST + "bus_location2_stopnm_common.do?ServiceKey=" + _SERVICE_KEY;
}
