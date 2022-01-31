package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.halley.common.c;
import com.tencent.halley.common.h;

public final class bm
{
  private static bm d;
  public bo a;
  public bp b = new bp();
  public bn c;
  
  private bm()
  {
    this.b.a();
    this.a = new bo();
    this.a.a();
    this.c = new bn();
    bn localbn = this.c;
    SharedPreferences localSharedPreferences = h.a().getSharedPreferences("Access_Preferences", 0);
    localbn.a = localSharedPreferences.getString("detectTaskCode", "200001010101011234");
    localbn.b = localSharedPreferences.getString("ipInfo", "DEFAULT");
  }
  
  public static bm a()
  {
    try
    {
      if (d == null) {
        d = new bm();
      }
      bm localbm = d;
      return localbm;
    }
    finally {}
  }
  
  public final void a(bp parambp)
  {
    if (parambp == null) {
      return;
    }
    c.b("AccessSchedulerConfiguration", "updateSdkCfInfo...SdkCfgInfo:" + parambp);
    if ((parambp.a < 2000) || (parambp.a > 60000))
    {
      c.c("AccessSchedulerConfiguration", "updateSdkCfInfo...connectTimeout:" + parambp.a + " is checked to 20s");
      parambp.a = 20000;
    }
    if ((parambp.b < 2000) || (parambp.b > 60000))
    {
      c.c("AccessSchedulerConfiguration", "updateSdkCfInfo...readTimeout:" + parambp.b + " is checked to 20s");
      parambp.b = 20000;
    }
    this.b = parambp;
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bm
 * JD-Core Version:    0.7.0.1
 */