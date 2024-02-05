//package com.sonam.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

//import com.sonam.utils.EmailService;

//@RestController
//public class EmailController {

//	@Autowired
//	private EmailService emailService;
//	
//	@GetMapping("/send-email")
//	public String sendEmail()
//	{
//		emailService.sendEmail("Email", "otp verification", "The otp to verify your email" );
//		return "Email sent successfully";
//		
//	}
//}
