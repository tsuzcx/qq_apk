package com.tencent.qqmail.popularize.model;

public class PopularizeMoreOperation
{
  public static final int OPT_COPY_LINK = 3;
  public static final int OPT_OPEN_WEBVIEW = 4;
  public static final int OPT_SEND_MAIL = 5;
  public static final int OPT_SHARED_TO_WECAHT_FRIEND = 2;
  public static final int OPT_SHARED_TO_WECAHT_TIMELINE = 1;
  private String abstracts;
  private String content;
  private String imageUrl;
  private String itemName;
  private int operation;
  private String title;
  private String type;
  private String url;
  
  public String getAbstracts()
  {
    return this.abstracts;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public String getItemName()
  {
    return this.itemName;
  }
  
  public int getOperation()
  {
    return this.operation;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setCopyLink(String paramString1, String paramString2)
  {
    this.operation = 3;
    this.url = paramString1;
    this.itemName = paramString2;
  }
  
  public void setOpenWebView(String paramString1, String paramString2)
  {
    this.operation = 4;
    this.url = paramString1;
    this.itemName = paramString2;
  }
  
  public void setSendMail(String paramString1, String paramString2, String paramString3)
  {
    this.operation = 5;
    this.type = paramString1;
    this.content = paramString2;
    this.itemName = paramString3;
  }
  
  public void setSharedToWechatFriend(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.operation = 2;
    this.title = paramString1;
    this.imageUrl = paramString2;
    this.abstracts = paramString3;
    this.url = paramString4;
    this.itemName = paramString5;
  }
  
  public void setSharedToWechatTimeline(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.operation = 1;
    this.title = paramString1;
    this.imageUrl = paramString2;
    this.abstracts = paramString3;
    this.url = paramString4;
    this.itemName = paramString5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.model.PopularizeMoreOperation
 * JD-Core Version:    0.7.0.1
 */