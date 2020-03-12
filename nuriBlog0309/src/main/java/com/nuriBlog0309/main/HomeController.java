package com.nuriBlog0309.main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private static final String FILE2 = "file";
	private static final String ARTICLE = "article";
	private static final String STATIC_IMAGES_THUMBNAILS = "/static/images/thumbnails/";
	private static final String UPLOADIMG = "/static/uploadimg/";
	private static final String UPLOADFILES = "/static/uploadfiles/";
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ServletContext servletContext;
	@Autowired
	DBService dbService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model, HttpServletRequest request, VO vo) {
		// 이미지 갯수
		int number = 0;
		// 현재 페이지 갯수
		int currentPageNo = 0;
		// 현재 총 레코드 갯수
		int currentRecord = 0;

		if (request.getParameter("number") != null) {
			number = Integer.parseInt(request.getParameter("number"));
		} else {
			number = 3;
		}

		if (request.getParameter("currentPageNo") != null) {
			currentPageNo = (Integer.parseInt(request.getParameter("currentPageNo")));
			currentRecord = ((currentPageNo - 1) * (number * 4));
			if (currentPageNo <= 0) {
				currentPageNo = 0;
				currentRecord = currentPageNo * (number * 4);
			}
		}

		BoardPaging bp = new BoardPaging(dbService.getCount(), currentPageNo, number);
		System.out.println("레코드값 : " + dbService.getCount());

		// 페이지 안에 표시되는 레코드 갯수 셋팅
		if (currentRecord == 0) {
			vo.setMinLimit(currentRecord);
		} else {
			vo.setMinLimit(currentRecord+1);
		}

		vo.setMaxLimit(currentRecord + (number * 4));
		System.out.println("현재 페이지 : " + currentPageNo);
		System.out.println("최소값 : " + vo.getMinLimit());
		System.out.println("최대값 : " + vo.getMaxLimit());

		ModelAndView mav = new ModelAndView("home");
		// 리스트
		mav.addObject("boardList", dbService.listBoard(vo));
		// 이미지 갯수 view로 전달
		mav.addObject("number", number);
		// 페이징 처리 view로 전달
		mav.addObject("boardPage", bp);

		return mav;
	}

//	@ResponseBody
//	@RequestMapping("/article")
//	public String imageUpload(MultipartHttpServletRequest request) throws IOException
//	{
//		System.out.println("여기 접속?");
//		
//		// 01. 리퀘스트에서 멀티파트파일을 받아서
//		MultiValueMap<String, MultipartFile> multiFileMap = request.getMultiFileMap();
//		List<MultipartFile> list = multiFileMap.get(FILE2);
//		MultipartFile multipartFile = list.get(0);
//		LOGGER.debug(multipartFile.getOriginalFilename());
//
//		// 02. 파일을 전송하고
//		String webappRoot = servletContext.getRealPath("/");
//		String filename = UPLOADIMG + multipartFile.getOriginalFilename();
//		File file = new File(webappRoot + filename);
//		multipartFile.transferTo(file);
//		
//		System.out.println("저장 주소 : "+webappRoot);
//		// 03. 마지막에 최종 주소를 반환한다.
//		// requet.getServername 을 하니, ajax에서 보내는 값이 리퀘스트 정보에 안떠서 InetAddress로
//		// 받았다.
//		String localIP = InetAddress.getLocalHost().getHostAddress();
//		// http://를 붙여줘야 에디터 창에서 불러올 수가 있다. 음.. 자바스크립트내에서 붙일까? 일단 그냥 적자.
//		return "http://" + localIP+ ":" + request.getServerPort() + filename;
//	}

	@RequestMapping("/insertForm.do")
	public String insertForm() {
		return "insertForm";
	}

}
