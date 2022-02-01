package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;

public final class WXAppLaunchData
{
  public static final String ACTION_HANDLE_WXAPPLAUNCH = ".ACTION_HANDLE_WXAPPLAUNCH";
  public static final String ACTION_HANDLE_WXAPP_RESULT = ".ACTION_HANDLE_WXAPP_RESULT";
  public static final String ACTION_HANDLE_WXAPP_SHOW = ".ACTION_HANDLE_WXAPP_SHOW";
  public int launchType;
  public String message;
  
  public static class Builder
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.WXAppLaunchData
 * JD-Core Version:    0.7.0.1
 */