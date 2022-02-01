package com.tencent.mobileqq.app;

import accy;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.URL;

public class ConfigHandler$9
  implements Runnable
{
  public ConfigHandler$9(accy paramaccy, String paramString, File paramFile) {}
  
  public void run()
  {
    try
    {
      HttpDownloadUtil.a(this.this$0.app, new URL(this.val$url), this.val$file);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.9
 * JD-Core Version:    0.7.0.1
 */