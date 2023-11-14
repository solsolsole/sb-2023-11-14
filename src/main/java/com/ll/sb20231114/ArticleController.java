package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {

    private List<Article> articles = new ArrayList<>();

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @GetMapping("/article/doWrite")
    @ResponseBody // 여기는 리턴을 html로 안했으니까 이걸 써줘야함
    RsData doWrite(  //doWrite가 RsData 객체를 반환한다.
            String title,
            String body
    ) {
        Article article = new Article(articles.size() + 1, title, body);
        articles.add(article);

        RsData<Article> rs = new RsData<>(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),
                article
        );

        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articles.getLast();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articles;
    }

}

@AllArgsConstructor
@Getter
class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;   // 데이터 값이 스트링일수도 인트일수도 즉 아티클일지 목록일지 모르니까 제너릭스를 사용한다.
}

    @AllArgsConstructor
    @Getter
    class Article {
        private long id;
        private String title;
        private String body;
    }

