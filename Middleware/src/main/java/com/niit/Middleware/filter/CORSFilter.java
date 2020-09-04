package com.niit.Middleware.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {
	
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException
	{
		System.out.println("Filter is on");
		HttpServletResponse httpResponse =(HttpServletResponse)res;
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Headers", "X-request-with,Content-Type,Authorization");
        System.out.println("CORS Configuration is set..........");
        chain.doFilter(req, res);
        
        
}
	public void destroy()
	{
		
	}
	public void init(FilterConfig filterConfig) throws ServletException
	{
		
	}
}

