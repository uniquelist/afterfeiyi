package com.feiyi.service.Impl;

import com.feiyi.dao.DeclarerDao;
import com.feiyi.dao.ProjectDao;
import com.feiyi.domain.Category;
import com.feiyi.domain.CountByCategory;
import com.feiyi.domain.Projects;
import com.feiyi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private DeclarerDao declarerDao;

    @Override
    public List<Projects> findAll() {
        return projectDao.findAll();
    }

    @Override
    public void addProject(Projects projects) {
        projectDao.addProject(projects);
    }

    @Override
    public void updateProject(Projects projects) {
        projectDao .updateProject(projects);
    }

    @Override
    public void deleteById(int projectId) {
        declarerDao.deleteByCode(projectId);
        projectDao.deleteById(projectId);

    }

    @Override
    public List<Category> findAllCate() {
        return projectDao.findAllCate();
    }

    @Override
    public Projects findById(int projectId) {
        return projectDao.findById(projectId);
    }

    @Override
    public Integer countProject() {
        return projectDao.countProject();
    }

    @Override
    public List<CountByCategory> countCateBai() {
        return projectDao.countCateBai();
    }

    @Override
    public Integer countYear() {
        return projectDao.countYear();
    }

}

