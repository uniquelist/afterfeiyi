package com.feiyi.service.Impl;

import com.feiyi.dao.ImagesDao;
import com.feiyi.domain.CountImageAndVideoByYear;
import com.feiyi.domain.Images;
import com.feiyi.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesServiceImpl implements ImagesService {
    @Autowired
    private ImagesDao imagesDao;

    @Override
    public List<Images> findAll() {
        return imagesDao.findAll();
    }

    @Override
    public List<Images> findAll0() {
        return imagesDao.findAll0();
    }

    @Override
    public void addImage(Images images) {
        imagesDao.addImage(images);
    }

    @Override
    public void updateImage(Images images) {
        imagesDao.updateImage(images);
    }

    @Override
    public void deleteById(int ImageId) {
        imagesDao.deleteById(ImageId);
    }

    @Override
    public List<Images> findByTitle(String title) {
        return imagesDao.findByTitle(title);
    }

    @Override
    public Integer countImages() {
        return imagesDao.countImages();
    }

    @Override
    public List<CountImageAndVideoByYear> countImagesByYear() {
        return imagesDao.countImagesByYear();
    }

    @Override
    public List<Images> findAllByStatus() {
        return imagesDao.findAllByStatus();
    }

    @Override
    public Images findById(Integer id) {
        return imagesDao.findById(id);
    }
}

