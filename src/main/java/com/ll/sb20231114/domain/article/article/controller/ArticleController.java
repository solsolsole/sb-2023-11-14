package com.ll.sb20231114.domain.article.article.controller;

import com.ll.sb20231114.domain.article.article.entity.Article;
import com.ll.sb20231114.domain.article.article.service.ArticleService;
import com.ll.sb20231114.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/article/write")
    String showWrite (){
        return "article/write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData write (
            String title,
            String body
    ) {

       Article article = articleService.write(title, body);

        RsData<Article> rs = new RsData<>(
               "S-1",
               String.format("%d번이 작성되었습니다.", article.getId()),
               article
       );

       return rs;

    }

    @GetMapping("article/getLastArticle")
    @ResponseBody
    Article getLastArticle(){
        return articleService.findLastArticle();
    }

    @GetMapping("article/getArticles")
    @ResponseBody
    List<Article> getArticles(){
        return articleService.findAll();
    }
}


