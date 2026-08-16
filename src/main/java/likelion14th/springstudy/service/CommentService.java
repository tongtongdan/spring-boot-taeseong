package likelion14th.springstudy.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import likelion14th.springstudy.domain.Article;
import likelion14th.springstudy.domain.Comment;
import likelion14th.springstudy.dto.response.CommentResponse;
import likelion14th.springstudy.repository.ArticleRepository;
import likelion14th.springstudy.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    @Transactional
    public CommentResponse addComment(Long article_Id, String author, String content, Long likeCnt){
        Article article = articleRepository.findById(article_Id).orElseThrow(()->new EntityNotFoundException("해당하는 id의 게시글이 없습니다."));
        Comment comment = new Comment(author,content,likeCnt,article);
        commentRepository.save(comment);
        return CommentResponse.of(article.getId(),comment);
    }
}
