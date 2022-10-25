package com.thunderdragon.projectshop.repository;


import com.thunderdragon.projectshop.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Integer> {

}
