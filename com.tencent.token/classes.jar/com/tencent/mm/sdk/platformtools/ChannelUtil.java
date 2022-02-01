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
  public static int channelId;
  public static boolean fullVersionInfo = false;
  public static String marketURL;
  public static String profileDeviceType;
  public static boolean shouldShowGprsAlert = false;
  public static int updateMode;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.VERSION.SDK_INT);
    profileDeviceType = localStringBuilder.toString();
    updateMode = 0;
    buildRev = 0;
    localStringBuilder = new StringBuilder("market://details?id=");
    localStringBuilder.append(MMApplicationContext.getPackageName());
    marketURL = localStringBuilder.toString();
  }
  
  public static String formatVersion(Context paramContext, int paramInt)
  {
    int i = paramInt >> 8 & 0xFF;
    if (i == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt >> 24 & 0xF);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(paramInt >> 16 & 0xFF);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt >> 24 & 0xF);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(paramInt >> 16 & 0xFF);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(i);
    }
    String str = ((StringBuilder)localObject).toString();
    Object localObject = new StringBuilder("minminor ");
    ((StringBuilder)localObject).append(i);
    Log.d("MicroMsg.SDK.ChannelUtil", ((StringBuilder)localObject).toString());
    i = paramInt & 0xFFFFFFF;
    localObject = str;
    paramInt = i;
    if (paramContext != null)
    {
      paramInt = i;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 128);
        localObject = str;
        paramInt = i;
        if (paramContext != null)
        {
          paramInt = i;
          i = paramContext.versionCode;
          paramInt = i;
          localObject = paramContext.versionName;
          paramInt = i;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        localObject = str;
      }
    }
    if (fullVersionInfo)
    {
      paramContext = new StringBuilder();
      paramContext.append((String)localObject);
      paramContext.append(" r");
      paramContext.append(paramInt);
      paramContext.append("(build.");
      paramContext.append(buildRev);
      paramContext.append(")");
      paramContext = paramContext.toString();
      localObject = new StringBuilder("full version: ");
      ((StringBuilder)localObject).append(paramContext);
      Log.d("MicroMsg.SDK.ChannelUtil", ((StringBuilder)localObject).toString());
      return paramContext;
    }
    return localObject;
  }
  
  public static void loadProfile(Context paramContext)
  {
    try
    {
      paramContext = KVConfig.parseIni(Util.convertStreamToString(paramContext.getAssets().open("profile.ini")));
      Object localObject = Util.nullAsNil((String)paramContext.get("PROFILE_DEVICE_TYPE"));
      profileDeviceType = (String)localObject;
      if (((String)localObject).length() <= 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
        profileDeviceType = ((StringBuilder)localObject).toString();
      }
      updateMode = Integer.parseInt((String)paramContext.get("UPDATE_MODE"));
      buildRev = Integer.parseInt((String)paramContext.get("BUILD_REVISION"));
      shouldShowGprsAlert = Boolean.parseBoolean((String)paramContext.get("GPRS_ALERT"));
      localObject = new StringBuilder("profileDeviceType=");
      ((StringBuilder)localObject).append(profileDeviceType);
      android.util.Log.w("MicroMsg.SDK.ChannelUtil", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder("updateMode=");
      ((StringBuilder)localObject).append(updateMode);
      android.util.Log.w("MicroMsg.SDK.ChannelUtil", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder("shouldShowGprsAlert=");
      ((StringBuilder)localObject).append(shouldShowGprsAlert);
      android.util.Log.w("MicroMsg.SDK.ChannelUtil", ((StringBuilder)localObject).toString());
      paramContext = (String)paramContext.get("MARKET_URL");
      if ((paramContext != null) && (paramContext.trim().length() != 0) && (Uri.parse(paramContext) != null)) {
        marketURL = paramContext;
      }
      paramContext = new StringBuilder("marketURL=");
      paramContext.append(marketURL);
      android.util.Log.w("MicroMsg.SDK.ChannelUtil", paramContext.toString());
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