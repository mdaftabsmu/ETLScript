package com.springmondb.example.service;

import java.io.Serializable;
import java.util.List;

import com.springmondb.example.models.Company;

public interface GenericService<T, PK extends Serializable> {
    T create(T t);
    List<T> create(Iterable<T> t);
    T read(PK id);
    List<T> readAll();
    T update(T t);
        void delete(T t);
}