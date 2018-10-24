package com.sp.sample.authserver1.model;


import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    public static HashMap<String, User> userMap = new HashMap<>();

    static {
        userMap.put("jongwon1", new User("jongwon1", "test1"));
        userMap.put("jongwon2", new User("jongwon2", "test2"));
        userMap.put("jongwon3", new User("jongwon3", "test3"));
        userMap.put("jongwon4", new User("jongwon4", "test4"));
        userMap.put("jongwon5", new User("jongwon5", "test5"));
    }

    public User getUser(String userId){
        return userMap.get(userId);
    }

}
