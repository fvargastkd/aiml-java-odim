package com.odim.aiml.channels;

import com.odim.aiml.bot.Bot;
import com.odim.aiml.exception.BotNotInitializedException;
import com.odim.aiml.exception.ChatNotStartedException;
import org.springframework.stereotype.Component;

/**
 * Channel
 *
 * @author anton
 * @since 18/04/17
 */
@Component
public interface Channel {

    default void startChat(String userId) {
        getBot().startChat(userId, getType());
    }

    Bot getBot();

    default void send(String phrase) throws ChatNotStartedException, BotNotInitializedException {
        if (getResponseHandler() == null)
            throw new ChatNotStartedException("response handler is not set");
        if (getBot() == null)
            throw new BotNotInitializedException("Bot is not set");
        String respond = getBot().getRespond(phrase);
        getResponseHandler().respond(respond);
    }

    ChannelType getType();

    ResponseHandler getResponseHandler();

    /**
     * ResponseHandler
     *
     * @author anton
     * @since 18/04/17
     */
    @FunctionalInterface
    interface ResponseHandler {
        void respond(String respond);
    }
}
