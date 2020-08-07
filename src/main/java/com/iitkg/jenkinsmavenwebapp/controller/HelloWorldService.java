package com.iitkg.jenkinsmavenwebapp.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

@Path("hello")
public class HelloWorldService {

	private final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "Jersey say : " + msg;
		logger.debug("Welcome to mkyong.com...debug");
		logger.info("Welcome to mkyong.com...info");
		logger.error("Welcome to mkyong.com...error");
		logger.warn("Welcome to mkyong.com...warn");
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/{packageName}/{level}")
	public String loggerLevelCahnge(@PathParam("packageName") String packageName, @PathParam("level") String level) {
		logger.info("packageName===>"+packageName +"level===>"+level);
		ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(packageName);
		// set its Level to INFO. The setLevel() method requires a logback logger
		logger.setLevel(getLevel(level));
		return "level changes successfully";
	}

	private Level getLevel(String level) {
		if (level.equalsIgnoreCase("info")) {
			return Level.INFO;
		} else if (level.equalsIgnoreCase("all")) {
			return Level.ALL;
		} else if (level.equalsIgnoreCase("debug")) {
			return Level.DEBUG;
		} else if (level.equalsIgnoreCase("error")) {
			return Level.ERROR;
		} else if (level.equalsIgnoreCase("trace")) {
			return Level.TRACE;
		} else if (level.equalsIgnoreCase("off")) {
			return Level.OFF;
		} else if (level.equalsIgnoreCase("warn")) {
			return Level.WARN;
		} else {
			return Level.INFO;
		}
	}
}