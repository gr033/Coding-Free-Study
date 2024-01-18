package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Article {
    @Id             //엔티티 대푯값
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 생성기능(숫자가 자동으로 매겨짐)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

}
