package com.feiyi.controller;

import com.feiyi.domain.Videos;
import com.feiyi.service.VideosService;
import com.feiyi.utils.FileLoad;
import com.feiyi.utils.FileSize;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping("videos")
public class VideosController {

    @Autowired
    VideosService videosService;
    @Value("${upload.dir}")
    private String uploadDir;

    //查询音频列表
    @GetMapping("/findAll")
    public List<Videos> findAll(){
        return videosService.findAll();
    }

    //查询音频列表
    @GetMapping("/findAll0")
    public List<Videos> findAll0(){
        return videosService.findAll0();
    }

    //添加音频
    @PostMapping("/addVideo")
    public String addVideo(@RequestParam(value = "file") MultipartFile file,
                           Videos videos){
        // 若照片不为空,就把图片转成base64的字符串设置给actor的pic属性
        if(file != null){
            try {
                videos.setUrl(Base64.encodeBase64String(file.getBytes())) ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 1.上传缩略图
        FileLoad.uploadFile(file, uploadDir);
        // 2.保存影视的信息
        videosService.addVideo(videos);
        return "提交成功!!";
    }
    @PostMapping("/updateVideo")
    // 更新一条记录
    public String updateVideo(@RequestBody Videos videos){
        // 更新影音的信息
        videosService.updateVideo(videos);
        return "更新成功!!";
    }
    // 删除一条记录
    @PostMapping("/delete")
    public String deleteById(@RequestBody Videos videos){
        videosService.deleteById(videos.getId());
        return "删除成功";
    }

    //根据tittle查询
    @GetMapping("/findByTitle")
    public List<Videos> findByTitle(String title){
        return videosService.findByTitle(title);
    }

    @GetMapping("/findByStatus")
    public List<Videos> findVideoByStatus(){
        return videosService.findVideoByStatus();
    }

    @GetMapping("/findById")
    public Videos findById(int videoId){
        return videosService.findAllById(videoId);
    }
}

