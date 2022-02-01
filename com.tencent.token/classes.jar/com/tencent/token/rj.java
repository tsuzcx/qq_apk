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

public final class rj
{
  Map<String, a> a = new ConcurrentHashMap();
  ma b = new ma()
  {
    public final void a() {}
    
    public final void a(lz paramAnonymouslz) {}
    
    public final void b(lz paramAnonymouslz) {}
    
    public final void c(lz paramAnonymouslz) {}
    
    public final void d(lz paramAnonymouslz) {}
    
    public final void e(lz paramAnonymouslz) {}
    
    public final void f(lz paramAnonymouslz)
    {
      if (paramAnonymouslz != null)
      {
        rj localrj = rj.this;
        rj.a locala = (rj.a)localrj.a.get(paramAnonymouslz.c());
        if (locala != null)
        {
          rj.a(paramAnonymouslz, locala);
          StringBuilder localStringBuilder = new StringBuilder("progressChangedCallback: [");
          localStringBuilder.append(rj.b(paramAnonymouslz));
          localStringBuilder.append("]");
          paramAnonymouslz = localrj.b().iterator();
          while (paramAnonymouslz.hasNext()) {
            ((rj.c)paramAnonymouslz.next()).a(locala);
          }
        }
      }
    }
    
    public final void g(lz paramAnonymouslz)
    {
      if (paramAnonymouslz != null) {
        rj.this.a(paramAnonymouslz);
      }
    }
    
    public final void h(lz paramAnonymouslz)
    {
      if (paramAnonymouslz != null) {
        rj.this.a(paramAnonymouslz);
      }
    }
    
    public final void i(lz paramAnonymouslz)
    {
      if (paramAnonymouslz != null) {
        rj.this.a(paramAnonymouslz);
      }
    }
  };
  private ly c = null;
  private Map<String, lz> d = new ConcurrentHashMap();
  private List<c> e = new ArrayList();
  
  public static String a()
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      Object localObject = zk.a("token_download");
      if (localObject != null) {
        return ((File)localObject).getAbsolutePath();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("token_download");
      return ((StringBuilder)localObject).toString();
    }
    return RqdApplication.p().getFilesDir().getAbsolutePath();
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
  
  static void a(lz paramlz, a parama)
  {
    if (paramlz != null)
    {
      if (parama == null) {
        return;
      }
      parama.e = paramlz.g();
      parama.f = paramlz.d();
      parama.b = paramlz.b();
      return;
    }
  }
  
  static String b(lz paramlz)
  {
    int i = paramlz.m();
    String str = paramlz.n();
    return String.format("status=%s per=%d saveName=%s uniquekey=%s errorcode=%d error=%s", new Object[] { a(paramlz.d()), Integer.valueOf(paramlz.g()), paramlz.j(), paramlz.b(), Integer.valueOf(i), str });
  }
  
  private static boolean c()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)RqdApplication.p().getSystemService("connectivity")).getActiveNetworkInfo();
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
      lb.a(paramContext, "0M100WJ33N1CQ08O", "999001", TMSDKBaseContext.getGuid());
      this.c = DownloaderFactory.getDownloader();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  final void a(lz paramlz)
  {
    a locala = (a)this.a.get(paramlz.c());
    if (locala == null) {
      return;
    }
    a(paramlz, locala);
    Object localObject = new StringBuilder("stateChangedCallback: [");
    ((StringBuilder)localObject).append(b(paramlz));
    ((StringBuilder)localObject).append("]");
    localObject = b();
    switch (2.a[paramlz.d().ordinal()])
    {
    default: 
    case 6: 
      paramlz = ((List)localObject).iterator();
      while (paramlz.hasNext()) {
        ((c)paramlz.next()).b(locala);
      }
      return;
    case 5: 
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c)((Iterator)localObject).next()).c(locala);
      }
      this.c.b(paramlz);
    case 7: 
      e(locala);
      return;
    case 4: 
      paramlz = ((List)localObject).iterator();
      while (paramlz.hasNext()) {
        ((c)paramlz.next()).d(locala);
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
    parama = (lz)this.d.get(parama.c);
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
      Toast.makeText(RqdApplication.p(), "请开启网络再试", 0).show();
      return;
    }
    e(parama);
    try
    {
      lz locallz = this.c.a(parama.a, parama.c, a(), parama.d, this.b);
      this.c.a(locallz);
      this.a.put(parama.c, parama);
      this.d.put(parama.c, locallz);
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
      Toast.makeText(RqdApplication.p(), "请开启网络再试", 0).show();
      return;
    }
    parama = (lz)this.d.get(parama.c);
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
    private static rj a = new rj();
  }
  
  public static abstract interface c
  {
    public abstract void a(rj.a parama);
    
    public abstract void b(rj.a parama);
    
    public abstract void c(rj.a parama);
    
    public abstract void d(rj.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rj
 * JD-Core Version:    0.7.0.1
 */