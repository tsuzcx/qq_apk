package com.tencent.util;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import fix;

public class BadgeUtils
{
  public static void a(Context paramContext, int paramInt)
  {
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
      ThreadManager.b(new fix(paramContext, paramInt));
    }
    while (!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
      return;
    }
    BadgeUtilImpl.changeMIBadge(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.util.BadgeUtils
 * JD-Core Version:    0.7.0.1
 */