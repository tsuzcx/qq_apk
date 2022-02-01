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

public final class anf
  extends ane
{
  private final alz<Float> g;
  private final List<ane> h = new ArrayList();
  private final RectF i = new RectF();
  private final Rect j = new Rect();
  private final RectF k = new RectF();
  
  public anf(asv paramasv, anh paramanh, List<anh> paramList, ass paramass)
  {
    super(paramasv, paramanh);
    paramanh = paramanh.s;
    if (paramanh != null)
    {
      this.g = paramanh.a();
      a(this.g);
      this.g.a(this);
    }
    else
    {
      this.g = null;
    }
    HashMap localHashMap = new HashMap(paramass.e.size());
    int m = paramList.size() - 1;
    Object localObject1;
    for (Object localObject2 = null; m >= 0; localObject2 = localObject1)
    {
      anh localanh = (anh)paramList.get(m);
      switch (ane.2.a[localanh.e.ordinal()])
      {
      default: 
        new StringBuilder("Unknown layer type ").append(localanh.e);
        paramanh = null;
        break;
      case 6: 
        paramanh = new anl(paramasv, localanh);
        break;
      case 5: 
        paramanh = new ani(paramasv, localanh);
        break;
      case 4: 
        paramanh = new ang(paramasv, localanh, paramass.i);
        break;
      case 3: 
        paramanh = new ank(paramasv, localanh);
        break;
      case 2: 
        paramanh = localanh.g;
        paramanh = new anf(paramasv, localanh, (List)paramass.a.get(paramanh), paramass);
        break;
      case 1: 
        paramanh = new anj(paramasv, localanh);
      }
      localObject1 = localObject2;
      if (paramanh != null)
      {
        localHashMap.put(Long.valueOf(paramanh.c.d), paramanh);
        if (localObject2 != null)
        {
          localObject2.d = paramanh;
          localObject1 = null;
        }
        else
        {
          this.h.add(0, paramanh);
          switch (1.a[(localanh.u - 1)])
          {
          default: 
            localObject1 = localObject2;
            break;
          case 1: 
          case 2: 
            localObject1 = paramanh;
          }
        }
      }
      m -= 1;
    }
    paramasv = localHashMap.keySet().iterator();
    while (paramasv.hasNext())
    {
      paramanh = (ane)localHashMap.get(paramasv.next());
      paramList = (ane)localHashMap.get(Long.valueOf(paramanh.c.f));
      if (paramList != null) {
        paramanh.e = paramList;
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
      ((ane)this.h.get(m)).a(f - paramFloat);
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
      ((ane)this.h.get(m)).a(this.i, this.a);
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
      ane localane = (ane)this.h.get(m);
      String str = localane.c.c;
      if (paramString1 == null) {
        localane.a(null, null, paramColorFilter);
      } else if (str.equals(paramString1)) {
        localane.a(paramString1, paramString2, paramColorFilter);
      }
      m += 1;
    }
  }
  
  final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    asx.a("CompositionLayer#draw");
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
        ((ane)this.h.get(m)).a(paramCanvas, paramMatrix, paramInt);
      }
      m -= 1;
    }
    if (!this.j.isEmpty()) {
      paramCanvas.clipRect(this.j, Region.Op.REPLACE);
    }
    asx.b("CompositionLayer#draw");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.anf
 * JD-Core Version:    0.7.0.1
 */