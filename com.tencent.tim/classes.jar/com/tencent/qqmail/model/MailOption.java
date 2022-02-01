package com.tencent.qqmail.model;

public class MailOption
{
  public String folderIndex;
  public boolean forceFetch = false;
  public long id;
  public boolean isPreread;
  public String mailId;
  public String parentId;
  
  public MailOption() {}
  
  public MailOption(long paramLong)
  {
    this.id = paramLong;
  }
  
  public MailOption(String paramString1, String paramString2)
  {
    this.mailId = paramString1;
    this.folderIndex = paramString2;
  }
  
  public MailOption(String paramString1, String paramString2, String paramString3)
  {
    this.mailId = paramString1;
    this.folderIndex = paramString2;
    this.parentId = paramString3;
  }
  
  public MailOption(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.mailId = paramString1;
    this.folderIndex = paramString2;
    this.parentId = paramString3;
    this.forceFetch = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.MailOption
 * JD-Core Version:    0.7.0.1
 */