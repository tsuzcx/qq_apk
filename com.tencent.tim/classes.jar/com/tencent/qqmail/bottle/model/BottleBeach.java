package com.tencent.qqmail.bottle.model;

public class BottleBeach
{
  String adUrl;
  String avatar;
  String bigAvatar;
  String bottleid;
  String city;
  String content;
  String contentHeader;
  String displayContent;
  int distance;
  String emoji;
  String imageUrl;
  private Bottler mBottler = null;
  boolean male;
  String name;
  int tagColor;
  long time;
  int type;
  String uin;
  
  public BottleBeach() {}
  
  public BottleBeach(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt2, int paramInt3, String paramString12)
  {
    this.bottleid = paramString1;
    this.time = paramLong;
    this.distance = paramInt1;
    this.imageUrl = paramString2;
    this.uin = paramString3;
    this.avatar = paramString4;
    this.bigAvatar = paramString5;
    this.name = paramString6;
    this.male = paramBoolean;
    this.city = paramString7;
    this.contentHeader = paramString8;
    this.content = paramString9;
    this.displayContent = paramString10;
    this.emoji = paramString11;
    this.type = paramInt2;
    this.tagColor = paramInt3;
    this.adUrl = paramString12;
  }
  
  public String getAdUrl()
  {
    return this.adUrl;
  }
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public String getBigAvatar()
  {
    return this.bigAvatar;
  }
  
  public String getBottleid()
  {
    return this.bottleid;
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
  
  public String getCity()
  {
    return this.city;
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
  
  public int getDistance()
  {
    return this.distance;
  }
  
  public String getEmoji()
  {
    return this.emoji;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getTagColor()
  {
    return this.tagColor;
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
  
  public boolean isMale()
  {
    return this.male;
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.BottleBeach
 * JD-Core Version:    0.7.0.1
 */