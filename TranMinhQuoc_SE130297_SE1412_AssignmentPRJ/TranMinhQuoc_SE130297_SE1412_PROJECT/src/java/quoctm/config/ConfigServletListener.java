/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoctm.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author SE130297
 */
public class ConfigServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        InputStream is = sce.getServletContext().getResourceAsStream("/WEB-INF/lable.properties");
        ServletContext context = sce.getServletContext();
        try {
            ResourceBundle bundle = new PropertyResourceBundle(is);
            context.setAttribute("CONFIG", bundle);
        } catch (IOException e) {
            System.out.println("ConfigServletListener: " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
