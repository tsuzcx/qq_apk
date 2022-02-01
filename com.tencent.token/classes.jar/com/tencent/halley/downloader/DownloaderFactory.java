package com.tencent.halley.downloader;

import com.tencent.halley.DownloaderConfig;
import com.tencent.halley.common.HalleyInitException;
import com.tencent.token.ah;
import com.tencent.token.ak;
import com.tencent.token.v;
import com.tencent.token.w;

public class DownloaderFactory
{
  private static a a;
  
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
    ak.a(ah.a());
  }
  
  public static a getDownloader()
  {
    a locala = a;
    if (locala != null) {
      return locala;
    }
    throw new HalleyInitException("Downloader is not inited, call HalleyAgent#init and make sure Class DownloaderFactory was not obfused.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */