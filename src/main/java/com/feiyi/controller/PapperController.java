package com.feiyi.controller;

import com.feiyi.domain.Declarer;
import com.feiyi.domain.Papper;
import com.feiyi.service.PapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@CrossOrigin
@RestController
@RequestMapping("papper")
public class PapperController {

    @Autowired
    PapperService papperService;

    //查询非遗传承人列表
    @GetMapping("/findAll")
    public List<Papper> findAll(){
        return papperService.findAll();
    }

    //添加非遗传承人
    @PostMapping("/addPapper")
    public String addDeclarer(@RequestBody Papper papper){
        // 保存演员的信息
        papperService.addPapper(papper);
        return "提交成功!!";
    }

    // 删除一条记录
    @PostMapping("/delete")
    public String deleteById(@RequestBody Papper papper){
       papperService.deleteById(papper.getId());
        return "删除成功";
    }
}
