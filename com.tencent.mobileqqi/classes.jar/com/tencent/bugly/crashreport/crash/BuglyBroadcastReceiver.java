package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

public class BuglyBroadcastReceiver
  extends BroadcastReceiver
{
  private static BuglyBroadcastReceiver d = null;
  private IntentFilter a = new IntentFilter();
  private Context b;
  private String c;
  private boolean e = true;
  
  private boolean a(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    if ((paramContext != null) && (paramIntent != null)) {}
    for (;;)
    {
      boolean bool1;
      try
      {
        bool1 = paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE");
        if (!bool1)
        {
          bool1 = false;
          return bool1;
        }
        if (this.e)
        {
          this.e = false;
          bool1 = bool2;
          continue;
        }
        str1 = com.tencent.bugly.crashreport.common.info.b.f(this.b);
      }
      finally {}
      String str1;
      x.c("is Connect BC " + str1, new Object[0]);
      x.a("network %s changed to %s", new Object[] { this.c, str1 });
      if (str1 == null)
      {
        this.c = null;
        bool1 = bool2;
      }
      else
      {
        String str2 = this.c;
        this.c = str1;
        long l = System.currentTimeMillis();
        com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
        paramIntent = u.a();
        paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
        if ((locala == null) || (paramIntent == null) || (paramContext == null))
        {
          x.d("not inited BC not work", new Object[0]);
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          if (!str1.equals(str2))
          {
            if (l - paramIntent.a(c.a) > 30000L)
            {
              x.a("try to upload crash on network changed.", new Object[0]);
              paramContext = c.a();
              if (paramContext != null) {
                paramContext.a(0L);
              }
            }
            bool1 = bool2;
            if (l - paramIntent.a(1001) > 30000L)
            {
              x.a("try to upload userinfo on network changed.", new Object[0]);
              com.tencent.bugly.crashreport.biz.b.b.b();
              bool1 = bool2;
            }
          }
        }
      }
    }
  }
  
  public static BuglyBroadcastReceiver getInstance()
  {
    try
    {
      if (d == null) {
        d = new BuglyBroadcastReceiver();
      }
      BuglyBroadcastReceiver localBuglyBroadcastReceiver = d;
      return localBuglyBroadcastReceiver;
    }
    finally {}
  }
  
  public void addFilter(String paramString)
  {
    try
    {
      if (!this.a.hasAction(paramString)) {
        this.a.addAction(paramString);
      }
      x.c("add action %s", new Object[] { paramString });
      return;
    }
    finally {}
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      a(paramContext, paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      while (x.a(paramContext)) {}
      paramContext.printStackTrace();
    }
  }
  
  public void register(Context paramContext)
  {
    try
    {
      this.b = paramContext;
      z.a(new Runnable()
      {
        public final void run()
        {
          try
          {
            x.a(BuglyBroadcastReceiver.a().getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
            synchronized (jdField_this)
            {
              BuglyBroadcastReceiver.b(BuglyBroadcastReceiver.this).registerReceiver(BuglyBroadcastReceiver.a(), BuglyBroadcastReceiver.a(BuglyBroadcastReceiver.this));
              return;
            }
            return;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      });
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void unregister(Context paramContext)
  {
    try
    {
      x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
      paramContext.unregisterReceiver(this);
      this.b = paramContext;
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        if (!x.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */