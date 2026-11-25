package com.ishika.taskboard.repository;

import com.ishika.taskboard.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(
            value = "select bm.board from BoardMember bm where bm.user.id = :userId",
            countQuery = "select count(bm) from BoardMember bm where bm.user.id = :userId"
    )
    Page<Board> findBoardsByMemberId(@Param("userId") Long userId, Pageable pageable);
}