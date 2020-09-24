/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkg.jenkinsmavenwebapp.model;

/**
 *
 * @author Surajit
 */
public class FileInfo {
 
    private String name;
    private String path;
 
    public FileInfo(String name, String path) {
        super();
        this.name = name;
        this.path = path;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPath() {
        return path;
    }
 
    public void setPath(String path) {
        this.path = path;
    }
 
}