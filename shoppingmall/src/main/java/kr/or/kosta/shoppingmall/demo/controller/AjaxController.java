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

public class AjaxController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String op = request.getParameter("op");

		System.out.println(num1);
		System.out.println(num2);
		System.out.println(op);

		int result;
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		if(op.equals("*")){
			result = n1 * n2;
		} else if(op.equals("/")){
			result = n1 / n2;
		} else if(op.equals("-")){
			result = n1 - n2;
		} else {
			result = n1 + n2;
		}

		response.setContentType("application/json; charset=utf-8");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(result);
		} catch (IOException e) {
			throw new ServletException(e.getMessage(), e);
		}
		

		
		return null;
	}
	
	

}
