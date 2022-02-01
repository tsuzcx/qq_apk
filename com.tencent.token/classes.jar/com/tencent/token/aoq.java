package com.tencent.token;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public abstract class aoq<K, A>
{
  final List<a> a = new ArrayList();
  boolean b = false;
  private final List<? extends aot<K>> c;
  private float d = 0.0F;
  private aot<K> e;
  
  aoq(List<? extends aot<K>> paramList)
  {
    this.c = paramList;
  }
  
  private aot<K> b()
  {
    if (!this.c.isEmpty())
    {
      Object localObject = this.e;
      if ((localObject != null) && (((aot)localObject).a(this.d))) {
        return this.e;
      }
      localObject = this.c;
      int i = 0;
      aot localaot = (aot)((List)localObject).get(0);
      localObject = localaot;
      if (this.d < localaot.a())
      {
        this.e = localaot;
        return localaot;
      }
      while ((!((aot)localObject).a(this.d)) && (i < this.c.size()))
      {
        localObject = (aot)this.c.get(i);
        i += 1;
      }
      this.e = ((aot)localObject);
      return localObject;
    }
    throw new IllegalStateException("There are no keyframes");
  }
  
  public A a()
  {
    aot localaot1 = b();
    boolean bool = this.b;
    float f1 = 0.0F;
    if (!bool)
    {
      aot localaot2 = b();
      int i;
      if (localaot2.c == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        f1 = this.d;
        float f2 = localaot2.a();
        float f3 = localaot2.b();
        float f4 = localaot2.a();
        f1 = localaot2.c.getInterpolation((f1 - f2) / (f3 - f4));
      }
    }
    return a(localaot1, f1);
  }
  
  public abstract A a(aot<K> paramaot, float paramFloat);
  
  public void a(float paramFloat)
  {
    boolean bool = this.c.isEmpty();
    int i = 0;
    float f1;
    if (bool) {
      f1 = 0.0F;
    } else {
      f1 = ((aot)this.c.get(0)).a();
    }
    if (paramFloat < f1)
    {
      f1 = 0.0F;
    }
    else
    {
      float f2;
      if (this.c.isEmpty())
      {
        f2 = 1.0F;
      }
      else
      {
        List localList = this.c;
        f2 = ((aot)localList.get(localList.size() - 1)).b();
      }
      f1 = paramFloat;
      if (paramFloat > f2) {
        f1 = 1.0F;
      }
    }
    if (f1 == this.d) {
      return;
    }
    this.d = f1;
    while (i < this.a.size())
    {
      ((a)this.a.get(i)).b();
      i += 1;
    }
  }
  
  public void a(a parama)
  {
    this.a.add(parama);
  }
  
  public static abstract interface a
  {
    public abstract void b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aoq
 * JD-Core Version:    0.7.0.1
 */