package com.playground.service;

import com.playground.common.dto.Edu;

public interface EduService {
    void insert(Edu edu);

    Edu update(Edu edu);

    void delete(Edu edu);
}
