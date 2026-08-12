package likelion14th.springstudy.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import likelion14th.springstudy.domain.Article;
import likelion14th.springstudy.dto.response.ArticleDetailResponse;
import likelion14th.springstudy.dto.response.ArticleSummaryResponse;
import likelion14th.springstudy.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
    private  final ArticleRepository articleRepository;
    @Transactional
    public ArticleDetailResponse addArticle(String title, String content, String author, String password){
        Article article = new Article(title,content,author,password);
        articleRepository.save(article);//JPA를 사용해서 저장
        return ArticleDetailResponse.from(article);
    }
    @Transactional
    public ArticleDetailResponse getArticle(Long Id){
        Article article = articleRepository.findById(Id).orElseThrow(()-> new EntityNotFoundException("해당 Id의 게시글이 없습니다."));
        return ArticleDetailResponse.from(article);
    }
    @Transactional
    public List<ArticleSummaryResponse> getArticles(){
        List<Article> articles = articleRepository.findAll();
        List<ArticleSummaryResponse> articleResponses = articles.stream()
                .map(ArticleSummaryResponse::from)
                .toList();
        return articleResponses;
    }
    @Transactional
    public ArticleDetailResponse patchArticle(Long Id,String title, String content){
        Article article=articleRepository.findById(Id).orElseThrow(()->new EntityNotFoundException("해당 Id의 게시글이 없습니다"));
        article.update(title,content);
        articleRepository.save(article);
        return ArticleDetailResponse.from(article);
    }
}
