package com.example.test.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
@Controller
public class ArticleContoller {

    private final ArticleService articleService;
    private final ArticleService articleRepository;

    @GetMapping("/article/list")
    public String list(Model model){
        List<Article> articleList = this.articleRepository.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @GetMapping(value = "/article/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        return "article_detail";
    }
}
