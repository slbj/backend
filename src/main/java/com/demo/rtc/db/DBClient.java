package com.demo.rtc.db;

import com.demo.rtc.resources.CourseVO;
import com.demo.rtc.resources.SignupRequestVO;
import com.demo.rtc.services.objects.RegistrationInfo;

public interface DBClient {
    UserVO loginWithPassword(String email, String password);

    boolean signupWithPassword(SignupRequestVO signupRequestVO);

    RegistrationInfo getRegisteredCourses(String email);

    boolean registerCourse(String email, String courseId);

    boolean uploadCourse(CourseVO courseVO);

    boolean getUserCourseRegistrationStatus(String email, String courseId);
}
