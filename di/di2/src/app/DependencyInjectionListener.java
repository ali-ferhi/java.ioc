package app;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import business.manager.factory.BusinessManagerFactory;
import business.manager.impl.FirstProjectManagerFirstImpl;
import service.rest.AbstractRestResouceService;

// elle est instanci�e par le serveur au d�marrage
public class DependencyInjectionListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent pServletContextEvent) {
		
	}

	// elle est appel�e par le serveur au d�marrage
	@Override
	public void contextInitialized(ServletContextEvent pServletContextEvent) {
		
		BusinessManagerFactory businessManagerFactory = new BusinessManagerFactory();
		businessManagerFactory.setFirstBusinessManager(new FirstProjectManagerFirstImpl());
		
		AbstractRestResouceService.setBusinessManagerFactory(businessManagerFactory);
		
	}

}
