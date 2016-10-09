package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction  extends ActionSupport{
    private String username ;
    private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String exeute() throws Exception{
		   if(username.trim().equals("test")&&password.trim().equals("123")){
			   return "success";
		   }

		   else{
			   addFieldError("username","用户或密码错误");
			   return "error";
		   }
	}
	public void validate()
	{
		if( null ==username ||username.trim().equals("")){
			 addFieldError("username","用户名必须输入");
		}
		if( null ==password ||password.trim().equals("")){
			 addFieldError("password","密码必须输入");
		}
	}    
}
