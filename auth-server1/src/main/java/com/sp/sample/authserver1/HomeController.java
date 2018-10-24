package com.sp.sample.authserver1;


import com.sp.sample.authserver1.model.Todo;
import com.sp.sample.authserver1.model.User;
import com.sp.sample.authserver1.model.UserForm;
import com.sp.sample.authserver1.model.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/home")
    public Map<String, Object> home(
            @AuthenticationPrincipal UserDetails user
    ){
        Map<String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("message", "hello, jongwon");
        return response;
    }

    @GetMapping(value="/user")
    public Map<String, Object> user(
            @AuthenticationPrincipal UserDetails user
    ){
        Map<String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("message", "hello, jongwon");
        return response;
    }

    @GetMapping(value="/remoteLogin")
    public Map<String, Object> remoteLogin(
            @RequestParam(value="userId") String userId
    ){
        Map<String, Object> response = new HashMap<>();
//        response.put("user", user);
        User user = userService.getUser(userId);
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        response.put("message", "hello, jongwon");
        response.put("user", user);
        return response;
    }

    @GetMapping(value="/myWorks")
    public List<Todo> myWorks(){
        return Arrays.asList(
                new Todo("등산하기"),
                new Todo("독서 3권"),
                new Todo("찬물에 목욕하기"),
                new Todo("우주선을 타보기"),
                new Todo("잠수해서 1분 참기"),
                new Todo("큰 물고기 잡기"),
                new Todo("보트타고 무인도 가기")
        );
    }

}
