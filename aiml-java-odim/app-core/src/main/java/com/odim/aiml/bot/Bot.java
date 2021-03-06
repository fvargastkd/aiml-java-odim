package com.odim.aiml.bot;

import com.odim.aiml.channels.ChannelType;
import com.odim.aiml.chat.ChatContext;
import com.odim.aiml.chat.ChatContextStorage;
import com.odim.aiml.core.Named;

/**
 * Bot
 *
 * @author fvargas
 * @since 04/09/18
 */
public interface Bot extends Named {
    String getRespond(String phrase);

    default void startChat(String userId, ChannelType channelType) {
        setChatContext(getChatContextStorage().getContext(userId, channelType));
    }

    ChatContextStorage getChatContextStorage();

    void setChatContext(ChatContext context);

    boolean wakeUp();
}
