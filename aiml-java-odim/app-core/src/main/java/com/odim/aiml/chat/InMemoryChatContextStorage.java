package com.odim.aiml.chat;

import com.odim.aiml.channels.ChannelType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * InMemoryChatContextStorage
 * @author fvargas
 * @since 04/09/18
 */
@Repository
public class InMemoryChatContextStorage implements ChatContextStorage {
    private Map<String, Map<ChannelType, ChatContext>> contexts;

    public InMemoryChatContextStorage() {
        contexts = new HashMap<>();
    }

    @Override
    public ChatContext getContext(String userId, ChannelType channelType) {
        Map<ChannelType, ChatContext> userContexts = contexts.get(userId);
        if (userContexts == null || userContexts.isEmpty()) {
            ChatContext context = new ChatContext(userId);
            userContexts = new HashMap<>();
            userContexts.put(channelType, context);
            contexts.put(userId, userContexts);
            return context;
        } else {
            return userContexts.computeIfAbsent(channelType, k -> new ChatContext(userId));
        }
    }
}
