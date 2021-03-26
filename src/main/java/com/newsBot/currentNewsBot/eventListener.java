package com.newsBot.currentNewsBot;

import java.io.IOException;
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
         if (content.equals("!news")) {
            System.out.println("news");
            MessageChannel channel = theEvent.getChannel();
            Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/news/").timeout(6000).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
               System.out.println(link.attr("href"));
               channel.sendMessage(link).queue();
            }
         }
         if (content.equals("!editorial")) {
            System.out.println("editorial");
            MessageChannel channel = theEvent.getChannel();
            Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/spotlight/editorial/").timeout(6000).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
               System.out.println(link.attr("href"));
               channel.sendMessage(link).queue();
            }
         }
         if (content.equals("!letters")) {
            System.out.println("letters to the editor");
            MessageChannel channel = theEvent.getChannel();
            Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/letters-to-the-editor/").timeout(6000).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
               System.out.println(link.attr("href"));
               channel.sendMessage(link).queue();
            }       
         }
         if (content.equals("!arts")) {
            System.out.println("arts and entertainment");
            MessageChannel channel = theEvent.getChannel();
            Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/arts-entertainment/").timeout(6000).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
               System.out.println(link.attr("href"));
               channel.sendMessage(link).queue();
            }       
         }
         if (content.equals("!sports")) {
            System.out.println("sports");
            MessageChannel channel = theEvent.getChannel();
            Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/arts-entertainment/sports").timeout(6000).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
               System.out.println(link.attr("href"));
               channel.sendMessage(link).queue();
            }       
         }
         if (content.equals("!spotlight")) {
            System.out.println("spotlight articles/pieces");
            MessageChannel channel = theEvent.getChannel();
            Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/spotlight/").timeout(6000).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
               System.out.println(link.attr("href"));
               channel.sendMessage(link).queue();
            }        
         }
         if (content.equals("!huskies")) {
            System.out.println("Huskies in the Hallway");
            MessageChannel channel = theEvent.getChannel();
            Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/spotlight/huskies-in-the-hallway/").timeout(6000).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
               System.out.println(link.attr("href"));
               channel.sendMessage(link).queue();
            }        
         }
      }
   }
}
