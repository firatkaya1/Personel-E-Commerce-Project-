package com.kayatech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kayatech.model.Comment;

@Service
public interface CommentService {

	Comment addComment(Comment comment);
	
	Comment updateComment(Comment comment);
	
	void deleteComment(Long id);
	
	Comment findByCommentId(String commentId);
	
	List<Comment> getAllComments();
	
}
