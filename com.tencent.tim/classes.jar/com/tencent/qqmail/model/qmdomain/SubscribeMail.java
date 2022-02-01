package com.tencent.qqmail.model.qmdomain;

import com.tencent.qqmail.utilities.QMMath;
import java.util.Date;

public class SubscribeMail
  extends Mail
{
  public static int ID_CARTOON = 109;
  public static int ID_DAILY_SPECIALS;
  public static int ID_ELLE;
  public static int ID_FML_CHINA;
  public static int ID_QQMAIL_ACT;
  public static int ID_SUBSCRIBE_STOCK = 32;
  public static int ID_TEST;
  public static int ID_XIN_DONG_FANG;
  public static int INDEX_ENTRANCE_MAIL = -1;
  public static int LOAD_MORE_PER_COUNT = 5;
  private String abstract_txt;
  private int accountId;
  private String bigIcon;
  private int colId;
  private String fromAddress;
  private String fromName;
  private String icon;
  private long id;
  private int index;
  private boolean isSnapShot;
  private String link;
  private long mid;
  private Date receive;
  private String remoteId;
  private String subject;
  
  static
  {
    ID_QQMAIL_ACT = 102;
    ID_FML_CHINA = 314;
    ID_XIN_DONG_FANG = 315;
    ID_DAILY_SPECIALS = 230;
    ID_ELLE = 327;
    ID_TEST = 10106;
  }
  
  public static long generateId(long paramLong, int paramInt)
  {
    return QMMath.hashLong(paramLong + "_" + paramInt);
  }
  
  public String getAbstract()
  {
    return this.abstract_txt;
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public String getBigIcon()
  {
    return this.bigIcon;
  }
  
  public int getColId()
  {
    return this.colId;
  }
  
  public String getFromAddress()
  {
    return this.fromAddress;
  }
  
  public String getFromName()
  {
    return this.fromName;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getLink()
  {
    return this.link;
  }
  
  public long getMid()
  {
    return this.mid;
  }
  
  public String getPreviewUrl()
  {
    return "http://rescdn.qqmail.com/riasharebook/mailid%3D$remoteId$%26colid%3D$colid$%26itemnum%3D$idx$".replace("$remoteId$", this.remoteId).replace("$idx$", Math.max(0, getIndex()) + "").replace("$colid$", this.colId + "");
  }
  
  public Date getReceive()
  {
    return this.receive;
  }
  
  public String getRemoteId()
  {
    return this.remoteId;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public boolean isSnapShot()
  {
    return this.isSnapShot;
  }
  
  public void setAbstract(String paramString)
  {
    this.abstract_txt = paramString;
  }
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setBigIcon(String paramString)
  {
    this.bigIcon = paramString;
  }
  
  public void setColId(int paramInt)
  {
    this.colId = paramInt;
  }
  
  public void setFromAddress(String paramString)
  {
    this.fromAddress = paramString;
  }
  
  public void setFromName(String paramString)
  {
    this.fromName = paramString;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setLink(String paramString)
  {
    this.link = paramString;
  }
  
  public void setMid(long paramLong)
  {
    this.mid = paramLong;
  }
  
  public void setReceive(Date paramDate)
  {
    this.receive = paramDate;
  }
  
  public void setRemoteId(String paramString)
  {
    this.remoteId = paramString;
  }
  
  public void setSnapShot(boolean paramBoolean)
  {
    this.isSnapShot = paramBoolean;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.SubscribeMail
 * JD-Core Version:    0.7.0.1
 */