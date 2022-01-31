package com.tencent.turingfd.sdk.base;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class bw
{
  public static final long a = ;
  public static String b = "";
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("T:");
    localStringBuilder.append(a);
    localStringBuilder.append(",");
    localStringBuilder.append("LT:");
    localStringBuilder.append("" + (System.currentTimeMillis() - a));
    localStringBuilder.append(",");
    localStringBuilder.append("F:");
    Object localObject1;
    if (paramBoolean) {
      localObject1 = "1";
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      Object localObject2 = bp.a(paramContext, "204");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "0";
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("R:");
        localStringBuilder.append((String)localObject1);
      }
      int i = paramContext.getSharedPreferences("turingfd_protect_105678_32_baseFull", 0).getInt("301", 0);
      if (i > 0)
      {
        localStringBuilder.append(",");
        localStringBuilder.append("RB:");
        localStringBuilder.append(i);
      }
      if (!TextUtils.isEmpty(bp.a(paramContext, "105")))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("TAT:");
        localStringBuilder.append("1");
      }
      if (TextUtils.isEmpty(b))
      {
        localObject2 = "";
        i = Process.myPid();
        localObject1 = localObject2;
        try
        {
          Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
          paramContext = (Context)localObject2;
          label276:
          localObject1 = paramContext;
          localObject2 = paramContext;
          if (localIterator.hasNext())
          {
            localObject1 = paramContext;
            localObject2 = (ActivityManager.RunningAppProcessInfo)localIterator.next();
            localObject1 = paramContext;
            if (((ActivityManager.RunningAppProcessInfo)localObject2).pid == i)
            {
              localObject1 = paramContext;
              paramContext = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
            }
            for (;;)
            {
              break label276;
              localObject1 = "0";
              break;
            }
          }
          paramContext = bu.a().a("3");
        }
        catch (Throwable paramContext)
        {
          localObject2 = localObject1;
          b = (String)localObject2;
          localStringBuilder.append(",");
          localStringBuilder.append("P:");
          localStringBuilder.append(b);
        }
      }
    }
    if (TextUtils.isEmpty(paramContext)) {
      paramContext = "";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramContext))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("RD:");
        localStringBuilder.append(paramContext);
      }
      return localStringBuilder.toString();
      localObject1 = ed.b(paramContext);
      if (localObject1.length == 0) {
        break;
      }
      localObject1 = ed.b((byte[])localObject1, ".turingdebug".getBytes());
      try
      {
        new File(paramContext).deleteOnExit();
        label456:
        paramContext = new String((byte[])localObject1);
      }
      catch (Throwable paramContext)
      {
        break label456;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bw
 * JD-Core Version:    0.7.0.1
 */