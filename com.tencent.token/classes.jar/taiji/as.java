package taiji;

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
import uilib.doraemon.a;
import uilib.doraemon.e;
import uilib.doraemon.g;

public class as
  extends ar
{
  private final p<Float> e;
  private final List<ar> f = new ArrayList();
  private final RectF g = new RectF();
  private final Rect h = new Rect();
  private final RectF i = new RectF();
  
  public as(e parame, cs paramcs, List<cs> paramList, a parama)
  {
    super(parame, paramcs);
    paramcs = paramcs.u();
    HashMap localHashMap;
    int j;
    label114:
    cs localcs;
    ar localar;
    if (paramcs != null)
    {
      this.e = paramcs.a();
      a(this.e);
      this.e.a(this);
      localHashMap = new HashMap(parama.e().size());
      j = paramList.size() - 1;
      paramcs = null;
      if (j < 0) {
        break label257;
      }
      localcs = (cs)paramList.get(j);
      localar = a(localcs, parame, parama);
      if (localar != null) {
        break label164;
      }
    }
    for (;;)
    {
      j -= 1;
      break label114;
      this.e = null;
      break;
      label164:
      localHashMap.put(Long.valueOf(localar.a().e()), localar);
      if (paramcs != null)
      {
        paramcs.a(localar);
        paramcs = null;
      }
      else
      {
        this.f.add(0, localar);
        switch (1.a[localcs.l().ordinal()])
        {
        default: 
          break;
        case 1: 
        case 2: 
          paramcs = localar;
        }
      }
    }
    label257:
    parame = localHashMap.keySet().iterator();
    while (parame.hasNext())
    {
      paramcs = (ar)localHashMap.get(parame.next());
      paramList = (ar)localHashMap.get(Long.valueOf(paramcs.a().m()));
      if (paramList != null) {
        paramcs.b(paramList);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    super.a(paramFloat);
    float f1 = paramFloat;
    if (this.c.b() != 0.0F) {
      f1 = paramFloat / this.c.b();
    }
    paramFloat = this.c.c();
    int j = this.f.size() - 1;
    while (j >= 0)
    {
      ((ar)this.f.get(j)).a(f1 - paramFloat);
      j -= 1;
    }
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    this.g.set(0.0F, 0.0F, 0.0F, 0.0F);
    int j = this.f.size() - 1;
    if (j >= 0)
    {
      ((ar)this.f.get(j)).a(this.g, this.a);
      if (paramRectF.isEmpty()) {
        paramRectF.set(this.g);
      }
      for (;;)
      {
        j -= 1;
        break;
        paramRectF.set(Math.min(paramRectF.left, this.g.left), Math.min(paramRectF.top, this.g.top), Math.max(paramRectF.right, this.g.right), Math.max(paramRectF.bottom, this.g.bottom));
      }
    }
  }
  
  public void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    int j = 0;
    if (j < this.f.size())
    {
      ar localar = (ar)this.f.get(j);
      String str = localar.a().f();
      if (paramString1 == null) {
        localar.a(null, null, paramColorFilter);
      }
      for (;;)
      {
        j += 1;
        break;
        if (str.equals(paramString1)) {
          localar.a(paramString1, paramString2, paramColorFilter);
        }
      }
    }
  }
  
  void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    g.a("CompositionLayer#draw");
    paramCanvas.getClipBounds(this.h);
    this.i.set(0.0F, 0.0F, this.c.h(), this.c.i());
    paramMatrix.mapRect(this.i);
    int j = this.f.size() - 1;
    while (j >= 0)
    {
      boolean bool = true;
      if (!this.i.isEmpty()) {
        bool = paramCanvas.clipRect(this.i);
      }
      if (bool) {
        ((ar)this.f.get(j)).a(paramCanvas, paramMatrix, paramInt);
      }
      j -= 1;
    }
    if (!this.h.isEmpty()) {
      paramCanvas.clipRect(this.h, Region.Op.REPLACE);
    }
    g.b("CompositionLayer#draw");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.as
 * JD-Core Version:    0.7.0.1
 */