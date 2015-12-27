package com.htoo.htoonoti.crwal.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrwalController {
	
	private static final Logger logger = LoggerFactory.getLogger(CrwalController.class);

	@RequestMapping(value = "/content1.htoo")
	public String content1(
			ModelMap model) throws Exception {
		
		return "htoo/htoonoti/content1/main";
		
	}

}
