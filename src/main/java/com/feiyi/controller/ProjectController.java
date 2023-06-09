package com.feiyi.controller;

import com.feiyi.domain.Category;
import com.feiyi.domain.Projects;
import com.feiyi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Validated
@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    //查询非遗传承人列表
    @GetMapping("/findAll")
    public List<Projects> findAll(){
        return projectService.findAll();
    }

    //添加非遗
    @PostMapping("/addProject")
    public String addProject(@RequestBody Projects projects){
        // 保存信息
        projectService.addProject(projects);
        return "提交成功!!";
    }

    //编辑非遗
    @GetMapping("/editProject")
    public Map<String,Object> editProject(int projectId){
        Projects projects=projectService.findById(projectId);
        List<Category> categoryList=projectService.findAllCate();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("projects", projects);
        dataMap.put("categoryList", categoryList);
        return dataMap;
    }
    //修改非遗
    @PostMapping("/updateProject")
    public String updateProject(@RequestBody Projects projects){
        // 保存信息
        projectService.updateProject(projects);
        return "提交成功!!";
    }
    // 删除一条记录
    @PostMapping("/delete")
    public String deleteById(@RequestBody Projects projects){
        projectService.deleteById(projects.getId());
        return "删除成功";
    }

    //查询类别
    @GetMapping("/findAllCate")
    public List<Category> findAllCate(){
        return projectService.findAllCate();
    }
}
