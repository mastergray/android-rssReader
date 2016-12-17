package com.example.com.mastergray.rssreader;
import java.util.ArrayList;

public class Channels {

	  public static ArrayList<Channel> channels = new ArrayList<Channel>();
	    
	    //  Add new channel:
	    public static void addChannel(Channel channel) {
	        
	        channels.add(channel);
	        
	    }
	    
	    //  Returns all channels:
	    public static ArrayList<Channel> getChannel() {
	        
	        return channels;
	        
	    }
	    
	    //  Returns channel by index:
	    public static Channel getChannel(int index) {
	        
	        return channels.get(index);
	        
	    }
	    
	    //  Returns index by channel:
	    public static int getChannelIndex(Channel channel) {
	        
	        return channels.indexOf(channel);
	        
	    }
	    
	    //  Removes all channels:
	    public static void removeChannel() {
	        
	        channels.clear();
	        
	    }
	    
	    //  Removes channel by index:
	    public static void removeChannel(int index) {
	        
	        channels.remove(index);
	        
	    }
	    
	    //  Removes channel by channel:
	    public static void removeChannel(Channel channel) {
	        
	        channels.remove(channel);
	        
	    }
	    
	    //  Returns all articles as a string for a channel by index:
	    public static String showArticles(int index) {
	        
	    	Channel channel = channels.get(index);
	    	
	    	String output = "";
	    	StringBuilder sb = new StringBuilder(output);
	          
            for (Article article : channel.getArticle()) {

            	output = sb.append(article.getTitle() + "\n").toString();
                
                if (!article.getDescription().equals("")) {
                
                	output = sb.append(article.getDescription() + "\n").toString();
                
                }
                
                output = sb.append(article.getLink() + "\n").toString();
                output = sb.append(article.getPubDate() + "\n").toString();
                output = sb.append("\n\n").toString();
                
            }
	              
            return output;
	        
	    }
	    
	
}
