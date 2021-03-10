package ua.telegrambot.commands;

import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FindCommand implements Command {

	@Value("${URL.wiki}")
	private String wikiURL;

	private final static String FIND_MESSAGE = "Для поиска на Википедии,введите ключевое слово: ";

	public void execute(Update update) {

	}
}
