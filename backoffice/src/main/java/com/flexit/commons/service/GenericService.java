package com.flexit.commons.service;

import com.flexit.commons.enums.Order;

import java.util.List;

public interface GenericService<T, D, I> {
    List<D> findAll(Order order);
}
