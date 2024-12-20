package com.java.study01;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class App {

	public static void main(String[] args) {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("Factory Connection!!");

			SqlSession session = sqlSessionFactory.openSession();
			int result =  session.selectOne("test.test1");
			System.out.println("Result : " + result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
