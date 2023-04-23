package com.feiyi.service.Impl;

import com.feiyi.dao.PapperDao;
import com.feiyi.domain.Papper;
import com.feiyi.service.PapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PapperServiceImpl implements PapperService {
    @Autowired
    private PapperDao papperDao;

    @Override
    public List<Papper> findAll() {
        return papperDao.findAll();
    }

    @Override
    public void addPapper(Papper papper) {
        papperDao.addPapper(papper);
    }

    @Override
    public void deleteById(int papperId) {
        papperDao.deleteById(papperId);
    }
}

