package com.struts2.action;

import java.lang.reflect.Array;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2.model.User;

public class MyAction extends ActionSupport implements RequestAware ,ServletRequestAware {
   private User user;
   private Map myRequestAware;
   private HttpServletRequest myHttpServletRequest;
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
     public String execute() throws Exception{
    	 if(user.getUsername()!=null||user.getPassword()!=null){
    	 if(user.getUsername().equals("test")&&user.getPassword().equals("123")){
    		 myHttpServletRequest.setAttribute("username", "正确"+user.getUsername());
    		 myRequestAware.put("password","正确"+user.getPassword());
    	 return "success";
    	 } else{
    		 System.out.println("密码错误");
    		 return "error";
    	 }
    	
    	 }
    	 else{
    		 System.out.println("密码错误");
    		 return "error";
    	 }
     }

	@Override
	public void setRequest(Map<String, Object> arg0) {
		myRequestAware = arg0;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		myHttpServletRequest = arg0;
		
	}
	public String test(){
		 return "hello";
	}
    
}
