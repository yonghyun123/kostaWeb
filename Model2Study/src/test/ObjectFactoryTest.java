package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.shoppingmall.common.factory.XMLObjectFactory;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;

/**
 * Annotation을 이용하여 Test 클래스를 정의하는 방법(JUnit 4)
 */
public class ObjectFactoryTest {
	String mapperLocation = "C:\\Users\\kosta\\Desktop\\hanaWeb\\Model2Study\\WebContent\\WEB-INF\\object-mapper.xml";
	UserService service;
	XMLObjectFactory factory;
	
	
	@Before
	public void init() throws Exception {
		// 선행 작업(자원할당 등)
		factory = new XMLObjectFactory(mapperLocation);
		service = (UserService) factory.getBean(UserServiceImpl.class);
	}

	@After
	public void destroy() throws Exception {
		// 후행 작업(자원해제 등)
	}

	@Test
	public void testObject() {
		try {
			System.out.println(service.list());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
