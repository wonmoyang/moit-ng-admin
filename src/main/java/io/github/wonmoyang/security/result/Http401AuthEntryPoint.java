package io.github.wonmoyang.security.result;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class Http401AuthEntryPoint implements AuthenticationEntryPoint{
	
	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
        logger.error("Access Denied.");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
        
	}

}
