/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkg.jenkinsmavenwebapp.controller;
import com.iitkg.jenkinsmavenwebapp.model.FileInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletContext;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

 
@Controller
public class FileuploadController {
    @Autowired
    ServletContext context;
 
    @RequestMapping(value = "/upload", method=RequestMethod.GET)
    public ModelAndView fileUpload() throws IOException {        
        ModelAndView model = new ModelAndView("fileUpload");
        return model;
    } 
   
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("file") List < MultipartFile > files) {
        List < FileInfo > uploadedFiles = new ArrayList < FileInfo > ();
        if (!files.isEmpty()) {
            try {
                for (MultipartFile file: files) {
                    String path = context.getRealPath("/WEB-INF/uploaded") + File.separator + file.getOriginalFilename();
                    System.out.println("file path is"+path);
                    File destinationFile = new File(path);
                    file.transferTo(destinationFile);
                    uploadedFiles.add(new FileInfo(destinationFile.getName(), path));
                }
 
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
 
        }
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("files", uploadedFiles);
        return modelAndView;
    }
}