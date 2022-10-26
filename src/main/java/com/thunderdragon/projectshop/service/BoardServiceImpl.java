package com.thunderdragon.projectshop.service;

import com.thunderdragon.projectshop.entity.Board;
import com.thunderdragon.projectshop.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository repository;

    @Override
    @Transactional
    public void register(Board board) throws Exception {
        repository.save(board);
    }

    @Override
    @Transactional(readOnly = true)
    public Board read(Integer boardNo) throws Exception {
        return repository.findById(boardNo).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public void modify(Board board) throws Exception {

        Board boardEntity = repository.findById(board.getBoardNo()).orElseThrow(EntityNotFoundException::new);

        boardEntity.setTitle(board.getTitle());
        boardEntity.setWriter(board.getWriter());
        boardEntity.setContent(board.getContent());
    }

    @Override
    @Transactional
    public void remove(Integer boardNo) throws Exception {
//        repository.delete(boardNo);
        repository.deleteById(boardNo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> list() throws Exception {
        return repository.findAll(Sort.by(Direction.DESC, "boardNo"));
    }
}
