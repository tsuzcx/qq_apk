package com.tencent.biz.common.download;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class OfflineDownloader
{
  protected static final String a = "OfflineDownload";
  private static Map a = new HashMap();
  
  public static int a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected())) {
        switch (paramContext.getType())
        {
        default: 
          return 4;
        case 1: 
          return 1;
        }
      }
    }
    switch (paramContext.getSubtype())
    {
    case 7: 
    case 10: 
    case 11: 
    default: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
      return 2;
    }
    return 3;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      a("NetWorkState Unavailabel");
      return null;
    }
    NetworkInfo localNetworkInfo = paramContext.getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      a("default NetWorkState Availabel");
      return localNetworkInfo;
    }
    paramContext = paramContext.getAllNetworkInfo();
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.length)
      {
        if (paramContext[i].getState() == NetworkInfo.State.CONNECTED)
        {
          a("NetWorkState Availabel");
          return paramContext[i];
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, AsyncBack paramAsyncBack)
  {
    if (paramAsyncBack == null) {
      return;
    }
    if ((paramContext == null) || (paramAsyncBack == null))
    {
      paramAsyncBack.a(paramString1, 11);
      return;
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      paramAsyncBack.a(paramString1, 12);
      return;
    }
    NetworkInfo localNetworkInfo = a(paramContext);
    if (localNetworkInfo == null)
    {
      paramAsyncBack.a(paramString1, 3);
      return;
    }
    if (!new File(paramString3.substring(0, paramString3.lastIndexOf("/"))).exists())
    {
      paramAsyncBack.a(paramString1, 13);
      return;
    }
    Object localObject = (Downloader)a.get(paramString1);
    if (localObject == null)
    {
      paramString3 = new Downloader(paramContext, paramString1, paramInt, paramString3, localNetworkInfo, paramAsyncBack);
      a.put(paramString1, paramString3);
    }
    while (paramString3.a())
    {
      a("isDownloading......");
      return;
      ((Downloader)localObject).a(paramAsyncBack);
      paramString3 = (String)localObject;
    }
    localObject = paramString3.a();
    if (localObject == null)
    {
      paramAsyncBack.a(paramString1, 4);
      return;
    }
    if ((((LoadInfo)localObject).b > 0) && (!TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("OfflineDownload", 4, "download from:" + ((LoadInfo)localObject).b + ", businessId:" + paramString2);
      }
      HtmlOffline.a(paramString2, ((LoadInfo)localObject).b, 0L, a(paramContext), "lixian_continue", "");
    }
    paramString3.a();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack)
  {
    a(paramContext, paramString1, 0, "0", paramString2, paramAsyncBack);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, paramString);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      a("NetWorkState Unavailabel");
    }
    for (;;)
    {
      return false;
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          if (paramContext[i].getState() == NetworkInfo.State.CONNECTED)
          {
            a("NetWorkState Availabel");
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((Downloader)a.get(paramString) == null) {
      return;
    }
    a.remove(paramString);
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = new File(paramString + ".tmp");
    } while (!paramString.exists());
    paramString.delete();
  }
  
  public static void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = (Downloader)a.get(paramString);
    } while (paramString == null);
    paramString.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.common.download.OfflineDownloader
 * JD-Core Version:    0.7.0.1
 */