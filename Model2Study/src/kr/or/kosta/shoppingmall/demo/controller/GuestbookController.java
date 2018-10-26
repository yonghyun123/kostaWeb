package kr.or.kosta.shoppingmall.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;

/**
 * hello.mall 요청에 대한 처리 클래스
 * @author kosta
 *
 */

public class GuestbookController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView();
		String message = "방명록 목록입니다....";
		mav.addObject("message", message);
		request.getSession().setAttribute("message", message);
		mav.setView("redirect:/model2/demo/guestbook.jsp");			
		
		return mav;
	}
	
}
