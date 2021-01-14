package com.horardrim.cm.spring.eyeofanu.controller;

import com.horardrim.cm.spring.eyeofanu.backend.HoradrimESService;
import com.horardrim.cm.spring.eyeofanu.view.HoradrimIssueView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HoradrimIssueController {
    @Autowired HoradrimESService backendService;

    @GetMapping("/issues")
    public ModelAndView issues(ModelAndView mv) {
        HoradrimIssueView issueViewA = new HoradrimIssueView("BANGO_ISSUE",
            "porn-vedio-abp", "045", "index and bango is not consistent", 321759721515L, "NEW");

        HoradrimIssueView issueViewB = new HoradrimIssueView("BANGO_ISSUE",
            "porn-vedio-abp", "045", "index and bango is not consistent", 321759721515L, "NEW");

        mv.addObject("title","This page is to show the inconsistency of vedio data in elasticsearch");
        mv.addObject("issues", Arrays.asList(issueViewA, issueViewB));

        return mv;
    }
}
