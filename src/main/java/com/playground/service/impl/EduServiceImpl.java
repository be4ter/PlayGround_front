package com.playground.service.impl;

import com.playground.common.dao.EduDao;
import com.playground.common.dto.Edu;
import com.playground.service.EduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EduServiceImpl implements EduService {
    @Autowired
    private EduDao eduDao;

    @Override
    public void insert(Edu edu) {
        eduDao.insert(edu);
    }

    @Override
    public Edu update(Edu edu) {
        return eduDao.update(edu);
    }

    @Override
    public void delete(Edu edu) {
        eduDao.delete(edu);
    }
}
