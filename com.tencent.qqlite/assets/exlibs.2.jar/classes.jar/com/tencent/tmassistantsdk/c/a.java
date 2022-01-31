package com.tencent.tmassistantsdk.c;

import android.net.Proxy;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.e.c.e;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;

public class a
  extends b
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
    k.b("DownloadReportManager", "createNewChunkLogInfo");
    DownloadChunkLogInfo localDownloadChunkLogInfo = new DownloadChunkLogInfo();
    localDownloadChunkLogInfo.type = paramByte;
    localDownloadChunkLogInfo.networkOperator = f.a().d();
    localDownloadChunkLogInfo.networkType = f.a().e();
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
    return e.e();
  }
  
  protected final byte c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.c.a
 * JD-Core Version:    0.7.0.1
 */