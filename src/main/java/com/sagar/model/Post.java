package com.sagar.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Integer postId;

	@Column(name = "post_name")
	@NotBlank(message = "Post can not be null or empty")
	private String postName;

	@Nullable
	private String url;

	@Nullable
	@Lob
	@Column(name = "post_desc")
	private String description;

	@Column(name = "vote_count")
	private Integer voteCount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@Column(name = "created_date")
	private Instant createdDate;

	@Column(name = "sub_reddit")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Subreddit subreddit;

}
