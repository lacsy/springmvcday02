package com.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author la
 * @date 2020/4/2 - 21:51
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回字符串
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("执行了");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("lala");
        user.setPassword("123");
        user.setAge(12);
        //model对象
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * void
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行void");
        //编写请求转发程序
   // request.getRequestDispatcher("/WEB-INFO/pages/success.jsp").forward(request,response);

    //重定向
  //  response.sendRedirect(request.getContextPath()+"/index.jsp");


    //设置中文乱码
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=utf-8");
    //直接进行响应
    response.getWriter().print("黎熬");
    return;
    }

    @RequestMapping("/textModelAndView")
    public ModelAndView textModelAndView(){
        System.out.println("执行了");
        //创建ModelAndView对象
        ModelAndView modelAndView =new ModelAndView();
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("lala");
        user.setPassword("123");
        user.setAge(12);

        //把user对象存储到mv对象中，也会把user对象存入到request对象
        modelAndView.addObject("user",user);

        //跳转到哪个页面
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 模拟异步请求响应
     * @param user
     */
    @RequestMapping("/testAjax")

    public @ResponseBody User testAjax(@RequestBody User user){
    System.out.println("ajax");
    //客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到User对象里面
    System.out.println(user);
    //做响应，模拟查询数据库
        user.setUsername("las");
        user.setAge(20);
        //做响应
    return user;

}
}
