package com.spboot.demo.LogicAPI.Urlcov;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class Urlcov {
    /**
     * from "urlstring" get some JSON information and translate them into Map.
     *
     * @param urlstring the target urlstring.
     * @return the Map translated from urlstring {"lat" : "XX" , "lng" : "XXX"} .
     */
    public Map<String, Double> getPosition(String urlstring) {
        Map<String, Double> res = new HashMap<>();
        String Info = "";
        try {
            URL url = new URL(urlstring);
            URLConnection conn = url.openConnection();
            HttpURLConnection connIn ;
            if (conn instanceof HttpURLConnection) {
                connIn = (HttpURLConnection) conn;
            } else {
                return null;
            }
            BufferedReader urlin = new BufferedReader(
                    new InputStreamReader(connIn.getInputStream())
            );
            StringBuilder sb = new StringBuilder();
            String now;
            while ((now = urlin.readLine()) != null) {
                sb.append(now);
            }
            Info = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(Info);
        JSONObject jsb ;
        try {
            jsb = new JSONObject(Info);
            JSONArray jsA = jsb.getJSONArray("results");
            if (jsA.length() <= 0) {
                System.err.println("null object");
                return null;
            }
            JSONObject target = (JSONObject) jsA.get(0);
            JSONObject position = (JSONObject) target.get("location");
            Double lat = (Double) position.get("lat");
            Double lng = (Double) position.get("lng");
            res.put("lat",lat);
            res.put("lng",lng);
        } catch (JSONException e) {
            System.out.println("error json");
            e.printStackTrace();
        }
        return res;
    }
}