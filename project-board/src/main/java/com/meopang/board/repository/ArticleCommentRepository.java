package com.meopang.board.repository;

import com.meopang.board.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<Article, Long> {
}
