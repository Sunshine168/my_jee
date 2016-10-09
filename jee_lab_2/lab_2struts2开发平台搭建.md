# lab_2struts2开发平台搭建

>一、实验目的     1、了解struts2框架     2、掌握struts2平台搭建二、实验内容     1、搭建平台     2、编写一个简单示例，具体参照电子手册制作


##实验总结
由于是对平台进行简单操作，在附上的word的上有详细的操作流程，这里就只是对操作里面的一些细节作出总结。
* 从网上直接下载的struts2里面包含的jar包之间是会有冲突的，需要按需导入
* MyEclipse 具有强大功能，右键项目 MyEcilpse选项中可以直接加载某个框架需要导入的jar包
* struts配置文件最好是直接使用blank模板或者是自动生成的自己敲很容易出错
* web.xml文件里面需要配置struts的mapping 不然文件可能无法找到

```
public class HelloWorldAction {
  private String name;
  public String execute() throws Exception{
	   return "success";
  }
  public String getName(){
	  return name;
  }
  public void setName(String name){
	  this.name= name;
  }
}
```
这里附上一个简单的Action类，
execute是默认的执行方法，可以在struts配置文件
action类的method上进行更改
里面的name属性通过get 、set方法可以直接映射。


