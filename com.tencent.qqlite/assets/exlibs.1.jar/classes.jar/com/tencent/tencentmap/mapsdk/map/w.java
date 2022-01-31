package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

class w
  extends i
{
  byte[] A = new byte[0];
  byte[] B = new byte[0];
  protected d u = null;
  protected k v = null;
  protected List<v.c> w = null;
  protected List<v.a> x = null;
  protected List<v.a> y = null;
  protected List<v.a> z = null;
  
  protected static boolean a(List<v.a> paramList, v.a parama)
  {
    if ((paramList == null) || (parama == null)) {}
    for (;;)
    {
      return false;
      int j = paramList.size();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          v.a locala = (v.a)paramList.get(i);
          if ((locala != null) && (locala.equals(parama))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  protected static void b(List<v.c> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        v.c localc = (v.c)paramList.remove(0);
        if (localc != null) {
          localc.g = null;
        }
        i += 1;
      }
    }
  }
  
  private boolean b(v.a parama)
  {
    synchronized (this.B)
    {
      if (this.x == null) {
        return false;
      }
      if (!this.x.contains(parama)) {
        return false;
      }
    }
    boolean bool = this.x.remove(parama);
    return bool;
  }
  
  private ArrayList<v.a> h()
  {
    int i;
    synchronized (this.B)
    {
      if (this.y == null) {
        return null;
      }
      i = this.y.size();
      if (i <= 0) {
        return null;
      }
    }
    ArrayList localArrayList = new ArrayList();
    int j = this.r;
    if (i > j)
    {
      i = j;
      break label167;
      if (j < i)
      {
        v.a locala = (v.a)this.y.remove(0);
        if (locala != null)
        {
          locala.d = this.s;
          localArrayList.add(locala);
          if ((this.x != null) && (this.x.contains(locala) != true)) {
            this.x.add(locala);
          }
        }
      }
      else
      {
        if (this.y.size() > 0) {
          i();
        }
        return localArrayList;
      }
    }
    for (;;)
    {
      label167:
      j = 0;
      break;
      j += 1;
      break;
    }
  }
  
  private void i()
  {
    if (this.f != null) {
      this.f.d();
    }
  }
  
  protected void a()
  {
    this.u.a.a();
    synchronized (this.A)
    {
      this.z.clear();
    }
    synchronized (this.B)
    {
      this.y.clear();
      this.x.clear();
      if (this.w != null)
      {
        int j = this.w.size();
        int i = 0;
        while (i < j)
        {
          ??? = (v.c)this.w.remove(0);
          if (??? != null) {
            ((v.c)???).g = null;
          }
          i += 1;
          continue;
          localObject2 = finally;
          throw localObject2;
        }
      }
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    int j = this.w.size();
    if (j <= 0) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < j)
      {
        v.c localc = (v.c)this.w.get(i);
        if (localc != null)
        {
          Bitmap localBitmap2 = localc.g;
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 == null)
          {
            a(localc);
            localBitmap1 = localc.g;
          }
          if (localBitmap1 != null) {
            paramCanvas.drawBitmap(localBitmap1, localc.e, localc.f, null);
          }
        }
        i += 1;
      }
    }
  }
  
  final void a(v.a parama)
  {
    if (parama == null) {}
    while (this.z == null) {
      return;
    }
    synchronized (this.A)
    {
      this.z.add(parama);
      if (this.f != null)
      {
        parama = this.f.c();
        if (parama != null)
        {
          parama = parama.a();
          if (parama != null) {
            parama.postInvalidate();
          }
        }
      }
      Thread.yield();
      return;
    }
  }
  
  protected final void a(v.a parama, ArrayList<v.a> paramArrayList)
  {
    for (;;)
    {
      int i;
      synchronized (this.B)
      {
        if (this.y == null) {
          return;
        }
        if (paramArrayList != null)
        {
          int j = paramArrayList.size();
          i = 0;
          if (i < j)
          {
            v.a locala = (v.a)paramArrayList.get(i);
            if ((locala == null) || (a(this.x, locala))) {
              break label120;
            }
            this.y.add(locala);
            break label120;
          }
        }
        if ((parama != null) && (!a(this.x, parama))) {
          this.y.add(parama);
        }
        i();
        return;
      }
      label120:
      i += 1;
    }
  }
  
  protected final void a(v.c paramc)
  {
    if (paramc == null) {}
    while (this.z == null) {
      return;
    }
    int j;
    synchronized (this.A)
    {
      j = this.z.size();
      if (j <= 0) {
        return;
      }
    }
    int i = 0;
    for (;;)
    {
      v.a locala;
      if (i < j)
      {
        locala = (v.a)this.z.get(i);
        if (locala == null) {
          return;
        }
      }
      try
      {
        if (!locala.equals(paramc))
        {
          k = i;
          m = j;
        }
        else
        {
          paramc.g = this.u.a(paramc.toString()).a;
          boolean bool = this.z.remove(locala);
          k = i;
          m = j;
          if (bool == true)
          {
            k = i - 1;
            m = j - 1;
          }
        }
      }
      catch (Exception localException)
      {
        int m = j;
        int k = i;
        i = k + 1;
        j = m;
      }
      return;
    }
  }
  
  protected void a(ArrayList<v.b> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null) {
      return;
    }
    b(this.w);
    for (;;)
    {
      int i;
      synchronized (this.A)
      {
        this.z.clear();
        i = this.f.a.g();
        if ((i > this.i) || (i < this.j)) {
          break;
        }
        ??? = paramArrayList;
        if (paramArrayList.size() == 0) {
          ??? = this.f.c.a(i, this.f.a.e(), this.f.a.f(), this.f.a.b());
        }
        i = this.f.a.g();
        if (??? == null)
        {
          paramArrayList = null;
          if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            if (this.m != true) {
              break label437;
            }
            a(null);
          }
          if (paramArrayList == null) {
            break;
          }
          paramArrayList.clear();
          return;
        }
      }
      if (!this.l)
      {
        paramArrayList = null;
      }
      else if ((i > this.i) || (i < this.j))
      {
        paramArrayList = null;
      }
      else
      {
        int j = ((ArrayList)???).size();
        if (j <= 0)
        {
          paramArrayList = null;
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          i = 0;
          for (;;)
          {
            paramArrayList = localArrayList;
            if (i >= j) {
              break;
            }
            paramArrayList = (v.b)((ArrayList)???).get(i);
            if (paramArrayList != null)
            {
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramArrayList.a);
              ((StringBuilder)localObject2).append("-");
              ((StringBuilder)localObject2).append(paramArrayList.b);
              ((StringBuilder)localObject2).append("-");
              ((StringBuilder)localObject2).append(paramArrayList.c);
              localObject2 = this.u.a(((StringBuilder)localObject2).toString());
              v.c localc = new v.c(paramArrayList.a, paramArrayList.b, paramArrayList.c);
              localc.e = paramArrayList.e;
              localc.f = paramArrayList.f;
              if (localObject2 != null) {
                localc.g = ((e.a)localObject2).a;
              }
              this.w.add(localc);
              if ((!paramBoolean) && (localc.g == null)) {
                localArrayList.add(new v.a(paramArrayList.a, paramArrayList.b, paramArrayList.c));
              }
            }
            i += 1;
          }
          label437:
          a(paramArrayList);
        }
      }
    }
  }
  
  protected final void a(List<v.a> paramList)
  {
    synchronized (this.B)
    {
      if (this.y == null) {
        return;
      }
      this.y.clear();
      if (paramList == null) {
        return;
      }
    }
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        v.a locala = (v.a)paramList.get(i);
        if ((locala != null) && (!a(this.x, locala))) {
          this.y.add(locala);
        }
      }
      else
      {
        i();
        return;
      }
      i += 1;
    }
  }
  
  protected void b()
  {
    this.g = true;
    this.u.a.a();
    synchronized (this.A)
    {
      this.z.clear();
    }
    synchronized (this.B)
    {
      this.y.clear();
      this.y = null;
      this.x.clear();
      this.x = null;
      if (this.w == null) {
        return;
      }
      int j = this.w.size();
      int i = 0;
      while (i < j)
      {
        ??? = (v.c)this.w.remove(0);
        if (??? != null) {
          ((v.c)???).g = null;
        }
        i += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
    }
    this.w = null;
  }
  
  protected void b(Canvas paramCanvas) {}
  
  protected void c() {}
  
  protected final void c(Canvas paramCanvas)
  {
    if (this.w == null) {
      return;
    }
    b(paramCanvas);
    a(paramCanvas);
  }
  
  protected void d()
  {
    this.w = new ArrayList();
    this.x = new ArrayList();
    this.y = new ArrayList();
    this.z = new ArrayList();
  }
  
  protected int e()
  {
    return 10;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof w)) {
      return false;
    }
    paramObject = (w)paramObject;
    return this.h.equals(paramObject.h);
  }
  
  protected void f() {}
  
  protected final void g()
  {
    if (this.g == true) {}
    ArrayList localArrayList;
    Object localObject1;
    do
    {
      int j;
      do
      {
        do
        {
          return;
          localArrayList = h();
        } while (localArrayList == null);
        j = localArrayList.size();
      } while (j <= 0);
      localObject1 = null;
      Object localObject2;
      if (this.t != null)
      {
        u localu = new u(localArrayList);
        localu.d = ((v.a)localArrayList.get(0)).d;
        localu.a(this);
        localObject2 = (Boolean)localu.b();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Boolean.valueOf(false);
        }
        localu.a(null);
      }
      int i = 0;
      while (i < j)
      {
        localObject2 = (v.a)localArrayList.get(i);
        if (localObject2 != null) {
          b((v.a)localObject2);
        }
        i += 1;
      }
    } while (((Boolean)localObject1).booleanValue());
    a(null, localArrayList);
  }
  
  public int hashCode()
  {
    return this.p;
  }
  
  public String toString()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.w
 * JD-Core Version:    0.7.0.1
 */