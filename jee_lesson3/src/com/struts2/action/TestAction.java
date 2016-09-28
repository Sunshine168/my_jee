package com.struts2.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
   public String execute(){
	   ActionContext ac = ActionContext.getContext();
	   Locale url = ac.getLocale();
	   System.out.println(url.getLanguage());
	   HttpServletRequest request = ServletActionContext.getRequest();
	   return "default";
   }
   public String hello(){
	   return "success";
   }
   public String hello2(){
	   return "error";
   }
}
