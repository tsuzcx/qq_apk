package taiji;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class cy
  implements cz, i, o
{
  private final Matrix a = new Matrix();
  private final Path b = new Path();
  private final RectF c = new RectF();
  private final String d;
  private final List e;
  private final uilib.doraemon.e f;
  private List g;
  private aa h;
  
  cy(uilib.doraemon.e parame, bd parambd, String paramString, List paramList, as paramas)
  {
    this.d = paramString;
    this.f = parame;
    this.e = paramList;
    if (paramas != null)
    {
      this.h = paramas.h();
      this.h.a(parambd);
      this.h.a(this);
    }
    parame = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      parambd = (cx)paramList.get(i);
      if ((parambd instanceof e)) {
        parame.add((e)parambd);
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
  
  public cy(uilib.doraemon.e parame, bd parambd, ba paramba)
  {
    this(parame, parambd, paramba.a(), a(parame, parambd, paramba.b()), a(paramba.b()));
  }
  
  private static List a(uilib.doraemon.e parame, bd parambd, List paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      cx localcx = ((ay)paramList.get(i)).a(parame, parambd);
      if (localcx != null) {
        localArrayList.add(localcx);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  static as a(List paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      ay localay = (ay)paramList.get(i);
      if ((localay instanceof as)) {
        return (as)localay;
      }
      i += 1;
    }
    return null;
  }
  
  public Path a()
  {
    this.a.reset();
    if (this.h != null) {
      this.a.set(this.h.b());
    }
    this.b.reset();
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      cx localcx = (cx)this.e.get(i);
      if ((localcx instanceof i)) {
        this.b.addPath(((i)localcx).a(), this.a);
      }
      i -= 1;
    }
    return this.b;
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.a.set(paramMatrix);
    int i = paramInt;
    if (this.h != null)
    {
      this.a.preConcat(this.h.b());
      i = (int)(((Integer)this.h.a().b()).intValue() / 100.0F * paramInt / 255.0F * 255.0F);
    }
    paramInt = this.e.size() - 1;
    while (paramInt >= 0)
    {
      paramMatrix = this.e.get(paramInt);
      if ((paramMatrix instanceof cz)) {
        ((cz)paramMatrix).a(paramCanvas, this.a, i);
      }
      paramInt -= 1;
    }
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.set(paramMatrix);
    if (this.h != null) {
      this.a.preConcat(this.h.b());
    }
    this.c.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i = this.e.size() - 1;
    if (i >= 0)
    {
      paramMatrix = (cx)this.e.get(i);
      if ((paramMatrix instanceof cz))
      {
        ((cz)paramMatrix).a(this.c, this.a);
        if (!paramRectF.isEmpty()) {
          break label117;
        }
        paramRectF.set(this.c);
      }
      for (;;)
      {
        i -= 1;
        break;
        label117:
        paramRectF.set(Math.min(paramRectF.left, this.c.left), Math.min(paramRectF.top, this.c.top), Math.max(paramRectF.right, this.c.right), Math.max(paramRectF.bottom, this.c.bottom));
      }
    }
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    int i = 0;
    if (i < this.e.size())
    {
      cx localcx = (cx)this.e.get(i);
      cz localcz;
      if ((localcx instanceof cz))
      {
        localcz = (cz)localcx;
        if ((paramString2 != null) && (!paramString2.equals(localcx.b()))) {
          break label85;
        }
        localcz.a(paramString1, null, paramColorFilter);
      }
      for (;;)
      {
        i += 1;
        break;
        label85:
        localcz.a(paramString1, paramString2, paramColorFilter);
      }
    }
  }
  
  public void a(List paramList1, List paramList2)
  {
    paramList2 = new ArrayList(paramList1.size() + this.e.size());
    paramList2.addAll(paramList1);
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      paramList1 = (cx)this.e.get(i);
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
  
  List d()
  {
    if (this.g == null)
    {
      this.g = new ArrayList();
      int i = 0;
      while (i < this.e.size())
      {
        cx localcx = (cx)this.e.get(i);
        if ((localcx instanceof i)) {
          this.g.add((i)localcx);
        }
        i += 1;
      }
    }
    return this.g;
  }
  
  Matrix e()
  {
    if (this.h != null) {
      return this.h.b();
    }
    this.a.reset();
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.cy
 * JD-Core Version:    0.7.0.1
 */