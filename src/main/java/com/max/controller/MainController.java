package com.max.controller;

import org.thymeleaf.ITemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MainController {
    void process(HttpServletRequest request, HttpServletResponse response,
                 ServletContext context, ITemplateEngine engine);
}
