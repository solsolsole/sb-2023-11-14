package com.ll.sb20231114.domain.article.article.repository;

import com.ll.sb20231114.domain.article.article.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {
    private final List<Article> articles = new ArrayList<>();

    public Article save(Article article){  // 추가
        if (article.getId() == null){
            article.setId(articles.size() + 1L);
        }
        articles.add(article);

        return article;
    }

    public Article findLastArticle() { // 조회
        return articles.getLast();
    }

    public List<Article> findAll () { // 조회
        return articles;
    }
}
