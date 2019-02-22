package com.demo.rtc.services.impl;

import com.demo.rtc.db.DBClient;
import com.demo.rtc.db.DBDao;
import com.demo.rtc.db.UserVO;
import com.demo.rtc.resources.SignupRequestVO;
import com.demo.rtc.services.IdentityService;
import com.demo.rtc.services.objects.UserInfo;

public class IdentityServiceImpl implements IdentityService {
    DBClient dbClient = new DBDao();

    @Override
    public UserInfo loginWithPwd(String email, String password) {
        UserVO userVO = dbClient.loginWithPassword(email, password);
        if (userVO == null) {
            return null;
        }
        UserInfo userInfo = new UserInfo(userVO.getEmail(), userVO.getDisplayName());
        return userInfo;
    }

    @Override
    public UserInfo signupWithPwd(SignupRequestVO signupRequestVO) {
        boolean isUserCreated = dbClient.signupWithPassword(signupRequestVO);

        UserVO userVO = dbClient.loginWithPassword(signupRequestVO.getEmail(), signupRequestVO.getPassword());
        UserInfo userInfo = new UserInfo(userVO.getEmail(), userVO.getDisplayName());
        return userInfo;
    }
}
