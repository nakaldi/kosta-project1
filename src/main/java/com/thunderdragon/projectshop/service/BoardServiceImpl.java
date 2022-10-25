package com.thunderdragon.projectshop.service;

import com.thunderdragon.projectshop.entity.Board;
import com.thunderdragon.projectshop.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private  BoardRepository boardRepository;


    @Override
    public void register(Board board) throws Exception {
        boardRepository.save(board);
    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        return boardRepository.findById(boardNo)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void modify(Board board) throws Exception {
     Board boardEntity =boardRepository.findById(board.getBoardNo())
             .orElseThrow(EntityNotFoundException::new);
     boardEntity.setTitle(board.getTitle());
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
    boardRepository.deleteById(boardNo);
    }

    @Override
    public List<Board> list() throws Exception {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC,"boardNo"));
    }
}
