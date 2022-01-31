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
import uilib.doraemon.m;

public class bg
  extends bd
{
  private final s e;
  private final List f = new ArrayList();
  private final RectF g = new RectF();
  private final Rect h = new Rect();
  private final RectF i = new RectF();
  
  public bg(e parame, cs paramcs, List paramList, a parama)
  {
    super(parame, paramcs);
    paramcs = paramcs.u();
    HashMap localHashMap;
    int j;
    label114:
    cs localcs;
    bd localbd;
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
      localbd = a(localcs, parame, parama);
      if (localbd != null) {
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
      localHashMap.put(Long.valueOf(localbd.a().e()), localbd);
      if (paramcs != null)
      {
        paramcs.a(localbd);
        paramcs = null;
      }
      else
      {
        this.f.add(0, localbd);
        switch (bh.a[localcs.l().ordinal()])
        {
        default: 
          break;
        case 1: 
        case 2: 
          paramcs = localbd;
        }
      }
    }
    label257:
    parame = localHashMap.keySet().iterator();
    while (parame.hasNext())
    {
      paramcs = (bd)localHashMap.get(parame.next());
      paramList = (bd)localHashMap.get(Long.valueOf(paramcs.a().m()));
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
      ((bd)this.f.get(j)).a(f1 - paramFloat);
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
      ((bd)this.f.get(j)).a(this.g, this.a);
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
      bd localbd = (bd)this.f.get(j);
      String str = localbd.a().f();
      if (paramString1 == null) {
        localbd.a(null, null, paramColorFilter);
      }
      for (;;)
      {
        j += 1;
        break;
        if (str.equals(paramString1)) {
          localbd.a(paramString1, paramString2, paramColorFilter);
        }
      }
    }
  }
  
  void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    m.a("CompositionLayer#draw");
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
        ((bd)this.f.get(j)).a(paramCanvas, paramMatrix, paramInt);
      }
      j -= 1;
    }
    if (!this.h.isEmpty()) {
      paramCanvas.clipRect(this.h, Region.Op.REPLACE);
    }
    m.b("CompositionLayer#draw");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bg
 * JD-Core Version:    0.7.0.1
 */