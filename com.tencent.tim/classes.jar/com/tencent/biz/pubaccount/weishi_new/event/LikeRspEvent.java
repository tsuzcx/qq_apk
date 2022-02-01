package com.tencent.biz.pubaccount.weishi_new.event;

public class LikeRspEvent
  extends WSSimpleBaseEvent
{
  private String feedId;
  private int position;
  private int rpsStatus;
  private int rspIsDing;
  
  public LikeRspEvent(String paramString, int paramInt)
  {
    this.feedId = paramString;
    this.position = paramInt;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int getRpsStatus()
  {
    return this.rpsStatus;
  }
  
  public int getRspIsDing()
  {
    return this.rspIsDing;
  }
  
  public void setFeedId(String paramString)
  {
    this.feedId = paramString;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setRpsStatus(int paramInt)
  {
    this.rpsStatus = paramInt;
  }
  
  public void setRspIsDing(int paramInt)
  {
    this.rspIsDing = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent
 * JD-Core Version:    0.7.0.1
 */