package com.cuiwz.dao;

import com.cuiwz.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cuiwz on 2020/02/24.
 */
public interface CommentRepository extends JpaRepository<Comment, Long>{

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);

}
