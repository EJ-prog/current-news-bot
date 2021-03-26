package com.newsBot.currentNewsBot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class newsBotApp {
   public static void main(String[] theArgs) {
      try (InputStream input = newsBotApp.class.getClassLoader()
                              .getResourceAsStream("config.properties")) {
         
         Properties prop = new Properties();

         if (input != null) {
            prop.load(input);

            String BOT_TOKEN = prop.getProperty("db.bot_token");
            try {
               JDA api = JDABuilder.createDefault(BOT_TOKEN)
                        .addEventListeners(new eventListener())
                        .build();
               api.awaitReady();
               System.out.println("I build JDA Builder!");               
            } 
            catch (LoginException e) {
               e.printStackTrace();
            } 
            catch (InterruptedException e) {
               e.printStackTrace();
            }
         } else {
            System.out.println("Huh... Something broke... \nGotta fix that!");
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
