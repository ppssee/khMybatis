package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "mybatis-config.xml";
		
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return session;
	}
	
	
//	String resource = "org/mybatis/example/mybatis-config.xml";
//	InputStream inputStream = Resources.getResourceAsStream(resource);
//	SqlSessionFactory sqlSessionFactory =
//	  new SqlSessionFactoryBuilder().build(inputStream);
	
	
}
