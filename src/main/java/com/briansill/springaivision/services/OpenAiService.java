package com.briansill.springaivision.services;

import com.briansill.springaivision.model.Answer;
import com.briansill.springaivision.model.Question;

public interface OpenAiService {

    Answer interpretImage(Question question);

}
