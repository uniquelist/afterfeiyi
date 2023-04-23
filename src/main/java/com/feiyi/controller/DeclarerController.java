package com.feiyi.controller;

import com.feiyi.domain.Category;
import com.feiyi.domain.Declarer;
import com.feiyi.domain.Nation;
import com.feiyi.domain.Projects;
import com.feiyi.service.DeclarerService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Validated
@RequestMapping("declarer")
public class DeclarerController {

    @Autowired
    DeclarerService declarerService;

    //查询非遗传承人列表
    @GetMapping("/findAll")
    public List<Declarer> findAll(){
        return declarerService.findAll();
    }

    //添加非遗传承人
    @PostMapping("/addDeclarer")
    public String addDeclarer(@RequestBody Declarer declarer){
        // 保存演员的信息
        declarerService.addDeclarer(declarer);
        return "提交成功!!";
    }

    //编辑非遗
    @GetMapping("/editDeclarer")
    public Map<String,Object> editDeclarer(int declarerId){
        Declarer declarer=declarerService.findById(declarerId);
        List<Nation> nationList=declarerService.findAllNation();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("declarer", declarer);
        dataMap.put("nationList", nationList);
        return dataMap;
    }

    //修改非遗传承人
    @PostMapping("/updateDeclarer")
    public String updateDeclarer(@RequestBody Declarer declarer){
        // 保存演员的信息
        declarerService.updateDeclarer(declarer);
        return "提交成功!!";
    }
    // 删除一条记录
    @PostMapping("/delete")
    public String deleteById(@RequestBody Declarer declarer){
        declarerService.deleteById(declarer.getId());
        return "删除成功";
    }

    @GetMapping("/findAllNation")
    public List<Nation> findAllNation(){
        return declarerService.findAllNation();
    }
}
