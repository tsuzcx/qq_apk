package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.widget.Toast;
import com.tencent.halley.downloader.DownloaderFactory;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.halley.downloader.exceptions.DownloaderAddTaskException;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.base.TMSDKBaseContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class rb
{
  Map<String, a> a = new ConcurrentHashMap();
  lt b = new lt()
  {
    public final void a() {}
    
    public final void a(ls paramAnonymousls) {}
    
    public final void b(ls paramAnonymousls) {}
    
    public final void c(ls paramAnonymousls) {}
    
    public final void d(ls paramAnonymousls) {}
    
    public final void e(ls paramAnonymousls) {}
    
    public final void f(ls paramAnonymousls)
    {
      if (paramAnonymousls != null)
      {
        rb localrb = rb.this;
        rb.a locala = (rb.a)localrb.a.get(paramAnonymousls.c());
        if (locala != null)
        {
          rb.a(paramAnonymousls, locala);
          StringBuilder localStringBuilder = new StringBuilder("progressChangedCallback: [");
          localStringBuilder.append(rb.b(paramAnonymousls));
          localStringBuilder.append("]");
          paramAnonymousls = localrb.b().iterator();
          while (paramAnonymousls.hasNext()) {
            ((rb.c)paramAnonymousls.next()).a(locala);
          }
        }
      }
    }
    
    public final void g(ls paramAnonymousls)
    {
      if (paramAnonymousls != null) {
        rb.this.a(paramAnonymousls);
      }
    }
    
    public final void h(ls paramAnonymousls)
    {
      if (paramAnonymousls != null) {
        rb.this.a(paramAnonymousls);
      }
    }
    
    public final void i(ls paramAnonymousls)
    {
      if (paramAnonymousls != null) {
        rb.this.a(paramAnonymousls);
      }
    }
  };
  private lr c = null;
  private Map<String, ls> d = new ConcurrentHashMap();
  private List<c> e = new ArrayList();
  
  public static String a()
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("token_download");
      return localStringBuilder.toString();
    }
    return RqdApplication.n().getFilesDir().getAbsolutePath();
  }
  
  private static String a(DownloaderTaskStatus paramDownloaderTaskStatus)
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
      localIntent.setDataAndType(FileProvider.a(paramContext, localStringBuilder.toString(), paramFile), "application/vnd.android.package-archive");
    }
    else
    {
      localStringBuilder = new StringBuilder("file://");
      localStringBuilder.append(paramFile.toString());
      localIntent.setDataAndType(Uri.parse(localStringBuilder.toString()), "application/vnd.android.package-archive");
    }
    paramContext.startActivity(localIntent);
  }
  
  static void a(ls paramls, a parama)
  {
    if (paramls != null)
    {
      if (parama == null) {
        return;
      }
      parama.e = paramls.g();
      parama.f = paramls.d();
      parama.b = paramls.b();
      return;
    }
  }
  
  static String b(ls paramls)
  {
    int i = paramls.m();
    String str = paramls.n();
    return String.format("status=%s per=%d saveName=%s uniquekey=%s errorcode=%d error=%s", new Object[] { a(paramls.d()), Integer.valueOf(paramls.g()), paramls.j(), paramls.b(), Integer.valueOf(i), str });
  }
  
  private static boolean c()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)RqdApplication.n().getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
  }
  
  private void e(a parama)
  {
    this.a.remove(parama.c);
    this.d.remove(parama.c);
  }
  
  public final a a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (a)this.a.get(paramString);
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      ku.a(paramContext, "0M100WJ33N1CQ08O", "999001", TMSDKBaseContext.getGuid());
      this.c = DownloaderFactory.getDownloader();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  final void a(ls paramls)
  {
    a locala = (a)this.a.get(paramls.c());
    if (locala == null) {
      return;
    }
    a(paramls, locala);
    Object localObject = new StringBuilder("stateChangedCallback: [");
    ((StringBuilder)localObject).append(b(paramls));
    ((StringBuilder)localObject).append("]");
    localObject = b();
    switch (2.a[paramls.d().ordinal()])
    {
    default: 
    case 6: 
      paramls = ((List)localObject).iterator();
      while (paramls.hasNext()) {
        ((c)paramls.next()).b(locala);
      }
      return;
    case 5: 
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c)((Iterator)localObject).next()).c(locala);
      }
      this.c.b(paramls);
    case 7: 
      e(locala);
      return;
    case 4: 
      paramls = ((List)localObject).iterator();
      while (paramls.hasNext()) {
        ((c)paramls.next()).d(locala);
      }
      e(locala);
      return;
    }
  }
  
  public final void a(c paramc)
  {
    synchronized (this.e)
    {
      this.e.add(0, paramc);
      return;
    }
  }
  
  public final boolean a(a parama)
  {
    if (a(parama.c) != null) {
      return false;
    }
    return new File(a(), parama.d).exists();
  }
  
  final List<c> b()
  {
    synchronized (this.e)
    {
      ArrayList localArrayList = new ArrayList(this.e);
      return localArrayList;
    }
  }
  
  public final void b(a parama)
  {
    parama = (ls)this.d.get(parama.c);
    if (parama != null) {
      parama.k();
    }
  }
  
  public final void b(c paramc)
  {
    synchronized (this.e)
    {
      this.e.remove(paramc);
      return;
    }
  }
  
  public final void c(a parama)
  {
    if (this.c == null) {
      return;
    }
    if (!c())
    {
      Toast.makeText(RqdApplication.n(), "请开启网络再试", 0).show();
      return;
    }
    e(parama);
    try
    {
      ls localls = this.c.a(parama.a, parama.c, a(), parama.d, this.b);
      this.c.a(localls);
      this.a.put(parama.c, parama);
      this.d.put(parama.c, localls);
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
    }
  }
  
  public final void d(a parama)
  {
    if (!c())
    {
      Toast.makeText(RqdApplication.n(), "请开启网络再试", 0).show();
      return;
    }
    parama = (ls)this.d.get(parama.c);
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
  
  public static final class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public DownloaderTaskStatus f = DownloaderTaskStatus.PENDING;
  }
  
  public static final class b
  {
    private static rb a = new rb();
  }
  
  public static abstract interface c
  {
    public abstract void a(rb.a parama);
    
    public abstract void b(rb.a parama);
    
    public abstract void c(rb.a parama);
    
    public abstract void d(rb.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rb
 * JD-Core Version:    0.7.0.1
 */