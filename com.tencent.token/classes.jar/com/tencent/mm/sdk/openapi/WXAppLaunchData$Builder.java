package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

public class WXAppLaunchData$Builder
{
  public static WXAppLaunchData fromBundle(Bundle paramBundle)
  {
    WXAppLaunchData localWXAppLaunchData = new WXAppLaunchData();
    localWXAppLaunchData.launchType = paramBundle.getInt("_wxapplaunchdata_launchType");
    localWXAppLaunchData.message = paramBundle.getString("_wxapplaunchdata_message");
    return localWXAppLaunchData;
  }
  
  public static Bundle toBundle(WXAppLaunchData paramWXAppLaunchData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_wxapplaunchdata_launchType", paramWXAppLaunchData.launchType);
    localBundle.putString("_wxapplaunchdata_message", paramWXAppLaunchData.message);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXAppLaunchData.Builder
 * JD-Core Version:    0.7.0.1
 */