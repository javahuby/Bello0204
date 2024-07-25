package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.board.BoardServiceimpl;
import com.example.board.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardServiceimpl service;
	
	BoardController() {
		System.out.println("===>BoardController 확인");
	}
	
	String resultStr="";

	@GetMapping("/form")
	private String insert() {
		System.out.println("==>form 확인!");
		return "board/form.html";
   }
	
	@PostMapping("/insert")
	private String insert(Model model, BoardVo vo) {
		System.out.println("==>insert 확인!");
		int totalCount = service.insert(vo);
		model.addAttribute("totalCount", totalCount);
		return "redirect:/board/getBoardList";
   }
	
	@GetMapping("/getBoardList")
	private String getBoardList(BoardVo vo, Model model) {
		System.out.println("==>getBoardList 확인!");
		model.addAttribute("li", service.getBoardList(vo));
		return "board/getBoardList";
   }
	
	@GetMapping("/boardEdit")
	private String boardEdit(Model model, BoardVo vo) {
		System.out.println("==>boardEdit 확인!");
		BoardVo m = new BoardVo();
		model.addAttribute("m", service.boardEdit(vo));
		System.out.println("상세보기:" + vo);
		return "board/boardEdit.html";
	}
	
	@GetMapping("/update")
	private String update(BoardVo vo, Model model) {
		System.out.println("==>update 확인!");
		service.update(vo);
		System.out.println("수정:" + vo);
		return "redirect:/board/getBoardList?idx=" + vo.getIdx();
	}
	
	@GetMapping("/delete")
	private String delete(BoardVo vo) {
		System.out.println("==>delete 확인!");
		service.delete(vo);
		System.out.println("삭제 :" + vo);
		return "redirect:/board/getBoardList";
	}
}
