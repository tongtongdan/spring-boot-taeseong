package likelion14th.springstudy.controller;

import likelion14th.springstudy.dto.request.CommentRequest;
import likelion14th.springstudy.dto.response.ApiResponse;
import likelion14th.springstudy.dto.response.CommentResponse;
import likelion14th.springstudy.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles/{article_id}")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/comments")
    public ResponseEntity<ApiResponse<CommentResponse>> addComment(@PathVariable Long article_id, @RequestBody CommentRequest commentRequest){
        CommentResponse commentResponse=commentService.addComment(article_id,commentRequest.getAuthor(),commentRequest.getContent(),commentRequest.getLikeCnt());
        return ResponseEntity.status(201).body(ApiResponse.success(201,"댓글 생성에 성공하였습니다.",commentResponse));
    }
}
