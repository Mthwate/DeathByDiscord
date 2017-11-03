package com.mthwate.dbd

import net.dv8tion.jda.core.entities.User
import java.io.Closeable
import java.util.Random
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class Game(users: List<User>) : Closeable {

	val rand = Random()

	val timerLength = TimeUnit.SECONDS.convert(3, TimeUnit.MINUTES) + rand.nextInt(TimeUnit.SECONDS.convert(4, TimeUnit.MINUTES).toInt())

	val exec = Executors.newScheduledThreadPool(users.size)

	val killer = users[rand.nextInt(users.size)]

	val players = users.filter { it != killer }.toHashSet()

	val marked = HashSet<User>()

	fun mark(user: User) {

		exec.schedule({

		}, timerLength, TimeUnit.SECONDS)

	}

	fun unmark(user: User) {

	}

	override fun close() {
		exec.shutdownNow()
	}

}