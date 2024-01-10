package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired  //스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입(DI)
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());
        //1. DTO를 엔티티로 변환
        Article article = form.toEntity();

        //DTO가 엔티티로 잘 변환되는지 확인
        System.out.println(article.toString());

        //2. 리퍼지토리로 엔티티 DB에 저장
        Article saved = articleRepository.save(article);

        //article이 DB에 잘 저장되는지 확인
        System.out.println(saved.toString());
        return "";
    }
}
