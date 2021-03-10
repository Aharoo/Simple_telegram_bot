package ua.telegrambot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ua.telegrambot.service.SendBotMessageService;

public class StartCommand implements Command {

	private SendBotMessageService sendBotMessageService;

	public StartCommand(SendBotMessageService sendBotMessageService){this.sendBotMessageService = sendBotMessageService;}

	public final static String START_MESSAGE = "Здравствуй,я EducationalBot,пожалуйста,используй меня по" +
			"назначению для достижения своих целей!";

	public void execute(Update update) {
		sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),START_MESSAGE);
	}
}
