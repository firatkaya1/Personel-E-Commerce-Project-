package com.kayatech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kayatech.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	Comment findByCommentId(String commentId);
	
	List<Comment> findByProductCode(String productCode);
	
	
	
	List<Comment> findAll();
	
	
}
