/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkg.jenkinsmavenwebapp.dao;

/**
 *
 * @author Surajit
 */
import com.iitkg.jenkinsmavenwebapp.model.User;
import java.util.List;
 

 
public interface UserDAO {
    public List<User> list();
}


