package com.feiyi.service.Impl;

import com.feiyi.dao.DeclarerDao;
import com.feiyi.domain.CountByCategory;
import com.feiyi.domain.Declarer;
import com.feiyi.domain.Nation;
import com.feiyi.service.DeclarerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarerServiceImpl implements DeclarerService {
    @Autowired
    private DeclarerDao declarerDao;

    @Override
    public List<Declarer> findAll() {
        return declarerDao.findAll();
    }

    @Override
    public void addDeclarer(Declarer declarer) {
        declarerDao.addDeclarer(declarer);
    }

    @Override
    public void updateDeclarer(Declarer declarer) {
        declarerDao.updateDeclarer(declarer);
    }

    @Override
    public void deleteById(int declarerId) {
        declarerDao.deleteById(declarerId);
    }

    @Override
    public List<Nation> findAllNation() {
        return declarerDao.findAllNation();
    }

    @Override
    public Declarer findById(int declarerId) {
        return declarerDao.findById(declarerId);
    }

    @Override
    public Integer countPeople() {
        return declarerDao.countPeople();
    }

    @Override
    public List<CountByCategory> countByNation() {
        return declarerDao.countByNation();
    }

    @Override
    public void deleteByCode(Integer id) {
        declarerDao.deleteByCode(id);
    }
}

