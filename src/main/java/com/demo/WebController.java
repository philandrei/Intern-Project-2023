/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import com.demo.User.User;
import com.demo.User.User.Status;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Phil Silla
 */
@Controller
public class WebController {

    @GetMapping("/user")
    public String getUserPage(Model model) {
        List<User> users = new ArrayList<>();
        String[] listOfUsernames = {"phil", "sample", "alfie", "tantan", "computer"};
        for (int c = 0; c < 5; c++) {
            User user = new User();

            Status status = (c / 2 == 0 ? User.Status.ACTIVE : User.Status.INACTIVE);
            user.setUsername(listOfUsernames[c]);
            user.setPassword(generateRandomAlphaNumericBySize(6));
            user.setStatus(status);
            users.add(user);
        }
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/hello")
    public String getHelloPage(Model model) {
        String hello = "Hello kitty";
        model.addAttribute("message", hello);
        return "helloworld";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/login-error")
    public String getLoginErrorPage(@RequestParam String errMessage,
            Model model) {
        model.addAttribute("errMessage", errMessage);
        return "/login";
    }

    @GetMapping("/profile")
    public String getProfilePage(@RequestParam String username,
            @RequestParam String password,
            Model model) {
        String existingUsername = "altpaynet";
        String existingPassword = "Admin12345";

        if (!username.equals(existingUsername) || !password.equals(existingPassword)) {
            return "redirect:/login-error?errMessage=Invalid Credentials";
        }
        model.addAttribute("username", username);
        return "profile";
    }

    public String generateRandomAlphaNumericBySize(int size) {
        String AlphaNumericSpecialChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz"
                + "+=@$/";

        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            int index
                    = (int) (AlphaNumericSpecialChars.length()
                    * Math.random());

            sb.append(AlphaNumericSpecialChars
                    .charAt(index));
        }
        return sb.toString();
    }

}
