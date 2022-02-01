package com.tencent.halley.downloader;

import com.tencent.halley.DownloaderConfig;
import com.tencent.halley.common.HalleyInitException;
import com.tencent.token.ly;
import com.tencent.token.mb;
import com.tencent.token.mc;
import com.tencent.token.ms;
import com.tencent.token.na;

public class DownloaderFactory
{
  private static ly a;
  
  public static void a(DownloaderConfig paramDownloaderConfig)
  {
    DownloaderConfig localDownloaderConfig = paramDownloaderConfig;
    if (paramDownloaderConfig == null) {
      localDownloaderConfig = DownloaderConfig.DEFAULT_DOWNLOADERCONFIG;
    }
    mc.a(localDownloaderConfig);
    if (a == null) {
      a = new mb();
    }
    na.a(ms.a());
  }
  
  public static ly getDownloader()
  {
    ly locally = a;
    if (locally != null) {
      return locally;
    }
    throw new HalleyInitException("Downloader is not inited, call HalleyAgent#init and make sure Class DownloaderFactory was not obfused.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */