package com.apress.isf.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apress.isf.spring.data.DocumentDAO;

@Controller//��Ʈ�ѷ�  ����
@RequestMapping("/search")//��Ʈ�ѷ� ���ٹ�� ��� 
public class SearchController {

	@Autowired//DAO�������̽����� ������ ����ü ����  
	DocumentDAO documentDAO;

	@RequestMapping(value="/all", method=RequestMethod.GET)
	//get������� ���� ���ͳݿ��� �����Ҷ� http://<server>/<context>/<servletname>/search/all������ �ȴ�.
	public String searchAll(Model model) {
		model.addAttribute("docs", documentDAO.getAll());
		return "search/all";
	}

}
