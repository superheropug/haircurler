package com.superheropug.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RequestSender {
    // This should be the smallest stub possible
    // Singleton design
    String hostStub;
    String endpoint;
    static RequestSender sender = new RequestSender();
    private RequestSender(){

    }
    public static RequestSender getSender(){
        return sender;
    }
    public String sendRequest(String url, String method){
        String ret = "";
        try{
            ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c",assembleCurlCommand(url, method));
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String next;
            next = br.readLine();
            while (next != null){
                ret = ret  +"\n   "+ next;
                next = br.readLine();
            }
            br.close();
        } catch(Exception e) {e.printStackTrace();}
        return ret;

    }
    private String assembleCurlCommand(String url, String method){
        String ret = "curl -D - ";
        if (method.equals("HEAD")){
            ret = ret + "-I ";
        } else {
            ret = ret + "-X "+ method + " ";
        }
        
        ret = ret + url + " ";
        return ret;


    }
    private String assembleCurlCommand(String url, String method, Map<String, String> headers, String body){
        String ret = "curl -D - ";
        if (method.equals("HEAD")){
            ret = ret + "-I ";
        } else {
            ret = ret + "-X "+ method + " ";
        }
        
        for (Entry header : headers.entrySet()){
            ret = ret + "-H \"" + header.getKey() + ": " + header.getValue() + "\" ";
        }
        if (!body.equals("")){
            ret = ret + "-d \'" + body + "\' ";
        }
        
        ret = ret + "\"" + url +"\"" + " ";
        return ret;


    }
    public String sendRequest(String url, String method, String headers, String body){
        body = body.replaceAll("\n", " ");
        String ret = "";
        Map<String, String> headerMap = headerMapMaker(headers);
        try{
            ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c",assembleCurlCommand(url, method, headerMap, body));
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String next;
            next = br.readLine();
            while (next != null){
                ret = ret  +"\n   "+ next;
                next = br.readLine();
            }
            br.close();
        } catch(Exception e) {e.printStackTrace();}
        return ret;

    }
    private Map<String, String> headerMapMaker(String headers){
        ArrayList<String> headerList = new ArrayList<String>();
        HashMap<String, String> headerAsMap = new HashMap<String, String>();
        String[] add = headers.split("\n");
        headerList.addAll(Arrays.asList(add));
        for (String header : headerList){
            try{
                headerAsMap.put(header.substring(0, header.indexOf(":")), header.substring(header.indexOf(":") + 1));
            } catch(Exception e) {}
            
        }
        return headerAsMap;
    }
}
