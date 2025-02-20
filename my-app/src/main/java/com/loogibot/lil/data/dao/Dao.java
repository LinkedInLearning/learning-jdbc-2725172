package com.loogibot.lil.data.dao;
import java.util.UUID;
import java.util.Optional;
import java.util.List;

public interface Dao <T, Id extends UUID> {
  List<T> getAll();
  T create(T entity);
  Optional<T> getOne(Id id);
  T update(T entity);
  void delete(Id id);
}
