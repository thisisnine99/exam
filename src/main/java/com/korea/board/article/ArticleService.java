package com.korea.board.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public void create(Article article) {
        articleRepository.save(article);
    }

    public Article findById(Integer id) {
        return articleRepository.findById(id).get();
    }
}
