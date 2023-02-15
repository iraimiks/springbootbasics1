package lv.raimonds.SpringBootPostsApp.service;

import lombok.RequiredArgsConstructor;
import lv.raimonds.SpringBootPostsApp.model.Post;
import lv.raimonds.SpringBootPostsApp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	public void addPost(Post post) {
		postRepository.addPost(post);
	}

	public Set<Post> findAllPosts() {
		return postRepository.findAllPosts();
	}

	public boolean postExistsWithTitle(String title) {
		return postRepository.findAllPosts().stream()
				.anyMatch(post -> post.getTitle().equals(title));
	}
}
