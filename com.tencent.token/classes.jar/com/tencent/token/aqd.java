package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public final class aqd
  implements anr, ans.a, aqe
{
  private final Matrix a = new Matrix();
  private final Path b = new Path();
  private final RectF c = new RectF();
  private final String d;
  private final List<aqc> e;
  private final auv f;
  private aof g;
  
  public aqd(auv paramauv, apb paramapb, aoz paramaoz)
  {
    this(paramauv, paramapb, paramaoz.a, a(paramauv, paramapb, paramaoz.b), b(paramaoz.b));
  }
  
  private aqd(auv paramauv, apb paramapb, String paramString, List<aqc> paramList, aor paramaor)
  {
    this.d = paramString;
    this.f = paramauv;
    this.e = paramList;
    if (paramaor != null)
    {
      this.g = paramaor.a();
      this.g.a(paramapb);
      this.g.a(this);
    }
    paramauv = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      paramapb = (aqc)paramList.get(i);
      if ((paramapb instanceof anp)) {
        paramauv.add((anp)paramapb);
      }
      i -= 1;
    }
    i = paramauv.size() - 1;
    while (i >= 0)
    {
      paramauv.get(i);
      paramList.listIterator(paramList.size());
      i -= 1;
    }
  }
  
  private static List<aqc> a(auv paramauv, apb paramapb, List<aov> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      aqc localaqc = ((aov)paramList.get(i)).a(paramauv, paramapb);
      if (localaqc != null) {
        localArrayList.add(localaqc);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static aor b(List<aov> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      aov localaov = (aov)paramList.get(i);
      if ((localaov instanceof aor)) {
        return (aor)localaov;
      }
      i += 1;
    }
    return null;
  }
  
  public final String a()
  {
    return this.d;
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.a.set(paramMatrix);
    paramMatrix = this.g;
    int i = paramInt;
    if (paramMatrix != null)
    {
      this.a.preConcat(paramMatrix.a());
      i = (int)(((Integer)this.g.a.a()).intValue() / 100.0F * paramInt / 255.0F * 255.0F);
    }
    paramInt = this.e.size() - 1;
    while (paramInt >= 0)
    {
      paramMatrix = this.e.get(paramInt);
      if ((paramMatrix instanceof aqe)) {
        ((aqe)paramMatrix).a(paramCanvas, this.a, i);
      }
      paramInt -= 1;
    }
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.set(paramMatrix);
    paramMatrix = this.g;
    if (paramMatrix != null) {
      this.a.preConcat(paramMatrix.a());
    }
    this.c.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      paramMatrix = (aqc)this.e.get(i);
      if ((paramMatrix instanceof aqe))
      {
        ((aqe)paramMatrix).a(this.c, this.a);
        if (paramRectF.isEmpty()) {
          paramRectF.set(this.c);
        } else {
          paramRectF.set(Math.min(paramRectF.left, this.c.left), Math.min(paramRectF.top, this.c.top), Math.max(paramRectF.right, this.c.right), Math.max(paramRectF.bottom, this.c.bottom));
        }
      }
      i -= 1;
    }
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    int i = 0;
    while (i < this.e.size())
    {
      aqc localaqc = (aqc)this.e.get(i);
      if ((localaqc instanceof aqe))
      {
        aqe localaqe = (aqe)localaqc;
        if ((paramString2 != null) && (!paramString2.equals(localaqc.a()))) {
          localaqe.a(paramString1, paramString2, paramColorFilter);
        } else {
          localaqe.a(paramString1, null, paramColorFilter);
        }
      }
      i += 1;
    }
  }
  
  public final void a(List<aqc> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size() + this.e.size());
    localArrayList.addAll(paramList);
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      paramList = (aqc)this.e.get(i);
      this.e.subList(0, i);
      paramList.a(localArrayList);
      localArrayList.add(paramList);
      i -= 1;
    }
  }
  
  public final void b()
  {
    this.f.invalidateSelf();
  }
  
  public final Path h_()
  {
    this.a.reset();
    Object localObject = this.g;
    if (localObject != null) {
      this.a.set(((aof)localObject).a());
    }
    this.b.reset();
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      localObject = (aqc)this.e.get(i);
      if ((localObject instanceof anr)) {
        this.b.addPath(((anr)localObject).h_(), this.a);
      }
      i -= 1;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqd
 * JD-Core Version:    0.7.0.1
 */