package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.halley.common.b;
import com.tencent.halley.common.f;

public final class be
{
  private static be d;
  public bg a;
  public bh b = new bh();
  public bf c;
  
  private be()
  {
    this.b.a();
    this.a = new bg();
    this.a.a();
    this.c = new bf();
    bf localbf = this.c;
    SharedPreferences localSharedPreferences = f.a().getSharedPreferences("Access_Preferences", 0);
    localbf.a = localSharedPreferences.getString("detectTaskCode", "200001010101011234");
    localbf.b = localSharedPreferences.getString("ipInfo", "DEFAULT");
  }
  
  public static be a()
  {
    try
    {
      if (d == null) {
        d = new be();
      }
      be localbe = d;
      return localbe;
    }
    finally {}
  }
  
  public final void a(bh parambh)
  {
    if (parambh == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("updateSdkCfInfo...SdkCfgInfo:");
    localStringBuilder.append(parambh);
    b.b("AccessSchedulerConfiguration", localStringBuilder.toString());
    if ((parambh.a < 2000) || (parambh.a > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...connectTimeout:");
      localStringBuilder.append(parambh.a);
      localStringBuilder.append(" is checked to 20s");
      b.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      parambh.a = 20000;
    }
    if ((parambh.b < 2000) || (parambh.b > 60000))
    {
      localStringBuilder = new StringBuilder("updateSdkCfInfo...readTimeout:");
      localStringBuilder.append(parambh.b);
      localStringBuilder.append(" is checked to 20s");
      b.c("AccessSchedulerConfiguration", localStringBuilder.toString());
      parambh.b = 20000;
    }
    this.b = parambh;
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.be
 * JD-Core Version:    0.7.0.1
 */