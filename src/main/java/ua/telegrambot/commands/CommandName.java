package ua.telegrambot.commands;

public enum CommandName {

	START("/start"),
	STOP("/stop"),
	HELP("/help"),
	NO("nocommand");

	private final String commandName;

	CommandName(String commandName){this.commandName = commandName;}

	public String getCommandName(){return commandName;}

}
