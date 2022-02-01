package com.tencent.qqmail.bottle.model;

public class BottleList
{
  String avatar;
  String bottleId;
  String displaySummary;
  String emoji;
  boolean isMine;
  boolean male;
  String name;
  String summary;
  long time;
  int type;
  String uin;
  int unreadCnt;
  int unsend;
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public String getBottleId()
  {
    return this.bottleId;
  }
  
  public String getEmoji()
  {
    return this.emoji;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSummary()
  {
    if (this.displaySummary == null) {
      return this.summary;
    }
    return this.displaySummary;
  }
  
  public long getTime()
  {
    return this.time;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public int getUnreadCnt()
  {
    return this.unreadCnt;
  }
  
  public int getUnsend()
  {
    return this.unsend;
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
 * Qualified Name:     com.tencent.qqmail.bottle.model.BottleList
 * JD-Core Version:    0.7.0.1
 */