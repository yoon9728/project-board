package com.meopang.board.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@DisplayName("View Controller - Article")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    private final MockMvc mvc;
    public ArticleControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }

    @DisplayName("[view][Get] Article List page")
    @Test
    public void givenNothing_whenRequestingArticlesView_thenReturnArticlesView() throws Exception {
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/index"))
                .andExpect(model().attributeExists("articles"));
    }

    @Disabled
    @DisplayName("[view][Get] Single Article page")
    @Test
    public void givenNothing_whenRequestingArticleView_thenReturnArticlesView() throws Exception {
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));

    }

    @Disabled
    @DisplayName("[view][Get] Search Article page")
    @Test
    public void givenNothing_whenRequestingArticleSearchView_thenReturnArticlesView() throws Exception {
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search"));

    }

    @Disabled
    @DisplayName("[view][Get] Search Article's Hashtag page")
    @Test
    public void givenNothing_whenRequestingArticleHashtagSearchView_thenReturnArticlesView() throws Exception {
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search-hashtag"));
    }

}