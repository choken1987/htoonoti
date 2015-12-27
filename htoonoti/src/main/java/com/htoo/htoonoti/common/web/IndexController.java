package com.htoo.htoonoti.common.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.htoo.htoonoti.common.service.IndexService;

@Controller
public class IndexController {

	@Resource(name = "indexService")
	private IndexService indexService;

	@RequestMapping(value = "/")
	public String root(
			ModelMap model) throws Exception {
		
		return "forward:/index.htoo";
//		return "redirect:/index.htoo";
		
	}

	@RequestMapping(value = "/index.htoo")
	public String index(
			ModelMap model) throws Exception {

		return "index";
		
	}

}
