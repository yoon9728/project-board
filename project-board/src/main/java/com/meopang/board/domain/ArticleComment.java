package com.meopang.board.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    private Article article; // Article ID
    private String title;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
