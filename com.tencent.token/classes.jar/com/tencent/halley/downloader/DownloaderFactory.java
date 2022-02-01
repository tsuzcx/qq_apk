package com.tencent.halley.downloader;

import com.tencent.halley.DownloaderConfig;
import com.tencent.halley.common.HalleyInitException;
import com.tencent.token.ls;
import com.tencent.token.lv;
import com.tencent.token.lw;
import com.tencent.token.mm;
import com.tencent.token.mu;

public class DownloaderFactory
{
  private static ls a;
  
  public static void a(DownloaderConfig paramDownloaderConfig)
  {
    DownloaderConfig localDownloaderConfig = paramDownloaderConfig;
    if (paramDownloaderConfig == null) {
      localDownloaderConfig = DownloaderConfig.DEFAULT_DOWNLOADERCONFIG;
    }
    lw.a(localDownloaderConfig);
    if (a == null) {
      a = new lv();
    }
    mu.a(mm.a());
  }
  
  public static ls getDownloader()
  {
    ls localls = a;
    if (localls != null) {
      return localls;
    }
    throw new HalleyInitException("Downloader is not inited, call HalleyAgent#init and make sure Class DownloaderFactory was not obfused.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */