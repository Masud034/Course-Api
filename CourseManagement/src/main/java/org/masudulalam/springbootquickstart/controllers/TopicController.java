package org.masudulalam.springbootquickstart.controllers;

import org.masudulalam.springbootquickstart.entities.Topic;
import org.masudulalam.springbootquickstart.services.TopicService;
import org.masudulalam.springbootquickstart.validators.TopicIdMustExist;
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

    @GetMapping(value = "/topics", produces = "application/json")
    public ResponseEntity<List<Topic>> getAllTopics(){
        return new ResponseEntity(topicService.getTopics(), HttpStatus.OK);
    }

    @GetMapping(value = "/topics/{id}", produces = "application/json")
    public ResponseEntity<Topic> getTopic(@PathVariable @TopicIdMustExist String id){
        return new ResponseEntity(topicService.getTopic(id),HttpStatus.OK);
    }

    @PostMapping(value = "/topics", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Topic> addTopic(@Valid @RequestBody Topic topic){
        return new ResponseEntity(topicService.addTopic(topic),HttpStatus.CREATED);
    }

    @PutMapping(value = "/topics/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic, @PathVariable @TopicIdMustExist String id){
        return new ResponseEntity(topicService.updateTopic(topic, id),HttpStatus.OK);
    }

    @DeleteMapping(value = "/topics/{id}")
    public ResponseEntity deleteTopic(@PathVariable @TopicIdMustExist String id){
        topicService.deleteTopic(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}