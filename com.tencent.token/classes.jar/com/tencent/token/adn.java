package com.tencent.token;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.turingfd.sdk.qps.Grapefruit;
import com.tencent.turingfd.sdk.qps.Guava;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class adn
{
  public static final agj<adn> a = new a();
  public Map<String, b> b = new HashMap();
  public Map<String, c> c = new HashMap();
  public ado d;
  
  public static adn a()
  {
    agj localagj = a;
    Object localObject3 = localagj.a;
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      try
      {
        localObject3 = localagj.a;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = new adn();
          localagj.a = localObject1;
        }
      }
      finally {}
    }
    return (adn)localObject2;
  }
  
  public final void a(String paramString)
  {
    Object localObject = (b)this.b.get(paramString);
    adt.c.remove(localObject);
    this.b.remove(paramString);
    localObject = (c)this.c.get(paramString);
    adt.d.remove(localObject);
    this.c.remove(paramString);
  }
  
  public final void a(String paramString, int paramInt, ado paramado)
  {
    this.d = paramado;
    if (this.b.get(paramString) == null)
    {
      paramado = new b(paramString, paramInt);
      this.b.put(paramString, paramado);
      adt.c.add(paramado);
    }
    if (this.c.get(paramString) == null)
    {
      paramado = new c(paramInt);
      this.c.put(paramString, paramado);
      adt.d.add(paramado);
    }
  }
  
  public final class a
    extends agj<adn>
  {}
  
  public final class b
    implements adv
  {
    public int a;
    public long b = -1L;
    public long c;
    public List<adn.d> d = new ArrayList();
    public String e;
    public boolean f = false;
    public boolean g = false;
    
    public b(String paramString, int paramInt)
    {
      this.a = paramInt;
      this.e = paramString;
    }
    
    private void a()
    {
      this.b = -1L;
      this.c = 0L;
      this.d.clear();
      this.f = false;
      this.g = false;
    }
    
    public final void a(adw paramadw)
    {
      if (!this.e.equals(paramadw.m)) {
        return;
      }
      int j = paramadw.g;
      int i = 0;
      boolean bool;
      if (j <= 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.f = bool;
      if (Build.VERSION.SDK_INT >= 14)
      {
        if (paramadw.h == 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.g = bool;
      }
      switch (paramadw.f)
      {
      default: 
        return;
      case 3: 
        a();
        return;
      case 2: 
        if (this.b != -1L) {
          i = 1;
        }
        if (i != 0)
        {
          paramadw = new adn.d(2, paramadw.i, paramadw.j, paramadw.k, paramadw.l);
        }
        else
        {
          a();
          paramadw = new adn.d(0, paramadw.i, paramadw.j, paramadw.k, paramadw.l);
          this.b = System.currentTimeMillis();
        }
        this.d.add(paramadw);
        return;
      case 1: 
        long l1 = this.b;
        this.c = (System.currentTimeMillis() - l1);
        paramadw = new adn.d(1, paramadw.i, paramadw.j, paramadw.k, paramadw.l);
        this.d.add(paramadw);
        Object localObject1 = adn.this;
        paramadw = this.d;
        localObject1.getClass();
        localObject1 = new ArrayList();
        adn.d locald;
        if (paramadw.size() <= 8)
        {
          ((ArrayList)localObject1).addAll(paramadw);
        }
        else
        {
          localObject2 = (adn.d)paramadw.get(0);
          locald = (adn.d)paramadw.get(paramadw.size() - 1);
          paramadw.remove(localObject2);
          paramadw.remove(locald);
          j = (int)Math.ceil(paramadw.size() / 6.0F);
          ((ArrayList)localObject1).add(localObject2);
          i = 1;
          while (i < paramadw.size())
          {
            ((ArrayList)localObject1).add(paramadw.get(i));
            i += j;
          }
          ((ArrayList)localObject1).add(locald);
        }
        paramadw = adn.this;
        l1 = this.b;
        long l2 = this.c;
        paramadw.getClass();
        paramadw = new Grapefruit();
        paramadw.c = ((int)l2);
        paramadw.b = l1;
        Object localObject2 = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          locald = (adn.d)((Iterator)localObject1).next();
          Guava localGuava = new Guava();
          switch (locald.a)
          {
          default: 
            localGuava.a = 0;
            break;
          case 3: 
            localGuava.a = 4;
            break;
          case 2: 
            localGuava.a = 2;
            break;
          case 1: 
            localGuava.a = 3;
            break;
          case 0: 
            localGuava.a = 1;
          }
          localGuava.b = locald.b;
          localGuava.c = locald.c;
          localGuava.d = locald.d;
          localGuava.e = locald.e;
          ((ArrayList)localObject2).add(localGuava);
        }
        paramadw.d = ((ArrayList)localObject2);
        if ((!this.f) && (!this.g))
        {
          localObject2 = adn.this;
          localObject1 = this.e;
          i = this.a;
          localObject2 = ((adn)localObject2).d;
          if (localObject2 != null) {
            ((ado)localObject2).a((String)localObject1, i, 1, paramadw);
          }
        }
        else
        {
          localObject2 = adn.this;
          localObject1 = this.e;
          i = this.a;
          localObject2 = ((adn)localObject2).d;
          if (localObject2 != null) {
            ((ado)localObject2).a((String)localObject1, i, 2, paramadw);
          }
        }
        a();
        return;
      }
      a();
      this.b = System.currentTimeMillis();
      paramadw = new adn.d(0, paramadw.i, paramadw.j, paramadw.k, paramadw.l);
      this.d.add(paramadw);
    }
  }
  
  public final class c
    implements adq
  {
    public int a;
    
    public c(int paramInt)
    {
      this.a = paramInt;
    }
    
    public final void a(String paramString, View paramView)
    {
      adn.this.d.a(paramString, this.a, 3, null);
    }
  }
  
  public final class d
  {
    public final int a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    
    public d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.a = this$1;
      this.b = paramFloat1;
      this.c = paramFloat2;
      this.d = paramFloat3;
      this.e = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adn
 * JD-Core Version:    0.7.0.1
 */