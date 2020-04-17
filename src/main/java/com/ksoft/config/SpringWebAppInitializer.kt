package com.ksoft.config

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.filter.CharacterEncodingFilter
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.FilterRegistration
import javax.servlet.ServletContext


class SpringWebAppInitializer : WebApplicationInitializer {
    override fun onStartup(servletContext: ServletContext) {
        println("onStartup .....................")
        val appContext = AnnotationConfigWebApplicationContext()
        appContext.register(ApplicationContextConfig::class.java)

        val dispatcher = servletContext.addServlet("SpringDispatcher",
                DispatcherServlet(appContext))
        dispatcher.setLoadOnStartup(1)
        dispatcher.addMapping("/")

        // UTF8 Charactor Filter.

        // UTF8 Charactor Filter.
        val fr: FilterRegistration.Dynamic = servletContext.addFilter("encodingFilter", CharacterEncodingFilter::class.java)

        fr.setInitParameter("encoding", "UTF-8")
        fr.setInitParameter("forceEncoding", "true")
        fr.addMappingForUrlPatterns(null, true, "/*")
    }
}