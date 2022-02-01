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
    int i = 0;
    if (this.c.isEmpty()) {
      throw new IllegalStateException("There are no keyframes");
    }
    if ((this.e != null) && (this.e.a(this.d))) {
      return this.e;
    }
    o localo2 = (o)this.c.get(0);
    o localo1 = localo2;
    if (this.d < localo2.a())
    {
      this.e = localo2;
      return localo2;
    }
    while ((!localo1.a(this.d)) && (i < this.c.size()))
    {
      localo1 = (o)this.c.get(i);
      i += 1;
    }
    this.e = localo1;
    return localo1;
  }
  
  private float d()
  {
    if (this.b) {}
    o localo;
    do
    {
      return 0.0F;
      localo = c();
    } while (localo.c());
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
    return ((o)this.c.get(this.c.size() - 1)).b();
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
      if (f != this.d) {
        break label37;
      }
    }
    for (;;)
    {
      return;
      f = paramFloat;
      if (paramFloat <= f()) {
        break;
      }
      f = 1.0F;
      break;
      label37:
      this.d = f;
      int i = 0;
      while (i < this.a.size())
      {
        ((a)this.a.get(i)).c();
        i += 1;
      }
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