package com.sagar.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Subreddit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Community name is required")
	@Column(name = "comm_name")
	private String commName;

	@NotBlank(message = "Description is required")
	private String description;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> posts;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@Column(name = "created_date")
	private Instant createdDate;

}
