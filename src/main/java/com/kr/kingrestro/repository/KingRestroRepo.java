package com.kr.kingrestro.repository;

import com.kr.kingrestro.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KingRestroRepo extends JpaRepository<BookingEntity, Integer> {
}
