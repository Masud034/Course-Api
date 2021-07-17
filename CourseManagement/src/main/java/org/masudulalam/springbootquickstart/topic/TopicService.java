package org.masudulalam.springbootquickstart.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring-101","Spring Framework", "Spring Framework Description"),
            new Topic("Java-101","Core Java", "Core Java Description")));

    public List<Topic> getTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        for (Topic topic: topics){
            if (id.equals(topic.getId())){
                return topic;
            }
        }
        return null;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for (int i = 0; i < topics.size(); i++){
            if (topics.get(i).getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        for (Topic topic: topics){
            if (topic.getId().equals(id)){
                topics.remove(topic);
            }
        }
    }
}
