package com.cuiwz.web.admin;

import com.cuiwz.po.User;
import com.cuiwz.service.UserService;
import com.cuiwz.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by cuiwz on 2020/02/22.
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    // 临时解决直接通过GET方法访问"/admin/login"问题
    @GetMapping("/login")
    public String login(HttpServletRequest request) throws Exception {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/admin";
        } else {
            return "admin/index";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Utils.code(password));
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "admin/index";
        } catch (Exception e) {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "redirect:/admin";
    }
}
