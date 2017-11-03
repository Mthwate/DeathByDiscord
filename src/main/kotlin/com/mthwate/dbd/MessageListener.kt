package com.mthwate.dbd

import net.dv8tion.jda.core.entities.ChannelType
import net.dv8tion.jda.core.hooks.ListenerAdapter
import net.dv8tion.jda.core.events.message.MessageReceivedEvent



class MessageListener : ListenerAdapter() {

	var game: Game? = null

	override fun onMessageReceived(event: MessageReceivedEvent) {
		if (!event.author.isBot) {
			val content = event.message.content.toLowerCase()

			println(content)
			println(event.channelType)

			if (content == "!start") {
				if (event.channelType == ChannelType.TEXT) {
					val channel = event.textChannel
					if (game == null) {
						val users = channel.members.map { it.user }
						game = Game(users)
						channel.sendMessage("Started a new game.").queue()
					} else {
						channel.sendMessage("A game is already started.").queue()
					}
				}
			} else if (content == "!stop") {
				game?.close()
				game = null
				event.channel.sendMessage("Stopped the current game.").queue()
			}


		}
	}

}