package com.demo.rtc.resources;

import com.demo.rtc.services.IdentityService;
import com.demo.rtc.services.impl.IdentityServiceImpl;
import com.demo.rtc.services.objects.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/identity")
public class IdentityResource {

    IdentityService identityService = new IdentityServiceImpl();

    @Path("/login/pwd/user")
    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response login(String requestJsonStr) {
        String jsonResponse;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LoginRequestVO loginRequestVO = objectMapper.readValue(requestJsonStr, LoginRequestVO.class);
            UserInfo userInfo = identityService.loginWithPwd(loginRequestVO.getEmail(), loginRequestVO.getPassword());

            if (userInfo == null) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
            jsonResponse = objectMapper.writeValueAsString(userInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().entity(jsonResponse).build();
    }

    @Path("/signup/pwd/user")
    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response signup(String requestJsonStr) {
        String jsonResponse = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SignupRequestVO signupRequestVO = objectMapper.readValue(requestJsonStr, SignupRequestVO.class);
            jsonResponse = objectMapper.writeValueAsString(identityService.signupWithPwd(signupRequestVO));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.ok().entity(jsonResponse).build();
    }

}
