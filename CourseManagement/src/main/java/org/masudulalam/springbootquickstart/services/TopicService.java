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

        List<Topic> topics = new ArrayList<>();
        for (Topic topic: topicRepository.findAll()){
            topics.add(topic);
        }
        return topics;
    }

    public Topic getTopic(String id){
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic newTopic, String id) {
        Topic topic = topicRepository.findById(id).get();
        topic.setName(newTopic.getName());
        topic.setDescription(newTopic.getDescription());
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
