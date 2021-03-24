package com.newsBot.currentNewsBot;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class eventListener extends ListenerAdapter {

   @Override
   public void onMessageReactionAdd(MessageReceivedEvent theEvent) {
      if (!theEvent.getAuthor().isBot()) {
         System.out.println("I'm not bot!");
         Message message = theEvent.getMessage();
         String content = message.getContentDisplay();
         if (content.equals("!ping")) {
            System.out.println("I heard ping! Sending Pog!");
            MessageChannel channel = theEvent.getChannel();
            channel.sendMessage("Pong!").queue();
         }
      }
   }
}
