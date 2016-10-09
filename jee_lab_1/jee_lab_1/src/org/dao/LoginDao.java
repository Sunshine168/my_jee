package org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.model.*;
import org.db.*;
public class LoginDao {
	Connection conn;											//��������������
	public Login checkLogin(String name, String password){		//��������������������
		try{
			conn = (Connection) DBConn.getConn();							//������������
			PreparedStatement pstmt =  conn.prepareStatement("select * from login where name=? " + "and password=?");
			pstmt.setString(1, name);							//���� SQL ��������1����������
			pstmt.setString(2, password);						//���� SQL ��������2��������
			ResultSet rs =  pstmt.executeQuery();				//��������������������
			if(rs.next()){										//��������������������������������
				Login login = new Login();						//����JavaBean����������
				login.setId(rs.getInt(1));
				login.setName(rs.getString(2));
				login.setPassword(rs.getString(3));
				login.setRole(rs.getBoolean(4));
				return login;									//��������������JavaBean����
			}
			return null;										//������������������������null
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBConn.CloseConn();									//��������
		}
	}
}
