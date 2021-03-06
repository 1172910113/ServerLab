package com.dxyinme.demo.service;

import java.util.List;
import com.dxyinme.demo.model.CommentExample;
import com.dxyinme.demo.model.Comment;

public interface CommentService {


    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(Comment record, CommentExample example);

    int updateByExample(Comment record, CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

}

