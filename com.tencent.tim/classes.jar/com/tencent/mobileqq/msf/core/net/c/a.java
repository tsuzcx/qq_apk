package com.tencent.mobileqq.msf.core.net.c;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.mobileqq.msf.core.y;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

public final class a
{
  private static final String a = "MSF.C.DeepSleepDetector";
  private static final int b = 120000;
  private a c = new a();
  private Handler d;
  private boolean e = false;
  private final Hashtable f = new Hashtable();
  
  public a(Handler paramHandler)
  {
    this.d = paramHandler;
  }
  
  private void a(boolean paramBoolean)
  {
    if (MsfCore.sCore != null)
    {
      k localk = MsfCore.sCore.getStatReporter();
      if (localk != null) {
        localk.d(paramBoolean);
      }
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.DeepSleepDetector", 2, "onAppForeground");
    }
    y.f().removeCallbacks(this.c);
    boolean bool = a.a(this.c, true);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.DeepSleepDetector", 2, "find deep sleep.");
      }
      a(bool);
    }
    a.a(this.c);
    if (MsfService.core.quicksender != null) {
      MsfService.core.quicksender.a(bool);
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.DeepSleepDetector", 2, "onAppBackground");
    }
    a.a(this.c, SystemClock.elapsedRealtime());
    this.d.removeCallbacks(this.c);
    this.d.post(this.c);
    if (MsfService.core.quicksender != null) {
      MsfService.core.quicksender.c();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.DeepSleepDetector", 2, "onScreenOn");
    }
    boolean bool = a.a(this.c, true);
    if (bool)
    {
      this.d.removeCallbacks(this.c);
      a(bool);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.DeepSleepDetector", 2, "onScreenOn hasInDeepSleep " + bool);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    boolean bool2 = this.e;
    Hashtable localHashtable = this.f;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.f.put(paramString, Long.valueOf(paramLong));
        if (this.f.isEmpty()) {
          break label192;
        }
        bool1 = true;
        this.e = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.DeepSleepDetector", 2, "onProcessViewableChanged process: " + paramString + ", state: " + paramBoolean + ", at: " + paramLong);
        }
        if ((this.e ^ bool2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.DeepSleepDetector", 2, "lead to app state changed from: " + bool2 + ", to: " + this.e);
          }
          if (!this.e) {
            break;
          }
          c();
        }
        return;
      }
      finally {}
      this.f.remove(paramString);
      continue;
      label192:
      boolean bool1 = false;
    }
    d();
  }
  
  public boolean b()
  {
    return a.a(this.c, false);
  }
  
  class a
    implements Runnable
  {
    long a;
    int b;
    
    a() {}
    
    private void a()
    {
      this.a = 0L;
      this.b = 0;
    }
    
    private void a(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.DeepSleepDetector", 2, "onAppBackground setStartTime " + paramLong);
      }
      this.a = paramLong;
    }
    
    private boolean a(boolean paramBoolean)
    {
      boolean bool = true;
      if (this.a > 0L) {
        if (Math.abs((int)((SystemClock.elapsedRealtime() - this.a) / 120000L) + 1 - this.b) <= 1) {}
      }
      for (;;)
      {
        if ((bool) && (paramBoolean)) {
          a();
        }
        return bool;
        bool = false;
        continue;
        bool = false;
      }
    }
    
    public void run()
    {
      this.b += 1;
      a.a(a.this).postDelayed(this, 120000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.a
 * JD-Core Version:    0.7.0.1
 */