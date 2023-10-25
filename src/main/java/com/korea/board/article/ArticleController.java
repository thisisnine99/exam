package com.korea.board.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articleList = articleService.getList();
        model.addAttribute("articleList", articleList);
        model.addAttribute("article", articleList.get(0));
        return "main";
    }

    @PostMapping("/create")
    public String create(Model model) {
        Article article = new Article();
        article.setTitle("NewTitle...");
        article.setContent("");
        article.setCreateDate(LocalDateTime.now());
        articleService.create(article);
        model.addAttribute("articleList", articleService.getList());
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Article article = articleService.findById(id);
        model.addAttribute("article", article);
        model.addAttribute("articleList", articleService.getList());
        return "main";
    }

    @PostMapping("update")
    public String update(String title, String content, int id) {
        Article article = articleService.findById(id);
        article.setTitle(title);
        article.setContent(content);
        articleService.create(article);
        return "redirect:/article/detail/" + id;
    }
}
