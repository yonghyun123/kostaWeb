package kr.or.kosta.shoppingmall.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;
import kr.or.kosta.shoppingmall.common.service.ServiceFactory;
import kr.or.kosta.shoppingmall.user.domain.User;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;

/**
 * hello.mall 요청에 대한 처리 클래스
 * @author kosta
 *
 */

public class UserListController implements Controller {

	private UserService userService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView();
		ServiceFactory factory = (ServiceFactory)request.getServletContext().getAttribute("serviceFactory");
		userService = (UserService)factory.getService(UserServiceImpl.class);
		List<User> list = null;
		try {
			list = userService.list();
		} catch (Exception e) {
			throw new ServletException("UserService.list() 예외발생", e);
		}
		mav.addObject("userList", list);
		mav.setView("/user/list.jsp");
				
		return mav;
	}
	
	

}
