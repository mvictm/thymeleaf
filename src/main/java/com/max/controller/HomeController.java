package com.max.controller;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author Max
 */

@NoArgsConstructor
public class HomeController implements MainController {

    /**
     * Method create web context for out application and set variable.
     * Variable "today" inject into page. when we use ${today} combination
     *
     * @param context include all data about thymeleaf template. Use default local
     * */
    public void process(HttpServletRequest request, HttpServletResponse response, ServletContext context, ITemplateEngine engine) {
        WebContext ctx = new WebContext(request, response, context, request.getLocale());
        ctx.setVariable("today", Calendar.getInstance());
        try {
            engine.process("home", ctx, response.getWriter());
        } catch (IOException e) {
            throw new RuntimeException(" Can't use getWriter method " + HomeController.class +" "+ e);
        }
    }
}
