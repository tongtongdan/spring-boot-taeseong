package likelion14th.springstudy.dto.response;

import likelion14th.springstudy.domain.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponse {
    private Long articleId;
    private Long commentId;
    private String author;
    private String content;

    public static CommentResponse of(Long articleId, Comment comment){
        return CommentResponse.builder()
                .articleId(articleId)
                .commentId(comment.getCommentId())
                .author(comment.getAuthor())
                .content(comment.getContent())
                .build();
    }
}
