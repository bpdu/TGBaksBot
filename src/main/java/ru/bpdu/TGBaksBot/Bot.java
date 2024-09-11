package ru.bpdu.TGBaksBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import io.github.cdimascio.dotenv.Dotenv;

public class Bot extends TelegramLongPollingBot{

    String GREETING = "Welcome to TGBaksBot! Please, use buttons to interact with me.";

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        String message = msg.getText();
        Long user_id = msg.getFrom().getId();
        if (msg.isCommand()) {
            if (message.equals("/start")) {
                sendText(user_id, GREETING);
            }

        }
    }

    @Override
    public String getBotToken() {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get("BOT_TOKEN");
    }

    @Override
    public String getBotUsername() {
        return "TGBaksBot";
    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                    .chatId(who.toString()) //Who are we sending a message to
                    .text(what).build();    //Message content
    try {
        execute(sm);                        //Actually sending the message
    } catch (TelegramApiException e) {
        throw new RuntimeException(e);      //Any error will be printed here
    }
    
}
}
    
