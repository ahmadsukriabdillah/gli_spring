package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, V> {
    Optional<T> findById(V id);

    List<T> findAll();

    T save(T values);

    void deleteById(V value);

    void update(T values);
}
