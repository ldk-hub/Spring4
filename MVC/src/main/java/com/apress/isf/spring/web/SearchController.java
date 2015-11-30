package com.apress.isf.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apress.isf.spring.data.DocumentDAO;

@Controller//컨트롤러  선언
@RequestMapping("/search")//컨트롤러 접근방법 명시 
public class SearchController {

	@Autowired//DAO인터페이스에서 선언한 구현체 주입  
	DocumentDAO documentDAO;

	@RequestMapping(value="/all", method=RequestMethod.GET)
	//get방식으로 설정 인터넷에서 접속할때 http://<server>/<context>/<servletname>/search/all식으로 된다.
	public String searchAll(Model model) {
		model.addAttribute("docs", documentDAO.getAll());
		return "search/all";
	}

}
