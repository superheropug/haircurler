package com.superheropug.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
                ret = ret  + next;
                next = br.readLine();
            }
            br.close();
        } catch(Exception e) {e.printStackTrace();}
        return ret;

    }
    private String assembleCurlCommand(String url, String method){
        String ret = "curl ";
        ret = ret + "-X "+ method + " ";
        ret = ret + url + " ";
        return ret;


    }
}
