package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;

public final class oi
{
  private static oi d;
  public ok a;
  public ol b = new ol();
  public oj c;
  
  private oi()
  {
    this.b.a();
    this.a = new ok();
    this.a.a();
    this.c = new oj();
    oj localoj = this.c;
    SharedPreferences localSharedPreferences = mj.a().getSharedPreferences("Access_Preferences", 0);
    localoj.a = localSharedPreferences.getString("detectTaskCode", "200001010101011234");
    localoj.b = localSharedPreferences.getString("ipInfo", "DEFAULT");
  }
  
  public static oi a()
  {
    try
    {
      if (d == null) {
        d = new oi();
      }
      oi localoi = d;
      return localoi;
    }
    finally {}
  }
  
  public final void a(ol paramol)
  {
    if (paramol == null) {
      return;
    }
    mc.b("AccessSchedulerConfiguration", "updateSdkCfInfo...SdkCfgInfo:".concat(String.valueOf(paramol)));
    StringBuilder localStringBuilder;
    if ((paramol.a < 2000) || (paramol.a > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...connectTimeout:");
      localStringBuilder.append(paramol.a);
      localStringBuilder.append(" is checked to 20s");
      mc.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      paramol.a = 20000;
    }
    if ((paramol.b < 2000) || (paramol.b > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...readTimeout:");
      localStringBuilder.append(paramol.b);
      localStringBuilder.append(" is checked to 20s");
      mc.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      paramol.b = 20000;
    }
    this.b = paramol;
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.oi
 * JD-Core Version:    0.7.0.1
 */