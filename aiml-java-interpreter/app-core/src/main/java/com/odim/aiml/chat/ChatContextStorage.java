package com.odim.aiml.chat;

import com.odim.aiml.channels.ChannelType;

/**
 * ChatContextStorage
 *
 * @author anton
 * @since 19/04/17
 */
public interface ChatContextStorage {
    ChatContext getContext(String userId, ChannelType channelType);
}
