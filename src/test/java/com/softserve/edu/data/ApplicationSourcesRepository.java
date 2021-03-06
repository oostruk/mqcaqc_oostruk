package com.softserve.edu.data;

public final class ApplicationSourcesRepository {
	
	private ApplicationSourcesRepository() {
	}

	public static ApplicationSources getFirefoxHerokuApplication() {
		return new ApplicationSources("FireFox", "",
				"http://registrator.herokuapp.com/login",
				"http://registrator.herokuapp.com/logout", 5L);
	}
	
	public static ApplicationSources getChromeHerokuApplication() {
		return new ApplicationSources("Chrome",
				"D:\\chromedriver2.21\\chromedriver.exe",
				"http://registrator.herokuapp.com/login",
				"http://registrator.herokuapp.com/logout", 5L);
	}

}
