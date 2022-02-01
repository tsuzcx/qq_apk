package taiji;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.token.go;
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
    float f1 = 0.0F;
    int i1 = 0;
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
    this.e[0] = paramChar;
    a(this.e, this.h, paramCanvas);
  }
  
  private void a(Path paramPath, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {}
    while ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private void a(am paramam, Matrix paramMatrix, aq paramaq, Canvas paramCanvas)
  {
    float f3 = paramam.c / 100.0F;
    float f4 = go.a(paramMatrix);
    String str = paramam.a;
    float f1 = paramam.e / 10.0F;
    if (this.q != null) {
      f1 = ((Float)this.q.b()).floatValue() + f1;
    }
    for (;;)
    {
      float f2;
      int i1;
      int i2;
      ay localay;
      if (paramam.d != 0)
      {
        f2 = 0.0F;
        i1 = 0;
        if (i1 < str.length())
        {
          i2 = ay.a(str.charAt(i1), paramaq.a(), paramaq.b());
          localay = (ay)this.m.f().get(Integer.valueOf(i2));
          if (localay == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            f2 = f1 * f4 + ((float)localay.b() * f3 * this.m.j() * f4 + f2);
          }
        }
        if (paramam.d == 1) {
          paramCanvas.translate(-f2, 0.0F);
        }
      }
      else
      {
        i1 = 0;
        label190:
        if (i1 >= str.length()) {
          break label325;
        }
        i2 = ay.a(str.charAt(i1), paramaq.a(), paramaq.b());
        localay = (ay)this.m.f().get(Integer.valueOf(i2));
        if (localay != null) {
          break label278;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label190;
        if (paramam.d != 2) {
          break;
        }
        paramCanvas.translate(-f2 / 2.0F, 0.0F);
        break;
        label278:
        a(localay, paramMatrix, f3, paramam, paramCanvas);
        paramCanvas.translate((float)localay.b() * f3 * this.m.j() * f4 + f1 * f4, 0.0F);
      }
      label325:
      return;
    }
  }
  
  private void a(am paramam, aq paramaq, Matrix paramMatrix, Canvas paramCanvas)
  {
    float f3 = go.a(paramMatrix);
    float f1 = paramam.e / 10.0F;
    if (this.q != null) {
      f1 = ((Float)this.q.b()).floatValue() + f1;
    }
    for (;;)
    {
      paramaq = paramam.a;
      float f4 = a(paramaq, f1, f3);
      paramMatrix = this.l.i();
      if (paramMatrix != null) {
        paramaq = paramMatrix.b(paramaq);
      }
      for (float f2 = a(paramaq, f1, f3);; f2 = 0.0F)
      {
        this.h.setTextSize(paramam.c * this.m.j());
        this.i.setTextSize(this.h.getTextSize());
        if (f2 > 0.0F)
        {
          if (paramam.d != 1) {
            break label217;
          }
          paramCanvas.translate(f4 - f2, 0.0F);
        }
        for (;;)
        {
          int i1 = 0;
          while (i1 < paramaq.length())
          {
            char c = paramaq.charAt(i1);
            a(c, paramam, paramCanvas);
            this.e[0] = c;
            paramCanvas.translate(this.h.measureText(this.e, 0, 1) + f1 * f3, 0.0F);
            i1 += 1;
          }
          label217:
          if (paramam.d == 2) {
            paramCanvas.translate((f4 - f2) / 2.0F, 0.0F);
          }
        }
        return;
      }
    }
  }
  
  private void a(ay paramay, Matrix paramMatrix, float paramFloat, am paramam, Canvas paramCanvas)
  {
    paramay = a(paramay);
    int i1 = 0;
    if (i1 < paramay.size())
    {
      Path localPath = ((bs)paramay.get(i1)).a();
      localPath.computeBounds(this.f, false);
      this.g.set(paramMatrix);
      this.g.preScale(paramFloat, paramFloat);
      localPath.transform(this.g);
      if (paramam.j)
      {
        a(localPath, this.h, paramCanvas);
        a(localPath, this.i, paramCanvas);
      }
      for (;;)
      {
        i1 += 1;
        break;
        a(localPath, this.i, paramCanvas);
        a(localPath, this.h, paramCanvas);
      }
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
    if (this.n != null)
    {
      this.h.setColor(((Integer)this.n.b()).intValue());
      if (this.o == null) {
        break label197;
      }
      this.i.setColor(((Integer)this.o.b()).intValue());
      label114:
      if (this.p == null) {
        break label212;
      }
      this.i.setStrokeWidth(((Float)this.p.b()).floatValue());
      label141:
      this.h.setAlpha(paramInt);
      this.i.setAlpha(paramInt);
      if (!this.l.j()) {
        break label245;
      }
      a(localam, paramMatrix, localaq, paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      this.h.setColor(localam.g);
      break;
      label197:
      this.i.setColor(localam.h);
      break label114;
      label212:
      float f1 = go.a(paramMatrix);
      this.i.setStrokeWidth(f1 * (localam.i * this.m.j()));
      break label141;
      label245:
      a(localam, localaq, paramMatrix, paramCanvas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ax
 * JD-Core Version:    0.7.0.1
 */