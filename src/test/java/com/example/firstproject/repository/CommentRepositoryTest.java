package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest // 해당 클래스를 JPA와 연동해 테스팅
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository; // commentRepository 객체 주입
    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long article_id = 4L;
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(article_id);
            // 3. 예상 데이터
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 고");
            Comment a = new Comment(1L, article, "짱준", "어바웃 타임");
            Comment b = new Comment(2L, article, "짱구", "짱구는 못말려 극장판");
            Comment c = new Comment(3L, article, "짱아", "코코");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString());
        }

        /* Case 2: 1번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long article_id = 1L;
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(article_id);
            // 3. 예상 데이터
            Article article = new Article(1L, "소주", "새로");
            List<Comment> expected = Arrays.asList();
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글은 댓글이 없음");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1: "짱구"의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            String nickname = "짱구";
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);
            // 3. 예상 데이터
            Comment a = new Comment(2L, new Article(4L, "당신의 인생 영화는?", "댓글 고"), nickname, "짱구는 못말려 극장판");
            Comment b = new Comment(5L, new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱ"), nickname, "초코비");
            Comment c = new Comment(8L, new Article(6L, "당신의 취미는?", "댓글 go"), nickname, "부리부리");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "짱구의 모든 댓글을 출력!");
        }
    }
}