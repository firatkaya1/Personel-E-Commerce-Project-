package com.kayatech.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kayatech.enums.MessageType;
import com.kayatech.model.Comment;
import com.kayatech.model.Message;
import com.kayatech.model.Product;
import com.kayatech.service.CommentService;
import com.kayatech.service.MessageService;
import com.kayatech.service.ProductService;

@Controller
@RequestMapping("/admin")
public class MenuController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	MessageService messageService;
	
	@GetMapping("/")
	public String index(Model model) {
		return "/main";
	}
	@PostMapping("/")
	public String index() {
		return "/main";
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("allProduct",productService.getAllProducts());
		return "/main";
	}
	@PostMapping("/main")
	public String main() {
		return "/main";
	}
	
	@GetMapping("/product")
	public String product(Model model) {
		System.out.println("product GET çalıştı.");
		model.addAttribute("products",productService.getAllProducts());
		return "/product";
	}
	
	@PostMapping("/product")
	public String product() {
		return "/product";
	}
	
	@GetMapping("/product-settings")
	public String productSettings(Model model) {
		model.addAttribute("productCode",productService.findAllTags());
		model.addAttribute("allProduct",productService.getAllProducts());
		return "/product-settings";
	}
	
	@PostMapping("/product-settings")
	public String productSettings() {
		System.out.println("product-settings POST çalıştı.");
		return "/product-settings";
	}
	
	@GetMapping("/product-add")
	public String productAdd(Model model) {
		model.addAttribute("product", new Product());
		return "/product-add";
	}
	
	@PostMapping("/product-add")
	public String productAdd(@ModelAttribute Product product,@RequestParam("file") MultipartFile file,
															 @RequestParam("file1") MultipartFile file1,
															 @RequestParam("file2") MultipartFile file2,
															 @RequestParam("file3") MultipartFile file3) {
		List<MultipartFile> list =Arrays.asList(file,file1,file2,file3);
		productService.uploadFile(list);
		product.setProductHeaderImage(file.getOriginalFilename());
		product.setProductSlider1(file1.getOriginalFilename());
		product.setProductSlider2(file2.getOriginalFilename());
		product.setProductSlider3(file3.getOriginalFilename());
		productService.addProduct(product);
		
		return "redirect:/admin/product-settings";
		
	}
	
	@GetMapping("/product-update")
	public String productUpdate(@RequestParam("productCode") String code,Model model) {
		model.addAttribute("product",productService.findByProductCode(code));
		return "/product-update";
	}
	
	@PostMapping("/product-update")
	public String productUpdate(@ModelAttribute Product product, @RequestParam("file") MultipartFile file,
																 @RequestParam("file1") MultipartFile file1,
																 @RequestParam("file2") MultipartFile file2,
																 @RequestParam("file3") MultipartFile file3) {
		List<MultipartFile> list =Arrays.asList(file,file1,file2,file3);
		productService.uploadFile(list);
		product.setProductHeaderImage(file.getOriginalFilename());
		product.setProductSlider1(file1.getOriginalFilename());
		product.setProductSlider2(file2.getOriginalFilename());
		product.setProductSlider3(file3.getOriginalFilename());
		productService.uptadeProduct(product);
		return "redirect:/admin/product-settings";
	}
	
	@GetMapping("/product-delete")
	public String productDelete(@RequestParam("productCode") String code,Model model) {
		model.addAttribute("product",productService.findByProductCode(code));
		return "/product-delete";
	}
	
	@PostMapping("/product-delete")
	public String productDelete(@ModelAttribute Product product) {
		productService.deleteProduct(product.getProductCode());
		return "redirect:/admin/product-settings";
	}
	
	@GetMapping("/message")
	public String message(Model model) {
		model.addAttribute("messages",messageService.getTypeMessage(MessageType.BUY));
		return "/message";
	}
	
	@PostMapping("/message")
	public String message(@ModelAttribute Message message) {
		System.out.println(message.toString());
		return "/message";
	}
	
	@GetMapping("/message-show")
	public String messageShow(@RequestParam("messageId") Long id,Model model) {
		model.addAttribute("message",messageService.findById(id));
		return "/message-show";
	}
	
	@GetMapping("/message-delete")
	public String messageDelete(@RequestParam("messageId") Long id) {
		Message m1  = messageService.findById(id);
		m1.setMessageType(MessageType.DELETE.toString());
		messageService.updateMessage(m1);
		return "redirect:/admin/message";
	}
	
	@GetMapping("/message-settings")
	public String messageSettings(Model model) {
		System.out.println("message-settings GET çalıştı.");
		return "/message-settings";
	}
	@PostMapping("/message-settings")
	public String messageSettings() {
		System.out.println("message-settings POST çalıştı.");
		return "/message-settings";
	}
	
	@GetMapping("/comment")
	public String comment(Model model) {
		System.out.println("comment GET çalıştı.");
		model.addAttribute("comments",commentService.getAllComments());
		return "/comment";
	}
	
	@PostMapping("/comment")
	public String comment() {
		System.out.println("comment POST çalıştı.");
		return "/comment";
	}
	
	@GetMapping("/comment-show")
	public String commentShow(@RequestParam("commentId") String commentId,Model model) {
		model.addAttribute("comment",commentService.findByCommentId(commentId));
		return "/comment-show";
	}
	
	@PostMapping("/comment-show")
	public String commentShow(@ModelAttribute Comment comment) {
		commentService.updateComment(comment);
		return "redirect:/admin/comment";
	}
	
	@GetMapping("/comment-delete")
	public String commentDelete(@RequestParam("commentId") Long commentId,Model model) {
		commentService.deleteComment(commentId);
		return "redirect:/admin/comment";
	}
	
	
	@GetMapping("/statics")
	public String statics(Model model) {
		System.out.println("statics GET çalıştı.");
		return "/statics";
	}
	@PostMapping("/statics")
	public String statics() {
		System.out.println("statics POST çalıştı.");
		return "/statics";
	}
	
	@GetMapping("/error-message")
	public String errorMessage(Model model) {
		model.addAttribute("messages",messageService.getTypeMessage(MessageType.ERROR));
		return "/error-message";
	}
	@PostMapping("/error-message")
	public String errorMessage() {
		return "/error-message";
	}
	
	@GetMapping("/delete-message")
	public String deleteMessage(Model model) {
		model.addAttribute("messages",messageService.getTypeMessage(MessageType.DELETE));
		return "/delete-message";
	}
	@PostMapping("/delete-message")
	public String deleteMessage() {
		System.out.println("delete-message POST çalıştı.");
		return "/delete-message";
	}
	
	@GetMapping("/delete-message-really")
	public String deleteMessageComplete(@RequestParam("messageId")Long id) {
		messageService.deleteMessage(id);
		return "redirect:/admin/delete-message";
	}
	
	@GetMapping("/settings")
	public String settings(Model model) {
		System.out.println("settings GET çalıştı.");
		return "/settings";
	}
	@PostMapping("/settings")
	public String settings() {
		System.out.println("settings POST çalıştı.");
		return "/settings";
	}
	
	
}
