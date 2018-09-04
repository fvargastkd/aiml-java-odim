//package com.batiaev.aiml.core;
//
//import com.batiaev.aiml.bot.BotImpl;
//import com.batiaev.aiml.bot.BotRepository;
//import com.batiaev.aiml.chat.ChatContext;
//import com.batiaev.aiml.chat.InMemoryChatContextStorage;
//import com.batiaev.aiml.consts.AimlConst;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * BotTest
// *
// * @author batiaev
// * @since 22/06/15
// */
//public class BotTest extends Assert {
//    private BotImpl bot;
//    private BotRepository botRepository = new BotRepository(new InMemoryChatContextStorage());
//
//    @Before
//    public void setUp() throws Exception {
//        botRepository.setRootPath("./aiml-bots/bots");
//        AimlConst.setRootPath("./aiml-bots/bots");
//        bot = (BotImpl) botRepository.get();
//        assertTrue(bot.wakeUp());
//    }
//
//    @Test
//    public void testMultisentenceRespond() throws Exception {
//        String request = "Как дела?";
//        List<String> correctResponds = Arrays.asList("отлично", "восхитительно", "замечательно", "прекрасно", "превосходно", "изумительно");
//        String respond = bot.multisentenceRespond(request, new ChatContext("Human")).trim();
//        assertTrue("Request = " + request + ", Respond = " + respond, correctResponds.contains(respond));
//    }
//
//    @Test
//    public void testMultisentenceRespondWithRandom() throws Exception {
//        String request = "Привет";
//        String respond = bot.multisentenceRespond(request, new ChatContext("Human")).trim();
//        String[] answers = "Здравствуй;Здравствуйте;Мое почтение!;Здарова;Приветствую;Привет;Доброго времени суток".split(";");
//        boolean result = false;
//        for (String answer : answers) {
//            if (respond.equals(answer))
//                result = true;
//        }
//        assertTrue("Request = " + request + ", Respond = " + respond, result);
//    }
//
//    @Test
//    public void testMultisentenceRespondWithSrai() throws Exception {
//        String request = "Здравствуй";
//        String respond = bot.multisentenceRespond(request, new ChatContext("Human")).trim();
//        String[] answers = "Здравствуй;Здравствуйте;Мое почтение!;Здарова;Приветствую;Привет;Доброго времени суток".split(";");
//        boolean result = false;
//        for (String answer : answers) {
//            if (respond.equals(answer))
//                result = true;
//        }
//        assertTrue("Request = " + request + ", Respond = " + respond, result);
//    }
//}
