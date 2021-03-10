package ua.telegrambot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ua.telegrambot.service.SendBotMessageService;

public class UnknownCommand implements Command {

	private SendBotMessageService sendBotMessageService;

	public UnknownCommand(SendBotMessageService sendBotMessageService){this.sendBotMessageService = sendBotMessageService;}

	public static final String NO_COMMAND_MESSAGE = "Не понимаю вас \uD83D\uDE1F, напишите /help чтобы узнать что я вас понял.";

	public void execute(Update update) {
		sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),NO_COMMAND_MESSAGE);
	}
}
