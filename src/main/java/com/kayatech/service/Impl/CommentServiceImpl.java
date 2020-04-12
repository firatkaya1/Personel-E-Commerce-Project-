package com.kayatech.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayatech.model.Comment;
import com.kayatech.repository.CommentRepository;
import com.kayatech.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private final CommentRepository commentRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}

	@Override
	public Comment addComment(Comment comment) {
		Comment c1 = new Comment();
		
		c1.setCommentId(UUID.randomUUID().toString());
		c1.setProductCode(comment.getProductCode());
		c1.setCommentEmail(comment.getCommentEmail());
		c1.setCommentName(comment.getCommentName());
		c1.setCommentTag(comment.getCommentTag());
		c1.setCommentDate(dateFormat(new Date()));
		c1.setCommentHide(false);
		c1.setCommentDescription(comment.getCommentDescription());
		c1.setCommentLike(0);
		
		return commentRepository.save(c1);
	}

	@Override
	public void deleteComment(Long id) {
		 commentRepository.deleteById(id);
	}

	@Override
	public Comment findByCommentId(String commentId) {
		return commentRepository.findByCommentId(commentId);
	}

	@Override
	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}

	@Override
	public Comment updateComment(Comment comment) {
		
		Comment c1 = new Comment();
		
		c1.setId(comment.getId());
		c1.setCommentId(comment.getCommentId());
		c1.setProductCode(comment.getProductCode());
		c1.setCommentEmail(comment.getCommentEmail());
		c1.setCommentName(comment.getCommentName());
		c1.setCommentTag(comment.getCommentTag());
		c1.setCommentDate(comment.getCommentDate());
		c1.setCommentHide(comment.isCommentHide());
		c1.setCommentDescription(comment.getCommentDescription());
		c1.setCommentLike(comment.getCommentLike());
		
		return commentRepository.save(c1);
	}

	@Override
	public List<Comment> findByProductCode(String productCode) {
		return commentRepository.findByProductCode(productCode);
	}
	
	public String dateFormat(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = format.format(date);		
		return dateString;
	}
	
	
	
}
