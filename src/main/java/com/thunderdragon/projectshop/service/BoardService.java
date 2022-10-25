package com.thunderdragon.projectshop.service;

import com.thunderdragon.projectshop.entity.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public void register(Board board) throws Exception;
    public Board read(Integer boardNo) throws Exception;
    public void modify(Board board) throws Exception;
    public void remove(Integer boardNo) throws Exception;
    public List<Board> list() throws Exception;

}
