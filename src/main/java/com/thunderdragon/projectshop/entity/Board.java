package com.thunderdragon.projectshop.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Entity
@Table(name="board")
@Getter
@Setter
public class Board extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Integer boardNo;
    private String title;
    private String content;
    private String writer;
    private int type;
}
