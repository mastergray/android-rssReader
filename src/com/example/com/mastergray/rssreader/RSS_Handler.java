package com.example.com.mastergray.rssreader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RSS_Handler extends DefaultHandler{
	
	boolean isChannel;
    boolean isItem;
    Channel channel;
    Article article;
    String tagName;
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        //System.out.println(qName);
        
        if (qName.equalsIgnoreCase("channel") || qName.equalsIgnoreCase("feed")) {

            isChannel = true;
            channel = new Channel();
            tagName = null;
            
        } else if (qName.equalsIgnoreCase("item") || qName.equalsIgnoreCase("entry")) {

            isItem = true;
            article = new Article();
            tagName = null;
            
        } else {
            
            if (!qName.equalsIgnoreCase("rss")) {
            
                tagName = qName;
                
            }
            
        }
             
        
    }
    
    public void characters(char ch[], int start, int length) throws SAXException {

        if (tagName != null) {

            String content = new String(ch, start, length);
            
            if (isItem) {
                
                
                article.setByTag(tagName, content);

                
            } else {
                
                channel.setByTag(tagName, content);
                
            }
        }
        

    }
    
     public void endElement(String uri, String localName, String qName) throws SAXException {

         if (qName.equalsIgnoreCase("channel") || qName.equalsIgnoreCase("feed")) {

            Channels.addChannel(channel);
            isChannel = false;
            
        } else if (qName.equalsIgnoreCase("item") || qName.equalsIgnoreCase("entry")) {

            channel.addArticle(article);
            isItem = false;
            
        }   else {
           
            tagName = null;
            
        }
        

    }

}
