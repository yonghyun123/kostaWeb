package kr.or.kosta.shoppingmall.common.service;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.xml.internal.ws.util.StringUtils;

import kr.or.kosta.shoppingmall.common.dao.DaoFactory;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;

public class XMLObjectFactory extends DaoFactory{
	private Hashtable<String, Object> serviceList;
	private Hashtable<String, Object> daoList;

	public XMLObjectFactory(String objectMapperLocation) throws ParserConfigurationException, SAXException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		serviceList = new Hashtable<String, Object>();
		daoList = new Hashtable<String, Object>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder parser = factory.newDocumentBuilder();
		Document document = parser.parse(objectMapperLocation);
		
		// 루트 엘리먼트 취득
		Element beans = document.getDocumentElement();
		
		// 루트 엘리먼트의 모든 자식 노드 검색
		NodeList beanList = beans.getElementsByTagName("bean");
		
		System.out.println("[디버깅]: 자식노드수: " + beanList.getLength());
		
		for (int i = 0; i < beanList.getLength(); i++) {
			Element bean = (Element) beanList.item(i);
			if(bean.getAttribute("type").equals("dao")){
				String daoClassName = bean.getAttribute("class");
				String daoName = bean.getAttribute("name");
				Object daoObject = Class.forName(daoClassName).newInstance();
				addDataSource(daoObject);
				daoList.put(daoName, daoObject);
				System.out.println(daoName + "=" + daoObject);
				
			} else { 
				// bean type 속성이 service일때
				System.out.println("--------서비스 클래스 받아옵니다-------");
				String serviceClassName = bean.getAttribute("class");
				System.out.println(serviceClassName);
				Object serviceObject = Class.forName(serviceClassName).newInstance();
				serviceList.put(serviceClassName, serviceObject);
				
				NodeList propertyBean = bean.getElementsByTagName("property");
				for(int j = 0; j < propertyBean.getLength(); j++){
					Element prop = (Element)propertyBean.item(j);
					String daoName = prop.getAttribute("ref");
					String methodName = "set" + StringUtils.capitalize(daoName);
					Class cls = serviceObject.getClass();
					Method method = null;
					try {
						String interfaceName = getDao(daoName).getClass().getInterfaces()[0].getName();
						method = cls.getMethod(methodName,Class.forName(interfaceName));
						method.invoke(serviceObject, getDao(daoName));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println("------------------------------------------------------");

	}

	public Object getService(String serviceName) {
		return serviceList.get(serviceName);
	}

	public Object getService(Class cls) {
		return getService(cls.getName());
	}

	public Object getDao(String daoName) {
		return daoList.get(daoName);
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
	
	private void addDao(Object service, String daoName, String methodName, Object dao) {
		Class cls = service.getClass();
		Method method;
		try {
			method = cls.getMethod(methodName, Class.forName(daoName));
			method.invoke(service, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		String mapperLocation = "C:\\Users\\kosta\\Desktop\\hanaWeb\\Model2Study\\WebContent\\WEB-INF\\object-mapper.xml";
		XMLObjectFactory factory = new XMLObjectFactory(mapperLocation);
		UserService userService = (UserService) factory.getService(UserServiceImpl.class);
		System.out.println(userService.list());

	}
}