package com.can2u.app.security;

import com.can2u.app.SpringApplicationContext;

public class SecurityConstants {
	public static final long EXPIRATION_TIME = 864000000;//10 days
	public static final String TOKEN_PREFIX = "Beares ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users";
	public static final String MANAGING_ROLE_URL = "/roles";
	public static final String TOKEN_SECRET = "jf9i4jgu83nf10";
	
	public static String getTokenSecret() {
		
		AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
		return appProperties.getTokenSecret();
		
	}
}
