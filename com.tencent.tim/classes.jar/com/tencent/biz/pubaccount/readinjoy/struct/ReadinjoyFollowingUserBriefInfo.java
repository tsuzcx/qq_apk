package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ReadinjoyFollowingUserBriefInfo
  extends Entity
{
  public int followed = 0;
  @unique
  public long uin;
  
  public ReadinjoyFollowingUserBriefInfo()
  {
    this.uin = 0L;
  }
  
  public ReadinjoyFollowingUserBriefInfo(long paramLong, int paramInt)
  {
    this.uin = paramLong;
    this.followed = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyFollowingUserBriefInfo
 * JD-Core Version:    0.7.0.1
 */