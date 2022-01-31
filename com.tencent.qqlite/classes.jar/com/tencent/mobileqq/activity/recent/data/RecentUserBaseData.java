package com.tencent.mobileqq.activity.recent.data;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.data.RecentUser;

public abstract class RecentUserBaseData
  extends RecentBaseData
{
  protected static final String f = "%s,%d,%s,%s";
  protected static final String g = "%s,%s,%s";
  public RecentUser a;
  
  public RecentUserBaseData(RecentUser paramRecentUser)
  {
    if (paramRecentUser == null) {
      throw new NullPointerException("RecentUser is null");
    }
    this.a = paramRecentUser;
    switch (this.a.type)
    {
    }
  }
  
  public int a()
  {
    return this.a.type;
  }
  
  public long a()
  {
    return this.a.lastmsgtime;
  }
  
  public RecentUser a()
  {
    return this.a;
  }
  
  public String a()
  {
    return this.a.uin;
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.a = paramRecentUser;
  }
  
  public final boolean a()
  {
    return (this.u == 1) || (this.u == 4);
  }
  
  public long b()
  {
    return this.a.lastmsgdrafttime;
  }
  
  public int c()
  {
    return this.a.msgType;
  }
  
  public String c()
  {
    return this.a.troopUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
 * JD-Core Version:    0.7.0.1
 */