package com.max.controller;

import lombok.NoArgsConstructor;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by 1 on 21.03.2019.
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
            //TODO add logger
            e.printStackTrace();
        }
    }
}
