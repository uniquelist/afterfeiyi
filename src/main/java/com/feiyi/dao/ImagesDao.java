package com.feiyi.dao;

import com.feiyi.domain.CountImageAndVideoByYear;
import com.feiyi.domain.Images;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImagesDao {
    //查询照片列表
    public List<Images> findAll();

    //查询未审核照片列表
    public List<Images> findAll0();

    //添加照片
    public void addImage(Images images);

    //修改照片状态
    public void updateImage(Images images);

    //删除照片
    public void deleteById(int ImageId);

    //根据title查询照片
    public List<Images> findByTitle(String title);

    //统计照片数量
    public Integer countImages();

    //统计每年近六年作品上传数量
    public List<CountImageAndVideoByYear> countImagesByYear();

    //查询审核通过的作品
    public List<Images> findAllByStatus();

    //根据id查找图片
    public Images findById(Integer id);

}
