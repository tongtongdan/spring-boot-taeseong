package likelion14th.springstudy.controller;

import likelion14th.springstudy.dto.request.ArticleRequest;
import likelion14th.springstudy.dto.response.ApiResponse;
import likelion14th.springstudy.dto.response.ArticleResponse;
import likelion14th.springstudy.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;
    @PostMapping
    public ResponseEntity<ApiResponse<ArticleResponse>> addArticle(@RequestBody ArticleRequest request){
        ArticleResponse articleResponse = articleService.addArticle(request.getTitle(),request.getContent(),request.getAuthor(),request.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(201,"게시글 생성에 성공하였습니다.",articleResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ArticleResponse>> getArticle(@PathVariable Long id){

        ArticleResponse articleResponse = articleService.getArticle(id);
        return ResponseEntity.ok(ApiResponse.success(201,"게시글 조회에 성공하였습니다.",articleResponse));
    }
}
