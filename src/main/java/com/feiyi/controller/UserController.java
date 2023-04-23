package com.feiyi.controller;

import com.feiyi.domain.Role;
import com.feiyi.domain.User;
import com.feiyi.exceptions.InnertalException;
import com.feiyi.service.TokenService;
import com.feiyi.service.UserService;
import com.feiyi.utils.FileLoad;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;
    @Value("${upload.dir}")
    private String uploadDir;

    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        User u = userService.findUser(user);
        JSONObject jsonObject = new JSONObject();
        System.out.println(u);
        if (u == null) {
            jsonObject.put("msg", "账号或密码错误");
            jsonObject.put("code", 500);
        } else {
            if(u.getRoleId() == 1)
                jsonObject.put("role",1);
            else
                jsonObject.put("role",2);
            user = u;
            System.out.println(user);
            String token = tokenService.getToken(user);
            jsonObject.put("token", token);
            jsonObject.put("user", user);
            jsonObject.put("msg", "登录成功");
            jsonObject.put("code", 200);
        }
        return jsonObject;
    }

    //添加照片
    @PostMapping("/register")
    public Object register(@RequestParam(value = "file") MultipartFile file, User user) throws InnertalException {
        if(file != null){
            try {
                user.setPic(Base64.encodeBase64String(file.getBytes())); ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        User user1= userService.findUserByName(user.getUsername());
        JSONObject jsonObject = new JSONObject();
//        System.out.println(user1);
        //不存在，可以正确注册
        if(user1==null){
            user.setStatus(0);//表示用户注册之后默认为通过
            user.setCreated_date(new Date());//注册日期为当前
            String token = tokenService.getToken(user);
            jsonObject.put("token", token);
            jsonObject.put("user", user);
            jsonObject.put("msg", "注册成功");
            jsonObject.put("code", 200);
            userService.addUser(user);
        }else{
            jsonObject.put("msg", "注册失败，用户名重复");
            jsonObject.put("code", 500);
        }
        return jsonObject;
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        List<User> list = userService.findAllUser();
        int age;
        for(int i = 0;i<list.size(); i++)
        {
            age = new Date().getYear() - list.get(i).getBirthday().getYear();
            list.get(i).setAge(age);
        }
        return list;
    }

    @PostMapping("/addUser")
    public Object addUser(@RequestParam(value = "file") MultipartFile file, User user) throws InnertalException {
        if(file != null){
            try {
                user.setPic(Base64.encodeBase64String(file.getBytes())); ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        User user1= userService.findUserByName(user.getUsername());
        JSONObject jsonObject = new JSONObject();
//        System.out.println(user1);
        //不存在，可以正确注册
        if(user1==null){
            //user.setStatus(2);//表示用户注册之后默认为未审核状态
            user.setPassword("88888888");
            user.setCreated_date(new Date());//注册日期为当前
            jsonObject.put("user", user);
            jsonObject.put("code", 200);
            userService.addUser(user);
        }else{
            jsonObject.put("code", 500);
        }
        return jsonObject;
    }

    @GetMapping("/getRole")
    public List<Role> findAllRole(){

        return userService.findAllRole();
    }

    @GetMapping("/editUser")
    public User editUser(int userId){
        return userService.findById(userId);
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user) throws InnertalException{
        user.setFinal_date(new Date());
        System.out.println(user);
        userService.updateUserById(user);
        return "保存成功";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestBody User user){
        userService.deleteById(user.getId());
        return "删除成功";
    }
}
