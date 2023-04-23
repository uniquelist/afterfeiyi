package com.feiyi.service.Impl;

import com.feiyi.dao.VideosDao;
import com.feiyi.domain.CountImageAndVideoByYear;
import com.feiyi.domain.Videos;
import com.feiyi.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideosServiceImpl implements VideosService {
    @Autowired
    private VideosDao videosDao;

    @Override
    public List<Videos> findAll() {
        return videosDao.findAll();
    }

    @Override
    public List<Videos> findAll0() {
        return videosDao.findAll0();
    }

    @Override
    public List<Videos> findVideoByStatus() {
        return videosDao.findVideoByStatus();
    }

    @Override
    public void addVideo(Videos videos) {
        videosDao.addVideo(videos);
    }

    @Override
    public void updateVideo(Videos videos) {
        videosDao.updateVideo(videos);
    }

    @Override
    public void deleteById(int videoId) {
        videosDao.deleteById(videoId);
    }

    @Override
    public List<Videos> findByTitle(String title) {
        return videosDao.findByTitle(title);
    }

    @Override
    public Integer countVedio() {
        return videosDao.countVedio();
    }

    @Override
    public List<CountImageAndVideoByYear> countVideosByYear() {
        return videosDao.countVideosByYear();
    }

    @Override
    public Videos findAllById(Integer id) {
        return videosDao.findAllById(id);
    }
}

