package com.bituan.regexplain.controller;

import com.bituan.regexplain.service.RegExPlainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegExPlainController {
    private final RegExPlainService regexplainService;

    @Autowired
    RegExPlainController (RegExPlainService regexplainService) {
        this.regexplainService = regexplainService;
    }
}
