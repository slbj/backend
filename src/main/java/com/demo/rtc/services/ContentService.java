package com.demo.rtc.services;

import com.demo.rtc.resources.CourseVO;
import com.demo.rtc.services.objects.RegistrationInfo;

public interface ContentService {
    boolean getUserCourseRegistrationStatus(String email, String courseId);

    RegistrationInfo getRegisteredCourses(String email);

    boolean registerCourse(String email, String courseId);

    boolean uploadCourse(CourseVO courseVO);
}
