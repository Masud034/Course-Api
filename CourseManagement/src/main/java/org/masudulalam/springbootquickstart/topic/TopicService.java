package org.masudulalam.springbootquickstart.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(
            new Topic("Spring-101","Spring Framework", "Spring Framework Description"),
            new Topic("Java-101","Core Java", "Core Java Description"));

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
}
