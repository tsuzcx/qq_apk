package com.tencent.halley.downloader;

import com.tencent.halley.DownloaderConfig;
import com.tencent.halley.common.HalleyInitException;
import com.tencent.token.mm;
import com.tencent.token.mp;
import com.tencent.token.mq;
import com.tencent.token.ng;
import com.tencent.token.no;

public class DownloaderFactory
{
  private static mm a;
  
  public static void a(DownloaderConfig paramDownloaderConfig)
  {
    DownloaderConfig localDownloaderConfig = paramDownloaderConfig;
    if (paramDownloaderConfig == null) {
      localDownloaderConfig = DownloaderConfig.DEFAULT_DOWNLOADERCONFIG;
    }
    mq.a(localDownloaderConfig);
    if (a == null) {
      a = new mp();
    }
    no.a(ng.a());
  }
  
  public static mm getDownloader()
  {
    mm localmm = a;
    if (localmm != null) {
      return localmm;
    }
    throw new HalleyInitException("Downloader is not inited, call HalleyAgent#init and make sure Class DownloaderFactory was not obfused.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.DownloaderFactory
 * JD-Core Version:    0.7.0.1
 */