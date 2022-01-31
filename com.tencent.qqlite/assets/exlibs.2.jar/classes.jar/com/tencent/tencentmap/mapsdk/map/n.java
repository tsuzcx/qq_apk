package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

final class n
{
  public b a;
  public a b;
  public p c = null;
  MapController d;
  b e = null;
  r f = null;
  byte[] g = new byte[0];
  boolean h = false;
  q.b i = q.b.a;
  boolean j = false;
  private m k = null;
  private o l = null;
  private View m = null;
  private MapView.a n = null;
  private MapView.b o = null;
  private boolean p = true;
  
  public n(Context paramContext)
  {
    q.c(paramContext);
    q.a(paramContext);
    q.b(paramContext);
    this.a = new b();
    this.n = this.a;
    this.c = new p(this.a);
    this.c.a();
    this.k = new m(this);
    this.b = new a(paramContext);
    l locall = new l();
    this.b.a(locall);
    this.d = new MapController(this);
    this.e = new b();
    this.e.a(this);
    this.f = new r(paramContext);
    this.f.a(this);
    this.l = new o(paramContext);
    this.l.a(this);
    this.m = this.l;
  }
  
  final View a()
  {
    return this.m;
  }
  
  final void a(MapView.b paramb)
  {
    this.o = paramb;
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      if (this.p) {
        bool = this.f.a(paramMotionEvent);
      }
      return bool;
      this.j = false;
      continue;
      this.j = true;
    }
  }
  
  final MapView.a b()
  {
    return this.n;
  }
  
  final MapView.b c()
  {
    return this.o;
  }
  
  final void d()
  {
    this.k.a(1);
  }
  
  final void e()
  {
    this.k.a();
  }
  
  final void f()
  {
    if (this.a.d == true) {}
    a locala;
    Date localDate;
    do
    {
      do
      {
        return;
        this.a.b(false);
        locala = this.b;
      } while ((q.a == q.a.c) || (q.b == null));
      localDate = q.b();
    } while ((localDate == null) || ((q.b.getYear() == localDate.getYear()) && (q.b.getMonth() == localDate.getMonth()) && (q.b.getDate() == localDate.getDate())));
    q.a = q.a.c;
    locala.a();
    locala.h.k.a(1);
  }
  
  public final void g()
  {
    this.a.d = false;
    this.k.b();
  }
  
  final void h()
  {
    this.a.d = false;
    this.k.a(1);
    this.k.a();
    this.a.b(false);
  }
  
  final void i()
  {
    this.k.a(1);
    this.k.a();
    this.a.d = true;
    this.k.c();
  }
  
  final class a
  {
    public List<i> a = null;
    public List<f> b = null;
    public List<Overlay> c = new ArrayList();
    byte[] d = new byte[0];
    byte[] e = new byte[0];
    public boolean f = false;
    public boolean g = false;
    private List<Overlay> i = new ArrayList();
    private int j = 0;
    private int k = 0;
    private final String l = "http://pwh.map.qq.com/ih?dt=tile&rt=m256&c=%s";
    private final String m = "http://rtt.map.qq.com/m?c=%s&sp=128x2";
    private int n = 0;
    private Matrix o = new Matrix();
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        return;
      }
      Object localObject = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      int i1 = ((DisplayMetrics)localObject).widthPixels;
      int i2 = ((DisplayMetrics)localObject).heightPixels;
      int i3 = (int)(i1 / 0.9F / 256.0F);
      int i4 = (int)(i2 / 0.9F / 256.0F);
      this.n = ((i1 / 256 + 1) * (i2 / 256 + 1) + (i3 + 2) * (i4 + 2));
      if (this.a == null) {
        this.a = new ArrayList();
      }
      if (this.b == null) {
        this.b = new ArrayList();
      }
      if (q.a == q.a.c) {
        a();
      }
      n.a(n.this).a(1);
      localObject = q.b.c;
      if (q.d == true) {
        localObject = q.b.b;
      }
      a((q.b)localObject, paramContext);
      n.a(n.this).a(10);
    }
    
    private static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      int i1 = paramInt3;
      if (paramBoolean == true) {
        i1 = (int)Math.pow(2.0D, paramInt4 + 1) - 1 - paramInt3;
      }
      paramInt3 = (int)Math.floor(paramInt2 / paramInt1);
      paramInt1 = (int)Math.floor(i1 / paramInt1);
      return paramInt4 + "/" + paramInt3 + "/" + paramInt1 + "/" + paramInt2 + "_" + i1;
    }
    
    private boolean a(j paramj, Context paramContext)
    {
      boolean bool1 = false;
      boolean bool2;
      if (paramj == null) {
        bool2 = bool1;
      }
      int i1;
      label57:
      label99:
      do
      {
        do
        {
          return bool2;
          bool2 = bool1;
        } while (paramj.h.equals("") == true);
        localObject = paramj.h;
        if (this.a == null) {
          break label408;
        }
        int i2 = this.a.size();
        i1 = 0;
        if (i1 >= i2) {
          break label408;
        }
        i locali = (i)this.a.get(i1);
        if ((locali == null) || (locali.h.equals(localObject) != true)) {
          break;
        }
        i1 = 1;
        bool2 = bool1;
      } while (i1 == 1);
      if (!paramj.h.equals("trafficmap_raster")) {}
      for (Object localObject = new g();; localObject = new w())
      {
        ((j)localObject).h = paramj.h;
        ((j)localObject).i = paramj.i;
        ((j)localObject).j = paramj.j;
        ((j)localObject).k = paramj.k;
        ((j)localObject).l = paramj.l;
        ((j)localObject).m = paramj.m;
        ((j)localObject).n = paramj.n;
        ((j)localObject).o = paramj.o;
        ((j)localObject).p = paramj.p;
        ((j)localObject).q = paramj.q;
        ((j)localObject).r = paramj.r;
        ((j)localObject).s = paramj.s;
        if (paramj.t != null) {
          ((j)localObject).t = new x.1(paramj.t, paramj.t);
        }
        ((w)localObject).a(n.this);
        ((w)localObject).u = new d(this.n, ((w)localObject).n, ((w)localObject).o);
        ((w)localObject).v = new k(paramContext, (j)localObject);
        ((w)localObject).v.a(((w)localObject).u);
        ((w)localObject).d();
        bool1 = false;
        i1 = this.a.size();
        if ((((w)localObject).k) && (i1 != 0)) {
          break label425;
        }
        bool1 = this.a.add(localObject);
        e();
        bool2 = bool1;
        if (((w)localObject).l != true) {
          break;
        }
        a(((w)localObject).h, true);
        return bool1;
        i1 += 1;
        break label57;
        label408:
        i1 = 0;
        break label99;
      }
      label425:
      i1 -= 1;
      for (;;)
      {
        bool2 = bool1;
        if (i1 >= 0)
        {
          paramj = (i)this.a.get(i1);
          if ((paramj != null) && (!paramj.k))
          {
            this.a.add(i1, localObject);
            bool2 = true;
          }
        }
        else
        {
          bool1 = bool2;
          if (bool2) {
            break;
          }
          bool1 = this.a.add(localObject);
          break;
        }
        i1 -= 1;
      }
    }
    
    private boolean a(String paramString, boolean paramBoolean)
    {
      if (paramString.equals("") == true) {
        return false;
      }
      int i2 = this.a.size();
      int i1 = 0;
      while (i1 < i2)
      {
        i locali = (i)this.a.get(i1);
        if ((locali != null) && (locali.h.equals(paramString) == true))
        {
          locali.l = paramBoolean;
          if (!locali.k) {
            return true;
          }
          if (paramBoolean == true)
          {
            if (locali.i > locali.j)
            {
              n.b localb = n.this.a;
              i1 = locali.i;
              if (i1 > 0) {
                localb.g.c.d = i1;
              }
              localb = n.this.a;
              i1 = locali.j;
              if (i1 > 0) {
                localb.g.c.c = i1;
              }
              n.this.c.b();
              if (n.this.a.g() > locali.i) {
                n.this.a.a(locali.i);
              }
              if (n.this.a.g() < locali.j) {
                n.this.a.a(locali.j);
              }
            }
            if (paramString.equals("") != true)
            {
              i2 = this.a.size();
              i1 = 0;
              while (i1 < i2)
              {
                locali = (i)this.a.get(i1);
                if ((locali != null) && (!locali.h.equals(paramString)) && (locali.k == true) && (locali.l == true)) {
                  locali.l = false;
                }
                i1 += 1;
              }
            }
            n.this.a.b(false);
            return true;
          }
        }
        i1 += 1;
      }
      return false;
    }
    
    private void e()
    {
      int i2 = this.a.size();
      int i1 = 0;
      while (i1 < i2)
      {
        i locali = (i)this.a.get(i1);
        if (locali != null) {
          locali.p = i1;
        }
        i1 += 1;
      }
    }
    
    final void a()
    {
      if (this.b == null) {
        return;
      }
      f localf = new f(q.c());
      synchronized (this.e)
      {
        if (this.b.size() == 0) {
          this.b.add(localf);
        }
        return;
      }
    }
    
    final void a(int paramInt)
    {
      if (this.i == null) {}
      for (;;)
      {
        return;
        int i2 = this.i.size();
        if (i2 > 0)
        {
          int i1 = 0;
          while (i1 < i2)
          {
            Overlay localOverlay = (Overlay)this.i.get(i1);
            if ((localOverlay != null) && ((localOverlay instanceof l))) {
              ((l)localOverlay).b(paramInt);
            }
            i1 += 1;
          }
        }
      }
    }
    
    final void a(int paramInt, float paramFloat)
    {
      if (this.i == null) {}
      for (;;)
      {
        return;
        int i2 = this.i.size();
        if (i2 > 0)
        {
          int i1 = 0;
          while (i1 < i2)
          {
            Overlay localOverlay = (Overlay)this.i.get(i1);
            if ((localOverlay != null) && ((localOverlay instanceof l))) {
              ((l)localOverlay).a(paramInt, paramFloat, n.b(n.this).getContext());
            }
            i1 += 1;
          }
        }
      }
    }
    
    final void a(int paramInt1, int paramInt2, Context paramContext)
    {
      if (this.i == null) {}
      for (;;)
      {
        return;
        int i2 = this.i.size();
        if (i2 > 0)
        {
          int i1 = 0;
          while (i1 < i2)
          {
            Overlay localOverlay = (Overlay)this.i.get(i1);
            if ((localOverlay != null) && ((localOverlay instanceof l))) {
              ((l)localOverlay).a(paramInt1, paramInt2, paramContext);
            }
            i1 += 1;
          }
        }
      }
    }
    
    final void a(Context paramContext)
    {
      j localj = new j();
      localj.n = true;
      localj.o = 120000L;
      localj.t = new x()
      {
        public final String a(int paramAnonymousInt, int... paramAnonymousVarArgs)
        {
          n.a locala = n.a.this;
          return String.format("http://rtt.map.qq.com/m?c=%s&sp=128x2", new Object[] { n.a.a(paramAnonymousInt, paramAnonymousVarArgs, true) });
        }
      };
      localj.h = "trafficmap_raster";
      localj.k = false;
      localj.l = true;
      localj.m = false;
      localj.i = 18;
      localj.j = 10;
      localj.r = 3;
      synchronized (this.d)
      {
        a(localj, paramContext);
        return;
      }
    }
    
    public final void a(Canvas paramCanvas)
    {
      float f1 = n.this.a.b();
      if (f1 != 1.0F)
      {
        paramCanvas.save();
        this.o.reset();
        this.o.postScale(f1, f1, n.this.c.c().x, n.this.c.c().y);
        paramCanvas.concat(this.o);
      }
      int i2 = this.a.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject1 = (i)this.a.get(i1);
        if ((localObject1 != null) && (((i)localObject1).l)) {
          ((i)localObject1).c(paramCanvas);
        }
        i1 += 1;
      }
      if (f1 != 1.0F) {
        paramCanvas.restore();
      }
      Object localObject2;
      if (n.c(n.this) != null)
      {
        localObject1 = n.c(n.this).a();
        if (localObject1 != null)
        {
          localObject2 = this.c.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Overlay localOverlay = (Overlay)((Iterator)localObject2).next();
            if (localOverlay != null) {
              localOverlay.draw(paramCanvas, (MapView)localObject1);
            }
          }
          if (n.this.i != q.b.b)
          {
            localObject2 = this.i.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((Overlay)((Iterator)localObject2).next()).draw(paramCanvas, (MapView)localObject1);
            }
          }
        }
      }
      Object localObject1 = n.this;
      if (q.a == q.a.b) {}
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0)
        {
          localObject1 = new Paint();
          ((Paint)localObject1).setColor(-65536);
          ((Paint)localObject1).setTextSize(30.0F);
          localObject2 = new Rect();
          i1 = n.this.a.e();
          i2 = n.this.a.f();
          ((Paint)localObject1).getTextBounds("鉴权失败，请到腾讯", 0, "鉴权失败，请到腾讯".length(), (Rect)localObject2);
          paramCanvas.drawText("鉴权失败，请到腾讯", i1 / 2 - ((Rect)localObject2).width() / 2, i2 / 2 - ((Rect)localObject2).height(), (Paint)localObject1);
          ((Paint)localObject1).getTextBounds("地图官网申请密钥", 0, "地图官网申请密钥".length(), (Rect)localObject2);
          paramCanvas.drawText("地图官网申请密钥", i1 / 2 - ((Rect)localObject2).width() / 2, i2 / 2 + 2, (Paint)localObject1);
        }
        return;
      }
    }
    
    protected final void a(GeoPoint paramGeoPoint)
    {
      int i1 = this.c.size() - 1;
      while (i1 >= 0)
      {
        Overlay localOverlay = (Overlay)this.c.get(i1);
        if (localOverlay != null) {
          localOverlay.onEmptyTap(paramGeoPoint);
        }
        i1 -= 1;
      }
    }
    
    public final void a(Overlay paramOverlay)
    {
      this.i.add(paramOverlay);
    }
    
    final void a(q.b arg1, Context paramContext)
    {
      if (??? == q.b.a) {}
      while (n.this.i == ???) {
        return;
      }
      ??? = "";
      if (n.this.i == q.b.b)
      {
        ??? = "map_google";
        label41:
        synchronized (this.d)
        {
          a((String)???);
          if (??? != q.b.c) {}
        }
      }
      for (;;)
      {
        synchronized (this.d)
        {
          for (;;)
          {
            ??? = new j();
            ((j)???).t = new x()
            {
              public final String a(int paramAnonymousInt, int... paramAnonymousVarArgs)
              {
                n.a locala = n.a.this;
                return String.format("http://pwh.map.qq.com/ih?dt=tile&rt=m256&c=%s", new Object[] { n.a.a(paramAnonymousInt, paramAnonymousVarArgs, false) });
              }
            };
            ((j)???).h = "map_raster";
            ((j)???).k = true;
            ((j)???).l = true;
            ((j)???).m = true;
            ((j)???).i = 18;
            ((j)???).j = 2;
            ((j)???).r = 3;
            ((j)???).s = q.b.c;
            synchronized (this.d)
            {
              a((j)???, paramContext);
              n.this.i = q.b.c;
              ??? = n.this.i;
              if (this.i == null) {
                break;
              }
              int i2 = this.i.size();
              if (i2 <= 0) {
                break;
              }
              int i1 = 0;
              while (i1 < i2)
              {
                ??? = (Overlay)this.i.get(i1);
                if ((??? != null) && ((??? instanceof l))) {
                  ((l)???).a(???, paramContext);
                }
                i1 += 1;
              }
              if (n.this.i == q.b.c)
              {
                ??? = "map_raster";
                break label41;
              }
              if (n.this.i != q.b.d) {
                break label41;
              }
              ??? = "map_satellite";
              break label41;
              ??? = finally;
              throw ???;
            }
          }
        }
        if (??? == q.b.d)
        {
          synchronized (this.d)
          {
            ??? = new j();
            ((j)???).t = new x()
            {
              public final String a(int paramAnonymousInt, int... paramAnonymousVarArgs)
              {
                if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length != 3)) {
                  return null;
                }
                n.a.d(n.a.this);
                if (n.a.e(n.a.this) > 3) {
                  n.a.f(n.a.this);
                }
                int j = n.a.e(n.a.this);
                int i = j;
                if (j > 3) {
                  i = 3;
                }
                j = paramAnonymousVarArgs[0];
                int k = paramAnonymousVarArgs[1];
                int m = paramAnonymousVarArgs[2];
                paramAnonymousVarArgs = n.a.this;
                paramAnonymousVarArgs = n.a.a(paramAnonymousInt, j, k, m + 1);
                return "http://p" + i + ".map.gtimg.com/sateTiles/" + paramAnonymousVarArgs + ".jpg";
              }
            };
            ((j)???).h = "map_satellite";
            ((j)???).k = true;
            ((j)???).l = true;
            ((j)???).m = true;
            ((j)???).i = 17;
            ((j)???).j = 1;
            ((j)???).r = 1;
            ((j)???).s = q.b.d;
          }
          synchronized (this.d)
          {
            a((j)???, paramContext);
            n.this.i = q.b.d;
            continue;
            paramContext = finally;
            throw paramContext;
          }
        }
        if (??? != q.b.b) {
          continue;
        }
        synchronized (this.d)
        {
          ??? = new j();
          ((j)???).t = new x()
          {
            public final String a(int paramAnonymousInt, int... paramAnonymousVarArgs)
            {
              if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length != 3)) {
                return null;
              }
              n.a.a(n.a.this);
              if (n.a.b(n.a.this) > 3) {
                n.a.c(n.a.this);
              }
              int i = n.a.b(n.a.this);
              paramAnonymousInt = i;
              if (i > 3) {
                paramAnonymousInt = 3;
              }
              i = paramAnonymousVarArgs[0];
              int j = paramAnonymousVarArgs[1];
              int k = paramAnonymousVarArgs[2];
              int m = (int)Math.pow(2.0D, paramAnonymousVarArgs[2] + 1);
              return "http://mt" + paramAnonymousInt + ".google.com/vt/lyrs=m@159000000&hl=zh-CN&gl=cn&x=" + i + "&y=" + (m - 1 - j) + "&z=" + (k + 1) + "&s=Gali";
            }
          };
          ((j)???).h = "map_google";
          ((j)???).k = true;
          ((j)???).l = true;
          ((j)???).m = true;
          ((j)???).i = 18;
          ((j)???).j = 2;
          ((j)???).r = 1;
          ((j)???).s = q.b.b;
        }
        synchronized (this.d)
        {
          a((j)???, paramContext);
          n.this.i = q.b.b;
          continue;
          paramContext = finally;
          throw paramContext;
        }
      }
    }
    
    public final boolean a(MotionEvent paramMotionEvent)
    {
      boolean bool2 = false;
      if (n.c(n.this) == null) {}
      MapView localMapView;
      do
      {
        return bool2;
        localMapView = n.c(n.this).a();
      } while (localMapView == null);
      boolean bool1 = false;
      Iterator localIterator = this.c.iterator();
      do
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        Overlay localOverlay = (Overlay)localIterator.next();
        bool2 = bool1;
        if (localOverlay != null) {
          bool2 = localOverlay.onTouchEvent(paramMotionEvent, localMapView);
        }
        bool1 = bool2;
      } while (!bool2);
      return bool2;
    }
    
    final boolean a(String paramString)
    {
      if (paramString.equals("") == true) {}
      for (;;)
      {
        return false;
        a(paramString, false);
        int i2 = this.a.size();
        int i1 = 0;
        while (i1 < i2)
        {
          i locali = (i)this.a.get(i1);
          if ((locali != null) && (locali.h.equals(paramString)))
          {
            locali.l = false;
            this.a.remove(locali);
            locali.b();
            e();
            return true;
          }
          i1 += 1;
        }
      }
    }
    
    public final void b()
    {
      int i2 = this.c.size();
      int i1 = 0;
      Overlay localOverlay;
      while (i1 < i2)
      {
        localOverlay = (Overlay)this.c.remove(0);
        if (localOverlay != null) {
          localOverlay.onRemoveOverlay();
        }
        i1 += 1;
      }
      i2 = this.i.size();
      i1 = 0;
      while (i1 < i2)
      {
        localOverlay = (Overlay)this.i.remove(0);
        if (localOverlay != null) {
          localOverlay.onRemoveOverlay();
        }
        i1 += 1;
      }
    }
    
    final void b(int paramInt)
    {
      if (this.i == null) {}
      for (;;)
      {
        return;
        int i2 = this.i.size();
        if (i2 > 0)
        {
          int i1 = 0;
          while (i1 < i2)
          {
            Overlay localOverlay = (Overlay)this.i.get(i1);
            if ((localOverlay != null) && ((localOverlay instanceof l))) {
              ((l)localOverlay).a(paramInt);
            }
            i1 += 1;
          }
        }
      }
    }
    
    protected final boolean b(MotionEvent paramMotionEvent)
    {
      if (n.c(n.this) == null) {}
      for (;;)
      {
        return false;
        MapView localMapView = n.c(n.this).a();
        if (localMapView != null)
        {
          paramMotionEvent = n.this.c.k.fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
          int i1 = this.c.size() - 1;
          while (i1 >= 0)
          {
            Overlay localOverlay = (Overlay)this.c.get(i1);
            if ((localOverlay != null) && (localOverlay.onTap(paramMotionEvent, localMapView))) {
              return true;
            }
            i1 -= 1;
          }
        }
      }
    }
    
    public final void c()
    {
      if (this.b != null) {}
      int i2;
      int i1;
      synchronized (this.e)
      {
        i2 = this.b.size();
        i1 = 0;
        while (i1 < i2)
        {
          this.b.remove(0);
          i1 += 1;
        }
        if (this.a == null) {}
      }
      synchronized (this.d)
      {
        i2 = this.a.size();
        i1 = 0;
        while (i1 < i2)
        {
          i locali = (i)this.a.remove(0);
          if (locali != null) {
            locali.b();
          }
          i1 += 1;
          continue;
          localObject1 = finally;
          throw localObject1;
        }
        return;
      }
    }
    
    final void c(int paramInt)
    {
      if (this.i == null) {}
      for (;;)
      {
        return;
        int i2 = this.i.size();
        if (i2 > 0)
        {
          int i1 = 0;
          while (i1 < i2)
          {
            Overlay localOverlay = (Overlay)this.i.get(i1);
            if ((localOverlay != null) && ((localOverlay instanceof l))) {
              ((l)localOverlay).c(paramInt);
            }
            i1 += 1;
          }
        }
      }
    }
    
    public final boolean c(MotionEvent paramMotionEvent)
    {
      if (n.c(n.this) == null) {}
      for (;;)
      {
        return false;
        MapView localMapView = n.c(n.this).a();
        if (localMapView != null)
        {
          GeoPoint localGeoPoint = n.this.c.k.fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
          int i1 = this.c.size() - 1;
          while (i1 >= 0)
          {
            Overlay localOverlay = (Overlay)this.c.get(i1);
            if ((localOverlay != null) && (localOverlay.onLongPress(localGeoPoint, paramMotionEvent, localMapView))) {
              return true;
            }
            i1 -= 1;
          }
        }
      }
    }
    
    public final boolean d()
    {
      boolean bool2 = false;
      v.c localc2 = n.this.c.g();
      v.c localc1 = null;
      int i2 = this.a.size();
      int i1 = 0;
      for (;;)
      {
        localObject = localc1;
        if (i1 < i2)
        {
          localObject = (j)this.a.get(i1);
          if ((localObject != null) && (((j)localObject).k))
          {
            localObject = (g)localObject;
            if (((g)localObject).k == true) {
              localObject = ((g)localObject).w;
            }
          }
        }
        else
        {
          if (localObject != null) {
            break;
          }
          return false;
        }
        i1 += 1;
      }
      Object localObject = ((List)localObject).iterator();
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localc1 = (v.c)((Iterator)localObject).next();
      } while ((localc1.a != localc2.a) || (localc1.b != localc2.b) || (localc1.c != localc2.c));
      boolean bool1 = bool2;
      if (localc1.g != null) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public final class b
    implements MapView.a
  {
    boolean a = false;
    boolean b = false;
    boolean c = true;
    public boolean d = false;
    GeoPoint e = null;
    GeoPoint f = null;
    private int h = 0;
    private int i = 0;
    private double j = 1.0D;
    private final float k;
    private final float l;
    private final float m = 0.9F;
    private float n = 0.0F;
    private float o = 0.0F;
    
    public b()
    {
      if (q.a())
      {
        this.k = 1.0F;
        this.l = 2.0F;
        return;
      }
      this.k = 0.9F;
      this.l = 1.8F;
    }
    
    private void a(PointF paramPointF)
    {
      n.this.c.a.x = paramPointF.x;
      n.this.c.a.y = paramPointF.y;
      n.this.c.e();
    }
    
    private static void a(MapView paramMapView, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      paramView.measure(paramInt1, paramInt2);
      int i1;
      label29:
      int i2;
      if (paramInt1 == -2)
      {
        i1 = paramView.getMeasuredWidth();
        if (paramInt2 != -2) {
          break label101;
        }
        paramInt1 = paramView.getMeasuredHeight();
        i2 = paramInt5 & 0x7;
        paramInt5 &= 0x70;
        if (i2 != 5) {
          break label116;
        }
        paramInt2 = paramInt3 - i1;
        label55:
        if (paramInt5 != 80) {
          break label136;
        }
        paramInt3 = paramInt4 - paramInt1;
      }
      for (;;)
      {
        paramView.layout(paramInt2, paramInt3, paramInt2 + i1, paramInt3 + paramInt1);
        return;
        i1 = paramInt1;
        if (paramInt1 != -1) {
          break;
        }
        i1 = paramMapView.getMeasuredWidth();
        break;
        label101:
        paramInt1 = paramInt2;
        if (paramInt2 != -1) {
          break label29;
        }
        paramInt1 = paramMapView.getMeasuredHeight();
        break label29;
        label116:
        paramInt2 = paramInt3;
        if (i2 != 1) {
          break label55;
        }
        paramInt2 = paramInt3 - i1 / 2;
        break label55;
        label136:
        paramInt3 = paramInt4;
        if (paramInt5 == 16) {
          paramInt3 = paramInt4 - paramInt1 / 2;
        }
      }
    }
    
    final void a()
    {
      this.j = 1.0D;
    }
    
    public final void a(double paramDouble)
    {
      double d1 = paramDouble * this.j;
      int i2 = g();
      int i3 = c();
      int i4 = d();
      if (d1 > this.l) {
        for (;;)
        {
          i1 = i2;
          paramDouble = d1;
          if (d1 <= this.l) {
            break;
          }
          i1 = i2;
          paramDouble = d1;
          if (i2 >= i3) {
            break;
          }
          d1 /= 2.0D;
          i2 += 1;
        }
      }
      int i1 = i2;
      paramDouble = d1;
      if (d1 < this.k) {
        for (;;)
        {
          i1 = i2;
          paramDouble = d1;
          if (d1 >= this.k) {
            break;
          }
          i1 = i2;
          paramDouble = d1;
          if (i2 <= i4) {
            break;
          }
          d1 *= 2.0D;
          i2 -= 1;
        }
      }
      d1 = paramDouble;
      if (i1 == i3)
      {
        d1 = paramDouble;
        if (paramDouble > 1.0D) {
          d1 = 1.0D;
        }
      }
      paramDouble = d1;
      if (i1 == i4)
      {
        paramDouble = d1;
        if (d1 < 1.0D) {
          paramDouble = 1.0D;
        }
      }
      this.j = paramDouble;
      if (i1 != g())
      {
        a(i1);
        return;
      }
      if (n.c(n.this) != null)
      {
        MapView localMapView = n.c(n.this).a();
        if (localMapView != null) {
          localMapView.invalidate();
        }
      }
      n.b(n.this).requestLayout();
    }
    
    final void a(float paramFloat1, float paramFloat2)
    {
      if (this.c == true) {}
      do
      {
        return;
        this.n += paramFloat1;
        this.o += paramFloat2;
        if (Math.abs((int)this.n) >= this.h)
        {
          this.c = true;
          return;
        }
      } while (Math.abs((int)this.o) < this.i);
      this.c = true;
    }
    
    public final void a(int paramInt)
    {
      if (paramInt != n.this.c.e)
      {
        if (paramInt > n.this.c.e) {
          a(false);
        }
        n.this.c.f();
        n.this.c.e = paramInt;
        n.this.c.b();
        Object localObject;
        if (n.c(n.this) != null)
        {
          localObject = n.c(n.this).a();
          if (localObject != null)
          {
            ((MapView)localObject).b();
            ((MapView)localObject).a(true, true);
          }
        }
        int i1 = n.this.b.a.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject = (i)n.this.b.a.get(paramInt);
          if (localObject != null) {
            ((i)localObject).f();
          }
          paramInt += 1;
        }
      }
      b(false);
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != this.h) || (paramInt2 != this.i))
      {
        this.h = paramInt1;
        this.i = paramInt2;
        b(false);
      }
    }
    
    public final void a(GeoPoint paramGeoPoint)
    {
      if (paramGeoPoint == null) {
        return;
      }
      a(true);
      a(n.this.c.a(paramGeoPoint, n.this.c.e));
      b(false);
    }
    
    final void a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, boolean paramBoolean)
    {
      if ((paramGeoPoint1 == null) || (paramGeoPoint2 == null)) {}
      int i1;
      int i2;
      do
      {
        return;
        if ((this.h == 0) || (this.i == 0))
        {
          this.e = paramGeoPoint1;
          this.f = paramGeoPoint2;
          return;
        }
        i1 = n.this.a.c();
        PointF localPointF1 = n.this.c.a(paramGeoPoint1, i1);
        PointF localPointF2 = n.this.c.a(paramGeoPoint2, i1);
        float f2 = localPointF2.x - localPointF1.x;
        float f1 = f2;
        if (f2 < 0.0F) {
          f1 = Math.abs(f2);
        }
        float f3 = localPointF2.y - localPointF1.y;
        f2 = f3;
        if (f3 < 0.0F) {
          f2 = Math.abs(f3);
        }
        f3 = (float)this.j;
        i1 = this.h;
        i2 = this.i;
        i1 = (int)Math.ceil(Math.max(Math.log(f1 * f3 / i1) / Math.log(2.0D), Math.log(f2 * f3 / i2) / Math.log(2.0D)));
        if (paramBoolean == true)
        {
          paramGeoPoint1 = new GeoPoint((paramGeoPoint1.getLatitudeE6() + paramGeoPoint2.getLatitudeE6()) / 2, (paramGeoPoint1.getLongitudeE6() + paramGeoPoint2.getLongitudeE6()) / 2);
          n.this.d.animateTo(paramGeoPoint1);
        }
        i1 = c() - i1;
        i2 = g();
      } while (i2 == i1);
      if (i1 > i2)
      {
        n.this.e.a(i1 - i2);
        return;
      }
      n.this.e.b(i2 - i1);
    }
    
    final void a(boolean paramBoolean)
    {
      this.c = paramBoolean;
      if (!paramBoolean)
      {
        this.n = 0.0F;
        this.o = 0.0F;
      }
    }
    
    public final float b()
    {
      return (float)this.j;
    }
    
    public final void b(GeoPoint paramGeoPoint)
    {
      if (paramGeoPoint == null) {
        return;
      }
      a(n.this.c.a(paramGeoPoint, n.this.c.e));
      b(false);
    }
    
    public final void b(boolean paramBoolean)
    {
      if ((n.this.c == null) || (n.this.b == null)) {}
      Object localObject;
      do
      {
        return;
        n.this.c.f();
        localObject = new ArrayList();
        int i2 = n.this.b.a.size();
        int i1 = 0;
        while (i1 < i2)
        {
          i locali = (i)n.this.b.a.get(i1);
          if (locali != null) {
            locali.a((ArrayList)localObject, paramBoolean);
          }
          i1 += 1;
        }
        ((ArrayList)localObject).clear();
        localObject = n.c(n.this).a();
      } while (localObject == null);
      ((MapView)localObject).postInvalidate();
      ((MapView)localObject).requestLayout();
    }
    
    public final int c()
    {
      return n.this.c.d;
    }
    
    public final void c(GeoPoint paramGeoPoint)
    {
      GeoPoint localGeoPoint = n.this.a.h();
      if ((paramGeoPoint != null) && (!paramGeoPoint.equals(localGeoPoint)))
      {
        a(n.this.c.a(paramGeoPoint, n.this.c.e));
        b(true);
      }
    }
    
    public final int d()
    {
      return n.this.c.c;
    }
    
    public final int e()
    {
      return this.h;
    }
    
    public final int f()
    {
      return this.i;
    }
    
    public final int g()
    {
      return n.this.c.e;
    }
    
    public final GeoPoint h()
    {
      return n.this.c.b(n.this.c.a, n.this.c.e);
    }
    
    public final void i()
    {
      if (n.c(n.this) != null)
      {
        MapView localMapView = n.c(n.this).a();
        if (localMapView != null)
        {
          int i2 = localMapView.getChildCount();
          int i1 = 0;
          if (i1 < i2)
          {
            View localView = localMapView.getChildAt(i1);
            MapView.LayoutParams localLayoutParams;
            if ((localView != null) && ((localView.getLayoutParams() instanceof MapView.LayoutParams)))
            {
              localLayoutParams = (MapView.LayoutParams)localView.getLayoutParams();
              if (localLayoutParams.mode != 0) {
                break label179;
              }
              if (localLayoutParams.point != null)
              {
                Point localPoint = n.this.c.k.toPixels(localLayoutParams.point, null);
                localPoint.x += localLayoutParams.x;
                localPoint.y += localLayoutParams.y;
                a(localMapView, localView, localLayoutParams.width, localLayoutParams.height, localPoint.x, localPoint.y, localLayoutParams.alignment);
              }
            }
            for (;;)
            {
              i1 += 1;
              break;
              label179:
              a(localMapView, localView, localLayoutParams.width, localLayoutParams.height, localLayoutParams.x, localLayoutParams.y, localLayoutParams.alignment);
            }
          }
          localMapView.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.n
 * JD-Core Version:    0.7.0.1
 */