package com.mthwate.dbd

import net.dv8tion.jda.core.MessageBuilder
import net.dv8tion.jda.core.entities.ChannelType
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.impl.MessageImpl
import net.dv8tion.jda.core.hooks.ListenerAdapter
import net.dv8tion.jda.core.events.message.MessageReceivedEvent



class MessageListener : ListenerAdapter() {

	var game: Game? = null

	override fun onMessageReceived(event: MessageReceivedEvent) {
		if (!event.author.isBot) {
			val content = event.message.content.toLowerCase()

			val split = content.split(' ')

			val cmd = split[0]

			when(cmd) {

				"!start" -> {
					if (event.channelType == ChannelType.TEXT) {
						val channel = event.textChannel
						if (game == null) {
							val users = channel.members.map { it.user }
							game = Game(users)
							channel.sendMessage(tts("Started a new game.")).queue()
						} else {
							channel.sendMessage("A game is already started.").queue()
						}
					}
				}

				"!stop" -> {
					game?.close()
					game = null
					event.channel.sendMessage("Stopped the current game.").queue()
				}

				"!mark" -> {
					//TODO
				}

				"!heal" -> {
					//TODO
				}

			}

		}
	}

	private fun tts(text: String): Message {
		return MessageBuilder().append(text).setTTS(true).build()
	}

}