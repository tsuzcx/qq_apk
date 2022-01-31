package com.tmsdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.global.n;
import com.tencent.token.utils.u;
import com.tencent.token.utils.w;
import com.tmsdk.base.AbsTMSBaseConfig;
import com.tmsdk.common.util.ReleaseSetting;

final class TMSDKContext$2
  extends AbsTMSBaseConfig
{
  TMSDKContext$2(Context paramContext) {}
  
  public int getBuildNo()
  {
    return u.a;
  }
  
  public String getChannel()
  {
    String str2 = w.m();
    String str1 = str2;
    if ("0000".equals(str2)) {
      str1 = "1002";
    }
    return str1;
  }
  
  public String getDeviceId1()
  {
    return w.b(this.val$aContext);
  }
  
  public String getDeviceId2()
  {
    return w.c(this.val$aContext);
  }
  
  public String getDeviceId3()
  {
    return TMSDKContext.sAbsTMSConfig.getDeviceId3();
  }
  
  public String getDeviceId4()
  {
    return n.b();
  }
  
  public String getLC()
  {
    return "QQTOKEN20190910";
  }
  
  public String getOpenIdTicket()
  {
    return n.c();
  }
  
  public int getProductId()
  {
    return 115;
  }
  
  public String getTCPServerAdd()
  {
    String str2 = TMSDKContext.sAbsTMSConfig.getServerAddress();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "mazu.3g.qq.com";
    }
    return str1;
  }
  
  public String getTccSoName()
  {
    return "Tcc-1.0.1";
  }
  
  public String getVersion()
  {
    return u.b;
  }
  
  public boolean isAllowAndroidID()
  {
    return ReleaseSetting.isAllowAndroidID();
  }
  
  public boolean isAllowImei()
  {
    if (TextUtils.isEmpty(getDeviceId1())) {
      return true;
    }
    return ReleaseSetting.isAllowImei();
  }
  
  public boolean isAllowImsi()
  {
    return ReleaseSetting.isAllowImsi();
  }
  
  public boolean isAllowMac()
  {
    return ReleaseSetting.isAllowMac();
  }
  
  public boolean isAllowOther()
  {
    return ReleaseSetting.isAllowOther();
  }
  
  public boolean isCheckLicence()
  {
    return ReleaseSetting.isCheckLicence();
  }
  
  public boolean isJavaTCC()
  {
    return ReleaseSetting.isJavaTCC();
  }
  
  public boolean isUseIPList()
  {
    return TMSDKContext.sAbsTMSConfig.isUseIPList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.TMSDKContext.2
 * JD-Core Version:    0.7.0.1
 */