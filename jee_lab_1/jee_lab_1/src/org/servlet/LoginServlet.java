package org.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.model.*;
import org.dao.*;
public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");			//�����������
		//����Ϊ��Ŀ�����ݵĽӿڣ�DAO�ӿڣ������ڴ������������ݿ���һЩ����
		LoginDao loginDao = new LoginDao();
		Login l = loginDao.checkLogin(request.getParameter("name"), request.getParameter("password"));
		if(l!=null){									//�����¼�ɹ�
			HttpSession session = request.getSession();	//��ûỰ���������浱ǰ��¼�û�����Ϣ
			session.setAttribute("login", l);			//�ѻ�ȡ�Ķ��󱣴��� Session ��
            response.sendRedirect("main.jsp");			//��֤�ɹ���ת����ӭ��ҳ main.jsp
		}else{
			response.sendRedirect("error.jsp");			//��֤ʧ����ת��������ҳ error.jsp
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}
