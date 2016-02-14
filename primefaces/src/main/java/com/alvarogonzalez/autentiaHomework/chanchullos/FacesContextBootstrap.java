package com.alvarogonzalez.autentiaHomework.chanchullos;

import javax.faces.context.FacesContext;
import javax.faces.validator.BeanValidator;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.validation.Validation;

/**
 * http://www.scriptscoop.net/t/2e17d72e780e/jsf-bean-validation-doesnt-work-with-mojarra-2-2-4.html
 * @author alvaro
 *
 */
public class FacesContextBootstrap implements ServletContextListener
{
    public static final String BEANS_VALIDATION_AVAILABILITY_CACHE_KEY = "javax.faces.BEANS_VALIDATION_AVAILABLE";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("FacesContextBootstrap");
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().remove(BEANS_VALIDATION_AVAILABILITY_CACHE_KEY);
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap()
                .put(BeanValidator.VALIDATOR_FACTORY_KEY, Validation.buildDefaultValidatorFactory());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}