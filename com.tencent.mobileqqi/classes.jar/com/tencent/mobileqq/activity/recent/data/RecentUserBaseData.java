package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public abstract class RecentUserBaseData
  extends RecentBaseData
{
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
    for (;;)
    {
      this.F &= 0xFFFFFF0F;
      if (this.a.showUpTime != 0L) {
        break;
      }
      this.F |= 0x10;
      return;
      this.F |= 0x1000;
      continue;
      this.F |= 0x2000;
    }
    this.F |= 0x20;
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
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.F &= 0xFFFFFF0F;
    if (this.a.showUpTime == 0L)
    {
      this.F |= 0x10;
      return;
    }
    this.F |= 0x20;
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.a = paramRecentUser;
  }
  
  public final boolean a()
  {
    return (this.z == 1) || (this.z == 4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
 * JD-Core Version:    0.7.0.1
 */