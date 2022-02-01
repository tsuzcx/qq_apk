package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;

public final class no
{
  private static no d;
  public nq a;
  public nr b = new nr();
  public np c;
  
  private no()
  {
    this.b.a();
    this.a = new nq();
    this.a.a();
    this.c = new np();
    np localnp = this.c;
    SharedPreferences localSharedPreferences = lp.a().getSharedPreferences("Access_Preferences", 0);
    localnp.a = localSharedPreferences.getString("detectTaskCode", "200001010101011234");
    localnp.b = localSharedPreferences.getString("ipInfo", "DEFAULT");
  }
  
  public static no a()
  {
    try
    {
      if (d == null) {
        d = new no();
      }
      no localno = d;
      return localno;
    }
    finally {}
  }
  
  public final void a(nr paramnr)
  {
    if (paramnr == null) {
      return;
    }
    li.b("AccessSchedulerConfiguration", "updateSdkCfInfo...SdkCfgInfo:".concat(String.valueOf(paramnr)));
    StringBuilder localStringBuilder;
    if ((paramnr.a < 2000) || (paramnr.a > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...connectTimeout:");
      localStringBuilder.append(paramnr.a);
      localStringBuilder.append(" is checked to 20s");
      li.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      paramnr.a = 20000;
    }
    if ((paramnr.b < 2000) || (paramnr.b > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...readTimeout:");
      localStringBuilder.append(paramnr.b);
      localStringBuilder.append(" is checked to 20s");
      li.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      paramnr.b = 20000;
    }
    this.b = paramnr;
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.no
 * JD-Core Version:    0.7.0.1
 */