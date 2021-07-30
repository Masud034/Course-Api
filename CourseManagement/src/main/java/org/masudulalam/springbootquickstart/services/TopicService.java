package org.masudulalam.springbootquickstart.services;

import org.masudulalam.springbootquickstart.entities.Topic;
import org.masudulalam.springbootquickstart.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getTopics(){
        return topicRepository.findAll();
    }

    public Topic getTopic(String id){
        return topicRepository.findById(id).get();
    }

    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Topic newTopic, String id) {
        Topic topic = topicRepository.findById(id).get();
        topic.setName(newTopic.getName());
        topic.setDescription(newTopic.getDescription());
        return topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
