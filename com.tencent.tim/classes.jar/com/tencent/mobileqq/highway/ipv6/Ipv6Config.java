package com.tencent.mobileqq.highway.ipv6;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;

public class Ipv6Config
{
  public static final String SP_KEY_IPV6_STRATEGY_BDH = "ipv6_strategy_bdh";
  public static final String SP_KEY_IPV6_STRATEGY_CAD = "ipv6_strategy_cad";
  public static final String SP_KEY_IPV6_STRATEGY_RMD = "ipv6_strategy_rm_down";
  public static final int STRATEGY_FIRST_AS_MSF = 3;
  public static final int STRATEGY_V4_FIRST = 1;
  public static final int STRATEGY_V6_FIRST = 2;
  private static Ipv6Config sInstance = new Ipv6Config();
  public int mBdhStrategy;
  public int mConnAttemptDelay;
  public int mCurnetIptype;
  public int mRMDownStrategy;
  
  private Ipv6Config()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    this.mRMDownStrategy = localSharedPreferences.getInt("ipv6_strategy_rm_down", 0);
    this.mBdhStrategy = localSharedPreferences.getInt("ipv6_strategy_bdh", 0);
    this.mConnAttemptDelay = localSharedPreferences.getInt("ipv6_strategy_cad", 0);
    BdhLogUtil.LogEvent("E", "Ipv6Config.getCfgFromSP: sRMDownStrategy = " + this.mRMDownStrategy + ", sBdhStrategy = " + this.mBdhStrategy + ", sConnAttemptDelay = " + this.mConnAttemptDelay);
  }
  
  public static Ipv6Config getInstance()
  {
    return sInstance;
  }
  
  public int getNetType()
  {
    this.mCurnetIptype = NetConnInfoCenter.getActiveNetIpFamily(true);
    return this.mCurnetIptype;
  }
  
  public boolean isIpv6BDHFirst(HwEngine paramHwEngine)
  {
    boolean bool = true;
    if ((paramHwEngine != null) && (!paramHwEngine.ipv6Switch)) {
      BdhLogUtil.LogEvent("E", "Ipv6Config.isIpv6BDHFirst, hwEngine.ipv6Switch is false");
    }
    do
    {
      return false;
      BdhLogUtil.LogEvent("E", "Ipv6Config.isIpv6BDHFirst, mBdhStrategy = " + this.mBdhStrategy);
      if (this.mBdhStrategy == 2) {
        return true;
      }
    } while (this.mRMDownStrategy != 3);
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean isIpv6SwitchOpen(HwEngine paramHwEngine)
  {
    return (paramHwEngine != null) && (paramHwEngine.ipv6Switch);
  }
  
  public void updateCfgFromSrv(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    BdhLogUtil.LogEvent("E", "Ipv6Config.updateCfgFromSrv: rmDownStrategy = " + paramInt1 + ", bdhStrategy = " + paramInt2 + ", connAttemptDelay = " + paramInt3);
    this.mRMDownStrategy = paramInt1;
    this.mBdhStrategy = paramInt2;
    this.mConnAttemptDelay = paramInt3;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ipv6_strategy_rm_down", paramInt1);
    paramContext.putInt("ipv6_strategy_bdh", paramInt2);
    paramContext.putInt("ipv6_strategy_cad", paramInt3);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.ipv6.Ipv6Config
 * JD-Core Version:    0.7.0.1
 */