package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.g;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class h
{
  public final Context a;
  public final String b;
  final File c;
  public final b d = new b(this);
  public final Map<String, Object> e = new ConcurrentHashMap();
  final Map<String, com.tencent.tbs.one.impl.c.b> f = new ConcurrentHashMap();
  public final Map<String, List<g>> g = new ConcurrentHashMap();
  public volatile TBSOneManager.Policy h = TBSOneManager.Policy.AUTO;
  volatile boolean i = false;
  volatile long j = 86400000L;
  volatile boolean k = true;
  public boolean l = false;
  public boolean m = false;
  public TBSOneDelegate n;
  public d o;
  public com.tencent.tbs.one.impl.a.a<d> p;
  
  public h(Context paramContext, String paramString)
  {
    if (paramContext.getApplicationContext() != null) {}
    for (this.a = paramContext.getApplicationContext();; this.a = paramContext)
    {
      this.b = paramString;
      this.c = com.tencent.tbs.one.impl.common.f.a(paramContext.getDir("tbs", 0), paramString);
      c.d(this.c);
      c.d(com.tencent.tbs.one.impl.common.f.d(this.c));
      return;
    }
  }
  
  private com.tencent.tbs.one.impl.c.b h(String paramString)
  {
    com.tencent.tbs.one.impl.c.b localb2 = (com.tencent.tbs.one.impl.c.b)this.f.get(paramString);
    com.tencent.tbs.one.impl.c.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new com.tencent.tbs.one.impl.c.b(this, paramString);
      this.f.put(paramString, localb1);
    }
    return localb1;
  }
  
  public TBSOneManager.Policy a()
  {
    return this.h;
  }
  
  public com.tencent.tbs.one.impl.a.a<e<d>> a(Bundle paramBundle, l<e<d>> paraml)
  {
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing DEPS", new Object[] { this.b });
    paramBundle = com.tencent.tbs.one.impl.common.f.b(this.c);
    paramBundle = new com.tencent.tbs.one.impl.e.b.b(this.a, this.b, paramBundle);
    paramBundle.a(paraml);
    return paramBundle;
  }
  
  public com.tencent.tbs.one.impl.a.a<e<File>> a(Bundle paramBundle, d.a parama, l<e<File>> paraml)
  {
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing component %s, version: %d", new Object[] { this.b, parama.a, Integer.valueOf(parama.c) });
    File localFile = a(parama.a, parama.c);
    c.d(localFile);
    paramBundle = new com.tencent.tbs.one.impl.e.b.a(this.a, this.b, parama, localFile, paramBundle, "");
    paramBundle.a(paraml);
    return paramBundle;
  }
  
  public final File a(String paramString)
  {
    return com.tencent.tbs.one.impl.common.f.b(this.c, paramString);
  }
  
  public final File a(String paramString, int paramInt)
  {
    return com.tencent.tbs.one.impl.common.f.a(this.c, paramString, paramInt);
  }
  
  public void a(Bundle paramBundle, String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    h(paramString).a(paramBundle, paramTBSOneCallback);
  }
  
  protected void a(e<d> parame)
  {
    com.tencent.tbs.one.impl.a.f.a("[%s] Finished loading DEPS#%d from %s", new Object[] { this.b, Integer.valueOf(((d)parame.b).a), parame.a });
    this.o = ((d)parame.b);
  }
  
  public void a(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    paramString = h(paramString);
    if (paramString.l != null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Loaded component %s", new Object[] { paramString.b.b, paramString.a, paramString.l });
      if (paramTBSOneCallback != null)
      {
        paramTBSOneCallback.onProgressChanged(0, 100);
        paramTBSOneCallback.onCompleted(paramString.l);
      }
      return;
    }
    if (paramTBSOneCallback != null)
    {
      paramTBSOneCallback.onProgressChanged(0, paramString.h);
      paramString.d.add(paramTBSOneCallback);
    }
    if (paramString.k != null)
    {
      paramString.b();
      return;
    }
    paramString.a(paramBundle);
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString == null)
    {
      com.tencent.tbs.one.impl.common.h.a("Unexpected null key when configure policy", new Throwable());
      return;
    }
    if (paramObject == null)
    {
      com.tencent.tbs.one.impl.common.h.a("Unexpected null value when configure policy", new Throwable());
      return;
    }
    this.e.put(paramString, paramObject);
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "." + paramString2;
    if (this.e.containsKey(paramString1))
    {
      paramString1 = this.e.get(paramString1);
      if ((paramString1 instanceof Boolean)) {
        return ((Boolean)paramString1).booleanValue();
      }
    }
    if (this.e.containsKey(paramString2))
    {
      paramString1 = this.e.get(paramString2);
      if ((paramString1 instanceof Boolean)) {
        return ((Boolean)paramString1).booleanValue();
      }
    }
    return false;
  }
  
  public void b(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    h(paramString).a(paramBundle, paramTBSOneCallback);
  }
  
  public final boolean b()
  {
    TBSOneManager.Policy localPolicy = a();
    return (localPolicy != TBSOneManager.Policy.BUILTIN_ONLY) && (localPolicy != TBSOneManager.Policy.LOCAL_ONLY);
  }
  
  public boolean b(String paramString)
  {
    return true;
  }
  
  public TBSOneOnlineService c()
  {
    return null;
  }
  
  public int[] c(String paramString)
  {
    return new int[] { -1 };
  }
  
  public TBSOneDebugger d()
  {
    return null;
  }
  
  public final void d(String paramString)
  {
    paramString = e(paramString);
    if (paramString != null)
    {
      paramString.f = true;
      if (paramString.m != null)
      {
        localObject = (com.tencent.tbs.one.impl.a.a)paramString.m.get();
        if (localObject != null) {
          ((com.tencent.tbs.one.impl.a.a)localObject).b();
        }
      }
      Object localObject = paramString.g;
      if (localObject != null)
      {
        localObject = ((d.a)localObject).f;
        if (localObject != null)
        {
          int i2 = localObject.length;
          int i1 = 0;
          while (i1 < i2)
          {
            String str = localObject[i1];
            paramString.b.d(str);
            i1 += 1;
          }
        }
      }
    }
  }
  
  public final com.tencent.tbs.one.impl.c.b e(String paramString)
  {
    return (com.tencent.tbs.one.impl.c.b)this.f.get(paramString);
  }
  
  public void e() {}
  
  public final com.tencent.tbs.one.impl.c.a f(String paramString)
  {
    paramString = e(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.l;
  }
  
  public final Object g(String paramString)
  {
    return this.e.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.h
 * JD-Core Version:    0.7.0.1
 */