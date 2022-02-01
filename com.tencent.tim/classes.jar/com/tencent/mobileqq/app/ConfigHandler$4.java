package com.tencent.mobileqq.app;

import accy;
import ahav;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigHandler$4
  implements Runnable
{
  public ConfigHandler$4(accy paramaccy, String paramString, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    ahav.h(this.this$0.app, MsfSdkUtils.insertMtype("ConfigCheck", this.val$url), this.c.uiNewVer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.4
 * JD-Core Version:    0.7.0.1
 */