package lv.raimonds.SpringBootPostsApp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lv.raimonds.SpringBootPostsApp.model.Post;
import lv.raimonds.SpringBootPostsApp.service.PostService;
import org.thymeleaf.util.StringUtils;

public record BlogPostTitleValidator(PostService postService) implements ConstraintValidator<BlogPostTitleAlreadyExists, Post> {
	@Override
	public boolean isValid(Post post, ConstraintValidatorContext constraintValidatorContext) {
		if (!StringUtils.isEmpty(post.getTitle()) && postService.postExistsWithTitle(post.getTitle())) {
			constraintValidatorContext.disableDefaultConstraintViolation();
			constraintValidatorContext.buildConstraintViolationWithTemplate("Title Already Exists")
					.addPropertyNode("title")
					.addConstraintViolation();
			return false;
		}
		return true;
	}

	@Override
	public void initialize(BlogPostTitleAlreadyExists constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
}
