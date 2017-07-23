package com.connectin.Utility;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sanjana on 23/7/17.
 */
public class Utility {

    public static Map<String, String> getQueryParams(String url) {
        try {
            Map<String, String> params = new HashMap<String, String>();
                String[] query = url.split("&");
                for (String param : query) {
                    String[] pair = param.split("=");
                    String key = URLDecoder.decode(pair[0], "UTF-8");
                    String value = "";
                    if (pair.length > 1) {
                        value = URLDecoder.decode(pair[1], "UTF-8");
                    }
                        params.put(key, value);
            }
            return params;
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }
    }
}
