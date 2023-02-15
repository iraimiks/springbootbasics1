package lv.raimonds.SpringBootPostsApp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lv.raimonds.SpringBootPostsApp.model.Post;
import lv.raimonds.SpringBootPostsApp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping("/add")
	public String addPostPage(Model model) {
		model.addAttribute("post", new Post());
		return "addPosts";
	}

	@PostMapping
	public String addPost(@ModelAttribute("post") @Valid Post post, Errors errors) {
		if (errors.hasErrors()) {
			return "addPosts";
		}
		postService.addPost(post);
		return "redirect:/posts";
	}

	@GetMapping
	public String postPage(Model model) {
		model.addAttribute("posts", postService.findAllPosts());
		return "post";
	}

}
