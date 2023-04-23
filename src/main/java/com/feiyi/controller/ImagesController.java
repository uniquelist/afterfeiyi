package com.feiyi.controller;

import com.feiyi.domain.Images;
import com.feiyi.service.ImagesService;
import com.feiyi.utils.FileLoad;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping("images")
public class ImagesController {

    @Autowired
    ImagesService imagesService;
    @Value("${upload.dir}")
    private String uploadDir;

    //查询照片列表
    @GetMapping("/findAll")
    public List<Images> findAll(){
        return imagesService.findAll();
    }

    //查询照片列表
    @GetMapping("/findAll0")
    public List<Images> findAll0(){
        return imagesService.findAll0();
    }

    //添加照片
    @PostMapping("/addImage")
    public String addImage(@RequestParam(value = "file") MultipartFile file,
                           Images images){
        // 若照片不为空,就把图片转成base64的字符串设置给actor的pic属性
        if(file != null){
            try {
                images.setUrl(Base64.encodeBase64String(file.getBytes())) ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 1.上传缩略图
        FileLoad.uploadFile(file, uploadDir);
        // 2.保存演员的信息
        imagesService.addImage(images);
        return "提交成功!!";
    }
    @PostMapping("/updateImage")
    // 更新一条记录
    public String updateImage(@RequestBody Images images){
        // 更新照片的信息
        imagesService.updateImage(images);
        return "提交成功!!";
    }
    // 删除一条记录
    @PostMapping("/delete")
    public String deleteById(@RequestBody Images images){
        imagesService.deleteById(images.getId());
        return "删除成功";
    }

    //根据tittle查询
    @GetMapping("/findByTitle")
    public List<Images> findByTitle(String title){
        return imagesService.findByTitle(title);
    }

    @GetMapping("/findAllByStatus")
    public List<Images> findAllByStatus(){
        return imagesService.findAllByStatus();
    }

    @GetMapping("/findImageById")
    public Images findImageById(int imageId){
        return imagesService.findById(imageId);
    }
}
