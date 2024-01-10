package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class ArticleForm {
    private String title;
    private String content;

    //전송받을 제목과 내용을 필드에 저장하는 생성자(constructor) 추가
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //데이터를 잘 받았는지 확인
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null,title, content);
    }
}
