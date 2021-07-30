package org.masudulalam.springbootquickstart.controllers;

import org.masudulalam.springbootquickstart.entities.Topic;
import org.masudulalam.springbootquickstart.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping(value = "/topics")
    public ResponseEntity<List<Topic>> getAllTopics(){
        return new ResponseEntity(topicService.getTopics(), HttpStatus.OK);
    }

    @GetMapping(value = "/topics/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable String id){
        return new ResponseEntity(topicService.getTopic(id),HttpStatus.OK);
    }

    @PostMapping(value = "/topics")
    public ResponseEntity<Topic> addTopic(@Valid @RequestBody Topic topic){
        return new ResponseEntity(topicService.addTopic(topic),HttpStatus.CREATED);
    }

    @PutMapping(value = "/topics/{id}")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic, @PathVariable String id){
        return new ResponseEntity(topicService.updateTopic(topic, id),HttpStatus.OK);
    }

    @DeleteMapping(value = "/topics/{id}")
    public ResponseEntity deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}