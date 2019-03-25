package com.max.filter;

import com.max.Application;
import com.max.controller.MainController;
import com.max.entity.User;
import lombok.NoArgsConstructor;
import org.thymeleaf.TemplateEngine;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by 1 on 25.03.2019.
 */
@NoArgsConstructor
public class MainFilter implements Filter {
    private ServletContext servletContext;
    private Application application;


    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
        application = new Application(servletContext);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        addUserToSession((HttpServletRequest) servletRequest);
        if (!process((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private boolean process(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        if (servletRequest.getRequestURI().startsWith("/css") ||
                servletRequest.getRequestURI().startsWith("/images") ||
                servletRequest.getRequestURI().startsWith("/favicon")) {
            return false;
        }
        MainController controller = application.resolveControllerForRequest(servletRequest);
        if (controller != null) {
            return false;
        }
        TemplateEngine templateEngine = application.getTemplateEngine();

        servletResponse.setContentType("text/html;charser=UTF-8");
        servletResponse.setHeader("Pragma", "no-cache");
        servletResponse.setHeader("Cache-Control", "no-cache");
        servletResponse.setDateHeader("Expires", 0);

        controller.process(servletRequest, servletResponse, servletContext, templateEngine);
        return true;
    }

    public void destroy() {

    }

    private static void addUserToSession(HttpServletRequest request) {
        request.getSession(true).setAttribute("user", new User("Mike", "Monson", 42));
    }
}
