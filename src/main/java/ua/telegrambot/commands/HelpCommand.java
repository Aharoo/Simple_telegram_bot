package ua.telegrambot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ua.telegrambot.service.SendBotMessageService;

import static ua.telegrambot.commands.CommandName.*;

public class HelpCommand implements Command {

	private SendBotMessageService sendBotMessageService;

	public HelpCommand(SendBotMessageService sendBotMessageService){this.sendBotMessageService = sendBotMessageService;}

	public final static String HELP_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"

			+ "<b>Начать\\закончить работу с ботом</b>\n"
			+ "%s - начать работу со мной\n"
			+ "%s - приостановить работу со мной\n\n"
			+ "%s - получить помощь в работе со мной\n", START.getCommandName(),
			STOP.getCommandName(),HELP.getCommandName());

	public void execute(Update update) {
		sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),HELP_MESSAGE);
	}
}
