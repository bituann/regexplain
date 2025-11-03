package com.bituan.regexplain.controller;

import com.bituan.regexplain.service.RegExPlainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegExPlainController {
    private final RegExPlainService regexplainService;

    @Autowired
    RegExPlainController (RegExPlainService regexplainService) {
        this.regexplainService = regexplainService;
    }

    @PostMapping("/explain")
    public ResponseEntity<String> explainRegex (@RequestParam(value = "regex") String regex) {
        String response = regexplainService.generateResponse(regex);
        return ResponseEntity.ok(response);
    }
}
