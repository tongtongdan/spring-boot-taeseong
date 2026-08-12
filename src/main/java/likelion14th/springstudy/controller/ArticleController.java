package likelion14th.springstudy.controller;

import likelion14th.springstudy.dto.request.ArticleRequest;
import likelion14th.springstudy.dto.request.UpdateArticleRequest;
import likelion14th.springstudy.dto.response.ApiResponse;
import likelion14th.springstudy.dto.response.ArticleDetailResponse;
import likelion14th.springstudy.dto.response.ArticleSummaryResponse;
import likelion14th.springstudy.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;
    @PostMapping
    public ResponseEntity<ApiResponse<ArticleDetailResponse>> addArticle(@RequestBody ArticleRequest request){
        ArticleDetailResponse articleDetailResponse = articleService.addArticle(request.getTitle(),request.getContent(),request.getAuthor(),request.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(201,"게시글 생성에 성공하였습니다.", articleDetailResponse));
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ArticleSummaryResponse>>> getArticles(){
        List<ArticleSummaryResponse> articleSummaryResponses = articleService.getArticles();
        return ResponseEntity.ok(ApiResponse.success(200,"게시글 전체 조회에 성공하였습니다.",articleSummaryResponses));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ArticleDetailResponse>> getArticle(@PathVariable Long id){

        ArticleDetailResponse articleDetailResponse = articleService.getArticle(id);
        return ResponseEntity.ok(ApiResponse.success(201,"게시글 조회에 성공하였습니다.", articleDetailResponse));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<ArticleDetailResponse>> patchArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request){
        ArticleDetailResponse articleDetailResponse = articleService.patchArticle(id, request.getTitle(), request.getContent());
        return ResponseEntity.ok(ApiResponse.success(200,"게시글을 수정하였습니다.",articleDetailResponse));
    }
}
