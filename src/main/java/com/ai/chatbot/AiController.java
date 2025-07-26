package com.ai.chatbot;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/qna")
public class AiController {

    private final QnAService qnAService;
    @PostMapping("/ask")
    public ResponseEntity<String>askQuestion(@RequestBody Map<String, String> payload){
        String question = payload.get("question");
        String answer = qnAService.getAnswer(question);
        System.out.println("Received question: " + payload.get("question"));
        return ResponseEntity.ok(answer);
    }


}
