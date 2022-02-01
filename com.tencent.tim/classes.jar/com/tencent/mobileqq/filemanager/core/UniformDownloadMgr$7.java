package com.tencent.mobileqq.filemanager.core;

import aglz;
import android.os.Bundle;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UniformDownloadMgr$7
  implements Runnable
{
  public UniformDownloadMgr$7(aglz paramaglz, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    long l = 0L;
    for (;;)
    {
      try
      {
        localURL = new URL(this.ajI);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        URL localURL;
        int i;
        localMalformedURLException.printStackTrace();
        continue;
      }
      try
      {
        i = localURL.openConnection().getContentLength();
        l = i;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    this.aT.putLong("_filesize_from_dlg", l);
    aglz.a(this.this$0, this.ajI, this.aT);
    aglz.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.7
 * JD-Core Version:    0.7.0.1
 */