package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public final class arb
  implements aop, aoq.a, arc
{
  private final Matrix a = new Matrix();
  private final Path b = new Path();
  private final RectF c = new RectF();
  private final String d;
  private final List<ara> e;
  private final avt f;
  private apd g;
  
  public arb(avt paramavt, apz paramapz, apx paramapx)
  {
    this(paramavt, paramapz, paramapx.a, a(paramavt, paramapz, paramapx.b), b(paramapx.b));
  }
  
  private arb(avt paramavt, apz paramapz, String paramString, List<ara> paramList, app paramapp)
  {
    this.d = paramString;
    this.f = paramavt;
    this.e = paramList;
    if (paramapp != null)
    {
      this.g = paramapp.a();
      this.g.a(paramapz);
      this.g.a(this);
    }
    paramavt = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      paramapz = (ara)paramList.get(i);
      if ((paramapz instanceof aon)) {
        paramavt.add((aon)paramapz);
      }
      i -= 1;
    }
    i = paramavt.size() - 1;
    while (i >= 0)
    {
      paramavt.get(i);
      paramList.listIterator(paramList.size());
      i -= 1;
    }
  }
  
  private static List<ara> a(avt paramavt, apz paramapz, List<apt> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      ara localara = ((apt)paramList.get(i)).a(paramavt, paramapz);
      if (localara != null) {
        localArrayList.add(localara);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static app b(List<apt> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      apt localapt = (apt)paramList.get(i);
      if ((localapt instanceof app)) {
        return (app)localapt;
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
      if ((paramMatrix instanceof arc)) {
        ((arc)paramMatrix).a(paramCanvas, this.a, i);
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
      paramMatrix = (ara)this.e.get(i);
      if ((paramMatrix instanceof arc))
      {
        ((arc)paramMatrix).a(this.c, this.a);
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
      ara localara = (ara)this.e.get(i);
      if ((localara instanceof arc))
      {
        arc localarc = (arc)localara;
        if ((paramString2 != null) && (!paramString2.equals(localara.a()))) {
          localarc.a(paramString1, paramString2, paramColorFilter);
        } else {
          localarc.a(paramString1, null, paramColorFilter);
        }
      }
      i += 1;
    }
  }
  
  public final void a(List<ara> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size() + this.e.size());
    localArrayList.addAll(paramList);
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      paramList = (ara)this.e.get(i);
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
      this.a.set(((apd)localObject).a());
    }
    this.b.reset();
    int i = this.e.size() - 1;
    while (i >= 0)
    {
      localObject = (ara)this.e.get(i);
      if ((localObject instanceof aop)) {
        this.b.addPath(((aop)localObject).h_(), this.a);
      }
      i -= 1;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.arb
 * JD-Core Version:    0.7.0.1
 */