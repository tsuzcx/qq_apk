package com.tribe.async.async;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;

public class Bosses
{
  private static Context sApp;
  private static volatile Boss sBoss;
  private static Looper sLooper;
  
  @NonNull
  public static Boss get()
  {
    if (sBoss != null) {
      return sBoss;
    }
    try
    {
      if (sBoss != null)
      {
        Boss localBoss1 = sBoss;
        return localBoss1;
      }
    }
    finally {}
    sBoss = new BossImp(sApp, sLooper);
    Boss localBoss2 = sBoss;
    return localBoss2;
  }
  
  public static void init(Context paramContext)
  {
    init(paramContext, Looper.myLooper());
  }
  
  public static void init(Context paramContext, Looper paramLooper)
  {
    sApp = paramContext.getApplicationContext();
    sLooper = paramLooper;
  }
  
  public static void initWithBoss(Context paramContext, Boss paramBoss)
  {
    sApp = paramContext.getApplicationContext();
    try
    {
      sBoss = paramBoss;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.async.Bosses
 * JD-Core Version:    0.7.0.1
 */