package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.Map;

public final class ChannelUtil
{
  public static final int FLAG_NULL = 0;
  public static final int FLAG_UPDATE_EXTERNAL = 1;
  public static final int FLAG_UPDATE_NOTIP = 2;
  public static int buildRev;
  public static int channelId = 0;
  public static boolean fullVersionInfo = false;
  public static String marketURL;
  public static String profileDeviceType = Build.VERSION.SDK_INT;
  public static boolean shouldShowGprsAlert = false;
  public static int updateMode = 0;
  
  static
  {
    buildRev = 0;
    marketURL = "market://details?id=" + MMApplicationContext.getPackageName();
  }
  
  public static String formatVersion(Context paramContext, int paramInt)
  {
    int i = paramInt >> 8 & 0xFF;
    if (i == 0) {}
    for (str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF);; str1 = (paramInt >> 24 & 0xF) + "." + (paramInt >> 16 & 0xFF) + "." + i)
    {
      Log.d("MicroMsg.SDK.ChannelUtil", "minminor " + i);
      i = 0xFFFFFFF & paramInt;
      str2 = str1;
      paramInt = i;
      if (paramContext != null) {
        paramInt = i;
      }
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 128);
        str2 = str1;
        paramInt = i;
        if (paramContext != null)
        {
          paramInt = i;
          i = paramContext.versionCode;
          paramInt = i;
          str2 = paramContext.versionName;
          paramInt = i;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          str2 = str1;
        }
      }
      paramContext = str2;
      if (fullVersionInfo)
      {
        paramContext = str2 + " r" + paramInt + "(build." + buildRev + ")";
        Log.d("MicroMsg.SDK.ChannelUtil", "full version: " + paramContext);
      }
      return paramContext;
    }
  }
  
  public static void loadProfile(Context paramContext)
  {
    try
    {
      paramContext = KVConfig.parseIni(Util.convertStreamToString(paramContext.getAssets().open("profile.ini")));
      String str = Util.nullAsNil((String)paramContext.get("PROFILE_DEVICE_TYPE"));
      profileDeviceType = str;
      if (str.length() <= 0) {
        profileDeviceType = Build.VERSION.SDK_INT;
      }
      updateMode = Integer.parseInt((String)paramContext.get("UPDATE_MODE"));
      buildRev = Integer.parseInt((String)paramContext.get("BUILD_REVISION"));
      shouldShowGprsAlert = Boolean.parseBoolean((String)paramContext.get("GPRS_ALERT"));
      android.util.Log.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + profileDeviceType);
      android.util.Log.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + updateMode);
      android.util.Log.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + shouldShowGprsAlert);
      paramContext = (String)paramContext.get("MARKET_URL");
      if ((paramContext != null) && (paramContext.trim().length() != 0) && (Uri.parse(paramContext) != null)) {
        marketURL = paramContext;
      }
      android.util.Log.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + marketURL);
      return;
    }
    catch (Exception paramContext)
    {
      android.util.Log.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
      paramContext.printStackTrace();
    }
  }
  
  public static void setupChannelId(Context paramContext)
  {
    try
    {
      channelId = Integer.parseInt((String)KVConfig.parseIni(Util.convertStreamToString(paramContext.getAssets().open("channel.ini"))).get("CHANNEL"));
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ChannelUtil
 * JD-Core Version:    0.7.0.1
 */