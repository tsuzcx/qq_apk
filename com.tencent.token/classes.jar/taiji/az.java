package taiji;

import android.graphics.PointF;
import com.tencent.token.it;
import java.util.ArrayList;
import java.util.List;

public class az
{
  private final List a = new ArrayList();
  private PointF b;
  private boolean c;
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if (this.b == null) {
      this.b = new PointF();
    }
    this.b.set(paramFloat1, paramFloat2);
  }
  
  public PointF a()
  {
    return this.b;
  }
  
  public void a(az paramaz1, az paramaz2, float paramFloat)
  {
    if (this.b == null) {
      this.b = new PointF();
    }
    if ((paramaz1.b()) || (paramaz2.b())) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      if ((this.a.isEmpty()) || (this.a.size() == paramaz1.c().size()) || (this.a.size() == paramaz2.c().size())) {
        break;
      }
      throw new IllegalStateException("Curves must have the same number of control points. This: " + c().size() + "\tShape 1: " + paramaz1.c().size() + "\tShape 2: " + paramaz2.c().size());
    }
    if (this.a.isEmpty())
    {
      i = paramaz1.c().size() - 1;
      while (i >= 0)
      {
        this.a.add(new ad());
        i -= 1;
      }
    }
    PointF localPointF1 = paramaz1.a();
    PointF localPointF2 = paramaz2.a();
    a(it.a(localPointF1.x, localPointF2.x, paramFloat), it.a(localPointF1.y, localPointF2.y, paramFloat));
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      Object localObject2 = (ad)paramaz1.c().get(i);
      Object localObject1 = (ad)paramaz2.c().get(i);
      localPointF1 = ((ad)localObject2).a();
      localPointF2 = ((ad)localObject2).b();
      localObject2 = ((ad)localObject2).c();
      PointF localPointF3 = ((ad)localObject1).a();
      PointF localPointF4 = ((ad)localObject1).b();
      localObject1 = ((ad)localObject1).c();
      ((ad)this.a.get(i)).a(it.a(localPointF1.x, localPointF3.x, paramFloat), it.a(localPointF1.y, localPointF3.y, paramFloat));
      ((ad)this.a.get(i)).b(it.a(localPointF2.x, localPointF4.x, paramFloat), it.a(localPointF2.y, localPointF4.y, paramFloat));
      ((ad)this.a.get(i)).c(it.a(((PointF)localObject2).x, ((PointF)localObject1).x, paramFloat), it.a(((PointF)localObject2).y, ((PointF)localObject1).y, paramFloat));
      i -= 1;
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public List c()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.az
 * JD-Core Version:    0.7.0.1
 */