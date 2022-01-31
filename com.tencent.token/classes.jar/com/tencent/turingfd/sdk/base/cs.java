package com.tencent.turingfd.sdk.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.File;
import java.util.List;

public class cs
  extends am
{
  public int a = 1;
  public int b = 1;
  public long c = 0L;
  
  public cs(cr paramcr, String paramString)
  {
    super(paramString);
  }
  
  public void a()
  {
    cx localcx = new cx();
    ??? = cr.a(this.d).c;
    if (Build.VERSION.SDK_INT >= 24) {}
    label278:
    for (;;)
    {
      ??? = ((Context)???).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (??? == null) {}
      label51:
      synchronized (cr.b(this.d))
      {
        cr.b(this.d).add(localcx);
        int i = this.a;
        if (i >= this.b) {
          try
          {
            if (!cr.c(this.d))
            {
              return;
              Object localObject4 = ed.a(new File(db.a(db.aj)));
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                continue;
              }
              if ("CONFIGURED".equals(localObject4))
              {
                for (;;)
                {
                  try
                  {
                    localObject4 = ((Context)???).getContentResolver();
                    i = Settings.Secure.getInt((ContentResolver)localObject4, "adb_enabled", 0);
                    if (i <= 0) {
                      continue;
                    }
                    i = 1;
                  }
                  catch (Throwable localThrowable)
                  {
                    i = 0;
                    continue;
                    localcx.a = 3;
                  }
                  if (i == 0) {
                    continue;
                  }
                  localcx.a = 1;
                  break;
                  i = 0;
                }
                continue;
              }
              if ("DISCONNECTED".equals(localThrowable))
              {
                localcx.a = 2;
                continue;
              }
              if (!"CONNECTED".equals(localThrowable)) {
                continue;
              }
              localcx.a = 3;
              continue;
              i = ((Intent)???).getIntExtra("status", -1);
              if ((i == 2) || (i == 5)) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  break label278;
                }
                localcx.b = 1;
                break;
              }
              i = ((Intent)???).getIntExtra("plugged", -1);
              if (i == 2)
              {
                localcx.b = 3;
                break label51;
              }
              if (i == 1)
              {
                localcx.b = 2;
                break label51;
              }
              localcx.b = 0;
              break label51;
            }
            cr.a(this.d, cr.d(this.d), cr.e(this.d));
            return;
          }
          finally {}
        }
        this.a = (i + 1);
        long l = this.c + dy.a * this.a - System.currentTimeMillis();
        if (l > 0L)
        {
          cr.d(this.d).postDelayed(cr.f(this.d), l);
          return;
        }
        cr.d(this.d).post(cr.f(this.d));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cs
 * JD-Core Version:    0.7.0.1
 */