package com.briansill.springaivision.services;

import com.briansill.springaivision.model.Answer;
import com.briansill.springaivision.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.content.Media;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.Base64;
import java.util.Collection;
import java.util.List;

//@RequiredArgsConstructor
@Service
public class OpenAiServiceImpl implements OpenAiService{

    private final ChatClient chatClient;

    public OpenAiServiceImpl(ChatClient.Builder chatClientBUilder){
        this.chatClient = chatClientBUilder.build();
    }

    @Override
    public Answer interpretImage(Question question){

        var imageMedia = Media.builder()
                .mimeType(MimeTypeUtils.IMAGE_PNG)
                .data(Base64.getDecoder().decode(question.imageBase64()))
                .build();

        var userMessage = UserMessage.builder()
                .text(question.question())
                .media(imageMedia)
                .build();

        var response = chatClient.prompt()
                .messages(userMessage)
                .call()
                .chatResponse();

        return new Answer(response.getResult().getOutput().getText());
    }
}
