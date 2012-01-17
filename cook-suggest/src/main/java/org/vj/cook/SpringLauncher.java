package org.vj.cook;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncher {

	public void launch() {
		String[] contextPath = new String[]{"org/vj/cook/config/applicationContext.xml"};
		new ClassPathXmlApplicationContext(contextPath);
	}

}
