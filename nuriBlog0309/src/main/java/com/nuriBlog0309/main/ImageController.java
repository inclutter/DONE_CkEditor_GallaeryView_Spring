package com.nuriBlog0309.main;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

	private static final String FILE2 = "file";
	private static final String ARTICLE = "article";
	private static final String STATIC_IMAGES_THUMBNAILS = "/static/images/thumbnails/";
	private static final String UPLOADIMG = "/static/uploadimg/";
	private static final String UPLOADFILES = "/static/uploadfiles/";
	
	@Autowired
	ServletContext servletContext;
	
//	@ResponseBody
//	@RequestMapping("/summer_image")
//	public void summer_image(MultipartFile file, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		System.out.println("여기에 접속!!");
//		String save_folder = "C:/image/";
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		String file_name = file.getOriginalFilename();
//		String server_file_name = fileDBName(file_name, save_folder);
//		System.out.println("server file : " + server_file_name);
//		file.transferTo(new File(save_folder + server_file_name));
//		out.println("resources/upload"+server_file_name);
//		out.close();
//	}
//    private String fileDBName(String fileName, String saveFolder) {
//		Calendar c = Calendar.getInstance();
//		int year = c.get(Calendar.YEAR);
//		int month = c.get(Calendar.MONTH);
//		int date = c.get(Calendar.DATE);
//
//		String homedir = saveFolder + year + "-" + month + "-" + date;
//		System.out.println(homedir);
//		File path1 = new File(homedir);
//		if (!(path1.exists())) {
//			path1.mkdir();
//		}
//		Random r = new Random();
//		int random = r.nextInt(100000000);
//
//		int index = fileName.lastIndexOf(".");
//
//		String fileExtension = fileName.substring(index + 1);
//		System.out.println("fileExtension = " + fileExtension);
//
//		String refileName = "bbs" + year + month + date + random + "." + fileExtension;
//		System.out.println("refileName = " + refileName);
//
//		String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
//		System.out.println("fileDBName = " + fileDBName);
//
//		return fileDBName;
//	}
	
	@ResponseBody
	@RequestMapping("/summer_image")
	public void  summer_image(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("===>컨트롤러 접속!!");
		String save_folder = "C:/image/";
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String file_name = file.getOriginalFilename();
		String server_file_name = fileDBName(file_name, save_folder);
		System.out.println("server file : " + server_file_name);
		file.transferTo(new File(save_folder + server_file_name));
		out.println("resources/upload"+server_file_name);
		out.close();
	}
    private String fileDBName(String fileName, String saveFolder) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);

		String homedir = saveFolder + year + "-" + month + "-" + date;
		System.out.println(homedir);
		File path1 = new File(homedir);
		if (!(path1.exists())) {
			path1.mkdir();
		}
		Random r = new Random();
		int random = r.nextInt(100000000);

		int index = fileName.lastIndexOf(".");

		String fileExtension = fileName.substring(index + 1);
		System.out.println("fileExtension = " + fileExtension);

		String refileName = "bbs" + year + month + date + random + "." + fileExtension;
		System.out.println("refileName = " + refileName);

		String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
		System.out.println("fileDBName = " + fileDBName);

		return fileDBName;
	}

    
}