package com.horardrim.cm.spring.eyeofanu.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@ConfigurationProperties("horadrim.elasticsearch")
@Data
public class HoradrimESProperties {

    private List<String> peers;
}
