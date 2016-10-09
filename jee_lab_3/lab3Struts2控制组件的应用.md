# lab3Struts2控制组件的应用


一、	实验目的1．	掌握Struts2的核心控制器的设置2．	掌握Struts2的业务逻辑控制器的创建3．	掌握ActionSupport类的使用4．	掌握使用struts.xml定义动作包及动作二、	实验环境1.Tomcat2. MyEclipse三、	实验描述使用ActionSupport类实现输入信息的校验：用户名输入admin，且密码输入sise后登录到welcome.jsp页面，如果没有输入用户名或密码将在相应字段上面显示提示信息，如果输入错误用户名或错误密码将在用户名字段上面显示提示信息。

##实验总结
Action类源码

```
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
```
继承自ActionSuppport类

这里简单说明一下关于此类

>   struts2不要求我们自己设计的action类继承任何的struts基类或struts接口，但是我们为了方便实现我们自己的action，大多数情况下都会继承com.opensymphony.xwork2.ActionSupport类，并重写此类里的public String execute() throws Exception方法。因为此类中实现了很多的实用借口，提供了很多默认方法，这些默认方法包括国际化信息的方法、默认的处理用户请求的方法等，这样可以大大的简化Acion的开发。 
    Struts2中通常直接使用Action来封装HTTP请求参数，因此，Action类里还应该包含与请求参数对应的属性，并且为属性提供对应的getter和setter方法。


validate()将在该Action类执行的时候自动执行，这里需要注意由于username 或者是password可能是没有传过来的 所以要先判断这个是否为空，不然会因为空指针直接抛出异常
addFieldError(param1,param2) method
对于param 1 所对应的jsp页面中的控件name 
对于param 2则是在改控件视图上面显示的错误信息。

另外 由于是要在视图上显示错误信息，则该视图在struts.xml配置文件中result中的类型是input

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC "-//Apache Software Foundation//DTD Struts Configuration 2.1//EN" "http://struts.apache.org/dtds/struts-2.1.dtd">
<struts>
<constant name="struts.devMode" value="true" />
   <package name="jee_lab_three" extends="struts-default" namespace="/mylogin">     
      <action name="login" 
            class="com.struts2.action.LoginAction" 
            method="execute">
            <result name="input">/login.jsp</result>
            <result name="success">/welcome.jsp</result>
            <result name="error">/login.jsp</result>
      </action>
   </package>
</struts>    
```
如上图所示。
另外由于是要使用struts的视图所以在输出也面的标签需要用到struts的标签
这里简单罗列一下代码

```
   <s:form action="login" namespace="/mylogin">
    <s:textfield name="username" label="用户名"></s:textfield>
    <s:textfield name="password" label="密码"></s:textfield>
    <s:submit value="登录"/>
    </s:form>
```
命名空间由于在lesson4的笔记中有说明这里就省略了 


