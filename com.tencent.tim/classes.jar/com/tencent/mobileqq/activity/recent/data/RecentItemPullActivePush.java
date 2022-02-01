package com.tencent.mobileqq.activity.recent.data;

import aqmu;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemPullActivePush
  extends RecentUserBaseData
{
  public long time;
  
  public RecentItemPullActivePush(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
  }
  
  public void init(String paramString, long paramLong)
  {
    this.mTitleName = paramString;
    this.time = paramLong;
    this.mShowTime = aqmu.a(paramLong, true, "yyyy-MM-dd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush
 * JD-Core Version:    0.7.0.1
 */