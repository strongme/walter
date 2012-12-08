package org.strongme.walter.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.strongme.walter.ApiConfig;

import com.renren.api.client.RenrenApiConfig;

public class ApiInitListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		RenrenApiConfig.renrenApiKey = ApiConfig.API_KEY;
		RenrenApiConfig.renrenApiSecret = ApiConfig.APP_SECRET;
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
