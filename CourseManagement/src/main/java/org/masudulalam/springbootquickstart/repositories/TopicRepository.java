package org.masudulalam.springbootquickstart.repositories;

import org.masudulalam.springbootquickstart.entities.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, String> {
    @Override
    List<Topic> findAll();
}
