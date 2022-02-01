package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public final class aog
  implements alu, alv.a, aoh
{
  private final Matrix a = new Matrix();
  private final Path b = new Path();
  private final RectF c = new RectF();
  private final String d;
  private final List<aof> e;
  private final asv f;
  private ami g;
  
  public aog(asv paramasv, ane paramane, anc paramanc)
  {
    this(paramasv, paramane, paramanc.a, a(paramasv, paramane, paramanc.b), b(paramanc.b));
  }
  
  private aog(asv paramasv, ane paramane, String paramString, List<aof> paramList, amu paramamu)
  {
    this.d = paramString;
    this.f = paramasv;
    this.e = paramList;
    if (paramamu != null)
    {
      this.g = paramamu.a();
      this.g.a(paramane);
      this.g.a(this);
    }
    paramasv = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      paramane = (aof)paramList.get(i);
      if ((paramane instanceof als)) {
        paramasv.add((als)paramane);
      }
      i -= 1;
    }
    i = paramasv.size() - 1;
    while (i >= 0)
    {
      paramasv.get(i);
      paramList.listIterator(paramList.size());
      i -= 1;
    }
  }
  
  private static List<aof> a(asv paramasv, ane paramane, List<amy> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      aof localaof = ((amy)paramList.get(i)).a(paramasv, paramane);
      if (localaof != null) {
        localArrayList.add(localaof);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static amu b(List<amy> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      amy localamy = (amy)paramList.get(i);
      if ((localamy instanceof amu)) {
        return (amu)localamy;
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
      if ((paramMatrix instanceof aoh)) {
        ((aoh)paramMatrix).a(paramCanvas, this.a, i);
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
      paramMatrix = (aof)this.e.get(i);
      if ((paramMatrix instanceof aoh))
      {
        ((aoh)paramMatrix).a(this.c, this.a);
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
      aof localaof = (aof)this.e.get(i);
      if ((localaof instanceof aoh))
      {
        aoh localaoh = (aoh)localaof;
        if ((paramString2 != null) && (!paramString2.equals(localaof.a()))) {
          localaoh.a(paramString1, paramString2, paramColorFilter);
        } else {
          localaoh.a(paramString1, null, paramColorFilter);
        }
      }
      i += 1;
    }
  }
  
  public final void a(List<aof> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size() + this.e.size());
    localArrayList.addAll(paramList);
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      paramList = (aof)this.e.get(i);
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
      this.a.set(((ami)localObject).a());
    }
    this.b.reset();
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      localObject = (aof)this.e.get(i);
      if ((localObject instanceof alu)) {
        this.b.addPath(((alu)localObject).g_(), this.a);
      }
      i -= 1;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aog
 * JD-Core Version:    0.7.0.1
 */