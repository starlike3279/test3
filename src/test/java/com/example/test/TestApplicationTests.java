package com.example.test;

import com.example.test.Article.Article;
import com.example.test.Article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;

	@Test
	void testJpa(){
		Article a = new Article();
		a.setTitle("제목");
		a.setContent("내용");
		this.articleRepository.save(a);
	}

	@Test
	void testJpa2(){
		Optional<Article> oa = this.articleRepository.findById(1);
		if(oa.isPresent()){
			Article a = oa.get();
			assertEquals("제목", a.getTitle());
		}
	}

	@Test
	void contextLoads() {
		List<Article> all = this.articleRepository.findAll();
		assertEquals(2, all.size());
	}
}
