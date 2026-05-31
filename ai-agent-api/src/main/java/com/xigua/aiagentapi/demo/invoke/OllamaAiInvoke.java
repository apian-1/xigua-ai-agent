package com.xigua.aiagentapi.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Spring AI调用Ollama大模型。
 * 引入的依赖spring-ai-ollama-spring-boot-starter可能会与spirng ai alibaba冲突。如果调用此依赖需要将阿里的给关掉。
 * 取消注释即可在SpringBoot项目启动时执行。
 */
//@Component
public class OllamaAiInvoke implements CommandLineRunner {

    @Resource
    private ChatModel ollamaChatModel;  //注意调用什么大模型就用什么名字。如果是灵积就是dashscopechatModel

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage assistantMessage = ollamaChatModel.call(new Prompt("你好，我是西瓜"))
                .getResult()
                .getOutput();

        System.out.println(assistantMessage.getText());
    }
}
