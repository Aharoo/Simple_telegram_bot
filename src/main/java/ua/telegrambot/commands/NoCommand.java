package ua.telegrambot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ua.telegrambot.service.SendBotMessageService;

public class NoCommand implements Command {

	private SendBotMessageService sendBotMessageService;

	public NoCommand(SendBotMessageService sendBotMessageService){this.sendBotMessageService = sendBotMessageService;}

	public static final String NO_COMMAND = "Мои команды начинаются со слеша(/)"+
			"Чтобы посмотреть список команд,наберите /help";

	public void execute(Update update) {
		sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),NO_COMMAND);
	}
}
