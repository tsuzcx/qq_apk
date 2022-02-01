package com.tencent.util;

import android.content.Context;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;

public final class BadgeUtils$1
  implements Runnable
{
  public BadgeUtils$1(int paramInt1, Context paramContext, int paramInt2) {}
  
  public void run()
  {
    BadgeUtilImpl.setLimitCount(this.val$limit);
    try
    {
      BadgeUtilImpl.setBadge(this.val$context, this.val$count);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BadgeUtilImpl", 2, "badge not support");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.util.BadgeUtils.1
 * JD-Core Version:    0.7.0.1
 */