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

public final class aqa
  extends apz
{
  private final aou<Float> g;
  private final List<apz> h = new ArrayList();
  private final RectF i = new RectF();
  private final Rect j = new Rect();
  private final RectF k = new RectF();
  
  public aqa(avt paramavt, aqc paramaqc, List<aqc> paramList, avq paramavq)
  {
    super(paramavt, paramaqc);
    paramaqc = paramaqc.s;
    if (paramaqc != null)
    {
      this.g = paramaqc.a();
      a(this.g);
      this.g.a(this);
    }
    else
    {
      this.g = null;
    }
    HashMap localHashMap = new HashMap(paramavq.e.size());
    int m = paramList.size() - 1;
    Object localObject1;
    for (Object localObject2 = null; m >= 0; localObject2 = localObject1)
    {
      aqc localaqc = (aqc)paramList.get(m);
      switch (apz.2.a[localaqc.e.ordinal()])
      {
      default: 
        new StringBuilder("Unknown layer type ").append(localaqc.e);
        paramaqc = null;
        break;
      case 6: 
        paramaqc = new aqg(paramavt, localaqc);
        break;
      case 5: 
        paramaqc = new aqd(paramavt, localaqc);
        break;
      case 4: 
        paramaqc = new aqb(paramavt, localaqc, paramavq.i);
        break;
      case 3: 
        paramaqc = new aqf(paramavt, localaqc);
        break;
      case 2: 
        paramaqc = localaqc.g;
        paramaqc = new aqa(paramavt, localaqc, (List)paramavq.a.get(paramaqc), paramavq);
        break;
      case 1: 
        paramaqc = new aqe(paramavt, localaqc);
      }
      localObject1 = localObject2;
      if (paramaqc != null)
      {
        localHashMap.put(Long.valueOf(paramaqc.c.d), paramaqc);
        if (localObject2 != null)
        {
          localObject2.d = paramaqc;
          localObject1 = null;
        }
        else
        {
          this.h.add(0, paramaqc);
          switch (1.a[(localaqc.u - 1)])
          {
          default: 
            localObject1 = localObject2;
            break;
          case 1: 
          case 2: 
            localObject1 = paramaqc;
          }
        }
      }
      m -= 1;
    }
    paramavt = localHashMap.keySet().iterator();
    while (paramavt.hasNext())
    {
      paramaqc = (apz)localHashMap.get(paramavt.next());
      paramList = (apz)localHashMap.get(Long.valueOf(paramaqc.c.f));
      if (paramList != null) {
        paramaqc.e = paramList;
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
      ((apz)this.h.get(m)).a(f - paramFloat);
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
      ((apz)this.h.get(m)).a(this.i, this.a);
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
      apz localapz = (apz)this.h.get(m);
      String str = localapz.c.c;
      if (paramString1 == null) {
        localapz.a(null, null, paramColorFilter);
      } else if (str.equals(paramString1)) {
        localapz.a(paramString1, paramString2, paramColorFilter);
      }
      m += 1;
    }
  }
  
  final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    avv.a("CompositionLayer#draw");
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
        ((apz)this.h.get(m)).a(paramCanvas, paramMatrix, paramInt);
      }
      m -= 1;
    }
    if (!this.j.isEmpty()) {
      paramCanvas.clipRect(this.j, Region.Op.REPLACE);
    }
    avv.b("CompositionLayer#draw");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqa
 * JD-Core Version:    0.7.0.1
 */