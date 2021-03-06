package com.codingdojo.repasoexamen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.repasoexamen.models.Comment;
import com.codingdojo.repasoexamen.repositories.CommentRepository;

@Service
public class CommentService {
	private final CommentRepository commentRepo;

	public CommentService(CommentRepository commentRepo) {
		this.commentRepo = commentRepo;
	}

	public Comment create(Comment c) {
		return commentRepo.save(c);
	}

	public List<Comment> getAll() {
		return (List<Comment>) commentRepo.findAll();
	}

	public Comment getOne(Long id) {
		Optional<Comment> comment = commentRepo.findById(id);
		return comment.isPresent() ? comment.get() : null;
	}

	public Comment update(Comment toUpdate) {
		return commentRepo.save(toUpdate);
	}
}
