package com.superheropug;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.superheropug.Service.CurlVersion;
import com.superheropug.Service.RequestSender;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
public class RequestScreenController{
    @FXML
    private ChoiceBox<String> httpMethod;
    @FXML
    private Label curlVersion;
    @FXML
    private Label responseField;
    @FXML
    private Button sendButton;
    @FXML
    private TextField urlField;
    @FXML
    private ScrollPane scrollPane;

    private String[] httpMethods = {"GET","POST","PUT","PATCH","DELETE","HEAD"};
    @FXML
    public void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    public void initialize(){
        try{curlVersion.setText("Curl Installed : "+CurlVersion.getCurlVersion());} catch(Exception e){e.printStackTrace();}
        httpMethod.getItems().addAll(httpMethods);
        scrollPane.setContent(responseField);
    }
    @FXML
    public void cUrl(){
        String response = RequestSender.getSender().sendRequest(urlField.getText(), httpMethod.getValue());
        responseField.setText(response);
        
    }
    
}
