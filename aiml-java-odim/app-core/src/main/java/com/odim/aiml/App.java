package com.odim.aiml;

import com.odim.aiml.bot.BotImpl;
import com.odim.aiml.bot.BotRepository;
import com.odim.aiml.channels.Channel;
import com.odim.aiml.channels.ConsoleChannel;
import com.odim.aiml.channels.Provider;
import com.odim.aiml.chat.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author fvargas
 * @since 30/06/15
 */
@SpringBootApplication
public class App {

    private static boolean debug = false;

    public static void main(String[] args) throws Exception {
        if (args.length > 0 && "debug".equals(args[0]))
            debug = true;

        SpringApplication.run(App.class, args);
    }

    @Autowired
    private BotRepository botRepository;

    @PostConstruct
    public void init() {
        BotImpl bot;
        if (debug) {
            botRepository.setRootPath("./app-core/aiml-bots/bots");
            bot = (BotImpl) botRepository.get("russian");
        } else {
            bot = (BotImpl) botRepository.get();
        }
        Provider provider = new ConsoleChannel(bot);

        Channel consoleChannel = new ConsoleChannel(bot);
        consoleChannel.startChat("Tony");

        if (!bot.wakeUp())
            return;
        Chat chat = new Chat(bot, provider);
        chat.start();
    }
}