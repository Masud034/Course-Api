package org.masudulalam.springbootquickstart.repositories;

import org.masudulalam.springbootquickstart.entities.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
