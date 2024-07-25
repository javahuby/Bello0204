package com.exam.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portoneT.PortOneVO;

@RequestMapping("/PortOneT")
@Controller
public class PortOneTController {
	PortOneTController(){
		System.out.println("===> PortOneTController ");
	}
	
	@GetMapping("/start")
	public String start(PortOneVO vo, Model model) {
		
		vo.setGname("지헬스클럽");
		vo.setGymnum("90001");
		
		vo.setMmail("kk0063@naver.com");
		vo.setMname("최지효");
		vo.setMphone("01050376133");
		vo.setMembernum("10001");
		
		Date d =new  Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy년M월dd일");
		System.out.println(f.format(d));
		
		vo.setDataName("3개월무료사용");
		vo.setDataPrice(100);
		vo.setDataGoodsnum("70001");		
		vo.setToday(f.format(d));
		
		model.addAttribute("m", vo);
		System.out.println("===> 결제시작하기 ");
		return "PostOneT/start.html";		
	}
	
	@PostMapping("/insertMPay")
	public String insertMPay(PortOneVO vo, Model model) {
		
		System.out.println("===> insertMPay 확인 " + vo);
		
		return "PostOneT/result.html";		
	}
}
