package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.halley.common.b;
import com.tencent.halley.common.f;

public final class bd
{
  private static bd d;
  public bf a;
  public bg b = new bg();
  public be c;
  
  private bd()
  {
    this.b.a();
    this.a = new bf();
    this.a.a();
    this.c = new be();
    be localbe = this.c;
    SharedPreferences localSharedPreferences = f.a().getSharedPreferences("Access_Preferences", 0);
    localbe.a = localSharedPreferences.getString("detectTaskCode", "200001010101011234");
    localbe.b = localSharedPreferences.getString("ipInfo", "DEFAULT");
  }
  
  public static bd a()
  {
    try
    {
      if (d == null) {
        d = new bd();
      }
      bd localbd = d;
      return localbd;
    }
    finally {}
  }
  
  public final void a(bg parambg)
  {
    if (parambg == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("updateSdkCfInfo...SdkCfgInfo:");
    localStringBuilder.append(parambg);
    b.b("AccessSchedulerConfiguration", localStringBuilder.toString());
    if ((parambg.a < 2000) || (parambg.a > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...connectTimeout:");
      localStringBuilder.append(parambg.a);
      localStringBuilder.append(" is checked to 20s");
      b.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      parambg.a = 20000;
    }
    if ((parambg.b < 2000) || (parambg.b > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...readTimeout:");
      localStringBuilder.append(parambg.b);
      localStringBuilder.append(" is checked to 20s");
      b.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      parambg.b = 20000;
    }
    this.b = parambg;
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bd
 * JD-Core Version:    0.7.0.1
 */