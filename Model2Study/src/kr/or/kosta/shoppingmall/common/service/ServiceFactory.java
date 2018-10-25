package kr.or.kosta.shoppingmall.common.service;

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
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;
import oracle.net.aso.f;

public class ServiceFactory {
	private Hashtable<String, Object> serviceList;
	public ServiceFactory(String serviceMapperLocation) {
		serviceList = new Hashtable<String, Object>();
		// 매핑정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(serviceMapperLocation);
			prop.load(fis);
			Iterator keyIter = prop.keySet().iterator();
			System.out.println("--- Service factory생성 ---");
			while (keyIter.hasNext()) {
				String serviceName = (String) keyIter.next();
				String serviceClass = prop.getProperty(serviceName);	
				Object service = Class.forName(serviceClass).newInstance();
				System.out.println(serviceName + ","+ service);
				serviceList.put(serviceClass, service);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Object getService(String serviceClass) {
		return serviceList.get(serviceClass);
	}

	public Object getService(Class cls) {
		return getService(cls.getName());
	}


	public static void main(String[] args) throws Exception {
		String testPath = "C:\\Users\\kosta\\Desktop\\hanaWeb\\Model2Study\\WebContent\\WEB-INF\\service-mapper.properties";
		ServiceFactory factory = new ServiceFactory(testPath);
		UserService userService = (UserService)factory.getService(UserServiceImpl.class);
		userService.list();
		
	}



}
