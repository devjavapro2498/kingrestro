package com.kr.kingrestro.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class KingUtils {
    private KingUtils(){
    }
public static ResponseEntity<String>  getResponseEntity(String responsemessage, HttpStatus httpstatus){
    return new ResponseEntity<String>("{\"message\":\""+responsemessage+"\"}",httpstatus);
}
}
