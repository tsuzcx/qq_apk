package taiji;

import android.graphics.PointF;
import com.tencent.token.gm;
import java.util.ArrayList;
import java.util.List;

public class ao
{
  private final List<aa> a = new ArrayList();
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
  
  public void a(ao paramao1, ao paramao2, float paramFloat)
  {
    if (this.b == null) {
      this.b = new PointF();
    }
    if ((paramao1.b()) || (paramao2.b())) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      if ((this.a.isEmpty()) || (this.a.size() == paramao1.c().size()) || (this.a.size() == paramao2.c().size())) {
        break;
      }
      throw new IllegalStateException("Curves must have the same number of control points. This: " + c().size() + "\tShape 1: " + paramao1.c().size() + "\tShape 2: " + paramao2.c().size());
    }
    if (this.a.isEmpty())
    {
      i = paramao1.c().size() - 1;
      while (i >= 0)
      {
        this.a.add(new aa());
        i -= 1;
      }
    }
    PointF localPointF1 = paramao1.a();
    PointF localPointF2 = paramao2.a();
    a(gm.a(localPointF1.x, localPointF2.x, paramFloat), gm.a(localPointF1.y, localPointF2.y, paramFloat));
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      Object localObject2 = (aa)paramao1.c().get(i);
      Object localObject1 = (aa)paramao2.c().get(i);
      localPointF1 = ((aa)localObject2).a();
      localPointF2 = ((aa)localObject2).b();
      localObject2 = ((aa)localObject2).c();
      PointF localPointF3 = ((aa)localObject1).a();
      PointF localPointF4 = ((aa)localObject1).b();
      localObject1 = ((aa)localObject1).c();
      ((aa)this.a.get(i)).a(gm.a(localPointF1.x, localPointF3.x, paramFloat), gm.a(localPointF1.y, localPointF3.y, paramFloat));
      ((aa)this.a.get(i)).b(gm.a(localPointF2.x, localPointF4.x, paramFloat), gm.a(localPointF2.y, localPointF4.y, paramFloat));
      ((aa)this.a.get(i)).c(gm.a(((PointF)localObject2).x, ((PointF)localObject1).x, paramFloat), gm.a(((PointF)localObject2).y, ((PointF)localObject1).y, paramFloat));
      i -= 1;
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public List<aa> c()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ao
 * JD-Core Version:    0.7.0.1
 */