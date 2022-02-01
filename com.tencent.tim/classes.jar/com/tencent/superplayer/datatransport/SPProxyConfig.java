package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.config.TPPlayerConfig;

public class SPProxyConfig
{
  private static final String TAG = "SPProxyConfig";
  
  public static void init(SuperPlayerSdkOption paramSuperPlayerSdkOption)
  {
    if (paramSuperPlayerSdkOption == null) {
      return;
    }
    LogUtil.d("SPProxyConfig", "init: " + paramSuperPlayerSdkOption);
    TPPlayerConfig.setProxyConfigStr(paramSuperPlayerSdkOption.getDownloadProxyConfig());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPProxyConfig
 * JD-Core Version:    0.7.0.1
 */