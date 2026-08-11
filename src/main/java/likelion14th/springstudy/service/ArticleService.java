package likelion14th.springstudy.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import likelion14th.springstudy.domain.Article;
import likelion14th.springstudy.dto.response.ArticleResponse;
import likelion14th.springstudy.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
    private  final ArticleRepository articleRepository;
    @Transactional
    public ArticleResponse addArticle(String title, String content, String author,String password){
        Article article = new Article(title,content,author,password);
        articleRepository.save(article);//JPA를 사용해서 저장
        return ArticleResponse.from(article);
    }
    @Transactional
    public ArticleResponse getArticle(Long Id){
        Article article = articleRepository.findById(Id).orElseThrow(()-> new EntityNotFoundException("해당 Id의 게시글이 없습니다."));
        return ArticleResponse.from(article);
    }
}
