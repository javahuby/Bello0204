package com.exam.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.portoneT.PortOneService;
import com.example.portoneT.PortOneVO;

@RequestMapping("/PortOneT")
@Controller
public class PortOneTController {
	PortOneTController(){
		System.out.println("===> PortOneTController ");
	}
	
	@Autowired
	private PortOneService service;
	
	PortOneVO vo1 = new PortOneVO();
	
	@GetMapping("/start")
	public String start(PortOneVO vo, Model model) {
		
		vo.setGname("지헬스클럽");
		vo.setGymnum(90001);
		
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
		return "PortOneT/start.html";		
	}
	
    @ResponseBody  // 비동기 통신을 통하여 돌아가기 위해 필수 (중요) 
	@PostMapping("/insertMPay")   // @RequestBody 비동기 통신의 값을 요청하기 위해서는 필수  (중요) 
	public String insertMPay(@RequestBody PortOneVO vo, Model model) {
		
		System.out.println("===> insertMPay 확인 " + vo);
		String OK = service.insert(vo);
		
		vo1.setMpaynum(vo.getMpaynum());
		vo1.setMpayproduct(vo.getMpayproduct());
		vo1.setMpaydate(vo.getMpaydate());
		return OK ;		
	}
    
    @GetMapping("/result")
	public String result(Model model, PortOneVO vo) {
		model.addAttribute("vo1", vo1);
		model.addAttribute("vo2", service.edit(vo));
		return "PortOneT/result.html";		
	}
    
    @GetMapping("/failure")
	public String failure(Model model) {
		System.out.println("===> failure 확인 ");
		model.addAttribute("failure", "failure");
		return "PortOneT/failure.html";	
	}
}