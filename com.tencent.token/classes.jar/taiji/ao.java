package taiji;

import android.graphics.PointF;
import com.tencent.token.gp;
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
    boolean bool;
    if ((!paramao1.b()) && (!paramao2.b())) {
      bool = false;
    } else {
      bool = true;
    }
    this.c = bool;
    if ((!this.a.isEmpty()) && (this.a.size() != paramao1.c().size()) && (this.a.size() != paramao2.c().size()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Curves must have the same number of control points. This: ");
      ((StringBuilder)localObject1).append(c().size());
      ((StringBuilder)localObject1).append("\tShape 1: ");
      ((StringBuilder)localObject1).append(paramao1.c().size());
      ((StringBuilder)localObject1).append("\tShape 2: ");
      ((StringBuilder)localObject1).append(paramao2.c().size());
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
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
    Object localObject1 = paramao1.a();
    PointF localPointF1 = paramao2.a();
    a(gp.a(((PointF)localObject1).x, localPointF1.x, paramFloat), gp.a(((PointF)localObject1).y, localPointF1.y, paramFloat));
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      Object localObject3 = (aa)paramao1.c().get(i);
      Object localObject2 = (aa)paramao2.c().get(i);
      localObject1 = ((aa)localObject3).a();
      localPointF1 = ((aa)localObject3).b();
      localObject3 = ((aa)localObject3).c();
      PointF localPointF2 = ((aa)localObject2).a();
      PointF localPointF3 = ((aa)localObject2).b();
      localObject2 = ((aa)localObject2).c();
      ((aa)this.a.get(i)).a(gp.a(((PointF)localObject1).x, localPointF2.x, paramFloat), gp.a(((PointF)localObject1).y, localPointF2.y, paramFloat));
      ((aa)this.a.get(i)).b(gp.a(localPointF1.x, localPointF3.x, paramFloat), gp.a(localPointF1.y, localPointF3.y, paramFloat));
      ((aa)this.a.get(i)).c(gp.a(((PointF)localObject3).x, ((PointF)localObject2).x, paramFloat), gp.a(((PointF)localObject3).y, ((PointF)localObject2).y, paramFloat));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeData{numCurves=");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append("closed=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ao
 * JD-Core Version:    0.7.0.1
 */