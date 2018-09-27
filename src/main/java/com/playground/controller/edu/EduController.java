package com.playground.controller.edu;

import com.playground.common.dto.Edu;
import com.playground.service.EduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edu")
public class EduController {
    @Autowired
    private EduService eduService;

    @PostMapping()
    public void create(String eduName) {
        eduService.insert(new Edu(eduName));
    }
}
