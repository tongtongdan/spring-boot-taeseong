package likelion14th.springstudy.dto.response;

import likelion14th.springstudy.domain.Article;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ArticleSummaryResponse {
    private final String title;
    private final String content;
    private final String author;
    public static ArticleSummaryResponse from (Article article){
        return ArticleSummaryResponse.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .author(article.getAuthor())
                .build();
    }
}
