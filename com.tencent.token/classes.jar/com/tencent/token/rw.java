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

public final class rw
{
  Map<String, a> a = new ConcurrentHashMap();
  mo b = new mo()
  {
    public final void a() {}
    
    public final void a(mn paramAnonymousmn) {}
    
    public final void b(mn paramAnonymousmn) {}
    
    public final void c(mn paramAnonymousmn) {}
    
    public final void d(mn paramAnonymousmn) {}
    
    public final void e(mn paramAnonymousmn) {}
    
    public final void f(mn paramAnonymousmn)
    {
      if (paramAnonymousmn != null)
      {
        rw localrw = rw.this;
        rw.a locala = (rw.a)localrw.a.get(paramAnonymousmn.c());
        if (locala != null)
        {
          rw.a(paramAnonymousmn, locala);
          StringBuilder localStringBuilder = new StringBuilder("progressChangedCallback: [");
          localStringBuilder.append(rw.b(paramAnonymousmn));
          localStringBuilder.append("]");
          paramAnonymousmn = localrw.b().iterator();
          while (paramAnonymousmn.hasNext()) {
            ((rw.c)paramAnonymousmn.next()).a(locala);
          }
        }
      }
    }
    
    public final void g(mn paramAnonymousmn)
    {
      if (paramAnonymousmn != null) {
        rw.this.a(paramAnonymousmn);
      }
    }
    
    public final void h(mn paramAnonymousmn)
    {
      if (paramAnonymousmn != null) {
        rw.this.a(paramAnonymousmn);
      }
    }
    
    public final void i(mn paramAnonymousmn)
    {
      if (paramAnonymousmn != null) {
        rw.this.a(paramAnonymousmn);
      }
    }
  };
  private mm c = null;
  private Map<String, mn> d = new ConcurrentHashMap();
  private List<c> e = new ArrayList();
  
  public static String a()
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      Object localObject = zw.a("token_download");
      if (localObject != null) {
        return ((File)localObject).getAbsolutePath();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("token_download");
      return ((StringBuilder)localObject).toString();
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
  
  static void a(mn parammn, a parama)
  {
    if (parammn != null)
    {
      if (parama == null) {
        return;
      }
      parama.e = parammn.g();
      parama.f = parammn.d();
      parama.b = parammn.b();
      return;
    }
  }
  
  static String b(mn parammn)
  {
    int i = parammn.m();
    String str = parammn.n();
    return String.format("status=%s per=%d saveName=%s uniquekey=%s errorcode=%d error=%s", new Object[] { a(parammn.d()), Integer.valueOf(parammn.g()), parammn.j(), parammn.b(), Integer.valueOf(i), str });
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
      lp.a(paramContext, "0M100WJ33N1CQ08O", "999001", TMSDKBaseContext.getGuid());
      this.c = DownloaderFactory.getDownloader();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  final void a(mn parammn)
  {
    a locala = (a)this.a.get(parammn.c());
    if (locala == null) {
      return;
    }
    a(parammn, locala);
    Object localObject = new StringBuilder("stateChangedCallback: [");
    ((StringBuilder)localObject).append(b(parammn));
    ((StringBuilder)localObject).append("]");
    localObject = b();
    switch (2.a[parammn.d().ordinal()])
    {
    default: 
    case 6: 
      parammn = ((List)localObject).iterator();
      while (parammn.hasNext()) {
        ((c)parammn.next()).b(locala);
      }
      return;
    case 5: 
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c)((Iterator)localObject).next()).c(locala);
      }
      this.c.b(parammn);
    case 7: 
      e(locala);
      return;
    case 4: 
      parammn = ((List)localObject).iterator();
      while (parammn.hasNext()) {
        ((c)parammn.next()).d(locala);
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
    parama = (mn)this.d.get(parama.c);
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
      mn localmn = this.c.a(parama.a, parama.c, a(), parama.d, this.b);
      this.c.a(localmn);
      this.a.put(parama.c, parama);
      this.d.put(parama.c, localmn);
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
    parama = (mn)this.d.get(parama.c);
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
    private static rw a = new rw();
  }
  
  public static abstract interface c
  {
    public abstract void a(rw.a parama);
    
    public abstract void b(rw.a parama);
    
    public abstract void c(rw.a parama);
    
    public abstract void d(rw.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rw
 * JD-Core Version:    0.7.0.1
 */