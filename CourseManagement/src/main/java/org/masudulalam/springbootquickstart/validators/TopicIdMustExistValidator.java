package org.masudulalam.springbootquickstart.validators;

import org.masudulalam.springbootquickstart.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TopicIdMustExistValidator implements ConstraintValidator<TopicIdMustExist, String> {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void initialize(TopicIdMustExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        return topicRepository.findById(id).isPresent();
    }
}
