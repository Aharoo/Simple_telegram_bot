package ua.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.telegrambot.bot.EducationalBot;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

	private final EducationalBot educationalBot;

	@Autowired
	public SendBotMessageServiceImpl(EducationalBot educationalBot){this.educationalBot = educationalBot;}

	public void sendMessage(String chat_id, String message) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(chat_id);
		sendMessage.enableHtml(true);
		sendMessage.setText(message);

		try {
			educationalBot.execute(sendMessage);
		} catch (TelegramApiException e){
			e.printStackTrace();
		}
	}
}
