package com.tencent.mobileqq.app;

import acbn;
import accy;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigHandler$5
  implements Runnable
{
  public ConfigHandler$5(accy paramaccy, String paramString, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    File localFile = new File(acbn.bmY);
    try
    {
      if (HttpDownloadUtil.a(this.this$0.app, new URL(this.val$url), localFile))
      {
        this.this$0.notifyUI(1, true, this.c);
        return;
      }
      this.this$0.notifyUI(1, false, this.c);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      this.this$0.notifyUI(1, false, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.5
 * JD-Core Version:    0.7.0.1
 */