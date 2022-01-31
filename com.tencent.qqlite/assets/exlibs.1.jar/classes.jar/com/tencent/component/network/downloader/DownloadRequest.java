package com.tencent.component.network.downloader;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.utils.AssertUtil;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DownloadRequest
{
  private final String a;
  private final String[] b;
  private final Downloader.DownloadListener c;
  private boolean d = false;
  private boolean e = false;
  private Map<String, String> f;
  public Downloader.DownloadMode mode = Downloader.DownloadMode.FastMode;
  public OutputStream outputStream;
  public long range;
  
  public DownloadRequest(String paramString, String[] paramArrayOfString, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    boolean bool1 = bool2;
    if (Const.a(paramString))
    {
      bool1 = bool2;
      if (paramArrayOfString != null) {
        bool1 = true;
      }
    }
    AssertUtil.assertTrue(bool1);
    this.a = paramString;
    this.b = paramArrayOfString;
    this.c = paramDownloadListener;
    this.e = paramBoolean;
  }
  
  public void addParam(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    if (this.f == null) {
      this.f = new HashMap();
    }
    this.f.put(paramString1, paramString2);
  }
  
  public void cancel()
  {
    this.d = true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof DownloadRequest))) {
        return false;
      }
      Object localObject = (DownloadRequest)paramObject;
      boolean bool;
      if (this.a.equalsIgnoreCase(((DownloadRequest)localObject).a))
      {
        paramObject = this.c;
        localObject = ((DownloadRequest)localObject).c;
        if (paramObject != null) {
          break label70;
        }
        if (localObject != null) {
          break label65;
        }
        bool = true;
      }
      while (!bool)
      {
        return false;
        label65:
        bool = false;
        continue;
        label70:
        bool = paramObject.equals(localObject);
      }
    }
  }
  
  public Downloader.DownloadListener getListener()
  {
    return this.c;
  }
  
  public Map<String, String> getParams()
  {
    return this.f;
  }
  
  public String getPath()
  {
    if ((this.b != null) && (this.b.length > 0)) {
      return this.b[0];
    }
    return null;
  }
  
  public String[] getPaths()
  {
    return this.b;
  }
  
  public String getUrl()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    Downloader.DownloadListener localDownloadListener = this.c;
    if (localDownloadListener == null) {}
    for (int i = 0;; i = localDownloadListener.hashCode()) {
      return i + (j + 527) * 31;
    }
  }
  
  public boolean isCanceled()
  {
    return this.d;
  }
  
  public boolean shouldCacheEntry()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadRequest
 * JD-Core Version:    0.7.0.1
 */