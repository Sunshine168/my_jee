package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2.model.Login;

public class LoginAction extends ActionSupport {
	private Login login;
	public String execute() throws Exception {
		String rs="error";
		if(login.getName().length()>0&&login.getPassword().length()>0){
			rs="success";
		}

		return rs;		
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

}
