package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ang
  extends anf
{
  private final ama<Float> g;
  private final List<anf> h = new ArrayList();
  private final RectF i = new RectF();
  private final Rect j = new Rect();
  private final RectF k = new RectF();
  
  public ang(asw paramasw, ani paramani, List<ani> paramList, ast paramast)
  {
    super(paramasw, paramani);
    paramani = paramani.s;
    if (paramani != null)
    {
      this.g = paramani.a();
      a(this.g);
      this.g.a(this);
    }
    else
    {
      this.g = null;
    }
    HashMap localHashMap = new HashMap(paramast.e.size());
    int m = paramList.size() - 1;
    Object localObject1;
    for (Object localObject2 = null; m >= 0; localObject2 = localObject1)
    {
      ani localani = (ani)paramList.get(m);
      switch (anf.2.a[localani.e.ordinal()])
      {
      default: 
        new StringBuilder("Unknown layer type ").append(localani.e);
        paramani = null;
        break;
      case 6: 
        paramani = new anm(paramasw, localani);
        break;
      case 5: 
        paramani = new anj(paramasw, localani);
        break;
      case 4: 
        paramani = new anh(paramasw, localani, paramast.i);
        break;
      case 3: 
        paramani = new anl(paramasw, localani);
        break;
      case 2: 
        paramani = localani.g;
        paramani = new ang(paramasw, localani, (List)paramast.a.get(paramani), paramast);
        break;
      case 1: 
        paramani = new ank(paramasw, localani);
      }
      localObject1 = localObject2;
      if (paramani != null)
      {
        localHashMap.put(Long.valueOf(paramani.c.d), paramani);
        if (localObject2 != null)
        {
          localObject2.d = paramani;
          localObject1 = null;
        }
        else
        {
          this.h.add(0, paramani);
          switch (1.a[(localani.u - 1)])
          {
          default: 
            localObject1 = localObject2;
            break;
          case 1: 
          case 2: 
            localObject1 = paramani;
          }
        }
      }
      m -= 1;
    }
    paramasw = localHashMap.keySet().iterator();
    while (paramasw.hasNext())
    {
      paramani = (anf)localHashMap.get(paramasw.next());
      paramList = (anf)localHashMap.get(Long.valueOf(paramani.c.f));
      if (paramList != null) {
        paramani.e = paramList;
      }
    }
  }
  
  public final void a(float paramFloat)
  {
    super.a(paramFloat);
    float f = paramFloat;
    if (this.c.m != 0.0F) {
      f = paramFloat / this.c.m;
    }
    paramFloat = this.c.n;
    int m = this.h.size() - 1;
    while (m >= 0)
    {
      ((anf)this.h.get(m)).a(f - paramFloat);
      m -= 1;
    }
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    this.i.set(0.0F, 0.0F, 0.0F, 0.0F);
    int m = this.h.size() - 1;
    while (m >= 0)
    {
      ((anf)this.h.get(m)).a(this.i, this.a);
      if (paramRectF.isEmpty()) {
        paramRectF.set(this.i);
      } else {
        paramRectF.set(Math.min(paramRectF.left, this.i.left), Math.min(paramRectF.top, this.i.top), Math.max(paramRectF.right, this.i.right), Math.max(paramRectF.bottom, this.i.bottom));
      }
      m -= 1;
    }
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    int m = 0;
    while (m < this.h.size())
    {
      anf localanf = (anf)this.h.get(m);
      String str = localanf.c.c;
      if (paramString1 == null) {
        localanf.a(null, null, paramColorFilter);
      } else if (str.equals(paramString1)) {
        localanf.a(paramString1, paramString2, paramColorFilter);
      }
      m += 1;
    }
  }
  
  final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    asy.a("CompositionLayer#draw");
    paramCanvas.getClipBounds(this.j);
    this.k.set(0.0F, 0.0F, this.c.o, this.c.p);
    paramMatrix.mapRect(this.k);
    int m = this.h.size() - 1;
    while (m >= 0)
    {
      boolean bool;
      if (!this.k.isEmpty()) {
        bool = paramCanvas.clipRect(this.k);
      } else {
        bool = true;
      }
      if (bool) {
        ((anf)this.h.get(m)).a(paramCanvas, paramMatrix, paramInt);
      }
      m -= 1;
    }
    if (!this.j.isEmpty()) {
      paramCanvas.clipRect(this.j, Region.Op.REPLACE);
    }
    asy.b("CompositionLayer#draw");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ang
 * JD-Core Version:    0.7.0.1
 */