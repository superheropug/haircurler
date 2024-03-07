package com.superheropug.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CurlVersion {
    

    public static String getCurlVersion() throws IOException{
        ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","curl -V");
        Process p = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        line = br.readLine();
        while (line != null && ! line.contains("curl")){
            line = br.readLine();
        }
        br.close();
        if (line == null){return "No CURL installation detected";}
        return line;
    }
}
