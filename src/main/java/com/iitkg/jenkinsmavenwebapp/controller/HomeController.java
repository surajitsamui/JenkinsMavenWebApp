/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkg.jenkinsmavenwebapp.controller;

import com.iitkg.jenkinsmavenwebapp.dao.UserDAO;
import com.iitkg.jenkinsmavenwebapp.model.User;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Surajit
 */
@Controller
public class HomeController {

    @Autowired
    @Qualifier("userDAOImpl")
    private UserDAO userDao;

    @RequestMapping(value = "/userList")
    public ModelAndView home() throws IOException {
        List<User> listUsers = userDao.list();
        ModelAndView model = new ModelAndView("home");
        model.addObject("userList", listUsers);
        return model;
    }
}
