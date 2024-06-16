package com.smhrd.personalrecipe;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "index";
	}
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String cart() {
		return "shopping-cart";
	}
	
	@RequestMapping(value="/shopgrid", method=RequestMethod.GET)
	public String shopGrid() {
		return "shop-grid";
	}
	
	@RequestMapping(value="/shopdetail", method=RequestMethod.GET)
	public String shopDetail() {
		return "shop-details";
	}
	
	@RequestMapping(value="/recipe", method=RequestMethod.GET)
	public String recipe() {
		return "recipe";
	}
	
	@RequestMapping(value="/recipedetail", method=RequestMethod.GET)
	public String recipeDetail() {
		return "recipe-details";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "join";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String myPage() {
		return "mypage";
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public String checkout() {
		return "checkout";
	}
	
//	@Controller
//	public class ChatbotController {
//
//	    @GetMapping("/chatbot")
//	    public String chatbot(Model model) {
//	        model.addAttribute("initMessage", "안녕하세요? 어떤 레시피를 추천해드릴까요?");
//	        return "chatbot";
//	    }
//	}
	
	// ChatGPT Api
	private String openaiApiKey = "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";
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
	    restTemplate.getInterceptors().add((request, body, execution) -> {
	        request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
	        return execution.execute(request, body);
	    });
		return restTemplate;
	}
	
}
