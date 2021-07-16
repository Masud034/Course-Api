package org.masudulalam.springbootquickstart.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return Arrays.asList(
                new Topic("Spring-101","Spring Framework", "Spring Framework Description"),
                new Topic("Java-101","Core Java", "Core Java Description"));
    }
}
