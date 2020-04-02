package com.kayatech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "comment_id")
	private String commentId;
	
	@Column(name = "product_code")
	private String productCode;
	
	@Column(name = "comment_email")
	private String commentEmail;
	
	@Column(name = "comment_name")
	private String commentName;
	
	@Column(name = "comment_tag")
	private String commentTag;
	
	@Column(name = "comment_date")
	private String commentDate;
	
	@Column(name = "comment_hide")
	private boolean commentHide;
	
	@Column(name = "comment_description")
	private String commentDescription;

	public Comment() {}

	public Comment(long id, String commentId, String productCode, String commentEmail, String commentName,
			String commentTag, String commentDate, boolean commentHide) {
		super();
		this.id = id;
		this.commentId = commentId;
		this.productCode = productCode;
		this.commentEmail = commentEmail;
		this.commentName = commentName;
		this.commentTag = commentTag;
		this.commentDate = commentDate;
		this.commentHide = commentHide;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getCommentEmail() {
		return commentEmail;
	}

	public void setCommentEmail(String commentEmail) {
		this.commentEmail = commentEmail;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getCommentTag() {
		return commentTag;
	}

	public void setCommentTag(String commentTag) {
		this.commentTag = commentTag;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public boolean isCommentHide() {
		return commentHide;
	}

	public void setCommentHide(boolean commentHide) {
		this.commentHide = commentHide;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentId=" + commentId + ", productCode=" + productCode + ", commentEmail="
				+ commentEmail + ", commentName=" + commentName + ", commentTag=" + commentTag + ", commentDate="
				+ commentDate + ", commentHide=" + commentHide + ", commentDescription=" + commentDescription + "]";
	}

	
	
	
	
	
	
}
