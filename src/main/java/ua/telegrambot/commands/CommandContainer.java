package ua.telegrambot.commands;

import com.google.common.collect.ImmutableMap;
import ua.telegrambot.service.SendBotMessageService;

import static ua.telegrambot.commands.CommandName.*;


public class CommandContainer {

	private final Command unknownCommand;
	private final ImmutableMap<String,Command> commandMap;

	public CommandContainer(SendBotMessageService sendBotMessageService){
		commandMap = ImmutableMap.<String,Command>builder()
				.put(START.getCommandName(),new StartCommand(sendBotMessageService))
				.put(STOP.getCommandName(),new StopCommand(sendBotMessageService))
				.put(HELP.getCommandName(),new HelpCommand(sendBotMessageService))
				.put(NO.getCommandName(), new NoCommand(sendBotMessageService))
				.build();

		unknownCommand = new UnknownCommand(sendBotMessageService);
	}

	public Command retrieveCommand(String commandIdentifier){
		return commandMap.getOrDefault(commandIdentifier,unknownCommand);
	}
}
