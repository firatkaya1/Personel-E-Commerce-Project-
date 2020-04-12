package com.kayatech.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kayatech.enums.MessageType;
import com.kayatech.model.Comment;
import com.kayatech.model.Message;
import com.kayatech.service.CommentService;
import com.kayatech.service.MessageService;
import com.kayatech.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CommentService commentService;

	@GetMapping(value = "/index")
	public String index() {
		return "/index";
	}
	
	@GetMapping(value = "/contact")
	public String contact(Model model) {
		model.addAttribute("message",new Message());
		return "/contact";
	}
	
	@PostMapping(value = "/contact")
	public String contact(@ModelAttribute Message message) {
		
		message.setProductTag("Contact");
		message.setProductCode("000000");
		messageService.addMessage(message);

		return "/index";
	}
	
	@GetMapping(value = "/products")
	public String products(Model model) {
		return "/products";
	}
	@PostMapping(value = "/products")
	public String products() {
		return "/products";
	}
	
	@GetMapping(value = "/products/{productTag}")
	public String forms(Model model,@PathVariable("productTag") String productTag) {
		model.addAttribute("products",productService.findByProductTag(productTag));
		
		return "/form";
	}
	
	@GetMapping(value = "/team")
	public String team(Model model) {
		return "/team";
	}
	@PostMapping(value = "/team")
	public String team() {
		return "/team";
	}
	
	@GetMapping(value = "/blog")
	public String blog(Model model) {
		return "/blog";
	}
	@PostMapping(value = "/blog")
	public String blog() {
		return "/blog";
	}

	
	@GetMapping(value = "/products/{productTag}/buy")
	public String buy(Model model,@PathVariable("productTag") String productTag,  @RequestParam("productCode") String productCode) {
		model.addAttribute("products",productService.findByProductCode(productCode));
		List<Comment> list = commentService.findByProductCode(productCode);
		model.addAttribute("comments",list);
		model.addAttribute("maxComment",list.size());
		model.addAttribute("messages",new Message());
		model.addAttribute("comment",new Comment());
		return "/buy";
	}
	
	@PostMapping(value = "/products/{productTag}/buy")
	public String buy(@ModelAttribute Message message,@PathVariable("productTag") String productTag) {
		message.setMessageType(MessageType.BUY.toString());
		messageService.addMessage(message);
		return "redirect:/products/"+productTag+"/buy?productCode="+message.getProductCode();
	}
	
	@PostMapping(value = "/products/{productTag}/error")
	public String errorPost(@ModelAttribute Message message,@PathVariable("productTag") String productTag) {	
		message.setMessageType(MessageType.ERROR.toString());
		messageService.addMessage(message);
		return "redirect:/products/"+productTag+"/buy?productCode="+message.getProductCode();
	}
	
	@PostMapping(value = "/products/{productTag}/comment")
	public String commentPost(@ModelAttribute Comment comment,@RequestParam("productCode") String productCode,@PathVariable("productTag") String productTag) {
		comment.setProductCode(productCode);
		comment.setCommentTag(productTag);
		commentService.addComment(comment);
		return "redirect:/products/"+productTag+"/buy?productCode="+comment.getProductCode();
	}

	@GetMapping(value = "/products/{productTag}/comment")
	public String commentLike(@RequestParam("commentId") String commentId,@PathVariable("productTag") String productTag) {
		
		Comment comment = commentService.findByCommentId(commentId);
		comment.setCommentLike(comment.getCommentLike() + 1);
		
		commentService.updateComment(comment);
		
		return "redirect:/products/"+productTag+"/buy?productCode="+comment.getProductCode();
	}
	
	
}
