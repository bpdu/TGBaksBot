package ru.bpdu.TGBaksBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TgBaksBotApplication {

	public static void main(String[] args) throws TelegramApiException {
		TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
		Bot bot = new Bot();                 
		botsApi.registerBot(bot);
		bot.sendText(54802860L, "Hello World!");  
		SpringApplication.run(TgBaksBotApplication.class, args);
	}
}
