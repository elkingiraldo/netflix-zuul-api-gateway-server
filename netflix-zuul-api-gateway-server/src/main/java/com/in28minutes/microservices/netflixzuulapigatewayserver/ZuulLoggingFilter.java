package com.in28minutes.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object run() throws ZuulException {
		// implements all logic here
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		logger.info("request -> {} request uri -> {}",request,request.getRequestURI());
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// filter needs to be implemented or not
		return true;
	}

	@Override
	public int filterOrder() {
		// priority
		return 1;
	}

	@Override
	public String filterType() {
		// "pre" or "post" or "error"
		return "pre";
	}

	
	
}
