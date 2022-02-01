package com.tencent.qqmail.popularize.model;

import com.tencent.qqmail.utilities.QMMath;

public class PopularizeSubItem
  implements Comparable<PopularizeSubItem>
{
  private int action;
  private int bottomRatio;
  private int condition;
  private int id;
  private String imageMd5;
  private String imageUrl;
  private boolean isCancel;
  private boolean isClick;
  private boolean isClickMyApp;
  private boolean isRelated;
  private boolean isRender;
  private long lastRenderTime;
  private String openUrl;
  private int popularizeId;
  private int position;
  private int sequence;
  private int serverId;
  private int showType;
  private String text;
  
  public static int generateId(int paramInt1, int paramInt2)
  {
    return QMMath.hashInt(paramInt1 + ":" + paramInt2);
  }
  
  public int compareTo(PopularizeSubItem paramPopularizeSubItem)
  {
    return getSequence() - paramPopularizeSubItem.getSequence();
  }
  
  public int getAction()
  {
    return this.action;
  }
  
  public int getBottomRatio()
  {
    return this.bottomRatio;
  }
  
  public int getCondition()
  {
    return this.condition;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getImageMd5()
  {
    return this.imageMd5;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public long getLastRenderTime()
  {
    return this.lastRenderTime;
  }
  
  public String getOpenUrl()
  {
    return this.openUrl;
  }
  
  public int getPopularizeId()
  {
    return this.popularizeId;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int getSequence()
  {
    return this.sequence;
  }
  
  public int getServerId()
  {
    return this.serverId;
  }
  
  public int getShowType()
  {
    return this.showType;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public boolean isCancel()
  {
    return this.isCancel;
  }
  
  public boolean isClick()
  {
    return this.isClick;
  }
  
  public boolean isClickMyApp()
  {
    return this.isClickMyApp;
  }
  
  public boolean isRelated()
  {
    return this.isRelated;
  }
  
  public boolean isRender()
  {
    return this.isRender;
  }
  
  public void setAction(int paramInt)
  {
    this.action = paramInt;
  }
  
  public void setBottomRatio(int paramInt)
  {
    this.bottomRatio = paramInt;
  }
  
  public void setCondition(int paramInt)
  {
    this.condition = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImageMd5(String paramString)
  {
    this.imageMd5 = paramString;
  }
  
  public void setImageUrl(String paramString)
  {
    this.imageUrl = paramString;
  }
  
  public void setIsCancel(boolean paramBoolean)
  {
    this.isCancel = paramBoolean;
  }
  
  public void setIsClick(boolean paramBoolean)
  {
    this.isClick = paramBoolean;
  }
  
  public void setIsClickMyApp(boolean paramBoolean)
  {
    this.isClickMyApp = paramBoolean;
  }
  
  public void setIsRelated(boolean paramBoolean)
  {
    this.isRelated = paramBoolean;
  }
  
  public void setIsRender(boolean paramBoolean)
  {
    this.isRender = paramBoolean;
  }
  
  public void setLastRenderTime(long paramLong)
  {
    this.lastRenderTime = paramLong;
  }
  
  public void setOpenUrl(String paramString)
  {
    this.openUrl = paramString;
  }
  
  public void setPopularizeId(int paramInt)
  {
    this.popularizeId = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setSequence(int paramInt)
  {
    this.sequence = paramInt;
  }
  
  public void setServerId(int paramInt)
  {
    this.serverId = paramInt;
  }
  
  public void setShowType(int paramInt)
  {
    this.showType = paramInt;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public String toString()
  {
    return "PopularizeSubItem{serverId=" + this.serverId + ", id=" + this.id + ", popularizeId=" + this.popularizeId + ", text='" + this.text + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", imageMd5='" + this.imageMd5 + '\'' + ", position=" + this.position + ", sequence=" + this.sequence + ", showType=" + this.showType + ", condition=" + this.condition + ", action=" + this.action + ", openUrl='" + this.openUrl + '\'' + ", bottom_radio=" + this.bottomRatio + ", lastRenderTime=" + this.lastRenderTime + ", isRender=" + this.isRender + ", isClick=" + this.isClick + ", isCancel=" + this.isCancel + ", isRelated=" + this.isRender + ", isClickMyApp=" + this.isClickMyApp + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.model.PopularizeSubItem
 * JD-Core Version:    0.7.0.1
 */