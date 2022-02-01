package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;

final class w
  implements Runnable
{
  w(String paramString, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.trim().length() == 0))
    {
      StatServiceImpl.f().w("qq num is null or empty.");
      return;
    }
    StatServiceImpl.a(this.b, new StatAccount(this.a), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.w
 * JD-Core Version:    0.7.0.1
 */