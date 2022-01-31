package com.tencent.tmassistantsdk.downloadservice;

import android.os.RemoteCallbackList;
import com.tencent.tmassistantsdk.a.e;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.a.c;
import com.tencent.tmassistantsdk.f.j;
import java.util.HashMap;
import java.util.Map;

public final class p
  extends e
{
  protected p(TMAssistantDownloadSDKService paramTMAssistantDownloadSDKService) {}
  
  public final int a()
  {
    return 1;
  }
  
  public final int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map paramMap)
  {
    j.b("TMAssistantDownloadSDKService", "startDownloadTask，clientkey:" + paramString1 + ",url:" + paramString2 + ",manager:" + this.a.c + ",fileName:" + paramString4);
    if (this.a.c != null)
    {
      com.tencent.tmassistantsdk.e.a.a();
      com.tencent.tmassistantsdk.e.a.a(paramString1, paramString2);
      return this.a.c.a(paramString1, paramString2, paramInt, paramString3, paramString4, paramMap);
    }
    return 3;
  }
  
  public final TMAssistantDownloadTaskInfo a(String paramString1, String paramString2)
  {
    j.b("TMAssistantDownloadSDKService", "getDownloadTaskInfo");
    if (this.a.c != null) {
      return this.a.c.a(paramString2);
    }
    return null;
  }
  
  public final void a(int paramInt)
  {
    f.a();
    f.a(paramInt);
  }
  
  public final void a(String paramString, com.tencent.tmassistantsdk.a.a parama)
  {
    j.b("TMAssistantDownloadSDKService", "registerDownloadTaskCallback,clientKey:" + paramString);
    if ((paramString != null) && (parama != null)) {
      this.a.a.register(parama);
    }
    try
    {
      this.a.b.put(parama, paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    f.a();
    f.a(paramBoolean);
  }
  
  public final void b(String paramString, com.tencent.tmassistantsdk.a.a parama)
  {
    j.b("TMAssistantDownloadSDKService", "unregisterDownloadTaskCallback,clientKey:" + paramString);
    if ((paramString != null) && (parama != null)) {
      this.a.a.unregister(parama);
    }
    try
    {
      this.a.b.remove(parama);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    j.b("TMAssistantDownloadSDKService", "pauseDownloadTask");
    try
    {
      if (this.a.c != null) {
        this.a.c.a(paramString1, paramString2);
      }
      j.b("TMAssistantDownloadSDKService", "pauseDownloadTask end");
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    f.a();
    f.b(paramBoolean);
  }
  
  public final boolean b()
  {
    return a.a().d().booleanValue();
  }
  
  public final void c(String paramString1, String paramString2)
  {
    if (this.a.c != null) {
      this.a.c.b(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.p
 * JD-Core Version:    0.7.0.1
 */