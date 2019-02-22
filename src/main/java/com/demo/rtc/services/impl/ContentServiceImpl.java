package com.demo.rtc.services.impl;

import com.demo.rtc.db.DBClient;
import com.demo.rtc.db.DBDao;
import com.demo.rtc.resources.CourseVO;
import com.demo.rtc.services.ContentService;
import com.demo.rtc.services.objects.RegistrationInfo;

public class ContentServiceImpl implements ContentService {

    DBClient dbClient = new DBDao();

    @Override
    public boolean getUserCourseRegistrationStatus(String email, String courseId) {
        return dbClient.getUserCourseRegistrationStatus(email, courseId);
    }

    @Override
    public RegistrationInfo getRegisteredCourses(String email) {
        return dbClient.getRegisteredCourses(email);
    }

    @Override
    public boolean registerCourse(String email, String courseId) {
        return dbClient.registerCourse(email, courseId);
    }

    @Override
    public boolean uploadCourse(CourseVO courseVO) {
        return dbClient.uploadCourse(courseVO);
    }
}
