package taiji;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public abstract class l<K, A>
{
  final List<a> a = new ArrayList();
  private boolean b = false;
  private final List<? extends o<K>> c;
  private float d = 0.0F;
  private o<K> e;
  
  l(List<? extends o<K>> paramList)
  {
    this.c = paramList;
  }
  
  private o<K> c()
  {
    if (!this.c.isEmpty())
    {
      Object localObject = this.e;
      if ((localObject != null) && (((o)localObject).a(this.d))) {
        return this.e;
      }
      localObject = this.c;
      int i = 0;
      o localo = (o)((List)localObject).get(0);
      localObject = localo;
      if (this.d < localo.a())
      {
        this.e = localo;
        return localo;
      }
      while ((!((o)localObject).a(this.d)) && (i < this.c.size()))
      {
        localObject = (o)this.c.get(i);
        i += 1;
      }
      this.e = ((o)localObject);
      return localObject;
    }
    throw new IllegalStateException("There are no keyframes");
  }
  
  private float d()
  {
    if (this.b) {
      return 0.0F;
    }
    o localo = c();
    if (localo.c()) {
      return 0.0F;
    }
    float f1 = this.d;
    float f2 = localo.a();
    float f3 = localo.b();
    float f4 = localo.a();
    return localo.c.getInterpolation((f1 - f2) / (f3 - f4));
  }
  
  private float e()
  {
    if (this.c.isEmpty()) {
      return 0.0F;
    }
    return ((o)this.c.get(0)).a();
  }
  
  private float f()
  {
    if (this.c.isEmpty()) {
      return 1.0F;
    }
    List localList = this.c;
    return ((o)localList.get(localList.size() - 1)).b();
  }
  
  public void a()
  {
    this.b = true;
  }
  
  public void a(float paramFloat)
  {
    float f;
    if (paramFloat < e())
    {
      f = 0.0F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat > f()) {
        f = 1.0F;
      }
    }
    if (f == this.d) {
      return;
    }
    this.d = f;
    int i = 0;
    while (i < this.a.size())
    {
      ((a)this.a.get(i)).c();
      i += 1;
    }
  }
  
  public void a(a parama)
  {
    this.a.add(parama);
  }
  
  public A b()
  {
    return b(c(), d());
  }
  
  public abstract A b(o<K> paramo, float paramFloat);
  
  public static abstract interface a
  {
    public abstract void c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.l
 * JD-Core Version:    0.7.0.1
 */