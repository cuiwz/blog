package com.cuiwz.service;

import com.cuiwz.po.Comment;

import java.util.List;

/**
 * Created by cuiwz on 2020/02/24.
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

}
