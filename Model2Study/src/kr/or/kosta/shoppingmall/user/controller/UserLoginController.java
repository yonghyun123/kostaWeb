package kr.or.kosta.shoppingmall.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;
import kr.or.kosta.shoppingmall.common.service.ObjectFactory;
import kr.or.kosta.shoppingmall.user.domain.User;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;

public class UserLoginController implements Controller {

	private UserService userService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView();
		ObjectFactory factory = (ObjectFactory)request.getServletContext().getAttribute("objectFactory");
		userService = (UserService)factory.getService(UserServiceImpl.class);
		
		String id = request.getParameter("userid");
		String passwd = request.getParameter("userpw");
		User user = null;
		try {
			System.out.println("id:"+id+", passwd"+ passwd);
			user = userService.search(id, passwd);
			System.out.println(user);
			if(user != null) {
				Cookie cookie = new Cookie("loginId", user.getId());
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		} catch (Exception e) {
			throw new ServletException("UserService.Login() 예외발생", e);
		}
		mav.addObject("user", user);
		mav.setView("redirect:/model2/index.jsp");
				
		return mav;
	}

}
