package com.tencent.qqmail.bottle.model;

public class BottleConversation
{
  String audioUrl;
  String avatar;
  String bigAvatar;
  String bottleId;
  String content;
  String contentHeader;
  String displayContent;
  String emoji;
  String imageUrl;
  boolean isMine;
  private Bottler mBottler = null;
  boolean male;
  String msgId;
  String name;
  long time;
  String uin;
  int unsend;
  
  public String getAudioUrl()
  {
    return this.audioUrl;
  }
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public String getBottleId()
  {
    return this.bottleId;
  }
  
  public Bottler getBottler()
  {
    if (this.mBottler == null)
    {
      this.mBottler = new Bottler();
      this.mBottler.setAll(this.uin, this.avatar, this.bigAvatar, this.name, this.male, false);
    }
    return this.mBottler;
  }
  
  public String getContent()
  {
    if (this.displayContent == null) {
      return this.content;
    }
    return this.displayContent;
  }
  
  public String getContentHeader()
  {
    return this.contentHeader;
  }
  
  public String getEmoji()
  {
    return this.emoji;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public String getMsgId()
  {
    return this.msgId;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getOriginalContent()
  {
    return this.content;
  }
  
  public long getTime()
  {
    return this.time;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public boolean isMale()
  {
    return this.male;
  }
  
  public boolean isMine()
  {
    return this.isMine;
  }
  
  public boolean isUnsend()
  {
    return this.unsend == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.BottleConversation
 * JD-Core Version:    0.7.0.1
 */