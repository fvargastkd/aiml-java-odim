package com.odim.aiml.chat;

import com.odim.aiml.consts.AimlConst;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Chat context
 * @author fvargas
 * @since 04/09/18
 */
public class ChatContext {
    private UUID chatUid;
    private ChatHistory history;
    private String request = "";
    private String topic = AimlConst.default_topic;
    private String that = AimlConst.default_that;
    private Map<String, String> predicates = new HashMap<>();

    public ChatContext(String userName) {
        chatUid = UUID.randomUUID();
        history = new ChatHistory(chatUid, userName);
    }

    public void newState(String request, String respond) {
        this.request = request;
        this.that = respond;
        history.addRequest(this.request);
        history.addRespond(this.that);
    }

    public String topic() {
        if (predicates.containsKey("topic")) {
            setTopic(predicates.get("topic"));
        }
        return topic;
    }

    public String that() {
        return that;
    }

    public String request() {
        return request;
    }

    public String respond() {
        return that;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setRespond(String respond) {
        this.that = respond;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Map<String, String> getPredicates() {
        return predicates;
    }

}
