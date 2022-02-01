package com.tencent.token;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.turingfd.sdk.qps.Grape;
import com.tencent.turingfd.sdk.qps.Grapefruit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class aca
{
  public static final agi<aca> a = new a();
  public Map<String, b> b = new HashMap();
  public Map<String, c> c = new HashMap();
  public acd d;
  
  public final class a
    extends agi<aca>
  {
    public final Object a()
    {
      return new aca();
    }
  }
  
  public final class b
    implements aci
  {
    public int a;
    public long b = -1L;
    public long c;
    public List<aca.d> d = new ArrayList();
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
    
    public final void a(acj paramacj)
    {
      if (!this.e.equals(paramacj.m)) {
        return;
      }
      int j = paramacj.g;
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
        if (paramacj.h == 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.g = bool;
      }
      switch (paramacj.f)
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
          paramacj = new aca.d(2, paramacj.i, paramacj.j, paramacj.k, paramacj.l);
        }
        else
        {
          a();
          paramacj = new aca.d(0, paramacj.i, paramacj.j, paramacj.k, paramacj.l);
          this.b = System.currentTimeMillis();
        }
        this.d.add(paramacj);
        return;
      case 1: 
        long l1 = this.b;
        this.c = (System.currentTimeMillis() - l1);
        paramacj = new aca.d(1, paramacj.i, paramacj.j, paramacj.k, paramacj.l);
        this.d.add(paramacj);
        Object localObject1 = aca.this;
        paramacj = this.d;
        localObject1.getClass();
        localObject1 = new ArrayList();
        aca.d locald;
        if (paramacj.size() <= 8)
        {
          ((ArrayList)localObject1).addAll(paramacj);
        }
        else
        {
          localObject2 = (aca.d)paramacj.get(0);
          locald = (aca.d)paramacj.get(paramacj.size() - 1);
          paramacj.remove(localObject2);
          paramacj.remove(locald);
          j = (int)Math.ceil(paramacj.size() / 6.0F);
          ((ArrayList)localObject1).add(localObject2);
          i = 1;
          while (i < paramacj.size())
          {
            ((ArrayList)localObject1).add((aca.d)paramacj.get(i));
            i += j;
          }
          ((ArrayList)localObject1).add(locald);
        }
        paramacj = aca.this;
        l1 = this.b;
        long l2 = this.c;
        paramacj.getClass();
        paramacj = new Grape();
        paramacj.c = ((int)l2);
        paramacj.b = l1;
        Object localObject2 = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          locald = (aca.d)((Iterator)localObject1).next();
          Grapefruit localGrapefruit = new Grapefruit();
          switch (locald.a)
          {
          default: 
            localGrapefruit.a = 0;
            break;
          case 3: 
            localGrapefruit.a = 4;
            break;
          case 2: 
            localGrapefruit.a = 2;
            break;
          case 1: 
            localGrapefruit.a = 3;
            break;
          case 0: 
            localGrapefruit.a = 1;
          }
          localGrapefruit.b = locald.b;
          localGrapefruit.c = locald.c;
          localGrapefruit.d = locald.d;
          localGrapefruit.e = locald.e;
          ((ArrayList)localObject2).add(localGrapefruit);
        }
        paramacj.d = ((ArrayList)localObject2);
        if ((!this.f) && (!this.g))
        {
          localObject2 = aca.this;
          localObject1 = this.e;
          i = this.a;
          localObject2 = ((aca)localObject2).d;
          if (localObject2 != null) {
            ((acd)localObject2).a((String)localObject1, i, 1, paramacj);
          }
        }
        else
        {
          localObject2 = aca.this;
          localObject1 = this.e;
          i = this.a;
          localObject2 = ((aca)localObject2).d;
          if (localObject2 != null) {
            ((acd)localObject2).a((String)localObject1, i, 2, paramacj);
          }
        }
        a();
        return;
      }
      a();
      this.b = System.currentTimeMillis();
      paramacj = new aca.d(0, paramacj.i, paramacj.j, paramacj.k, paramacj.l);
      this.d.add(paramacj);
    }
  }
  
  public final class c
    implements acf
  {
    public int a;
    
    public c(int paramInt)
    {
      this.a = paramInt;
    }
    
    public final void a(String paramString, View paramView)
    {
      aca.this.d.a(paramString, this.a, 3, null);
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
 * Qualified Name:     com.tencent.token.aca
 * JD-Core Version:    0.7.0.1
 */