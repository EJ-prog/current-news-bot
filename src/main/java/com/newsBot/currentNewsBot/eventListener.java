package com.newsBot.currentNewsBot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class eventListener extends ListenerAdapter {
   public void onMessageRecieved(MessageReceivedEvent theEvent) {
      if (!theEvent.getAuthor().isBot()) {
         Message message = theEvent.getMessage();
         String content = message.getContentRaw();
         if (content.equals("!ping")) {
            MessageChannel channel = theEvent.getChannel();
            channel.sendMessage("Pong!").queue();
         }
      }
   }
}
