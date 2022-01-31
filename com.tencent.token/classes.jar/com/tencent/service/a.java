package com.tencent.service;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Toast;
import com.tencent.halley.downloader.DownloaderFactory;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.halley.downloader.c;
import com.tencent.halley.downloader.exceptions.DownloaderAddTaskException;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.base.TMSDKBaseContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  c a = new b(this);
  private com.tencent.halley.downloader.a b = null;
  private Map c = new ConcurrentHashMap();
  private Map d = new ConcurrentHashMap();
  private List e = new ArrayList();
  
  public static a a()
  {
    return e.a();
  }
  
  private String a(DownloaderTaskStatus paramDownloaderTaskStatus)
  {
    switch (c.a[paramDownloaderTaskStatus.ordinal()])
    {
    default: 
      return "";
    case 1: 
      return "PENDING";
    case 2: 
      return "STARTED";
    case 3: 
      return "DOWNLOADING";
    case 4: 
      return "COMPLETE";
    case 6: 
      return "PAUSED";
    case 5: 
      return "FAILED";
    }
    return "DELETED";
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(1);
    localIntent.addFlags(268435456);
    if (Build.VERSION.SDK_INT >= 24) {
      localIntent.setDataAndType(FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".FileProvider", paramFile), "application/vnd.android.package-archive");
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      localIntent.setDataAndType(Uri.parse("file://" + paramFile.toString()), "application/vnd.android.package-archive");
    }
  }
  
  public static String b()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {
      return Environment.getExternalStorageDirectory() + File.separator + "token_download";
    }
    return RqdApplication.l().getFilesDir().getAbsolutePath();
  }
  
  private String c(com.tencent.halley.downloader.b paramb)
  {
    int i = paramb.m();
    String str = paramb.n();
    return String.format("status=%s per=%d saveName=%s uniquekey=%s errorcode=%d error=%s", new Object[] { a(paramb.d()), Integer.valueOf(paramb.g()), paramb.j(), paramb.b(), Integer.valueOf(i), str });
  }
  
  private boolean c()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)RqdApplication.l().getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
  }
  
  private List d()
  {
    synchronized (this.e)
    {
      ArrayList localArrayList = new ArrayList(this.e);
      return localArrayList;
    }
  }
  
  private void e(d paramd)
  {
    this.c.remove(paramd.c);
    paramd = (com.tencent.halley.downloader.b)this.d.remove(paramd.c);
  }
  
  public d a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (d)this.c.get(paramString);
  }
  
  public void a(Context paramContext)
  {
    try
    {
      com.tencent.halley.a.a(paramContext, "0M100WJ33N1CQ08O", "1002", TMSDKBaseContext.getGuid(), null, null);
      this.b = DownloaderFactory.getDownloader();
      Log.i("DownloadService", "init done.");
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  void a(com.tencent.halley.downloader.b paramb)
  {
    d locald = (d)this.c.get(paramb.c());
    if (locald == null) {}
    for (;;)
    {
      return;
      a(paramb, locald);
      Log.i("DownloadService", "progressChangedCallback: [" + c(paramb) + "]");
      paramb = d().iterator();
      while (paramb.hasNext()) {
        ((f)paramb.next()).a(locald);
      }
    }
  }
  
  void a(com.tencent.halley.downloader.b paramb, d paramd)
  {
    if ((paramb == null) || (paramd == null)) {
      return;
    }
    paramd.e = paramb.g();
    paramd.f = paramb.d();
    paramd.b = paramb.b();
  }
  
  public void a(f paramf)
  {
    synchronized (this.e)
    {
      this.e.add(0, paramf);
      return;
    }
  }
  
  public boolean a(d paramd)
  {
    if (a(paramd.c) != null) {
      return false;
    }
    return new File(b(), paramd.d).exists();
  }
  
  void b(com.tencent.halley.downloader.b paramb)
  {
    d locald = (d)this.c.get(paramb.c());
    if (locald == null) {
      return;
    }
    a(paramb, locald);
    Log.i("DownloadService", "stateChangedCallback: [" + c(paramb) + "]");
    Object localObject = d();
    switch (c.a[paramb.d().ordinal()])
    {
    case 1: 
    case 2: 
    case 3: 
    default: 
      return;
    case 4: 
      paramb = ((List)localObject).iterator();
      while (paramb.hasNext()) {
        ((f)paramb.next()).d(locald);
      }
      e(locald);
      return;
    case 5: 
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).c(locald);
      }
      this.b.a(paramb, true);
      e(locald);
      return;
    case 6: 
      paramb = ((List)localObject).iterator();
      while (paramb.hasNext()) {
        ((f)paramb.next()).b(locald);
      }
    }
    e(locald);
  }
  
  public void b(d paramd)
  {
    paramd = (com.tencent.halley.downloader.b)this.d.get(paramd.c);
    if (paramd != null) {
      paramd.k();
    }
  }
  
  public void b(f paramf)
  {
    synchronized (this.e)
    {
      this.e.remove(paramf);
      return;
    }
  }
  
  public void c(d paramd)
  {
    if (this.b == null) {
      return;
    }
    if (!c())
    {
      Toast.makeText(RqdApplication.l(), "请开启网络再试", 0).show();
      return;
    }
    e(paramd);
    try
    {
      com.tencent.halley.downloader.b localb = this.b.a(1, paramd.a, paramd.c, null, null, null, b(), paramd.d, this.a, false, 0L);
      this.b.a(localb);
      this.c.put(paramd.c, paramd);
      this.d.put(paramd.c, localb);
      return;
    }
    catch (Exception paramd)
    {
      paramd.printStackTrace();
    }
  }
  
  public void d(d paramd)
  {
    if (!c()) {
      Toast.makeText(RqdApplication.l(), "请开启网络再试", 0).show();
    }
    do
    {
      return;
      paramd = (com.tencent.halley.downloader.b)this.d.get(paramd.c);
    } while (paramd == null);
    try
    {
      paramd.l();
      return;
    }
    catch (DownloaderAddTaskException paramd)
    {
      paramd.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.a
 * JD-Core Version:    0.7.0.1
 */