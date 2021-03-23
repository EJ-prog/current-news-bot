package com.newsBot.currentNewsBot;


import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class newsBotApp {
   public static void main(String[] theArgs) {
      // Some code about the key
      try {
         JDA api = JDABuilder.createDefault(BOT_TOKEN).build();
      } 
      catch (LoginException e) {
         e.printStackTrace();
      }
   }
}
