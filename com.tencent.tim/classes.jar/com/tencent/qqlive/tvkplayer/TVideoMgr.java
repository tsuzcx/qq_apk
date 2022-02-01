package com.tencent.qqlive.tvkplayer;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlatformInfo;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class TVideoMgr
{
  private static Context mAppContext;
  public static Map<String, String> mFreeNetFlowRequestMap;
  public static String mOriginalUpc = "";
  private static int mPlatform;
  private static SparseArray<TVKPlatformInfo> mPlatformMap;
  private static String mQIEMI;
  private static String mStaGuid;
  
  public static Context getApplicationContext()
  {
    return mAppContext;
  }
  
  public static String getPlayerVersion()
  {
    return "1.0.0";
  }
  
  public static String getStaGuid()
  {
    if (!TextUtils.isEmpty(mStaGuid)) {
      return mStaGuid;
    }
    Object localObject = TVKVcSystemInfo.getAndroidID(mAppContext) + TVKVcSystemInfo.getDeviceMacAddr(mAppContext);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = ((String)localObject).getBytes("UTF-8");
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest((byte[])localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < arrayOfByte.length)
      {
        String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
        localObject = str;
        if (str.length() == 1) {
          localObject = '0' + str;
        }
        localStringBuilder.append(((String)localObject).toUpperCase());
        i += 1;
      }
      mStaGuid = localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    if (TextUtils.isEmpty(mStaGuid)) {
      mStaGuid = "wtfguidisemptyhehehe";
    }
    return mStaGuid;
  }
  
  public static int getVinfoPlatform()
  {
    return mPlatform;
  }
  
  public static String getVinfoSdtfrom()
  {
    return getVinfoSdtfrom(mPlatform);
  }
  
  public static String getVinfoSdtfrom(int paramInt)
  {
    if ((mPlatformMap != null) && (mPlatformMap.indexOfKey(paramInt) > 0)) {
      return ((TVKPlatformInfo)mPlatformMap.get(paramInt)).getSdtFrom();
    }
    return null;
  }
  
  public static void init(Context paramContext, int paramInt, String paramString)
  {
    mAppContext = paramContext.getApplicationContext();
    mPlatform = paramInt;
    mQIEMI = paramString;
    CKeyFacade.setInterface("", "", new TVideoMgr.1(), null);
    CKeyFacade.instance().init(mAppContext, null, getStaGuid());
  }
  
  public static boolean registerTVideoPlatformInfo(TVKPlatformInfo paramTVKPlatformInfo)
  {
    if (paramTVKPlatformInfo == null) {}
    do
    {
      return false;
      if (mPlatformMap == null) {
        mPlatformMap = new SparseArray();
      }
    } while (mPlatformMap.indexOfKey(paramTVKPlatformInfo.getPlatform()) >= 0);
    mPlatformMap.put(paramTVKPlatformInfo.getPlatform(), paramTVKPlatformInfo);
    CKeyFacade.instance().addVsAppkey(mAppContext, paramTVKPlatformInfo.getAppKey());
    return true;
  }
  
  public static void setDeviceInfo(String paramString1, String paramString2, String paramString3)
  {
    TVKVcSystemInfo.setDeviceMacAddr(paramString1);
    TVKVcSystemInfo.setAndroidID(paramString2);
    TVKVcSystemInfo.setDeviceIMEI(paramString3);
  }
  
  public static void setOnLogListener(OnTVideoLogListener paramOnTVideoLogListener)
  {
    TVKLogUtil.setOnTVideoLogListener(paramOnTVideoLogListener);
  }
  
  public static void setUpc(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      mFreeNetFlowRequestMap = null;
      mOriginalUpc = "";
    }
    do
    {
      return;
      mOriginalUpc = paramString;
      paramString = paramString.split("&");
    } while (paramString.length <= 0);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("=");
      if ((arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1]))) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      i += 1;
    }
    mFreeNetFlowRequestMap = localHashMap;
  }
  
  public static abstract interface OnTVideoLogListener
  {
    public abstract int d(String paramString1, String paramString2);
    
    public abstract int e(String paramString1, String paramString2);
    
    public abstract int i(String paramString1, String paramString2);
    
    public abstract int v(String paramString1, String paramString2);
    
    public abstract int w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.TVideoMgr
 * JD-Core Version:    0.7.0.1
 */