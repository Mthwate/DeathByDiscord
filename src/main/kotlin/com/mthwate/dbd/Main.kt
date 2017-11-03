package com.mthwate.dbd

import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder


object Main {

	@JvmStatic fun main(args: Array<String>) {
        val jda = JDABuilder(AccountType.BOT)
                .setToken("Mzc1ODIyODU1ODM4ODkyMDYy.DN1cVw.obq1a3GrNUoh1vEcZhDysn6Oahw")
                .addEventListener(MessageListener())
                .buildBlocking()
	}

}