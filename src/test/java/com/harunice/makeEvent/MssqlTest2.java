package com.harunice.makeEvent;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class MssqlTest2 {
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://114.204.170.93:3726;databaseName=event_DB";
    private static final String USER = "sa"; //DB 사용자명
    private static final String PW = "!han284472";   //DB 사용자 비밀번호

    @Test
    public void testConnection() throws Exception{

        Class.forName(DRIVER); //com.microsoft.sqlserver.jdbc.SQLServerDriver JDBC Driver class 로딩

        Connection con = DriverManager.getConnection(URL, USER, PW); // java.sql.Connection 객체생성

        try{
            System.out.println(con);
             
            System.out.println(con.isClosed()); // connection 닫힘 유무

            Statement stmt = con.createStatement(); // Statement 객체생성

            String sql = "select name, tel, email from dbo.event_user"; // 쿼리문

            ResultSet rs = stmt.executeQuery(sql); // 

            while(rs.next()) {
                System.out.println(rs.getString("name")+"///"+rs.getString("tel")+"///"+rs.getString("email"));
            }

            con.close();

            System.out.println(con.isClosed());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            con.close();
        }
   }

}
