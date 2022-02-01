package com.wifisdk.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.wifisdk.TMSDKCustomConfig;
import com.tencent.wifisdk.TMSDKCustomConfig.IToast;
import com.tencent.wifisdk.TMSDKWifiManager;
import com.wifisdk.ui.api.BaseFragImplManager;
import com.wifisdk.ui.api.RProxy.Impl;
import java.util.ArrayList;
import wf7.hk;
import wf7.hl;

public class WifiSDKUIApi
{
  public static final int COME_FROM_CONN_TIPS = 3;
  public static final int COME_FROM_DEFAULT = 0;
  public static final int COME_FROM_FILES_TRANSFER = 1;
  public static final int COME_FROM_FLOOR_PAGE = 6;
  public static final int COME_FROM_IM_VIDEO = 2;
  public static final int COME_FROM_NORMAL_RESULT_SOLUTION = 5;
  public static final int COME_FROM_SERIOUS_RESULT_SOLUTION = 4;
  public static final String KEY_COME_FROM = "uiapi_k101";
  public static final String KEY_RISK_LIST = "uiapi_k100";
  private static final String TAG = WifiSDKUIApi.class.getSimpleName();
  private static boolean tl = false;
  private static BaseFragImplManager tm;
  
  public static BaseFragImplManager getFragImplManager()
  {
    return tm;
  }
  
  public static void gotoWifiAppConnectPage(Context paramContext)
  {
    try
    {
      hl.a(paramContext, "11993089", 1);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void gotoWifiAppSecurityPage(Context paramContext)
  {
    try
    {
      hl.a(paramContext, "11993112", 0);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void gotoWifiFloorPage(Context paramContext)
  {
    getFragImplManager().switchFragImpl(paramContext, 0, 3, null);
  }
  
  public static void gotoWifiListPage(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uiapi_k101", paramInt);
    getFragImplManager().switchFragImpl(paramContext, 0, 1, localIntent);
  }
  
  public static void gotoWifiSecurityPage(Context paramContext, ArrayList<Integer> paramArrayList)
  {
    Intent localIntent = new Intent();
    localIntent.putIntegerArrayListExtra("uiapi_k100", paramArrayList);
    tm.switchFragImpl(paramContext, 0, 2, localIntent);
  }
  
  public static boolean init(RProxy.Impl paramImpl, BaseFragImplManager paramBaseFragImplManager)
  {
    if (tl) {
      return true;
    }
    paramImpl.init();
    tm = paramBaseFragImplManager;
    tl = true;
    return true;
  }
  
  public static boolean isWiFiManagerExist()
  {
    return hl.fo();
  }
  
  public static void reportActionStat(int paramInt)
  {
    hk.az(paramInt);
  }
  
  public static void showToast(Context paramContext, String paramString, int paramInt)
  {
    TMSDKCustomConfig.IToast localIToast = TMSDKWifiManager.getCustomConfig().getCustomToast();
    if (localIToast != null)
    {
      localIToast.showToast(paramContext, paramString, paramInt);
      return;
    }
    Toast.makeText(paramContext, paramString, paramInt).show();
  }
  
  public static abstract interface FeatureID
  {
    public static final int EMID_WiFiUISDK_QQ_Tips_Request_Result_Show = 398677;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Files_Click = 398668;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Files_Show = 398667;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_IM_Video_Click = 398671;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_IM_Video_Show = 398670;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Jump_H5_When_Cloud_Controll = 500102;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Jump_H5_When_No_Permission = 500103;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Jump_To_WifiManager = 500101;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Jump_WiFiSDK_Floor_Page = 500177;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Jump_WiFiSDK_When_Cloud_Controll = 500104;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Jump_WiFiSDK_When_Has_Permission = 500105;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Tips_Click = 398679;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Tips_Click_To_H5 = 500147;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Tips_Show = 398678;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Video_Transfer_Click = 398690;
    public static final int EMID_WiFiUISDK_QQ_WiFiconnect_Video_Transfer_Show = 398689;
    public static final int EMID_WiFiUISDK_QQ_WiFisecurity_Tips_Click = 398681;
    public static final int EMID_WiFiUISDK_QQ_WiFisecurity_Tips_Show = 398680;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.wifisdk.ui.WifiSDKUIApi
 * JD-Core Version:    0.7.0.1
 */