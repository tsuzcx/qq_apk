package com.tencent.mobileqq.ar;

import adfn;
import adfw;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anpt;
import com.tencent.qphone.base.util.QLog;

public class NeonControl$1
  implements Runnable
{
  public NeonControl$1(adfn paramadfn, SharedPreferences paramSharedPreferences, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool1 = true;
    ??? = new anpt();
    ((anpt)???).Ap();
    boolean bool2 = ((anpt)???).ayI();
    this.m.edit().putBoolean("sp_cpu_neon_support", bool2).apply();
    boolean bool3 = adfw.a().bMK;
    int i;
    int j;
    if (QLog.isColorLevel())
    {
      if (!bool3) {
        break label216;
      }
      i = 1;
      if (!bool2) {
        break label221;
      }
      j = 1;
      label76:
      if (!this.bMA) {
        break label226;
      }
    }
    label216:
    label221:
    label226:
    for (int k = 1;; k = 0)
    {
      QLog.i("NeonControl", 2, String.format("dpcNeonCfgSwitch:%d isCpuNeonSupport:%d forceOpenNeon:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      if (this.bMA) {
        synchronized (this.this$0.mLock)
        {
          adfn.a(this.this$0, bool2);
          return;
        }
      }
      for (;;)
      {
        synchronized (this.this$0.mLock)
        {
          adfn localadfn = this.this$0;
          if ((bool3) && (bool2))
          {
            adfn.a(localadfn, bool1);
            return;
          }
        }
        bool1 = false;
      }
      i = 0;
      break;
      j = 0;
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.NeonControl.1
 * JD-Core Version:    0.7.0.1
 */