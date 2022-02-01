package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.map.sdk.engine.jni.callbacks.TileOverlayCallback;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

public class ix
  extends mu
  implements TileOverlayCallback
{
  static final String h = "%s" + File.separatorChar + "%d-%d-%d";
  public int i;
  public Map<String, Integer> j = new Hashtable();
  public iy k;
  TileOverlayOptions l;
  public ny<iu> m;
  private qg n;
  private BlockingQueue<Runnable> o;
  private qf p = new ix.1(this);
  
  public ix(iy paramiy, TileOverlayOptions paramTileOverlayOptions)
  {
    this.k = paramiy;
    this.l = paramTileOverlayOptions;
    if ((this.k == null) || (this.l == null))
    {
      this.i = -1;
      return;
    }
    this.m = l();
    paramiy = this.k;
    boolean bool = this.l.isBetterQuality();
    if (paramiy.a == null) {}
    for (;;)
    {
      this.i = i1;
      "zl create tileOverlay:".concat(String.valueOf(this));
      new StringBuilder("id:").append(this.i).toString();
      os.a();
      a(this.l.getZIndex());
      return;
      i1 = paramiy.a.a(this, bool);
    }
  }
  
  private void k()
  {
    if (this.m == null) {
      return;
    }
    if ((this.m instanceof ob))
    {
      ny localny = ((ob)this.m).a(0);
      if ((localny instanceof og)) {
        localny.a();
      }
      localny = ((ob)this.m).a(1);
      if ((localny instanceof oe)) {
        ((oe)localny).b();
      }
    }
    for (;;)
    {
      this.j.clear();
      return;
      if ((this.m instanceof og)) {
        this.m.a();
      }
    }
  }
  
  private ny<iu> l()
  {
    if (this.k == null) {
      return null;
    }
    og.a locala = new og.a();
    locala.a = this.l.getMaxMemoryCacheSize();
    locala.b = new a((byte)0);
    if ((!TextUtils.isEmpty(this.k.c)) && (this.l != null) && (!TextUtils.isEmpty(this.l.getDiskCacheDir())))
    {
      oe.c localc = new oe.c();
      if (!TextUtils.isEmpty(g())) {
        localc.a();
      }
      String str = g() + this.l.getDiskCacheDir();
      localc.a = new File(this.k.c);
      localc.b = str;
      localc.h = -1;
      localc.i = new it();
      localc.c = new iv(this.k.c + File.separator + str);
      return oc.a(iu.class, new ny.a[] { locala, localc });
    }
    return oc.a(iu.class, new ny.a[] { locala });
  }
  
  public final void a(int paramInt)
  {
    if ((this.k == null) || (this.i < 0)) {
      return;
    }
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    paramInt = e(i1);
    this.k.a(this.i, paramInt);
  }
  
  public final void a(String paramString)
  {
    if ((this.l == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.l.diskCacheDir(paramString);
    this.m = l();
  }
  
  public final void a(GL10 paramGL10) {}
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void b()
  {
    if ((this.k == null) || (this.i < 0)) {}
    Object localObject;
    int i1;
    do
    {
      do
      {
        return;
        k();
        if (this.n != null)
        {
          this.n.a();
          this.n = null;
        }
        localObject = this.k;
        i1 = this.i;
      } while (((iy)localObject).a == null);
      ((iy)localObject).b.remove(Integer.valueOf(i1));
      localObject = ((iy)localObject).a;
    } while ((((pf)localObject).b == 0L) || (((pf)localObject).f == null));
    ((pf)localObject).f.a(new pf.26((pf)localObject, i1));
  }
  
  public final void c() {}
  
  public final void d() {}
  
  protected int e(int paramInt)
  {
    return paramInt + 100;
  }
  
  public final qg e()
  {
    if (this.n == null)
    {
      this.n = new qg();
      this.o = new LinkedBlockingQueue();
      this.n.a(this.p);
      this.n.b = new ThreadPoolExecutor(16, 32, 0L, TimeUnit.MILLISECONDS, this.o, new b(this));
    }
    return this.n;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while ((!(paramObject instanceof ix)) || (this.i != ((ix)paramObject).i)) {
      return false;
    }
    return true;
  }
  
  public final void f()
  {
    if ((this.k == null) || (this.i < 0)) {}
    for (;;)
    {
      return;
      k();
      Object localObject = this.k;
      int i1 = this.i;
      if (((iy)localObject).a != null)
      {
        localObject = ((iy)localObject).a;
        if ((((pf)localObject).b != 0L) && (((pf)localObject).f != null)) {
          break label74;
        }
      }
      while (this.o != null)
      {
        this.o.clear();
        return;
        label74:
        ((pf)localObject).f.a(new pf.27((pf)localObject, i1));
      }
    }
  }
  
  protected String g()
  {
    return "/tile/";
  }
  
  public final void h() {}
  
  public int hashCode()
  {
    return this.L.hashCode();
  }
  
  public Bitmap onLoadTile(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if ((this.l == null) || (this.l.getTileProvider() == null)) {
      return null;
    }
    Object localObject1 = om.b(this.l.getVersionInfo());
    localObject1 = String.format(h, new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    os.e();
    int i1 = os.d();
    os.d();
    os.d();
    os.d();
    Object localObject2 = (iu)oc.a(this.m).b((String)localObject1, iu.class);
    if (localObject2 != null)
    {
      i1 = os.e();
      os.g();
    }
    "get from cache of cacheId:".concat(String.valueOf(localObject1));
    "cacheCount:".concat(String.valueOf(i1));
    os.a();
    if (localObject2 != null)
    {
      this.j.remove(localObject1);
      return ((ok)localObject2).b;
    }
    localObject2 = (Integer)this.j.get(localObject1);
    if ((localObject2 != null) && (((Integer)localObject2).intValue() > 10))
    {
      paramArrayOfByte = this.j.entrySet().iterator();
      paramInt1 = 0;
      if (paramArrayOfByte.hasNext())
      {
        if (((Integer)((Map.Entry)paramArrayOfByte.next()).getValue()).intValue() <= 10) {
          break label401;
        }
        paramInt1 += 1;
      }
    }
    label401:
    for (;;)
    {
      if (paramInt1 > 50)
      {
        or.b("超过50个瓦片请求大于10次，重新加载TileOverlay");
        f();
        return null;
      }
      break;
      Map localMap = this.j;
      if (localObject2 == null) {}
      for (i1 = 0;; i1 = ((Integer)localObject2).intValue() + 1)
      {
        localMap.put(localObject1, Integer.valueOf(i1));
        localObject1 = (128 + "tileOverlay://getTile/" + this.i + "?x=" + paramInt1 + "&y=" + paramInt2 + "&z=" + paramInt3).getBytes();
        System.arraycopy(localObject1, 0, paramArrayOfByte, 0, localObject1.length);
        return null;
      }
    }
  }
  
  public void onWriteTile(int paramInt1, int paramInt2, int paramInt3, String paramString, byte[] paramArrayOfByte) {}
  
  static final class a
    implements ny.b<iu>
  {}
  
  static final class b
    implements ThreadFactory
  {
    private final ThreadGroup a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final String c;
    
    b(ix paramix)
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.a = ((ThreadGroup)localObject);
        this.c = ("tileOverlay-" + paramix.i + "-thread-");
        return;
      }
    }
    
    public final Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.a, paramRunnable, this.c + this.b.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      if (paramRunnable.getPriority() != 5) {
        paramRunnable.setPriority(5);
      }
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ix
 * JD-Core Version:    0.7.0.1
 */