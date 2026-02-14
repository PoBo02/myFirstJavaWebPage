package DTO.model.dao;

import java.util.List;

public interface Accessable<T> {
    int insertRec(T obj);
    int updateRec(T obj);
    int deleteRec(T obj);
    T getObjectById(String id);
    List<T> listAll();
}
