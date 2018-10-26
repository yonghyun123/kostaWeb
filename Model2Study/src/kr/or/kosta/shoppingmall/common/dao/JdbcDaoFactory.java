package kr.or.kosta.shoppingmall.common.dao;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.user.dao.JdbcUserDao;
import kr.or.kosta.shoppingmall.user.dao.UserDao;
import kr.or.kosta.shoppingmall.user.domain.User;
import oracle.net.aso.f;

public class JdbcDaoFactory extends DaoFactory {
	
	private Hashtable<String, Object> daos;
	private String testPath = "C:\\Users\\kosta\\Desktop\\hanaWeb\\Model2Study\\WebContent\\WEB-INF\\dao-mapper.properties";
	public JdbcDaoFactory(String daoMapperLocation) {
		daos = new Hashtable<String, Object>();
		// 매핑정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(daoMapperLocation);
			prop.load(fis);
			Iterator keyIter = prop.keySet().iterator();
			System.out.println("--- JDBC DAO factory생성 ---");
			while (keyIter.hasNext()) {
				String daoName = (String) keyIter.next();
				String daoClass = prop.getProperty(daoName);	
				Object dao = Class.forName(daoClass).newInstance();
				addDataSource(dao);
				daos.put(daoClass, dao);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
//
//	@Override
//	public UserDao getUserDao() {
//		return (UserDao)daos.get("jdbcUserDao");
//	}
	
	public Object getDao(String daoName) {
		return daos.get(daoName);
	}
	
	public Object getDao(Class cls) {
		return getDao(cls.getName());
	}
	
	
	private void addDataSource(Object dao) {
		Class cls = dao.getClass();
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public BarDao getBarDao() {...};
//	public FooDao getFooDao() {...};
	

	public static void main(String[] args) throws Exception {
		String testPath = "C:\\Users\\kosta\\Desktop\\hanaWeb\\Model2Study\\WebContent\\WEB-INF\\dao-mapper.properties";
		DaoFactory factory = new JdbcDaoFactory(testPath);
		UserDao dao = (UserDao)factory.getDao(JdbcUserDao.class);
		List<User> list = dao.listAll();
		for (User user : list) {
			System.out.println(user.toString());
		}
		
	}



}
