package com.example.firstproject.service;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Service
public class PizzaService {
    @Autowired
    public PizzaRepository pizzaRepository;

    public List<Pizza> index() {
        return pizzaRepository.findAll();
    }

    public Pizza show(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public Pizza create(PizzaDto dto) {
        Pizza pizza = dto.toEntity();
        if (pizza.getId() != null) {
            return null;
        }
        return pizzaRepository.save(pizza);
    }

    public Pizza update(Long id, PizzaDto dto) {
        // 1. DTO -> 엔티티 변환하기
        Pizza pizza = dto.toEntity();
        log.info("id: {}, pizza: {}", id, pizza.toString());
        // 2. 타깃 조회하기
        Pizza target = pizzaRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리하기
        if (target == null || id != pizza.getId()) {
            log.info("잘못된 요청! id: {}, pizza: {}", id, pizza.toString());
            return null;
        }
        // 4. 업데이트 및 정상 응답(200)하기
        target.patch(pizza);
        Pizza updated = pizzaRepository.save(pizza);
        return updated;
    }

    public Pizza delete(Long id) {
        // 1. 대상 찾기
        Pizza target = pizzaRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        if (target == null)
            return null;
        // 3. 대상 삭제하기
        pizzaRepository.delete(target);
        return target;
    }
}
