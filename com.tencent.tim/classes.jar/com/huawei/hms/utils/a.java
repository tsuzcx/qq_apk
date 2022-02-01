package com.huawei.hms.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;

public class a
{
  private String a = "UNKNOWN";
  private String b = "UNKNOWN";
  private boolean c = false;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, paramBoolean);
    this.b = this.b.toUpperCase(Locale.ENGLISH);
  }
  
  private void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      throw new NullPointerException("context must be not null.Please provide app's Context");
    }
    try
    {
      d();
      if (b())
      {
        HMSLog.i("CountryCodeBean", "getCountryCode get country code from VENDOR_COUNTRY");
        return;
      }
      b(paramContext, paramBoolean);
      if (b())
      {
        HMSLog.i("CountryCodeBean", "getCountryCode get country code from SIM_COUNTRY");
        return;
      }
    }
    catch (Exception paramContext)
    {
      HMSLog.w("CountryCodeBean", "get CountryCode error");
      return;
    }
    e();
    if (b()) {
      HMSLog.i("CountryCodeBean", "getCountryCode get country code from LOCALE_INFO");
    }
  }
  
  private void b(Context paramContext, boolean paramBoolean)
  {
    paramContext = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    if (paramContext != null)
    {
      if ((!paramBoolean) || (paramContext.getPhoneType() == 2)) {
        break label55;
      }
      HMSLog.i("CountryCodeBean", "getCountryCode get country code from NETWORK_COUNTRY");
      this.b = paramContext.getNetworkCountryIso();
    }
    for (this.a = "NETWORK_COUNTRY";; this.a = "SIM_COUNTRY")
    {
      c();
      return;
      label55:
      HMSLog.i("CountryCodeBean", "getCountryCode get country code from SIM_COUNTRY");
      this.b = paramContext.getSimCountryIso();
    }
  }
  
  private boolean b()
  {
    return !"UNKNOWN".equals(this.b);
  }
  
  private void c()
  {
    if ((this.b == null) || (this.b.length() != 2))
    {
      this.b = "UNKNOWN";
      this.a = "UNKNOWN";
    }
  }
  
  private void d()
  {
    this.a = "VENDOR_COUNTRY";
    this.b = SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", "UNKNOWN");
    if ("normal".equalsIgnoreCase(this.b)) {
      this.c = true;
    }
    if (("eu".equalsIgnoreCase(this.b)) || ("la".equalsIgnoreCase(this.b)))
    {
      this.b = "UNKNOWN";
      this.a = "UNKNOWN";
      return;
    }
    c();
  }
  
  private void e()
  {
    this.b = SystemPropUtils.getProperty("get", "ro.product.locale.region", "android.os.SystemProperties", "UNKNOWN");
    this.a = "LOCALE_INFO";
    if ((!"cn".equalsIgnoreCase(this.b)) && (!this.c))
    {
      HMSLog.w("CountryCodeBean", "countryCode from system language is not reliable.");
      this.b = "UNKNOWN";
      this.a = "UNKNOWN";
    }
  }
  
  public String a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.utils.a
 * JD-Core Version:    0.7.0.1
 */