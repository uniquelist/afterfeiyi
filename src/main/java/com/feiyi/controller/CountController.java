package com.feiyi.controller;

import com.feiyi.domain.CountByCategory;
import com.feiyi.domain.CountImageAndVideoByYear;
import com.feiyi.domain.CountUserByYear;
import com.feiyi.service.*;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping("count")
public class CountController {
    @Autowired
    VideosService videosService;

    @Autowired
    ImagesService imagesService;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    DeclarerService declarerService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/zuopin")
    public Object Count(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count1",videosService.countVedio() + imagesService.countImages());
        jsonObject.put("count2",userService.countUser());
        jsonObject.put("count3",projectService.countProject());
        jsonObject.put("count4",declarerService.countPeople());

        //统计图二
        List<CountUserByYear> list = userService.countByYear();
        System.out.println(list);
        int[] data = new int[list.size()];
        String[] year = new String[list.size()];
        for(int i = 0; i<list.size(); i++)
        {
            data[i] = list.get(i).getCountuser();
            year[i] = list.get(i).getYear();
        }
        jsonObject.put("datatwo",data);
        jsonObject.put("year",year);

        //图片和视频统计图三
        List<CountImageAndVideoByYear> listimage = imagesService.countImagesByYear();

        int len1 = listimage.size();
        String[] year1 = new String[len1];
        int[] imagedata = new int[len1];
        for(int i = 0; i<len1; i++)
        {
            imagedata[i] = listimage.get(i).getCountImages();
            year1[i] = listimage.get(i).getYear();
        }
        jsonObject.put("datathreei",imagedata);

        List<CountImageAndVideoByYear> listvideo = videosService.countVideosByYear();

        System.out.println(listvideo);
        int len2 = listvideo.size();
        String[] year2 = new String[len2];
        int[] videodata = new int[len2];
        for(int i = 0; i<len2; i++)
        {
            videodata[i] = listvideo.get(i).getCountVideos();
        }
        jsonObject.put("datathreev",videodata);
        jsonObject.put("year1",year1);

//        统计图一
        List<CountByCategory> nationlist = declarerService.countByNation();
        String[] nation = new String[nationlist.size()];
        Double[] counNation = new Double[nationlist.size()];
        for(int i = 0; i<nationlist.size(); i++)
        {
            nation[i] = nationlist.get(i).getNation();
            counNation[i] = nationlist.get(i).getCountNation();
        }
        jsonObject.put("count",counNation);
        jsonObject.put("name",nation);

//        统计四
        List<CountByCategory> categoryList = projectService.countCateBai();
        String[] type = new String[categoryList.size()];
        Double[] countCategory = new Double[categoryList.size()];
        for(int i = 0; i<categoryList.size(); i++)
        {
            type[i] = categoryList.get(i).getType();
            countCategory[i] = categoryList.get(i).getCountCategory();
        }
        jsonObject.put("namefour",type);
        jsonObject.put("valuefour",countCategory);
        return jsonObject;
    }

}
