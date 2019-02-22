package com.demo.rtc.services.objects;

import java.util.List;

public class RegistrationInfo {
    private String email;
    private List<String> registeredCourses;

    public RegistrationInfo(String email, List<String> registeredCourses) {
        this.email = email;
        this.registeredCourses = registeredCourses;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }
}
