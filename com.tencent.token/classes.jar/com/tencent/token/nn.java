package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;

public final class nn
{
  private static nn d;
  public np a;
  public nq b = new nq();
  public no c;
  
  private nn()
  {
    this.b.a();
    this.a = new np();
    this.a.a();
    this.c = new no();
    no localno = this.c;
    SharedPreferences localSharedPreferences = lo.a().getSharedPreferences("Access_Preferences", 0);
    localno.a = localSharedPreferences.getString("detectTaskCode", "200001010101011234");
    localno.b = localSharedPreferences.getString("ipInfo", "DEFAULT");
  }
  
  public static nn a()
  {
    try
    {
      if (d == null) {
        d = new nn();
      }
      nn localnn = d;
      return localnn;
    }
    finally {}
  }
  
  public final void a(nq paramnq)
  {
    if (paramnq == null) {
      return;
    }
    lh.b("AccessSchedulerConfiguration", "updateSdkCfInfo...SdkCfgInfo:".concat(String.valueOf(paramnq)));
    StringBuilder localStringBuilder;
    if ((paramnq.a < 2000) || (paramnq.a > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...connectTimeout:");
      localStringBuilder.append(paramnq.a);
      localStringBuilder.append(" is checked to 20s");
      lh.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      paramnq.a = 20000;
    }
    if ((paramnq.b < 2000) || (paramnq.b > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...readTimeout:");
      localStringBuilder.append(paramnq.b);
      localStringBuilder.append(" is checked to 20s");
      lh.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      paramnq.b = 20000;
    }
    this.b = paramnq;
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nn
 * JD-Core Version:    0.7.0.1
 */