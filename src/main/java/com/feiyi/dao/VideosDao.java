package com.feiyi.dao;

import com.feiyi.domain.CountImageAndVideoByYear;
import com.feiyi.domain.Videos;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VideosDao {
    //查询影音列表
    public List<Videos> findAll();

    //查询影音列表
    public List<Videos> findAll0();

    //没有被拉黑的
    public List<Videos> findVideoByStatus();

    //根据ID查找
    public Videos findAllById(Integer id);

    //添加影音
    public void addVideo(Videos videos);

    //修改影音状态
    public void updateVideo(Videos videos);

    //删除影音
    public void deleteById(int VideoId);

    //根据title查询照片
    public List<Videos> findByTitle(String title);

    //统计视频数量
    public Integer countVedio();

    //统计每年近六年作品上传数量
    public List<CountImageAndVideoByYear> countVideosByYear();

}
