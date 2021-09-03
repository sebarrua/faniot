package com.test.faniot.service;

import java.util.List;
import java.util.Optional;

public interface IBaseService<T> {
	List<T> getAll();
    Optional<T> get(Long id);
    void save(T entity);
    void delete(Long id);
    void update(T entity, Long id);
}
