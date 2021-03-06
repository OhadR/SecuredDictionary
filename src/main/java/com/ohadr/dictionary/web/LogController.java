package com.ohadr.dictionary.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LogController
{
	private static Logger log = Logger.getLogger(LogController.class);

	
	@RequestMapping(value = "/log", method = RequestMethod.POST)	
	protected void log(
			@RequestParam("context") String context,
			@RequestParam("level") String level,
			@RequestParam("message") String message,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		System.out.print( "/log, message: " + message );
		log.info( message + " , context: " + context );
		
		response.getWriter().println("got to /log");

	}
	
	@RequestMapping(value = "/ping")	
	protected void ping(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		log.info( "got to ping" );
		System.out.print( "pong" );
		response.getWriter().println("ping response: pong");

	}
	
}
