package com.htoo.htoonoti.common.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.htoo.htoonoti.common.service.IndexService;
import com.htoo.htoonoti.common.service.impl.IndexServiceImpl;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexServiceImpl.class);

	@Resource(name = "indexService")
	private IndexService indexService;

	@RequestMapping(value = "/index.htoo")
	public String index(
			ModelMap model) throws Exception {
		
		logger.info("come: /index.htoo");
		
//		return "/jsp/htoo/htoonoti/index/index";
//		return "/WEB-INF/jsp/htoo/htoonoti/index/index";
//		return "sample/egovSampleList";
		return "htoo/htoonoti/index/index";
		
	}

}
