package com.xigua.aiagentapi.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

/**
 * curlHttp AI SDK 调用
 */
public class HttpAiInvoke {
    public static void main(String[] args) {
        // 从环境变量读取 API Key（也可直接赋值）
        String apiKey = TestApiKey.API_KEY;
        String url = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

        // 构建请求体 JSON
        JSONObject body = new JSONObject();
        body.set("model", "qwen-plus");

        // 构建 input.messages
        JSONObject systemMsg = new JSONObject();
        systemMsg.set("role", "system");
        systemMsg.set("content", "You are a helpful assistant.");

        JSONObject userMsg = new JSONObject();
        userMsg.set("role", "user");
        userMsg.set("content", "你是谁？");

        JSONArray messages = new JSONArray();
        messages.add(systemMsg);
        messages.add(userMsg);

        JSONObject input = new JSONObject();
        input.set("messages", messages);
        body.set("input", input);

        // 构建 parameters
        JSONObject parameters = new JSONObject();
        parameters.set("result_format", "message");
        body.set("parameters", parameters);

        // 发送 POST 请求
        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(body.toString())
                .execute();

        // 处理响应
        if (response.isOk()) {
            System.out.println("Response: " + response.body());
        } else {
            System.err.println("Request failed with status: " + response.getStatus());
            System.err.println(response.body());
        }
    }
}