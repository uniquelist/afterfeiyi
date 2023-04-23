package com.feiyi.service;

import com.feiyi.domain.Papper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PapperService {
    //查询文章所有列表
    public List<Papper> findAll();
    //添加文章
    public void addPapper(Papper papper);
    //删除文章
    public void deleteById(int papperId);
}
