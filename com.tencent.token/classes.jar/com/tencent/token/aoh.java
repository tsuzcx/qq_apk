package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public final class aoh
  implements alv, alw.a, aoi
{
  private final Matrix a = new Matrix();
  private final Path b = new Path();
  private final RectF c = new RectF();
  private final String d;
  private final List<aog> e;
  private final asw f;
  private amj g;
  
  public aoh(asw paramasw, anf paramanf, and paramand)
  {
    this(paramasw, paramanf, paramand.a, a(paramasw, paramanf, paramand.b), b(paramand.b));
  }
  
  private aoh(asw paramasw, anf paramanf, String paramString, List<aog> paramList, amv paramamv)
  {
    this.d = paramString;
    this.f = paramasw;
    this.e = paramList;
    if (paramamv != null)
    {
      this.g = paramamv.a();
      this.g.a(paramanf);
      this.g.a(this);
    }
    paramasw = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      paramanf = (aog)paramList.get(i);
      if ((paramanf instanceof alt)) {
        paramasw.add((alt)paramanf);
      }
      i -= 1;
    }
    i = paramasw.size() - 1;
    while (i >= 0)
    {
      paramasw.get(i);
      paramList.listIterator(paramList.size());
      i -= 1;
    }
  }
  
  private static List<aog> a(asw paramasw, anf paramanf, List<amz> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      aog localaog = ((amz)paramList.get(i)).a(paramasw, paramanf);
      if (localaog != null) {
        localArrayList.add(localaog);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static amv b(List<amz> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      amz localamz = (amz)paramList.get(i);
      if ((localamz instanceof amv)) {
        return (amv)localamz;
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
      if ((paramMatrix instanceof aoi)) {
        ((aoi)paramMatrix).a(paramCanvas, this.a, i);
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
      paramMatrix = (aog)this.e.get(i);
      if ((paramMatrix instanceof aoi))
      {
        ((aoi)paramMatrix).a(this.c, this.a);
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
      aog localaog = (aog)this.e.get(i);
      if ((localaog instanceof aoi))
      {
        aoi localaoi = (aoi)localaog;
        if ((paramString2 != null) && (!paramString2.equals(localaog.a()))) {
          localaoi.a(paramString1, paramString2, paramColorFilter);
        } else {
          localaoi.a(paramString1, null, paramColorFilter);
        }
      }
      i += 1;
    }
  }
  
  public final void a(List<aog> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size() + this.e.size());
    localArrayList.addAll(paramList);
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      paramList = (aog)this.e.get(i);
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
  
  public final Path g_()
  {
    this.a.reset();
    Object localObject = this.g;
    if (localObject != null) {
      this.a.set(((amj)localObject).a());
    }
    this.b.reset();
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      localObject = (aog)this.e.get(i);
      if ((localObject instanceof alv)) {
        this.b.addPath(((alv)localObject).g_(), this.a);
      }
      i -= 1;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aoh
 * JD-Core Version:    0.7.0.1
 */