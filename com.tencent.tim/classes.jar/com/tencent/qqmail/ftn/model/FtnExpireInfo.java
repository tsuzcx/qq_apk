package com.tencent.qqmail.ftn.model;

import java.io.Serializable;

public class FtnExpireInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private long accountId;
  private String lstExpHashId;
  private int lstExpireCnt;
  private int lstTotalCnt;
  private long lstUpdateTime;
  
  public long getAccountId()
  {
    return this.accountId;
  }
  
  public String getLstExpHashId()
  {
    return this.lstExpHashId;
  }
  
  public int getLstExpireCnt()
  {
    return this.lstExpireCnt;
  }
  
  public int getLstTotalCnt()
  {
    return this.lstTotalCnt;
  }
  
  public long getLstUpdateTime()
  {
    return this.lstUpdateTime;
  }
  
  public void setAccountId(long paramLong)
  {
    this.accountId = paramLong;
  }
  
  public void setLstExpHashId(String paramString)
  {
    this.lstExpHashId = paramString;
  }
  
  public void setLstExpireCnt(int paramInt)
  {
    this.lstExpireCnt = paramInt;
  }
  
  public void setLstTotalCnt(int paramInt)
  {
    this.lstTotalCnt = paramInt;
  }
  
  public void setLstUpdateTime(long paramLong)
  {
    this.lstUpdateTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.model.FtnExpireInfo
 * JD-Core Version:    0.7.0.1
 */