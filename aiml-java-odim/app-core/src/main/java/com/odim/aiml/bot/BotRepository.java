package com.odim.aiml.bot;

import com.odim.aiml.chat.ChatContextStorage;
import com.odim.aiml.consts.AimlConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;

/**
 * Bot repository
 * @author fvargas
 * @since 04/09/18
 */
@Repository
public class BotRepository {
    private String rootDir = AimlConst.getRootPath();

    private ChatContextStorage chatContextStorage;

    @Autowired
    public BotRepository(ChatContextStorage chatContextStorage) {
        this.chatContextStorage = chatContextStorage;
    }

    public void setRootPath(String path) {
        rootDir = path;
    }

    public Bot get() {
        return get(AimlConst.default_bot_name);
    }

    public Bot get(String name) {
        return new BotImpl(name, getBotPath(name), chatContextStorage);
    }

    private String getBotPath(String name) {
        return rootDir + File.separator + name + File.separator;
    }
}
