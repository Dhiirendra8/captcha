package com.captcha.controller;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.captcha.model.Captcha;
import com.captcha.service.CaptchaGenerator;

@Controller
public class CaptchaController {

	
	public static final String CAPTCHA = "CAPTCHA";
	public static final String FILE_TYPE = "jpeg";
	
	@RequestMapping(value="/captchaPage")
	public String homepage(Model model){
		Captcha captcha= new Captcha();
		model.addAttribute("captcha", captcha);
		return "captcha";
	}
	
	@RequestMapping(value = "/captcha", method = RequestMethod.POST)
	public String login(@ModelAttribute("captcha") Captcha captcha,BindingResult result,Model model,HttpSession session) {
		System.out.println("--------Inside captcha-------");
		String cap = (String) session.getAttribute(CAPTCHA);
		if(cap == null || (cap != null && !cap.equals(captcha.getCaptcha()))){
			captcha.setCaptcha("");
			model.addAttribute("message", "Captcha does not match");
			return "captcha";
		}

		return "home";
		
	}
	
	@RequestMapping(value = "/captcha.jpg", method = RequestMethod.GET)
	protected void captchaImage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Max-Age", 0);
		response.setContentType("image/jpeg");

		String captchaStr="";

		System.out.println("------------------In captcha---------------");

		captchaStr = CaptchaGenerator.generateCaptchaTextMethod2(6);


		try {
			int width=100;     	
			int height=40;

			Color bg = new Color(0,255,255);
			Color fg = new Color(0,100,0);

			Font font = new Font("Arial", Font.BOLD, 20);
			BufferedImage cpimg =new BufferedImage(width,height,BufferedImage.OPAQUE);
			Graphics g = cpimg.createGraphics();

			g.setFont(font);
			g.setColor(bg);
			g.fillRect(0, 0, width, height);
			g.setColor(fg);
			g.drawString(captchaStr,10,25);   

			HttpSession session = request.getSession(true);
			session.setAttribute(CAPTCHA, captchaStr);

			OutputStream outputStream = response.getOutputStream();

			ImageIO.write(cpimg, FILE_TYPE, outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
