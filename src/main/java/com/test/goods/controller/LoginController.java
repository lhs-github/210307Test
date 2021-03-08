package com.test.goods.controller;


import com.test.goods.pojo.User;
import com.test.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/goods")
public class LoginController {

    @Value("${IMAGE_DIR}")
    String imageUrl;

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpSession session) {
        //int i = 10 / 0;
        System.out.println(user);
        boolean result = userService.isLogin(user);
        if (result) {
            session.setAttribute("email",user.getEmail());
            session.setAttribute("images",user.getImages());
            return "index";
        } else {
            return "error";
        }
    }

    @RequestMapping("/showLogin")
    public String showLogin() {
        return "redirect:/login.jsp";
    }

    @RequestMapping("/temp")
    public String temp(HttpSession session) {
        return "addImages";
    }

        @RequestMapping("/add")
        @ResponseBody
        public String add(User user){
            int result = userService.add(user);
            return "success";
        }

        @RequestMapping("/addImages")
        public String addImages(HttpServletRequest request, MultipartFile fileUpload, HttpSession session) throws IOException {

            // 1.获取原始的图片名
            String oldFilename = fileUpload.getOriginalFilename();

            // 2.组合新的图片名
            String suffixName = oldFilename.substring(oldFilename.lastIndexOf("."));
            String newFilename = UUID.randomUUID().toString().replace("-","")+suffixName ;

            // 3.创建日期文件夹
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dirName = sdf.format(date);
            String targetName = imageUrl + dirName;

            File file = new File(targetName);
            if (!file.exists()) {
                file.mkdirs();
            }

            // 4.文件上传
            fileUpload.transferTo(new File(targetName,newFilename));
            System.out.println(dirName);

            // 5.保存到数据库
            String email = (String) session.getAttribute("email");
            userService.updateUserImage(dirName + "/" + newFilename,email);

            return "redirect:login";

            /*
            // 以前getParameter()是不好使的, 现在springmvc是可以获取到正常输入框输入的值
            String address = request.getParameter("address");
            System.out.println("address: " + address);

            String filename = fileUpload.getOriginalFilename();
            System.out.println("filename: " + filename); // filename: 数值传值错误.PNG

            byte[] bytes = fileUpload.getBytes();
            System.out.println("bytes: " + bytes); // bytes: [B@4c3cdbba
            String contentType = fileUpload.getContentType();
            System.out.println("contentType: " + contentType); // contentType: image/png
            String name = fileUpload.getName();  // name: fileUpload
            System.out.println("name: " + name);
            long size = fileUpload.getSize();
            System.out.println("size: " + size); // size: 110248
            */
        }

        @RequestMapping("*")
        public String error404() {
            return "404";
        }


}
