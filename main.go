package main

import (
	"fmt"
	"log"
	"os"

	tgbotapi "github.com/go-telegram-bot-api/telegram-bot-api"
)

func main() {
	bs, err := os.ReadFile("bot_api.resources")
	if err != nil {
		fmt.Print(err)
		TELEGRAM_APITOKEN := string(bs)

		bot, err := tgbotapi.NewBotAPI(os.Getenv(TELEGRAM_APITOKEN))
		if err != nil {
			panic(err)
		}

		bot.Debug = true

		log.Printf("Authorized on account %s", bot.Self.UserName)

		u := tgbotapi.NewUpdate(0)
		u.Timeout = 60

		updates, _ := bot.GetUpdatesChan(u)

		for update := range updates {
			if update.Message != nil {
				log.Printf("[%s] %s", update.Message.From.UserName, update.Message.Text)

				msg := tgbotapi.NewMessage(update.Message.Chat.ID, update.Message.Text)
				bot.Send(msg)
			}
		}
	}
}
