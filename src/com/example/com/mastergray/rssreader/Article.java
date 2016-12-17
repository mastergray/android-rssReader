package com.example.com.mastergray.rssreader;

public class Article {

	 private String title;
	    private String description = "";
	    private String link;
	    private String guid;
	    private String pubDate;
	    private boolean hasBeenRead = false;
	   
	    //  No Argument Constructor:
	    Article () {}
	    
	    Article (String title, String description, String link, String guid, String pubDate) {
	        
	        this.title = title;
	        this.description = description;
	        this.link = link;
	        this.guid = guid;
	        this.pubDate = pubDate;
	        
	    }
	    
	    public String getTitle() {
	        
	        return this.title;
	        
	    }
	    
	    public String getDescription() {
	        
	        return this.description;
	        
	    }
	    
	    public String getLink() {
	        
	        return this.link;
	        
	    }
	    
	    public String getGUID() {
	        
	        return this.guid;
	        
	    }
	    
	    public String getPubDate() {
	        
	        return this.pubDate;
	        
	    }
	    
	    public void setTitle(String title) {
	        
	        this.title = title;
	        
	    }
	    
	    public void setDescription(String description) {
	   
	       StringBuilder sb = new StringBuilder(this.description);
	       this.description = sb.append(description).toString();
	
	    }
	    
	    public void setLink(String link) {
	        
	        this.link = link;
	        
	    }
	    
	    public void setGUID(String guid) {
	        
	        this.guid = guid;
	        
	    }
	    
	    public void setPubDate(String pubDate) {
	        
	        this.pubDate = pubDate; 
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
	        
	        if (tagName.equalsIgnoreCase("guid")) {
	            
	            this.setGUID(content);
	            
	        }
	        
	         if (tagName.equalsIgnoreCase("pubDate")) {
	            
	            this.setPubDate(content);
	            
	        }
	        
	    }
	    
	    public boolean readStatus() {
	        
	        return this.hasBeenRead;
	        
	    }
	    
	    public void readStatus(boolean status) {
	        
	        this.hasBeenRead = status;
	        
	    }
	
}
