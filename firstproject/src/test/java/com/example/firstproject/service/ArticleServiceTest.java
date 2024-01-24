package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;       //앞으로 사용할 수 있는 패키지 임포

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        //1. 예싱 데이터
        Article a = new Article(1L, "1", "123");
        Article b = new Article(2L, "2", "456");
        Article c = new Article(3L, "3", "789");
        List<Article> expected = new ArrayList<>(Arrays.asList(a, b, c));

        //2. 실제 데이터
        List<Article> articles = articleService.index();

        //3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_success() {
        //1. 예싱 데이터
        Long id = 1L;
        Article expected = new Article(id, "1", "123");

        //2. 실제 데이터
        Article article = articleService.show(id);

        //3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_failed() {
        //1. 예싱 데이터
        Long id = -1L;
        Article expected = null;

        //2. 실제 데이터
        Article article = articleService.show(id);

        //3. 비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_success() {
        //1. 예싱 데이터
        String title = "1";
        String content = "123";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        //2. 실제 데이터
        Article article = articleService.create(dto);

        //3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_failed() {
        //1. 예싱 데이터
        Long id = 4L;
        String title = "title";
        String content = "content";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        //2. 실제 데이터
        Article article = articleService.create(dto);

        //3. 비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_success1() {
        //1. 예싱 데이터
        String title = "updated title";
        String content = "updated content";
        ArticleForm dto = new ArticleForm(1L, title, content);
        Article expected = new Article(1L, title, content);

        //2. 실제 데이터
        Article article = articleService.update(1L, dto);

        //3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_success2() {
        //1. 예싱 데이터
        String title = "updated title";
        String content = "123";
        Article expected = new Article(1L, title, content);

        //2. 실제 데이터
        ArticleForm dto = new ArticleForm(1L, title, null);
        Article article = articleService.update(1L, dto);

        //3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_failed() {
        //1. 예싱 데이터
        Long id = -1L;
        String title = "updated title";
        String content = "updated content";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        //2. 실제 데이터
        Article article = articleService.update(id, dto);

        //3. 비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void delete_success() {
        //1. 예싱 데이터
        Article expected = new Article(1L, "1", "123");

        //2. 실제 데이터
        Article article = articleService.delete(1L);

        //3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void delete_failed() {
        //1. 예싱 데이터
        Article expected = null;

        //2. 실제 데이터
        Article article = articleService.delete(-1L);

        //3. 비교 및 검증
        assertEquals(expected, article);
    }
}