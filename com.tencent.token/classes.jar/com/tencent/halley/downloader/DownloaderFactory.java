package com.tencent.halley.downloader;

import com.tencent.halley.DownloaderConfig;
import com.tencent.halley.common.HalleyInitException;
import com.tencent.token.ak;
import com.tencent.token.ao;
import com.tencent.token.v;
import com.tencent.token.w;

public class DownloaderFactory
{
  private static a a = null;
  
  public static void a(DownloaderConfig paramDownloaderConfig)
  {
    DownloaderConfig localDownloaderConfig = paramDownloaderConfig;
    if (paramDownloaderConfig == null) {
      localDownloaderConfig = DownloaderConfig.DEFAULT_DOWNLOADERCONFIG;
    }
    w.a(localDownloaderConfig);
    if (a == null) {
      a = new v();
    }
    ao.a(ak.a());
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