package com.qingcheng.controller.file;


import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OSSClient ossClient;

    @PostMapping("/native")
    public String nativeUpload( @RequestParam("file") MultipartFile file){

        String path = request.getSession().getServletContext().getRealPath("img");

        UUID uuid = UUID.randomUUID();
        String filePath=path+"/"+ uuid +file.getOriginalFilename();
        File destFile = new File(filePath);

        if(!destFile.getParentFile().exists()){
            destFile.mkdirs();
        }

        try {
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://localhost:9101/img/"+uuid+file.getOriginalFilename();
    }

    @PostMapping("/oss")
    public String ossUpload(@RequestParam("file") MultipartFile file,String folder){

        String bucketName="simonlee";
        String fileName=folder+"/"+UUID.randomUUID()+file.getOriginalFilename();
        try {
            ossClient.putObject(bucketName,fileName,file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "https://"+bucketName+".oss-cn-chengdu.aliyuncs.com/"+fileName;
    }

}
