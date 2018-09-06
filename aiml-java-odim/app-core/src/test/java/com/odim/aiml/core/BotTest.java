package com.odim.aiml.core;

import com.odim.aiml.bot.BotImpl;
import com.odim.aiml.bot.BotRepository;
import com.odim.aiml.chat.ChatContext;
import com.odim.aiml.chat.InMemoryChatContextStorage;
import com.odim.aiml.consts.AimlConst;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * BotTest
 *
 * @author fvargas
 * @since 04/09/18
 */
public class BotTest extends Assert {

    private BotImpl bot;
    private BotRepository botRepository = new BotRepository(new InMemoryChatContextStorage());

    @Before
    public void setUp() throws Exception {
        botRepository.setRootPath("./aiml-bots/bots");
        AimlConst.setRootPath("./aiml-bots/bots");
        bot = (BotImpl) botRepository.get();
        assertTrue(bot.wakeUp());
    }

    @Test
    public void testMultisentenceRespond() throws Exception {
        String request = "Как дела?";
        List<String> correctResponds = Arrays.asList("отлично", "восхитительно", "замечательно", "прекрасно", "превосходно", "изумительно", "Desculpe, deve ter algo de errado comigo.");
        String respond = bot.multisentenceRespond(request, new ChatContext("Human")).trim();
        assertTrue("Request = " + request + ", Respond = " + respond, correctResponds.contains(respond));
    }

    @Test
    public void testMultisentenceRespondWithRandom() throws Exception {
        String request = "Привет";
        String respond = bot.multisentenceRespond(request, new ChatContext("Human")).trim();
        String[] answers = "Здравствуй;Здравствуйте;Мое почтение!;Здарова;Приветствую;Привет;Доброго времени суток;Desculpe, deve ter algo de errado comigo.".split(";");
        boolean result = false;
        for (String answer : answers) {
            if (respond.equals(answer)) {
                result = true;
            }
        }
        assertTrue("Request = " + request + ", Respond = " + respond, result);
    }

    @Test
    public void testMultisentenceRespondWithSrai() throws Exception {
        String request = "Здравствуй";
        String respond = bot.multisentenceRespond(request, new ChatContext("Human")).trim();
        String[] answers = "Здравствуй;Здравствуйте;Мое почтение!;Здарова;Приветствую;Привет;Доброго времени суток;Desculpe, deve ter algo de errado comigo.".split(";");
        boolean result = false;
        for (String answer : answers) {
            if (respond.equals(answer)) {
                result = true;
            }
        }
        assertTrue("Request = " + request + ", Respond = " + respond, result);
    }
}
