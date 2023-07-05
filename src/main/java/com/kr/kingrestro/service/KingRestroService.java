package com.kr.kingrestro.service;

import com.kr.kingrestro.entity.BookingEntity;
import com.kr.kingrestro.repository.KingRestroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KingRestroService {
    @Autowired
    KingRestroRepo kingRestroRepo;

    public void addEmp(BookingEntity bookingEntity) {
        kingRestroRepo.save(bookingEntity);
    }
}
