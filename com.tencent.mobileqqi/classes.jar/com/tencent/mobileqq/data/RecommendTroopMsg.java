package com.tencent.mobileqq.data;

public class RecommendTroopMsg
{
  public boolean isRead;
  public int msgtype;
  public RecTroopBusinessItem rtbItem;
  public long timeStamp;
  public RecommendTroopInfo troop;
  public long uniseq;
  
  public boolean isBusiness()
  {
    return (this.msgtype == -1040) && (this.rtbItem != null);
  }
  
  public boolean isTroop()
  {
    return (this.msgtype == -1039) && (this.troop != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendTroopMsg
 * JD-Core Version:    0.7.0.1
 */