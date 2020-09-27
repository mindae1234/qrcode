package com.sw.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home",  method = {RequestMethod.GET, RequestMethod.POST})
	public String home(Locale locale, Model model, HttpServletRequest request) {
		
		if(request.getParameter("kk")==null) {
			return "/home";
		}
		else if(request.getParameter("kk").equals(null)) {
			return "/home";
		}else if(request.getParameter("kk").equals("ko")) {
			return "/home1";
		}
		String code = "100";
		
		System.out.println("!!!");
		
		return "/home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/qrcode",  method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> qrcode(Locale locale, Model model, HttpServletRequest request) {
		
		System.out.println("@@@");
		String part = request.getParameter("content");
		System.out.println("ASDfadsf"+part);
		
		
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		Map<String, Object> rmap2 = new HashMap<String, Object>();
		rmap2.put("part", part);
		
		int i = rmap2.size();
		System.out.println(i);
		String n = Integer.toString(i);
		System.out.println(n);
	
		try {
			File file = null;
			// 큐알이미지를 저장할 디렉토리 지정
			String root = request.getSession().getServletContext().getRealPath("/");
			String path = "E:\\test\\qrcode\\src\\main\\webapp\\resources\\image" + File.separator;
			//System.out.println("E:\\test\\qrcode\\src\\main\\webapp\\resources\\image");
			file = new File("E:\\test\\qrcode\\src\\main\\webapp\\resources\\image");
			if(!file.exists()) {
				file.mkdirs();
			}
			// 코드인식시 링크걸 URL주소
			//String codeurl = new String("http://localhost:8080/test/home?part="+part+"&qrcode="+n.getBytes("UTF-8"), "ISO-8859-1");
			String tmp = "http://localhost:8080/test/home?part="+part+"&qrcode="+n.getBytes("UTF-8");		      
		    String codeurl = new String(tmp.getBytes("UTF-8"), "ISO-8859-1");
			// 큐알코드 바코드 생상값
			int qrcodeColor =   0xFF2e4e96;
			// 큐알코드 배경색상값
			int backgroundColor = 0xFFFFFFFF;

			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			// 3,4번째 parameter값 : width/height값 지정
			BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE,400, 400);
			//
			MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
			// ImageIO를 사용한 바코드 파일쓰기
			ImageIO.write(bufferedImage, "jpg", new File(path+part+".jpg"));
			String img=path+part+".jpg";
			System.out.println(img);
			rmap.put("img",img);
			
			
			return rmap;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		return rmap;
	}
	@RequestMapping(value = "/home1",  method = {RequestMethod.GET, RequestMethod.POST})
	public String home1(Locale locale, Model model, HttpServletRequest request) {
		
		String aaaa = request.getParameter("ddd");
		if(aaaa ==null) {
			return "/";
		}
		return "/home1";
	}
	
	@RequestMapping(value = "/scanner",  method = {RequestMethod.GET, RequestMethod.POST})
	public String scanner(Locale locale, Model model, HttpServletRequest request) {

		String aaaa = request.getParameter("ddd");
		String chk1 = request.getParameter("chk1");
		
		if(aaaa ==null) {
			aaaa = "no";
		}
		if(chk1 == null) {
			chk1 = "no";
		}
		
		request.getAttribute(chk1);
		request.getAttribute(aaaa);
	
		return "/scanner";
	}
	
	@RequestMapping(value = "/one",  method = {RequestMethod.GET, RequestMethod.POST})
	public String one(Locale locale, Model model, HttpServletRequest request) {
		
		String aaaa = request.getParameter("ddd");
		String chk1 = request.getParameter("chk1");
		
		if(aaaa ==null) {
			aaaa = "no";
		}
		if(chk1 == null) {
			chk1 = "no";
		}
		
		request.getAttribute(chk1);
		request.getAttribute(aaaa);
		
		return "/one";
	}
	
	@RequestMapping(value = "/two",  method = {RequestMethod.GET, RequestMethod.POST})
	public String first(Locale locale, Model model, HttpServletRequest request) {
		

		String aaaa = request.getParameter("ddd");
		String chk1 = request.getParameter("chk1");
		
		if(aaaa ==null) {
			aaaa = "no";
		}
		if(chk1 == null) {
			chk1 = "no";
		}
		
		request.getAttribute(chk1);
		request.getAttribute(aaaa);
	
		return "/two";
	}

	
	
	
	
	
	
}
