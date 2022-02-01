package com.tencent.qqmail.bottle.model;

public class Bottler
{
  boolean anonymous;
  String avatar;
  String bigAvatar;
  boolean male;
  String name;
  String uin;
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public String getBigAvatar()
  {
    return this.bigAvatar;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public boolean isAnonymous()
  {
    return this.anonymous;
  }
  
  public boolean isMale()
  {
    return this.male;
  }
  
  public void setAll(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.uin = paramString1;
    this.avatar = paramString2;
    this.bigAvatar = paramString3;
    this.name = paramString4;
    this.male = paramBoolean1;
    this.anonymous = paramBoolean2;
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.Bottler
 * JD-Core Version:    0.7.0.1
 */