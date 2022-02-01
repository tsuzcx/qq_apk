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
import com.tencent.halley.downloader.b;
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
  c a = new c()
  {
    public void a(b paramAnonymousb)
    {
      Log.i("DownloadService", "onTaskPendingMainloop");
    }
    
    public void b(b paramAnonymousb)
    {
      Log.i("DownloadService", "onTaskStartedMainloop");
    }
    
    public void c(b paramAnonymousb)
    {
      Log.i("DownloadService", "onTaskDetectedMainloop");
    }
    
    public void d(b paramAnonymousb)
    {
      Log.i("DownloadService", "onTaskReceivedMainloop");
    }
    
    public void e(b paramAnonymousb)
    {
      Log.i("DownloadService", "onTaskPendingMainloop");
    }
    
    public void f(b paramAnonymousb)
    {
      Log.i("DownloadService", "onTaskFailedMainloop");
    }
    
    public void g(b paramAnonymousb)
    {
      Log.i("DownloadService", "onTaskCompletedMainloop");
    }
    
    public void h(b paramAnonymousb)
    {
      Log.i("DownloadService", "onTaskStartedSubloop");
    }
    
    public void i(b paramAnonymousb)
    {
      Log.i("DownloadService", "onTaskDetectedSubloop");
    }
    
    public void j(b paramAnonymousb)
    {
      if (paramAnonymousb != null) {
        a.this.a(paramAnonymousb);
      }
    }
    
    public void k(b paramAnonymousb)
    {
      if (paramAnonymousb != null) {
        a.this.b(paramAnonymousb);
      }
    }
    
    public void l(b paramAnonymousb)
    {
      if (paramAnonymousb != null) {
        a.this.b(paramAnonymousb);
      }
    }
    
    public void m(b paramAnonymousb)
    {
      if (paramAnonymousb != null) {
        a.this.b(paramAnonymousb);
      }
    }
  };
  private com.tencent.halley.downloader.a b = null;
  private Map<String, a> c = new ConcurrentHashMap();
  private Map<String, b> d = new ConcurrentHashMap();
  private List<c> e = new ArrayList();
  
  public static a a()
  {
    return b.a();
  }
  
  private String a(DownloaderTaskStatus paramDownloaderTaskStatus)
  {
    switch (2.a[paramDownloaderTaskStatus.ordinal()])
    {
    default: 
      return "";
    case 7: 
      return "DELETED";
    case 6: 
      return "PAUSED";
    case 5: 
      return "FAILED";
    case 4: 
      return "COMPLETE";
    case 3: 
      return "DOWNLOADING";
    case 2: 
      return "STARTED";
    }
    return "PENDING";
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setFlags(1);
    localIntent.addFlags(268435456);
    StringBuilder localStringBuilder;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(".FileProvider");
      localIntent.setDataAndType(FileProvider.getUriForFile(paramContext, localStringBuilder.toString(), paramFile), "application/vnd.android.package-archive");
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(paramFile.toString());
      localIntent.setDataAndType(Uri.parse(localStringBuilder.toString()), "application/vnd.android.package-archive");
    }
    paramContext.startActivity(localIntent);
  }
  
  public static String b()
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("token_download");
      return localStringBuilder.toString();
    }
    return RqdApplication.l().getFilesDir().getAbsolutePath();
  }
  
  private String c(b paramb)
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
  
  private List<c> d()
  {
    synchronized (this.e)
    {
      ArrayList localArrayList = new ArrayList(this.e);
      return localArrayList;
    }
  }
  
  private void e(a parama)
  {
    this.c.remove(parama.c);
    parama = (b)this.d.remove(parama.c);
  }
  
  public a a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (a)this.c.get(paramString);
  }
  
  public void a(Context paramContext)
  {
    try
    {
      com.tencent.halley.a.a(paramContext, "0M100WJ33N1CQ08O", "1001", TMSDKBaseContext.getGuid(), null, null);
      this.b = DownloaderFactory.getDownloader();
      Log.i("DownloadService", "init done.");
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  void a(b paramb)
  {
    a locala = (a)this.c.get(paramb.c());
    if (locala == null) {
      return;
    }
    a(paramb, locala);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progressChangedCallback: [");
    localStringBuilder.append(c(paramb));
    localStringBuilder.append("]");
    Log.i("DownloadService", localStringBuilder.toString());
    paramb = d().iterator();
    while (paramb.hasNext()) {
      ((c)paramb.next()).a(locala);
    }
  }
  
  void a(b paramb, a parama)
  {
    if (paramb != null)
    {
      if (parama == null) {
        return;
      }
      parama.e = paramb.g();
      parama.f = paramb.d();
      parama.b = paramb.b();
      return;
    }
  }
  
  public void a(c paramc)
  {
    synchronized (this.e)
    {
      this.e.add(0, paramc);
      return;
    }
  }
  
  public boolean a(a parama)
  {
    if (a(parama.c) != null) {
      return false;
    }
    return new File(b(), parama.d).exists();
  }
  
  void b(b paramb)
  {
    a locala = (a)this.c.get(paramb.c());
    if (locala == null) {
      return;
    }
    a(paramb, locala);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stateChangedCallback: [");
    ((StringBuilder)localObject).append(c(paramb));
    ((StringBuilder)localObject).append("]");
    Log.i("DownloadService", ((StringBuilder)localObject).toString());
    localObject = d();
    switch (2.a[paramb.d().ordinal()])
    {
    default: 
    case 7: 
      e(locala);
      return;
    case 6: 
      paramb = ((List)localObject).iterator();
    case 5: 
    case 4: 
      while (paramb.hasNext())
      {
        ((c)paramb.next()).b(locala);
        continue;
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((c)((Iterator)localObject).next()).c(locala);
        }
        this.b.a(paramb, true);
        e(locala);
        return;
        paramb = ((List)localObject).iterator();
        while (paramb.hasNext()) {
          ((c)paramb.next()).d(locala);
        }
        e(locala);
      }
    }
  }
  
  public void b(a parama)
  {
    parama = (b)this.d.get(parama.c);
    if (parama != null) {
      parama.k();
    }
  }
  
  public void b(c paramc)
  {
    synchronized (this.e)
    {
      this.e.remove(paramc);
      return;
    }
  }
  
  public void c(a parama)
  {
    if (this.b == null) {
      return;
    }
    if (!c())
    {
      Toast.makeText(RqdApplication.l(), "请开启网络再试", 0).show();
      return;
    }
    e(parama);
    try
    {
      b localb = this.b.a(1, parama.a, parama.c, null, null, null, b(), parama.d, this.a, false, 0L);
      this.b.a(localb);
      this.c.put(parama.c, parama);
      this.d.put(parama.c, localb);
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
    }
  }
  
  public void d(a parama)
  {
    if (!c())
    {
      Toast.makeText(RqdApplication.l(), "请开启网络再试", 0).show();
      return;
    }
    parama = (b)this.d.get(parama.c);
    if (parama != null) {
      try
      {
        parama.l();
        return;
      }
      catch (DownloaderAddTaskException parama)
      {
        parama.printStackTrace();
      }
    }
  }
  
  public static class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public DownloaderTaskStatus f = DownloaderTaskStatus.PENDING;
  }
  
  public static class b
  {
    private static a a = new a();
  }
  
  public static abstract interface c
  {
    public abstract void a(a.a parama);
    
    public abstract void b(a.a parama);
    
    public abstract void c(a.a parama);
    
    public abstract void d(a.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.a
 * JD-Core Version:    0.7.0.1
 */