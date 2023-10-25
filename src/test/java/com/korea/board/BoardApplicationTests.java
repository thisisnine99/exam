package com.korea.board;

import com.korea.board.article.Article;
import com.korea.board.article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;

	@Test
	void contextLoads() {
		Article a = new Article();
		a.setTitle("안녕하세요");
		a.setContent("첫번째 글입니다.");
		a.setCreateDate(LocalDateTime.now());
		articleRepository.save(a);

		Article b = new Article();
		b.setTitle("반갑습니다");
		b.setContent("두번째 글입니다.");
		b.setCreateDate(LocalDateTime.now());
		articleRepository.save(b);
	}

}
