package com.xigua.aiagentapi.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Spring AI 框架调用AI大模型
 */
//@Component
public class SpringAiInvoke implements CommandLineRunner {
    // CommandLineRunner项目启动时运行一次，用于测试。

    @Resource
    private ChatModel dashscopechatModel;   //一定要是dashscopechatModel名称

    @Override
    public void run(String... args) throws Exception {

        AssistantMessage assistantMessage = dashscopechatModel.call(new Prompt("你好，我是西瓜"))
                .getResult()
                .getOutput();

        System.out.println(assistantMessage.getText()); //打印获取信息

    }
}
