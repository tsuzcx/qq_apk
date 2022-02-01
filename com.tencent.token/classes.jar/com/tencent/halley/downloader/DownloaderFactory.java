package com.tencent.halley.downloader;

import com.tencent.halley.DownloaderConfig;
import com.tencent.halley.common.HalleyInitException;
import com.tencent.token.lr;
import com.tencent.token.lu;
import com.tencent.token.lv;
import com.tencent.token.ml;
import com.tencent.token.mt;

public class DownloaderFactory
{
  private static lr a;
  
  public static void a(DownloaderConfig paramDownloaderConfig)
  {
    DownloaderConfig localDownloaderConfig = paramDownloaderConfig;
    if (paramDownloaderConfig == null) {
      localDownloaderConfig = DownloaderConfig.DEFAULT_DOWNLOADERCONFIG;
    }
    lv.a(localDownloaderConfig);
    if (a == null) {
      a = new lu();
    }
    mt.a(ml.a());
  }
  
  public static lr getDownloader()
  {
    lr locallr = a;
    if (locallr != null) {
      return locallr;
    }
    throw new HalleyInitException("Downloader is not inited, call HalleyAgent#init and make sure Class DownloaderFactory was not obfused.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */