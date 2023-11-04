package com.kr.kingrestro.restImpl;

import com.kr.kingrestro.constents.KingContensts;
import com.kr.kingrestro.rest.UserRest;
import com.kr.kingrestro.service.UserService;
import com.kr.kingrestro.utils.KingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {
    @Autowired
    UserService userService;
    @Override
    public ResponseEntity<String> signup(@RequestBody(required = true) Map<String, String> requestMap) {
        try{
            return  userService.signUp(requestMap);
        }catch (Exception e){
            System.out.println("Exception Message" +e);
        }

return  KingUtils.getResponseEntity(KingContensts.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
