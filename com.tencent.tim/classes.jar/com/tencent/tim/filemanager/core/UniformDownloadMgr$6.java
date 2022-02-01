package com.tencent.tim.filemanager.core;

import android.os.Bundle;
import atur;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UniformDownloadMgr$6
  implements Runnable
{
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
    atur.a(this.this$0, this.ajI, this.aT);
    atur.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.UniformDownloadMgr.6
 * JD-Core Version:    0.7.0.1
 */