package com.ssy.test.bankBook;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="delete.ssy", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setDelete(bankBookDTO);
		mv.setViewName("redirect:./list.ssy");
		return mv;
	}
	
	
	@RequestMapping(value="update.ssy", method=RequestMethod.GET)
	public void Update(BankBookDTO bankBookDTO, Model model) throws Exception{
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	
	@RequestMapping(value="update.ssy", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO, Model model)throws Exception{
		int result = bankBookService.setUpdate(bankBookDTO);
		return "redirect:./detail.ssy?bookNum="+bankBookDTO.getBookNum();
	}
	
	
	@RequestMapping(value="add.ssy", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		Calendar ca = Calendar.getInstance();
		bankBookDTO.setBookNum(ca.getTimeInMillis());
		int result = bankBookService.setBankBook(bankBookDTO);
		
		//상품 등록 후 리스트페이지로 이동
		mv.setViewName("redirect:./list.ssy");
		return mv;
	}

	//  /bankbook/add GET /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value="add.ssy", method = RequestMethod.GET)
	public void add()throws Exception{
		System.out.println("ADD");
	}
	
	
	@RequestMapping(value="list.ssy", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		System.out.println("LIST");
		//DB 없으면
		List<BankBookDTO> ar = bankBookService.getList();
		
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	
	@RequestMapping(value="detail.ssy", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception{
		System.out.println("DETAIL");
		//스프링이 하는 과정을 직접 객체를 만들어 보내도 됨
		ModelAndView mv = new ModelAndView();
		
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDTO);
		
		return mv;
	}
	
	
	
	
	
	
	
	
}
