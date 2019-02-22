package com.demo.rtc.services;

import com.demo.rtc.resources.SignupRequestVO;
import com.demo.rtc.services.objects.UserInfo;

public interface IdentityService {
    UserInfo loginWithPwd(String email, String password);

    UserInfo signupWithPwd(SignupRequestVO signupRequestVO);
}
