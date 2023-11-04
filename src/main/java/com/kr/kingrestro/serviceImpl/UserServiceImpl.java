package com.kr.kingrestro.serviceImpl;

import com.kr.kingrestro.POJO.User;
import com.kr.kingrestro.constents.KingContensts;
import com.kr.kingrestro.dao.UserDao;
import com.kr.kingrestro.service.UserService;
import com.kr.kingrestro.utils.KingUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
@Autowired
    UserDao userDao;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        System.out.println("Inside signUp" +requestMap);
        try {
            if(requestValidateMap(requestMap)){
                User user= userDao.findByEmailId(requestMap.get("email"));
                if(Objects.isNull(user)){
                    userDao.save(getUserRequestMap(requestMap));
                    return KingUtils.getResponseEntity(KingContensts.SUCESSFULLY_REGISTERED,HttpStatus.OK);
                }else {
                    return KingUtils.getResponseEntity(KingContensts.Email_Id_Already_EXISTS,HttpStatus.BAD_REQUEST);
                }

            }else {
                return KingUtils.getResponseEntity(KingContensts.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
           e.printStackTrace();
        }

return KingUtils.getResponseEntity(KingContensts.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean requestValidateMap(Map<String,String> requestMap){
        if(requestMap.containsKey("name")&& requestMap.containsKey("contactNumber") && requestMap.containsKey("email")&& requestMap.containsKey("password") ){
            return  true;
        }else {
            return  false;
        }
    }

    private User getUserRequestMap(Map<String,String> requestMap){
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");
        return  user;
    }
}
