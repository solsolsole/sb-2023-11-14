package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ArticleController {
    private Article lastarticle;

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

//    @GetMapping("/article/dowrite")
//    String  doWrite(
//            String title,
//            String body
//    ) {
//        return "게시물이 작성되었습니다.";
//    }

//    @GetMapping("/article/dowrite")
//    Article doWrite(
//            long id,
//            String title,
//            String body
//    ) {
//        Article = new Article(1, title, body);
//
//        return article;
//    }

    @GetMapping("/article/dowrite")
    Map<String, Object> doWrite(
            long id,
            String title,
            String body
    ) {
        Map<String, Object> rs = new HashMap<>();
        lastarticle = new Article(1, title, body);
        rs.put("msg","%1번 게시물이 작성되었습니다.");
        rs.put("data", lastarticle);

        return rs;
    }
}

    @AllArgsConstructor
    @Getter
    class Article {
        private long id;
        private String title;
        private String body;
    }

