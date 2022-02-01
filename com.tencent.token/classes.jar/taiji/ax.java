package taiji;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.token.gn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uilib.doraemon.a;
import uilib.doraemon.d;
import uilib.doraemon.e;

class ax
  extends ar
{
  private final char[] e = new char[1];
  private final RectF f = new RectF();
  private final Matrix g = new Matrix();
  private final Paint h = new Paint(1) {};
  private final Paint i = new Paint(1) {};
  private final Map<ay, List<bs>> j = new HashMap();
  private final w k;
  private final e l;
  private final a m;
  private p<Integer> n;
  private p<Integer> o;
  private p<Float> p;
  private p<Float> q;
  
  ax(e parame, cs paramcs)
  {
    super(parame, paramcs);
    this.l = parame;
    this.m = paramcs.a();
    this.k = paramcs.s().a();
    this.k.a(this);
    a(this.k);
    parame = paramcs.t();
    if ((parame != null) && (parame.a != null))
    {
      this.n = parame.a.a();
      this.n.a(this);
      a(this.n);
    }
    if ((parame != null) && (parame.b != null))
    {
      this.o = parame.b.a();
      this.o.a(this);
      a(this.o);
    }
    if ((parame != null) && (parame.c != null))
    {
      this.p = parame.c.a();
      this.p.a(this);
      a(this.p);
    }
    if ((parame != null) && (parame.d != null))
    {
      this.q = parame.d.a();
      this.q.a(this);
      a(this.q);
    }
  }
  
  private float a(String paramString, float paramFloat1, float paramFloat2)
  {
    int i1 = 0;
    float f1 = 0.0F;
    while (i1 < paramString.length())
    {
      this.e[0] = paramString.charAt(i1);
      f1 = f1 + this.h.measureText(this.e, 0, 1) + paramFloat1 * paramFloat2;
      i1 += 1;
    }
    return f1;
  }
  
  private List<bs> a(ay paramay)
  {
    if (this.j.containsKey(paramay)) {
      return (List)this.j.get(paramay);
    }
    List localList = paramay.a();
    int i2 = localList.size();
    ArrayList localArrayList = new ArrayList(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      ap localap = (ap)localList.get(i1);
      localArrayList.add(new bs(this.l, this, localap));
      i1 += 1;
    }
    this.j.put(paramay, localArrayList);
    return localArrayList;
  }
  
  private void a(char paramChar, am paramam, Canvas paramCanvas)
  {
    paramam = this.e;
    paramam[0] = paramChar;
    a(paramam, this.h, paramCanvas);
  }
  
  private void a(Path paramPath, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {
      return;
    }
    if ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private void a(am paramam, Matrix paramMatrix, aq paramaq, Canvas paramCanvas)
  {
    float f3 = paramam.c / 100.0F;
    float f4 = gn.a(paramMatrix);
    String str = paramam.a;
    float f2 = paramam.e / 10.0F;
    Object localObject = this.q;
    float f1 = f2;
    if (localObject != null) {
      f1 = f2 + ((Float)((p)localObject).b()).floatValue();
    }
    int i2;
    if (paramam.d != 0)
    {
      i1 = 0;
      f2 = 0.0F;
      while (i1 < str.length())
      {
        i2 = ay.a(str.charAt(i1), paramaq.a(), paramaq.b());
        localObject = (ay)this.m.f().get(Integer.valueOf(i2));
        if (localObject != null) {
          f2 = f2 + (float)((ay)localObject).b() * f3 * this.m.j() * f4 + f1 * f4;
        }
        i1 += 1;
      }
      if (paramam.d == 1) {}
      for (f2 = -f2;; f2 = -f2 / 2.0F)
      {
        paramCanvas.translate(f2, 0.0F);
        break;
        if (paramam.d != 2) {
          break;
        }
      }
    }
    int i1 = 0;
    while (i1 < str.length())
    {
      i2 = ay.a(str.charAt(i1), paramaq.a(), paramaq.b());
      localObject = (ay)this.m.f().get(Integer.valueOf(i2));
      if (localObject != null)
      {
        a((ay)localObject, paramMatrix, f3, paramam, paramCanvas);
        paramCanvas.translate((float)((ay)localObject).b() * f3 * this.m.j() * f4 + f1 * f4, 0.0F);
      }
      i1 += 1;
    }
  }
  
  private void a(am paramam, aq paramaq, Matrix paramMatrix, Canvas paramCanvas)
  {
    float f3 = gn.a(paramMatrix);
    float f2 = paramam.e / 10.0F;
    paramaq = this.q;
    float f1 = f2;
    if (paramaq != null) {
      f1 = f2 + ((Float)paramaq.b()).floatValue();
    }
    paramaq = paramam.a;
    float f4 = a(paramaq, f1, f3);
    paramMatrix = this.l.i();
    if (paramMatrix != null)
    {
      paramaq = paramMatrix.b(paramaq);
      f2 = a(paramaq, f1, f3);
    }
    else
    {
      f2 = 0.0F;
    }
    this.h.setTextSize(paramam.c * this.m.j());
    this.i.setTextSize(this.h.getTextSize());
    if (f2 > 0.0F)
    {
      if (paramam.d == 1) {}
      for (f2 = f4 - f2;; f2 = (f4 - f2) / 2.0F)
      {
        paramCanvas.translate(f2, 0.0F);
        break;
        if (paramam.d != 2) {
          break;
        }
      }
    }
    int i1 = 0;
    while (i1 < paramaq.length())
    {
      char c = paramaq.charAt(i1);
      a(c, paramam, paramCanvas);
      paramMatrix = this.e;
      paramMatrix[0] = c;
      paramCanvas.translate(this.h.measureText(paramMatrix, 0, 1) + f1 * f3, 0.0F);
      i1 += 1;
    }
  }
  
  private void a(ay paramay, Matrix paramMatrix, float paramFloat, am paramam, Canvas paramCanvas)
  {
    List localList = a(paramay);
    int i1 = 0;
    while (i1 < localList.size())
    {
      Path localPath = ((bs)localList.get(i1)).a();
      localPath.computeBounds(this.f, false);
      this.g.set(paramMatrix);
      this.g.preScale(paramFloat, paramFloat);
      localPath.transform(this.g);
      if (paramam.j)
      {
        a(localPath, this.h, paramCanvas);
        paramay = this.i;
      }
      else
      {
        a(localPath, this.i, paramCanvas);
        paramay = this.h;
      }
      a(localPath, paramay, paramCanvas);
      i1 += 1;
    }
  }
  
  private void a(char[] paramArrayOfChar, Paint paramPaint, Canvas paramCanvas)
  {
    paramCanvas.drawText(paramArrayOfChar, 0, 1, 0.0F, 0.0F, paramPaint);
  }
  
  void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    paramCanvas.save();
    if (!this.l.j()) {
      paramCanvas.concat(paramMatrix);
    }
    am localam = (am)this.k.b();
    aq localaq = (aq)this.m.g().get(localam.b);
    if (localaq == null) {
      return;
    }
    p localp = this.n;
    if (localp != null) {
      this.h.setColor(((Integer)localp.b()).intValue());
    } else {
      this.h.setColor(localam.g);
    }
    localp = this.o;
    if (localp != null) {
      this.i.setColor(((Integer)localp.b()).intValue());
    } else {
      this.i.setColor(localam.h);
    }
    localp = this.p;
    if (localp != null)
    {
      this.i.setStrokeWidth(((Float)localp.b()).floatValue());
    }
    else
    {
      float f1 = gn.a(paramMatrix);
      this.i.setStrokeWidth(localam.i * this.m.j() * f1);
    }
    this.h.setAlpha(paramInt);
    this.i.setAlpha(paramInt);
    if (this.l.j()) {
      a(localam, paramMatrix, localaq, paramCanvas);
    } else {
      a(localam, localaq, paramMatrix, paramCanvas);
    }
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ax
 * JD-Core Version:    0.7.0.1
 */