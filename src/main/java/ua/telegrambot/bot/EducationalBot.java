package ua.telegrambot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ua.telegrambot.commands.CommandContainer;
import ua.telegrambot.service.SendBotMessageServiceImpl;

import static ua.telegrambot.commands.CommandName.NO;

@Component
public class EducationalBot extends TelegramLongPollingBot {

	public static String COMMAND_PREFIX = "/";

	@Value("${bot.name}")
	private String botName;

	@Value("${bot.token}")
	private String botToken;

	private final CommandContainer commandContainer;

	public EducationalBot(){this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));}

	public String getBotUsername() {
		return botName;
	}

	public String getBotToken() {
		return botToken;
	}

	public void onUpdateReceived(Update update) {
		if (update.getMessage() != null && update.getMessage().hasText()){
			String message = update.getMessage().getText().trim();
			if (message.startsWith(COMMAND_PREFIX)){
				String commandIdentifier = message.split(" ")[0].toLowerCase();

				commandContainer.retrieveCommand(commandIdentifier).execute(update);
			} else {
				commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
			}
		}
	}
}
