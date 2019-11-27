package com.nanodegree.fileupload.controller;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {
    Map<String, Object> result = new HashMap<>();

    @RequestMapping("upload")
    public Map<String, Object> upload(@RequestParam("attach")MultipartFile file) throws IOException{
        // get file info
        System.out.println("File name :" + file.getOriginalFilename());
        System.out.println("File type :" + file.getContentType());

        //save to disk { get path and transfer to location }
//        Path path = FileSystems.getDefault().getPath("src", "main", "resources",
//                "static", "images", file.getOriginalFilename());

        // using java.io package
        String filepath = "C:\\Users\\chukw\\OneDrive\\Documents\\Java\\file-upload\\src\\main\\resources\\static\\images\\";
        file.transferTo(new File(filepath + file.getOriginalFilename()));
        result.put("Success", true);
        return result;
    }
}
