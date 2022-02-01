package taiji;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class bs
  implements bt, h, l.a
{
  private final Matrix a = new Matrix();
  private final Path b = new Path();
  private final RectF c = new RectF();
  private final String d;
  private final List<br> e;
  private final uilib.doraemon.e f;
  private List<h> g;
  private x h;
  
  bs(uilib.doraemon.e parame, ar paramar, String paramString, List<br> paramList, aj paramaj)
  {
    this.d = paramString;
    this.f = parame;
    this.e = paramList;
    if (paramaj != null)
    {
      this.h = paramaj.h();
      this.h.a(paramar);
      this.h.a(this);
    }
    parame = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      paramar = (br)paramList.get(i);
      if ((paramar instanceof e)) {
        parame.add((e)paramar);
      }
      i -= 1;
    }
    i = parame.size() - 1;
    while (i >= 0)
    {
      ((e)parame.get(i)).a(paramList.listIterator(paramList.size()));
      i -= 1;
    }
  }
  
  public bs(uilib.doraemon.e parame, ar paramar, ap paramap)
  {
    this(parame, paramar, paramap.a(), a(parame, paramar, paramap.b()), a(paramap.b()));
  }
  
  private static List<br> a(uilib.doraemon.e parame, ar paramar, List<an> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      br localbr = ((an)paramList.get(i)).a(parame, paramar);
      if (localbr != null) {
        localArrayList.add(localbr);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  static aj a(List<an> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      an localan = (an)paramList.get(i);
      if ((localan instanceof aj)) {
        return (aj)localan;
      }
      i += 1;
    }
    return null;
  }
  
  public Path a()
  {
    this.a.reset();
    Object localObject = this.h;
    if (localObject != null) {
      this.a.set(((x)localObject).b());
    }
    this.b.reset();
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      localObject = (br)this.e.get(i);
      if ((localObject instanceof h)) {
        this.b.addPath(((h)localObject).a(), this.a);
      }
      i -= 1;
    }
    return this.b;
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.a.set(paramMatrix);
    paramMatrix = this.h;
    int i = paramInt;
    if (paramMatrix != null)
    {
      this.a.preConcat(paramMatrix.b());
      i = (int)(((Integer)this.h.a().b()).intValue() / 100.0F * paramInt / 255.0F * 255.0F);
    }
    paramInt = this.e.size() - 1;
    while (paramInt >= 0)
    {
      paramMatrix = this.e.get(paramInt);
      if ((paramMatrix instanceof bt)) {
        ((bt)paramMatrix).a(paramCanvas, this.a, i);
      }
      paramInt -= 1;
    }
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.set(paramMatrix);
    paramMatrix = this.h;
    if (paramMatrix != null) {
      this.a.preConcat(paramMatrix.b());
    }
    this.c.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      paramMatrix = (br)this.e.get(i);
      if ((paramMatrix instanceof bt))
      {
        ((bt)paramMatrix).a(this.c, this.a);
        if (paramRectF.isEmpty()) {
          paramRectF.set(this.c);
        } else {
          paramRectF.set(Math.min(paramRectF.left, this.c.left), Math.min(paramRectF.top, this.c.top), Math.max(paramRectF.right, this.c.right), Math.max(paramRectF.bottom, this.c.bottom));
        }
      }
      i -= 1;
    }
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    int i = 0;
    while (i < this.e.size())
    {
      br localbr = (br)this.e.get(i);
      if ((localbr instanceof bt))
      {
        bt localbt = (bt)localbr;
        if ((paramString2 != null) && (!paramString2.equals(localbr.b()))) {
          localbt.a(paramString1, paramString2, paramColorFilter);
        } else {
          localbt.a(paramString1, null, paramColorFilter);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<br> paramList1, List<br> paramList2)
  {
    paramList2 = new ArrayList(paramList1.size() + this.e.size());
    paramList2.addAll(paramList1);
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      paramList1 = (br)this.e.get(i);
      paramList1.a(paramList2, this.e.subList(0, i));
      paramList2.add(paramList1);
      i -= 1;
    }
  }
  
  public String b()
  {
    return this.d;
  }
  
  public void c()
  {
    this.f.invalidateSelf();
  }
  
  List<h> d()
  {
    if (this.g == null)
    {
      this.g = new ArrayList();
      int i = 0;
      while (i < this.e.size())
      {
        br localbr = (br)this.e.get(i);
        if ((localbr instanceof h)) {
          this.g.add((h)localbr);
        }
        i += 1;
      }
    }
    return this.g;
  }
  
  Matrix e()
  {
    x localx = this.h;
    if (localx != null) {
      return localx.b();
    }
    this.a.reset();
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bs
 * JD-Core Version:    0.7.0.1
 */