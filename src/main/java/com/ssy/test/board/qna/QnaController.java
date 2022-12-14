package com.ssy.test.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssy.test.board.impl.BoardDTO;
import com.ssy.test.util.Pager;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	
	//글목록
	@RequestMapping(value = "list.ssy", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		return mv; 
	}
	
	
	//글상세
	@RequestMapping(value="detail.ssy",method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}
	
	
	//글작성
	@RequestMapping(value = "add.ssy", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		return "board/add";
	}
	
	
	@RequestMapping(value = "add.ssy", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setAdd(boardDTO, files, session.getServletContext());
		mv.setViewName("redirect:./list.ssy");
		return mv;
	}
	
	
	//글수정
	@RequestMapping(value = "update.ssy")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		
		boardDTO = qnaService.getDetail(boardDTO);
		
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	
	
	@RequestMapping(value = "update.ssy", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setUpdate(boardDTO);
		//return "redirect:./detail.ssy?num="+boardDTO.getNum();
		return "redirect:./detail.ssy?num="+boardDTO.getNum();
	}
	
	
	//글삭제
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setDelete(boardDTO);
		return "redirect:./list.ssy";
	}
	
	//답글
	@PostMapping("reply.ssy")
	public String setReply(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.setReply(qnaDTO);
		return "redirect:./list.ssy";
	}
	
	
	//답글
	@GetMapping("reply.ssy")
	public ModelAndView setReply(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/reply");
		return mv;
	}
	
	
	
	
	

}