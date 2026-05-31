package com.xigua.aiagentapi.demo.invoke;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.ChatLanguageModelExtensionsKt;
import org.springframework.ai.chat.model.ChatModel;


public class LangChainAiInvoke {

    public static void main(String[] args) {
        ChatLanguageModel chatModel = QwenChatModel.builder()
                .apiKey(TestApiKey.API_KEY)
                .modelName("qwen-max")
                .build();

        String chat = chatModel.chat("你好，我是西瓜");

        System.out.println(chat);
    }
}

