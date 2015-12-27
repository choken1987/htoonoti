package com.htoo.htoonoti.crwal.web;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

@Controller
public class CrwalController {
	
	private static final Logger logger = LoggerFactory.getLogger(CrwalController.class);

	@RequestMapping(
			value = "/crwal/main.htoo",
			method = { RequestMethod.GET }
			)
	public String crwal(
			ModelMap model) throws Exception {
		
		return "htoo/htoonoti/crwal/main";
		
	}

	@RequestMapping(
			value = "/crwal/main.htoo",
			method = { RequestMethod.POST },
			produces="text/plain;charset=UTF-8"
			)
//	public @ResponseBody Map<String, String> crwalAjax(
	public @ResponseBody String crwalAjax(
			@RequestParam Map<String, String> paramMap,
//			@RequestParam Map<String, Object> paramMap,
//			HttpServletResponse rep,
			ModelMap model) throws Exception {
		
		logger.info("paramMap : " + paramMap.toString()); // TODO Delete
		
		String returnString = "";
		
		try {
			
			Document document = Jsoup.connect("http://zetawiki.com/wiki/").get();
			logger.info("document : " + document.toString()); // TODO Delete
			
			Elements targetElement = document.select("#mw-content-text > div:nth-child(3)");
			logger.info("targetElement : " + targetElement.toString()); // TODO Delete
			
			returnString = targetElement.text();
			logger.info("returnString : " + returnString.toString()); // TODO Delete
			
			returnString = returnString.split(" ")[0];
			logger.info("returnString : " + returnString.toString()); // TODO Delete
			
//			rep.setCharacterEncoding("text/html;charset=UTF-8");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnString;
		
	}
	
}
