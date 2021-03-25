package com.newsBot.currentNewsBot;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class eventListener extends ListenerAdapter {

   @Override
   public void onMessageReceived(MessageReceivedEvent theEvent) {
      if (!theEvent.getAuthor().isBot()) {
         System.out.println("I'm not bot!");

         Message message = theEvent.getMessage();
         String content = message.getContentDisplay();
         MessageChannel channel = theEvent.getChannel();

         if (content.equals("!ping")) {
            // Ping pong Command
            System.out.println("I heard ping! Sending Pog!");
            channel.sendMessage("Pong!").queue();
         } else if (content.equals("!news")) {
            // Gives you news on demand
            channel.sendMessage("Tis' the news!\n (Insert Links Here)");
         } else if (content.equals("!opinion")) {
            // Opinions section of news
            channel.sendMessage("It's an opinion!\n (Insert Links Here)");
         } else if (content.equals("!help") || content.equals("!halp")) {
            // Gives help
            channel.sendMessage("Never Fear! Uni News Bot is Here! \\o/\n"+
               "!ping - Gives pong! \n" +
               "!news - Shows Current articles from Uni!\n" +
               "!opinion - Shows Opinion articles from Uni!\n" +
               "!help - Gives you help! (You are here)").queue();
         }
      }
   }
}
