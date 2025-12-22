package com.briansill.springaivision.controllers;

import com.briansill.springaivision.model.Answer;
import com.briansill.springaivision.model.Question;
import com.briansill.springaivision.services.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/ai/image")
public class QuestionController {

    private final OpenAiService openAiService;

    @PostMapping("/process")
    public Answer processImage(@RequestBody Question question){

        return openAiService.interpretImage(question);
    }

}
