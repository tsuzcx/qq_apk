package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;

public final class nu
{
  private static nu d;
  public nw a;
  public nx b = new nx();
  public nv c;
  
  private nu()
  {
    this.b.a();
    this.a = new nw();
    this.a.a();
    this.c = new nv();
    nv localnv = this.c;
    SharedPreferences localSharedPreferences = lv.a().getSharedPreferences("Access_Preferences", 0);
    localnv.a = localSharedPreferences.getString("detectTaskCode", "200001010101011234");
    localnv.b = localSharedPreferences.getString("ipInfo", "DEFAULT");
  }
  
  public static nu a()
  {
    try
    {
      if (d == null) {
        d = new nu();
      }
      nu localnu = d;
      return localnu;
    }
    finally {}
  }
  
  public final void a(nx paramnx)
  {
    if (paramnx == null) {
      return;
    }
    lo.b("AccessSchedulerConfiguration", "updateSdkCfInfo...SdkCfgInfo:".concat(String.valueOf(paramnx)));
    StringBuilder localStringBuilder;
    if ((paramnx.a < 2000) || (paramnx.a > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...connectTimeout:");
      localStringBuilder.append(paramnx.a);
      localStringBuilder.append(" is checked to 20s");
      lo.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      paramnx.a = 20000;
    }
    if ((paramnx.b < 2000) || (paramnx.b > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...readTimeout:");
      localStringBuilder.append(paramnx.b);
      localStringBuilder.append(" is checked to 20s");
      lo.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      paramnx.b = 20000;
    }
    this.b = paramnx;
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nu
 * JD-Core Version:    0.7.0.1
 */