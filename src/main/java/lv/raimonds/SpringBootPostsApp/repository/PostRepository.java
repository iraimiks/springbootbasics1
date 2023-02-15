package lv.raimonds.SpringBootPostsApp.repository;

import lv.raimonds.SpringBootPostsApp.model.Post;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Repository
public class PostRepository {
	private final Set<Post> postSet = new CopyOnWriteArraySet<>();
	public void addPost(Post post) {
		postSet.add(post);
	}

	public Set<Post> findAllPosts() {
		return postSet;
	}
}
