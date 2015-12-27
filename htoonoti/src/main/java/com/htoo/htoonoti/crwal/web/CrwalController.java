package com.htoo.htoonoti.crwal.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			
			// 변수들
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("<hr />");
			
			String page = paramMap.get("page");
			String eventNum = "";
			Document eventDocument = null;
			Elements infoElements = null;
			
			// 이벤트 리스트 페이지
			// event 번호 구함
			Document eventListDocument = Jsoup.connect("" + page + "&c=&sort=latest").get();
			
			Elements aEventList = eventListDocument.select("#content > article > div.container > ul > li > div.eventBottomArea > span.pin > a");
			
			// FIXME: 다수 이벤트 번호 가져와야 함; 12개
//			eventNum = aEventList.attr("data-event");
			
			//
			List<Object> eventList = new ArrayList<Object>();
			for (Element element : aEventList) {
				
				Map<String, Object> eventMap = new HashMap<String, Object>();
				Map<String, String> event = new HashMap<String, String>();
				///////////////////////////////
				
				eventNum = element.attr("data-event");
				
				// event 상세 페이지
				eventDocument = Jsoup.connect("" + eventNum).get();
				
//				infoElements = eventDocument.select(".eventInfo, .hostInfo");
//				infoElements.select(".strGarbage").remove();
//				stringBuffer.append(infoElements.html());
				// 일단 정제하지 않고 뿌려주는 걸로..
				infoElements = eventDocument.select(".eventView");
				stringBuffer.append(infoElements.html());
				
				//
				stringBuffer.append("<hr />");
				
				///////////////////////////////
				eventMap.put(eventNum, event);
				String[] targets = {
						"eventIdx",
						"eventNum",
						"eventTimeSpan",
						"eventLocation",
						"eventContent",
						"attend",
						};
				for (String target : targets) {
					event.put(target, eventDocument.select("." + target).html());
				}
				
				eventList.add(eventMap);
				logger.info("eventMap : " + eventMap.toString()); // TODO Delete
			}
			
			returnString = stringBuffer.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnString;
		
	}
	
}
