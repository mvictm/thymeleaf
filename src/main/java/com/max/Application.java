package com.max;

import com.max.controller.HomeController;
import com.max.controller.MainController;
import com.max.controller.UserProfileController;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Max
 */

@Slf4j
public class Application {
    @Getter
    private TemplateEngine templateEngine;

    private Map<String, MainController> controllerMapByURL;

    public Application(ServletContext servletContext) {
        initializeTemplate(servletContext);
        log.info("Success initialize");
    }

    private void initializeTemplate(ServletContext servletContext) {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        //set default mod
        templateResolver.setTemplateMode(TemplateMode.HTML);
        //this command change logic: so string "home" application will interprets like /WEB-INF/templates/home.html
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        //set template cache to 1 hour. Without this, entries would live in cache until expelled by
        templateResolver.setCacheTTLMs(36000000L);
        templateResolver.setCacheable(true);
        initializeParameters(templateResolver);
    }

    private void initializeParameters(ServletContextTemplateResolver templateResolver) {
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        fillsUpMap();
    }

    private void fillsUpMap() {
        controllerMapByURL = new HashMap<String, MainController>();
        controllerMapByURL.put("/", new HomeController());
        controllerMapByURL.put("/userprofile", new UserProfileController());
    }


}
