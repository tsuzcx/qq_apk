package com.tencent.mobileqq.data;

import aczw;
import java.io.Serializable;

public class MessageForNearbyRecommenderTips
  extends ChatMessage
{
  public boolean readFlag;
  public String strBrief = "";
  public long uRecommendTime;
  
  protected void doParse()
  {
    try
    {
      NearbyRecommenderInfo localNearbyRecommenderInfo = (NearbyRecommenderInfo)aczw.c(this.msgData);
      if (localNearbyRecommenderInfo != null)
      {
        this.uRecommendTime = localNearbyRecommenderInfo.uRecommendTime;
        this.readFlag = localNearbyRecommenderInfo.readFlag;
        this.strBrief = localNearbyRecommenderInfo.strBrief;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    NearbyRecommenderInfo localNearbyRecommenderInfo = new NearbyRecommenderInfo();
    localNearbyRecommenderInfo.uRecommendTime = this.uRecommendTime;
    localNearbyRecommenderInfo.readFlag = this.readFlag;
    localNearbyRecommenderInfo.strBrief = this.strBrief;
    try
    {
      this.msgData = aczw.b(localNearbyRecommenderInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static class NearbyRecommenderInfo
    implements Serializable
  {
    public boolean readFlag;
    public String strBrief;
    public long uRecommendTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyRecommenderTips
 * JD-Core Version:    0.7.0.1
 */