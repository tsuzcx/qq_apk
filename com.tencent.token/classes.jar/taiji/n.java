package taiji;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public abstract class n
{
  final List a = new ArrayList();
  private boolean b = false;
  private final List c;
  private float d = 0.0F;
  private r e;
  
  n(List paramList)
  {
    this.c = paramList;
  }
  
  private r c()
  {
    int i = 0;
    if (this.c.isEmpty()) {
      throw new IllegalStateException("There are no keyframes");
    }
    if ((this.e != null) && (this.e.a(this.d))) {
      return this.e;
    }
    r localr2 = (r)this.c.get(0);
    r localr1 = localr2;
    if (this.d < localr2.a())
    {
      this.e = localr2;
      return localr2;
    }
    while ((!localr1.a(this.d)) && (i < this.c.size()))
    {
      localr1 = (r)this.c.get(i);
      i += 1;
    }
    this.e = localr1;
    return localr1;
  }
  
  private float d()
  {
    if (this.b) {}
    r localr;
    do
    {
      return 0.0F;
      localr = c();
    } while (localr.c());
    float f1 = this.d;
    float f2 = localr.a();
    float f3 = localr.b();
    float f4 = localr.a();
    return localr.c.getInterpolation((f1 - f2) / (f3 - f4));
  }
  
  private float e()
  {
    if (this.c.isEmpty()) {
      return 0.0F;
    }
    return ((r)this.c.get(0)).a();
  }
  
  private float f()
  {
    if (this.c.isEmpty()) {
      return 1.0F;
    }
    return ((r)this.c.get(this.c.size() - 1)).b();
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
        ((o)this.a.get(i)).c();
        i += 1;
      }
    }
  }
  
  public void a(o paramo)
  {
    this.a.add(paramo);
  }
  
  public Object b()
  {
    return b(c(), d());
  }
  
  public abstract Object b(r paramr, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.n
 * JD-Core Version:    0.7.0.1
 */