package ua.telegrambot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ua.telegrambot.service.SendBotMessageService;

public class StopCommand implements Command {

	private SendBotMessageService sendBotMessageService;

	public StopCommand(SendBotMessageService sendBotMessageService){this.sendBotMessageService = sendBotMessageService;}

	private static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F";

	public void execute(Update update) {
		sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),STOP_MESSAGE);
	}
}
