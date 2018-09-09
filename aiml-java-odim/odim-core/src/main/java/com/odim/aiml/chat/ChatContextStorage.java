package com.odim.aiml.chat;

import com.odim.aiml.channels.ChannelType;

/**
 * ChatContextStorage
 * @author fvargas
 * @since 04/09/18
 */
public interface ChatContextStorage {
    ChatContext getContext(String userId, ChannelType channelType);
}
