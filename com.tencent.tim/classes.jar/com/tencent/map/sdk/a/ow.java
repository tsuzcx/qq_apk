package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class ow
{
  private static final j<Object> a = new ow.1();
  
  @NonNull
  public static <T extends g> f<T> a(int paramInt, @NonNull d<T> paramd)
  {
    return a(new ow.i.b(paramInt), paramd);
  }
  
  public static f<h<Bitmap>> a(@NonNull a parama)
  {
    return a(10, new ow.2(parama));
  }
  
  @NonNull
  private static <T extends g> f<T> a(@NonNull f<T> paramf, @NonNull d<T> paramd)
  {
    return a(paramf, paramd, a);
  }
  
  @NonNull
  private static <T> f<T> a(@NonNull f<T> paramf, @NonNull d<T> paramd, @NonNull j<T> paramj)
  {
    return new e(paramf, paramd, paramj);
  }
  
  public static final class a
  {
    public int a = 256;
    public int b = 256;
    public Bitmap.Config c;
    
    public a(Bitmap.Config paramConfig)
    {
      this.c = paramConfig;
    }
    
    public final void a(a parama)
    {
      if (parama != null)
      {
        this.a = parama.a;
        this.b = parama.b;
        this.c = parama.c;
      }
    }
  }
  
  static abstract class b<T>
    implements ow.d<T>
  {
    ow.a a;
    
    b(ow.a parama)
    {
      this.a = parama;
    }
  }
  
  public static final class c
    extends ow.k
  {
    private volatile boolean a;
    
    public final void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
  }
  
  public static abstract interface d<T>
  {
    public abstract T a();
  }
  
  static final class e<T>
    implements ow.f<T>
  {
    private final ow.d<T> a;
    private final ow.j<T> b;
    private final ow.f<T> c;
    
    e(@NonNull ow.f<T> paramf, @NonNull ow.d<T> paramd, @NonNull ow.j<T> paramj)
    {
      this.c = paramf;
      this.a = paramd;
      this.b = paramj;
    }
    
    public final T a()
    {
      Object localObject2 = this.c.a();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.a.a();
        or.a("PoolUtil", "Created new ".concat(String.valueOf(localObject1)));
      }
      if ((localObject1 instanceof ow.g)) {
        ((ow.g)localObject1).b().a(false);
      }
      return localObject1;
    }
    
    public final boolean a(@NonNull T paramT)
    {
      if ((paramT instanceof ow.g)) {
        ((ow.g)paramT).b().a(true);
      }
      return this.c.a(paramT);
    }
  }
  
  public static abstract interface f<T>
  {
    @Nullable
    public abstract T a();
    
    public abstract boolean a(@NonNull T paramT);
  }
  
  public static abstract interface g
  {
    @NonNull
    public abstract ow.k b();
  }
  
  public static final class h<T>
    implements ow.g
  {
    public final T a;
    private ow.k b = new ow.c();
    
    public h(T paramT)
    {
      this.a = paramT;
    }
    
    @NonNull
    public final ow.k b()
    {
      return this.b;
    }
  }
  
  public static final class i
  {
    public static class a<T>
      implements ow.f<T>
    {
      private final Object[] a;
      private int b;
      
      public a(int paramInt)
      {
        if (paramInt <= 0) {
          throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[paramInt];
      }
      
      public T a()
      {
        if (this.b > 0)
        {
          int i = this.b - 1;
          Object localObject = this.a[i];
          this.a[i] = null;
          this.b -= 1;
          return localObject;
        }
        return null;
      }
      
      public boolean a(@NonNull T paramT)
      {
        boolean bool = false;
        int i = 0;
        if (i < this.b) {
          if (this.a[i] != paramT) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label50;
          }
          throw new IllegalStateException("Already in the pool!");
          i += 1;
          break;
        }
        label50:
        if (this.b < this.a.length)
        {
          this.a[this.b] = paramT;
          this.b += 1;
          bool = true;
        }
        return bool;
      }
    }
    
    public static final class b<T>
      extends ow.i.a<T>
    {
      private final Object a = new Object();
      
      public b(int paramInt)
      {
        super();
      }
      
      public final T a()
      {
        synchronized (this.a)
        {
          Object localObject2 = super.a();
          return localObject2;
        }
      }
      
      public final boolean a(@NonNull T paramT)
      {
        synchronized (this.a)
        {
          boolean bool = super.a(paramT);
          return bool;
        }
      }
    }
  }
  
  public static abstract interface j<T> {}
  
  public static abstract class k
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ow
 * JD-Core Version:    0.7.0.1
 */