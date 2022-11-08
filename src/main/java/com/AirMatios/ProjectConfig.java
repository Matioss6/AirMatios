package com.AirMatios;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.AirMatios.Service")
public class ProjectConfig {
}
