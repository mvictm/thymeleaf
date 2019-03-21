package com.max.controller;

import lombok.NoArgsConstructor;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 1 on 21.03.2019.
 */

@NoArgsConstructor
public class UserProfileController implements MainController{
    public void process(HttpServletRequest request, HttpServletResponse response, ServletContext context, ITemplateEngine engine) {
        WebContext webContext = new WebContext(request, response, context, request.getLocale());
        try {
            engine.process("userprofile", webContext, response.getWriter());
        } catch (IOException e) {
            //TODO add logger
            e.printStackTrace();
        }
    }
}
