package likelion14th.springstudy.repository;

import likelion14th.springstudy.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
