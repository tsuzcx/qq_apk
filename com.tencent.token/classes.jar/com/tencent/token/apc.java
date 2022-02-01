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

public final class apc
  extends apb
{
  private final anw<Float> g;
  private final List<apb> h = new ArrayList();
  private final RectF i = new RectF();
  private final Rect j = new Rect();
  private final RectF k = new RectF();
  
  public apc(auv paramauv, ape paramape, List<ape> paramList, aus paramaus)
  {
    super(paramauv, paramape);
    paramape = paramape.s;
    if (paramape != null)
    {
      this.g = paramape.a();
      a(this.g);
      this.g.a(this);
    }
    else
    {
      this.g = null;
    }
    HashMap localHashMap = new HashMap(paramaus.e.size());
    int m = paramList.size() - 1;
    Object localObject1;
    for (Object localObject2 = null; m >= 0; localObject2 = localObject1)
    {
      ape localape = (ape)paramList.get(m);
      switch (apb.2.a[localape.e.ordinal()])
      {
      default: 
        new StringBuilder("Unknown layer type ").append(localape.e);
        paramape = null;
        break;
      case 6: 
        paramape = new api(paramauv, localape);
        break;
      case 5: 
        paramape = new apf(paramauv, localape);
        break;
      case 4: 
        paramape = new apd(paramauv, localape, paramaus.i);
        break;
      case 3: 
        paramape = new aph(paramauv, localape);
        break;
      case 2: 
        paramape = localape.g;
        paramape = new apc(paramauv, localape, (List)paramaus.a.get(paramape), paramaus);
        break;
      case 1: 
        paramape = new apg(paramauv, localape);
      }
      localObject1 = localObject2;
      if (paramape != null)
      {
        localHashMap.put(Long.valueOf(paramape.c.d), paramape);
        if (localObject2 != null)
        {
          localObject2.d = paramape;
          localObject1 = null;
        }
        else
        {
          this.h.add(0, paramape);
          switch (1.a[(localape.u - 1)])
          {
          default: 
            localObject1 = localObject2;
            break;
          case 1: 
          case 2: 
            localObject1 = paramape;
          }
        }
      }
      m -= 1;
    }
    paramauv = localHashMap.keySet().iterator();
    while (paramauv.hasNext())
    {
      paramape = (apb)localHashMap.get(paramauv.next());
      paramList = (apb)localHashMap.get(Long.valueOf(paramape.c.f));
      if (paramList != null) {
        paramape.e = paramList;
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
      ((apb)this.h.get(m)).a(f - paramFloat);
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
      ((apb)this.h.get(m)).a(this.i, this.a);
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
      apb localapb = (apb)this.h.get(m);
      String str = localapb.c.c;
      if (paramString1 == null) {
        localapb.a(null, null, paramColorFilter);
      } else if (str.equals(paramString1)) {
        localapb.a(paramString1, paramString2, paramColorFilter);
      }
      m += 1;
    }
  }
  
  final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    aux.a("CompositionLayer#draw");
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
        ((apb)this.h.get(m)).a(paramCanvas, paramMatrix, paramInt);
      }
      m -= 1;
    }
    if (!this.j.isEmpty()) {
      paramCanvas.clipRect(this.j, Region.Op.REPLACE);
    }
    aux.b("CompositionLayer#draw");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apc
 * JD-Core Version:    0.7.0.1
 */