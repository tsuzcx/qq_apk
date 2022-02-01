package com.tencent.token;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public abstract class ans<K, A>
{
  final List<a> a = new ArrayList();
  boolean b = false;
  private final List<? extends anv<K>> c;
  private float d = 0.0F;
  private anv<K> e;
  
  ans(List<? extends anv<K>> paramList)
  {
    this.c = paramList;
  }
  
  private anv<K> b()
  {
    if (!this.c.isEmpty())
    {
      Object localObject = this.e;
      if ((localObject != null) && (((anv)localObject).a(this.d))) {
        return this.e;
      }
      localObject = this.c;
      int i = 0;
      anv localanv = (anv)((List)localObject).get(0);
      localObject = localanv;
      if (this.d < localanv.a())
      {
        this.e = localanv;
        return localanv;
      }
      while ((!((anv)localObject).a(this.d)) && (i < this.c.size()))
      {
        localObject = (anv)this.c.get(i);
        i += 1;
      }
      this.e = ((anv)localObject);
      return localObject;
    }
    throw new IllegalStateException("There are no keyframes");
  }
  
  public A a()
  {
    anv localanv1 = b();
    boolean bool = this.b;
    float f1 = 0.0F;
    if (!bool)
    {
      anv localanv2 = b();
      int i;
      if (localanv2.c == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        f1 = this.d;
        float f2 = localanv2.a();
        float f3 = localanv2.b();
        float f4 = localanv2.a();
        f1 = localanv2.c.getInterpolation((f1 - f2) / (f3 - f4));
      }
    }
    return a(localanv1, f1);
  }
  
  public abstract A a(anv<K> paramanv, float paramFloat);
  
  public void a(float paramFloat)
  {
    boolean bool = this.c.isEmpty();
    int i = 0;
    float f1;
    if (bool) {
      f1 = 0.0F;
    } else {
      f1 = ((anv)this.c.get(0)).a();
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
        f2 = ((anv)localList.get(localList.size() - 1)).b();
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
 * Qualified Name:     com.tencent.token.ans
 * JD-Core Version:    0.7.0.1
 */