package com.thunderdragon.projectshop.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="board_comment")
@Getter
@Setter
public class BoardComment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_comment__no")
    private Integer boardCommentNo;
    private Integer boardNo;
    private String title;
    private String content;
    private String writer;
    private int type;
}
