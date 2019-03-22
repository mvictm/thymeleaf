package com.max.controller;

import lombok.NoArgsConstructor;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Max
 */

@NoArgsConstructor
public class SubscribeController implements MainController {
    public void process(HttpServletRequest request, HttpServletResponse response, ServletContext context, ITemplateEngine engine) {
        WebContext webContext = new WebContext(request, response, context, request.getLocale());
        try {
            engine.process("subscribe", webContext, response.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(" Can't use getWriter method " + SubscribeController.class +" "+ e);
        }
    }
}
