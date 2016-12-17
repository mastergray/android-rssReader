package com.example.com.mastergray.rssreader;

import java.util.*;

public class Channel {
	
	  private String title;
	    private String description;
	    private String link;
	    private String lastBuildDate;
	    private String pubDate;
	    private int ttl;
	    private ArrayList<Article> Articles = new ArrayList<Article>();
	    
	    //  No Argument Constructor:
	    Channel () {}
	    
	    Channel (String title, String description, String link, String lastBuildDate, String pubDate, int ttl) {
	        
	        this.title = title;
	        this.description = description;
	        this.link = link;
	        this.lastBuildDate = lastBuildDate;
	        this.pubDate = pubDate;
	        this.ttl = ttl;
	        
	    }
	   
	    /*************************
	    
	        RSS Channel Methods
	     
	    *************************/
	    
	    public String getTitle() {
	       
	        return this.title;
	        
	    }
	    
	    public String getDescription() {
	        
	        return this.description;
	        
	    }
	    
	    public String getLink() {
	        
	        return this.link;
	        
	    }
	    
	    public String getLastBuildDate() {
	        
	        return this.lastBuildDate;
	        
	    }
	    
	    public String getPubDate() {
	        
	        return this.pubDate;
	        
	    }
	    
	    public int getTTL() {
	        
	        return this.ttl;
	        
	    }
	    
	    public void setTitle(String title) {
	       
	        this.title = title;
	        
	    }
	    
	    public void setDescription(String description) {
	        
	        this.description = description;
	        
	    }
	    
	    public void setLink(String link) {
	        
	        this.link = link;
	        
	    }
	    
	    public void setLastBuildDate(String lastBuildDate) {
	        
	        this.lastBuildDate = lastBuildDate;
	        
	    }
	    
	    public void setPubDate(String pubDate) {
	        
	        this.pubDate = pubDate;
	        
	    }
	    
	    public void setTTL(int ttl) {
	        
	        this.ttl = ttl;
	        
	    }
	    
	     public void setByTag(String tagName, String content) {
	        
	        if (tagName.equalsIgnoreCase("title")) {
	            
	            this.setTitle(content);
	            
	        }
	        
	        if (tagName.equalsIgnoreCase("description")) {
	            
	            this.setDescription(content);
	            
	        }
	        
	        if (tagName.equalsIgnoreCase("link")) {
	            
	            this.setLink(content);
	            
	        }
	        
	        if (tagName.equalsIgnoreCase("lastBuildDate")) {
	            
	            this.setLastBuildDate(content);
	            
	        }
	        
	         if (tagName.equalsIgnoreCase("updated")) {
	            
	            this.setLastBuildDate(content);
	            
	        }
	        
	        if (tagName.equalsIgnoreCase("published")) {
	            
	            this.setPubDate(content);
	            
	        }
	         
	        if (tagName.equalsIgnoreCase("pubDate")) {
	            
	            this.setPubDate(content);
	            
	        } 
	        
	        if (tagName.equalsIgnoreCase("ttl")) {
	            
	           this.setTTL(Integer.parseInt(content));
	            
	        }
	        
	    }
	    
	   /***********************
	   
	        RSS Item Methods
	     
	   ***********************/
	    
	   //   Adds article: 
	   public void addArticle(Article article) {
	       
	       this.Articles.add(article);
	       
	   }
	   
	   //   Returns all articles:
	   public ArrayList<Article> getArticle() {
	       
	       return this.Articles;
	       
	   }
	   
	   //   Returns article for given index:
	   public Article getArticle(int index) {
	       
	       return this.Articles.get(index);
	       
	   }
	   
	   //	Returns all article headlines:
	   public ArrayList<String> getHeadLines() {
		   
		   ArrayList<String> headlines = new ArrayList<String>();
		   
			   	for (Article article : this.Articles) {
			   		
			   		headlines.add(article.getTitle());
			   		
			   	}
		   
		   	return headlines;
		   
	   }
	   
	   //   Returns index for given article:
	   public int getArticleIndex(Article article) {
	       
	       return this.Articles.indexOf(article);
	       
	   }
	   
	   //  Removes all articles:
	   public void removeArticle() {
	       
	       this.Articles.clear();
	       
	   }
	   
	   //  Removes article by index:
	   public void removeArticle(int index) {
	        
	       this.Articles.remove(index);
	       
	   }
	   
	   //  Removes article by article:
	   public void removeArticle(Article article) {
	       
	       this.Articles.remove(article);
	       
	   }
	   
	   //  Returns all articles as a string:
    public String showArticles() {
        
    	
    	String output = "";
    	StringBuilder sb = new StringBuilder(output);
          
       for (Article article : this.Articles) {

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
