package com.globalopencampus.parkourapi.service;

import org.springframework.ai.chat.model.ChatResponse;

public interface MistralAiService {
    /**
     * To call Mistral AI with prompt
     * @param prompt the prompt for AI
     * @return AI response
     */
    public String call(String prompt);
}
