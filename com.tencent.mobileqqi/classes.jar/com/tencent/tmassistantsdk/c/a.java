package com.tencent.tmassistantsdk.c;

import android.net.Proxy;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.f.j;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;

public class a
  extends c
{
  private static a d = null;
  
  public static a a()
  {
    try
    {
      if (d == null) {
        d = new a();
      }
      a locala = d;
      return locala;
    }
    finally {}
  }
  
  public static DownloadChunkLogInfo a(byte paramByte)
  {
    j.b("DownloadReportManager", "createNewChunkLogInfo");
    DownloadChunkLogInfo localDownloadChunkLogInfo = new DownloadChunkLogInfo();
    localDownloadChunkLogInfo.type = paramByte;
    localDownloadChunkLogInfo.networkOperator = com.tencent.tmassistantsdk.f.e.a().d();
    localDownloadChunkLogInfo.networkType = com.tencent.tmassistantsdk.f.e.a().e();
    if (!TextUtils.isEmpty(Proxy.getDefaultHost())) {}
    for (int i = 1;; i = 0)
    {
      localDownloadChunkLogInfo.isWap = ((byte)i);
      localDownloadChunkLogInfo.startTime = System.currentTimeMillis();
      return localDownloadChunkLogInfo;
    }
  }
  
  protected final com.tencent.tmassistantsdk.e.c.a b()
  {
    return com.tencent.tmassistantsdk.e.c.e.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.c.a
 * JD-Core Version:    0.7.0.1
 */