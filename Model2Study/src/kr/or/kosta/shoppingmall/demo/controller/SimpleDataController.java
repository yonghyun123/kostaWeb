package kr.or.kosta.shoppingmall.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;
import kr.or.kosta.shoppingmall.user.domain.User;

/**
 * hello.mall 요청에 대한 처리 클래스
 * @author kosta
 *
 */

public class SimpleDataController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		// plain text, xml, json 데이터 바로 출력		
		String message = "모델2 기반 웹애플리케이션 개발";
		response.setContentType("application/json; charset=utf-8");
		
		User tempUser = new User("1111", "1111", "1111", "1111", "1111");
		String objectToReturn = "{ key1: 'value1', key2: 'value2' }";
		Map<String, Object> tempObj = new HashMap();
		tempObj.put("user", tempUser);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(tempObj);
		} catch (IOException e) {
			throw new ServletException(e.getMessage(), e);
		}
		

		
		return null;
	}
	
	

}
