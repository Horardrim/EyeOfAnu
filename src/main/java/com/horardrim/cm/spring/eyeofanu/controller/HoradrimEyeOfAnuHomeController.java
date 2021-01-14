package com.horardrim.cm.spring.eyeofanu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HoradrimEyeOfAnuHomeController {
    
    @GetMapping("/")
    public String home(){
		return "I'm eye of anu";
	}
}
