package ru.bpdu.TGBaksBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import io.github.cdimascio.dotenv.Dotenv;

public class Bot extends TelegramLongPollingBot{

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);    
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
    
}
