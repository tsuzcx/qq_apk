package tmsdk.common;

import android.content.Context;
import dualsim.common.ILogPrint;
import dualsim.common.IPhoneInfoBridge;
import dualsim.common.KcConfig;

public abstract interface ITmsContextInterface
{
  public static final String DUAL_SIM_INTERNAL_MANAGER_CLASS = "dualsim.common.DualSimSDKManager";
  public static final String KING_CARD_INTERNAL_MANAGER_CLASS = "dualsim.common.KingCardManager";
  public static final String TMS_CONTEXT_CLASS = "tmsdk.common.KcSdkManager";
  
  public abstract boolean initInBaseProcess(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean initInOtherProcess(Context paramContext, String paramString1, String paramString2);
  
  public abstract void setKcConfig(KcConfig paramKcConfig);
  
  public abstract void setLogPrint(ILogPrint paramILogPrint);
  
  public abstract void setPhoneInfoBridge(IPhoneInfoBridge paramIPhoneInfoBridge);
  
  public abstract void setTMSDKLogEnable(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmsdk.common.ITmsContextInterface
 * JD-Core Version:    0.7.0.1
 */