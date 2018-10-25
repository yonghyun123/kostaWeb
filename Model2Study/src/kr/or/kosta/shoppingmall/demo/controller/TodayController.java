package kr.or.kosta.shoppingmall.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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

public class TodayController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView();
		
		Calendar calendar = Calendar.getInstance();
		String today = String.format("%1$tF %1$tT", calendar);
		mav.addObject("today", today);
		
		// 모델영역의 비즈니스 메소드 호출 및 데이터 반환
		mav.setView("/demo/today.jsp");
				
		return mav;
	}
	
	

}
