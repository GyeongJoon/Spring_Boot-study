package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.firstproject.repository.ArticleRepository;

@Controller
public class ArticleController {
    @Autowired // 스프링 부트가 미리 생성해 높은 리파지터리 객체 주입(DI)
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());
        Article article = form.toEntity();
        Article saved =  articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
