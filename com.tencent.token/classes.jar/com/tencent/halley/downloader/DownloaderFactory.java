package com.tencent.halley.downloader;

import com.tencent.halley.DownloaderConfig;
import com.tencent.halley.common.HalleyInitException;
import com.tencent.token.ag;
import com.tencent.token.aj;
import com.tencent.token.u;
import com.tencent.token.v;

public class DownloaderFactory
{
  private static a a = null;
  
  public static void a(DownloaderConfig paramDownloaderConfig)
  {
    DownloaderConfig localDownloaderConfig = paramDownloaderConfig;
    if (paramDownloaderConfig == null) {
      localDownloaderConfig = DownloaderConfig.DEFAULT_DOWNLOADERCONFIG;
    }
    v.a(localDownloaderConfig);
    if (a == null) {
      a = new u();
    }
    aj.a(ag.a());
  }
  
  public static a getDownloader()
  {
    if (a == null) {
      throw new HalleyInitException("Downloader is not inited, call HalleyAgent#init and make sure Class DownloaderFactory was not obfused.");
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */