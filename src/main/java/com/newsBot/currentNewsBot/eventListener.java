package com.newsBot.currentNewsBot;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
         } else if (content.equals("!help") || content.equals("!halp")) {
            // Gives help
            System.out.println("MEDIC! HAAALLLPPP!");
            channel.sendMessage("Never Fear! Uni News Bot is Here! \\o/\n"+
               "!ping - Gives pong! \n" +
               "!news - Shows Current articles from Uni!\n" +
               "!editorial - Shows Editorial articles from Uni!\n" +
               "!help - Gives you help! (You are here)").queue();
         }
         if (content.equals("!news")) {
            System.out.println("news");
            try {
               Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/news/").timeout(6000).get();
               Elements links = doc.select("a[href]");
               for (Element link : links) {
                  System.out.println(link.attr("href"));
                  channel.sendMessage(link.text()).queue();
               }
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         if (content.equals("!editorial")) {
            System.out.println("editorial");
            try {
               Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/spotlight/editorial/").timeout(6000).get();
               Elements links = doc.select("a[href]");
               for (Element link : links) {
                  System.out.println(link.attr("href"));
                  channel.sendMessage(link.text()).queue();
               }
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         if (content.equals("!letters")) {
            System.out.println("letters to the editor");
            try {
               Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/letters-to-the-editor/").timeout(6000).get();
               Elements links = doc.select("a[href]");
               for (Element link : links) {
                  System.out.println(link.attr("href"));
                  channel.sendMessage(link.text()).queue();
               }       
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         if (content.equals("!arts")) {
            System.out.println("arts and entertainment");
            try {
               Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/arts-entertainment/").timeout(6000).get();
               Elements links = doc.select("a[href]");
               for (Element link : links) {
                  System.out.println(link.attr("href"));
                  channel.sendMessage(link.text()).queue();
               }       
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         if (content.equals("!sports")) {
            System.out.println("sports");
            try {
               Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/arts-entertainment/sports").timeout(6000).get();
               Elements links = doc.select("a[href]");
               for (Element link : links) {
                  System.out.println(link.attr("href"));
                  channel.sendMessage(link.text()).queue();
               }       
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         if (content.equals("!spotlight")) {
            System.out.println("spotlight articles/pieces");
            try {
               Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/spotlight/").timeout(6000).get();
               Elements links = doc.select("a[href]");
               for (Element link : links) {
                  System.out.println(link.attr("href"));
                  channel.sendMessage(link.text()).queue();
               }        
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         if (content.equals("!huskies")) {
            System.out.println("Huskies in the Hallway");
            try {
               Document doc = Jsoup.connect("https://www.thetacomaledger.com/category/spotlight/huskies-in-the-hallway/").timeout(6000).get();
               Elements links = doc.select("a[href]");
               for (Element link : links) {
                  System.out.println(link.attr("href"));
                  channel.sendMessage(link.text()).queue();
               }        
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }
}
