package com.tencent.moai.mailsdk.protocol.exchange.model;

public class ExchangeRule
{
  private Actions actions;
  private Conditions conditions;
  private String displayName;
  private String id;
  private boolean isEnabled;
  private int priority;
  
  public Actions getActions()
  {
    return this.actions;
  }
  
  public Conditions getConditions()
  {
    return this.conditions;
  }
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public boolean isEnabled()
  {
    return this.isEnabled;
  }
  
  public void setActions(Actions paramActions)
  {
    this.actions = paramActions;
  }
  
  public void setConditions(Conditions paramConditions)
  {
    this.conditions = paramConditions;
  }
  
  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.isEnabled = paramBoolean;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setPriority(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public class Actions
  {
    private String desFolderId_;
    private int desFolderType_;
    private boolean markAsRead;
    private boolean softDeleteMail;
    private boolean stopSubsequentRules;
    
    public Actions() {}
    
    public String getDesFolderId_()
    {
      return this.desFolderId_;
    }
    
    public int getDesFolderType_()
    {
      return this.desFolderType_;
    }
    
    public boolean isMarkAsRead()
    {
      return this.markAsRead;
    }
    
    public boolean isSoftDeleteMail()
    {
      return this.softDeleteMail;
    }
    
    public boolean isStopSubsequentRules()
    {
      return this.stopSubsequentRules;
    }
    
    public void setDesFolderId_(String paramString)
    {
      this.desFolderId_ = paramString;
    }
    
    public void setDesFolderType_(int paramInt)
    {
      this.desFolderType_ = paramInt;
    }
    
    public void setMarkAsRead(boolean paramBoolean)
    {
      this.markAsRead = paramBoolean;
    }
    
    public void setSoftDeleteMail(boolean paramBoolean)
    {
      this.softDeleteMail = paramBoolean;
    }
    
    public void setStopSubsequentRules(boolean paramBoolean)
    {
      this.stopSubsequentRules = paramBoolean;
    }
  }
  
  public class Conditions
  {
    private String sender;
    private String subject;
    private String to;
    
    public Conditions() {}
    
    public String getSender()
    {
      return this.sender;
    }
    
    public String getSubject()
    {
      return this.subject;
    }
    
    public String getTo()
    {
      return this.to;
    }
    
    public void setSender(String paramString)
    {
      this.sender = paramString;
    }
    
    public void setSubject(String paramString)
    {
      this.subject = paramString;
    }
    
    public void setTo(String paramString)
    {
      this.to = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeRule
 * JD-Core Version:    0.7.0.1
 */