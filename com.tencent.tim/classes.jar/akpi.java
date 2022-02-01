import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.Settings.Fit;

public class akpi
{
  private static final RectF aI = new RectF();
  private static final Rect bF;
  private static final float[] cS;
  private static final Point m;
  private static final Matrix s = new Matrix();
  private final Settings a;
  private final RectF aJ = new RectF();
  private float yb;
  private float yc;
  private float yd;
  
  static
  {
    cS = new float[2];
    m = new Point();
    bF = new Rect();
  }
  
  public akpi(Settings paramSettings)
  {
    this.a = paramSettings;
  }
  
  private void a(RectF paramRectF, Rect paramRect)
  {
    if (paramRectF.width() < paramRect.width())
    {
      this.aJ.left = (paramRectF.left - (paramRect.width() - paramRectF.width()));
      this.aJ.right = paramRectF.left;
    }
    while (paramRectF.height() < paramRect.height())
    {
      this.aJ.top = (paramRectF.top - (paramRect.height() - paramRectF.height()));
      this.aJ.bottom = paramRectF.top;
      return;
      localRectF1 = this.aJ;
      RectF localRectF2 = this.aJ;
      f = paramRect.left;
      localRectF2.right = f;
      localRectF1.left = f;
    }
    paramRectF = this.aJ;
    RectF localRectF1 = this.aJ;
    float f = paramRect.top;
    localRectF1.bottom = f;
    paramRectF.top = f;
  }
  
  private void b(RectF paramRectF, Rect paramRect)
  {
    if (paramRectF.width() < paramRect.width()) {
      this.aJ.left = (paramRectF.left - (paramRect.width() - paramRectF.width()));
    }
    for (this.aJ.right = paramRectF.left; paramRectF.height() < paramRect.height(); this.aJ.right = (paramRectF.right - paramRect.width()))
    {
      this.aJ.top = (paramRectF.top - (paramRect.height() - paramRectF.height()));
      this.aJ.bottom = paramRectF.top;
      return;
      this.aJ.left = paramRectF.left;
    }
    this.aJ.top = paramRectF.top;
    this.aJ.bottom = (paramRectF.bottom - paramRect.height());
  }
  
  private void c(RectF paramRectF, Rect paramRect)
  {
    this.aJ.left = (paramRectF.left - paramRect.width());
    this.aJ.right = paramRectF.right;
    this.aJ.top = (paramRectF.top - paramRect.height());
    this.aJ.bottom = paramRectF.bottom;
  }
  
  private void l(Rect paramRect)
  {
    akpo.a(this.a, m);
    cS[0] = m.x;
    cS[1] = m.y;
    if (!akpm.equals(this.yb, 0.0F))
    {
      s.setRotate(-this.yb, this.yc, this.yd);
      s.mapPoints(cS);
    }
    this.aJ.left = (cS[0] - paramRect.width());
    this.aJ.right = cS[0];
    this.aJ.top = (cS[1] - paramRect.height());
    this.aJ.bottom = cS[1];
  }
  
  public void U(float paramFloat1, float paramFloat2)
  {
    cS[0] = paramFloat1;
    cS[1] = paramFloat2;
    if (this.yb != 0.0F)
    {
      s.setRotate(-this.yb, this.yc, this.yd);
      s.mapPoints(cS);
    }
    this.aJ.union(cS[0], cS[1]);
  }
  
  public akpi a(akpm paramakpm)
  {
    Object localObject = aI;
    akpo.a(this.a, bF);
    ((RectF)localObject).set(bF);
    Rect localRect = bF;
    if (this.a.a() == Settings.Fit.OUTSIDE)
    {
      this.yb = paramakpm.getRotation();
      this.yc = ((RectF)localObject).centerX();
      this.yd = ((RectF)localObject).centerY();
      if (!akpm.equals(this.yb, 0.0F))
      {
        s.setRotate(-this.yb, this.yc, this.yd);
        s.mapRect((RectF)localObject);
      }
      paramakpm.d(s);
      if (!akpm.equals(this.yb, 0.0F)) {
        s.postRotate(-this.yb, this.yc, this.yd);
      }
      akpo.a(s, this.a, localRect);
      switch (akpj.mf[this.a.a().ordinal()])
      {
      default: 
        this.aJ.set(-5.368709E+008F, -5.368709E+008F, 5.368709E+008F, 5.368709E+008F);
      }
    }
    for (;;)
    {
      if (this.a.a() != Settings.Fit.OUTSIDE)
      {
        paramakpm.d(s);
        paramakpm = aI;
        paramakpm.set(0.0F, 0.0F, this.a.GY(), this.a.GZ());
        s.mapRect(paramakpm);
        localObject = cS;
        cS[1] = 0.0F;
        localObject[0] = 0.0F;
        s.mapPoints(cS);
        this.aJ.offset(cS[0] - paramakpm.left, cS[1] - paramakpm.top);
      }
      return this;
      this.yb = 0.0F;
      this.yd = 0.0F;
      this.yc = 0.0F;
      break;
      a((RectF)localObject, localRect);
      continue;
      b((RectF)localObject, localRect);
      continue;
      c((RectF)localObject, localRect);
      continue;
      l(localRect);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, PointF paramPointF)
  {
    cS[0] = paramFloat1;
    cS[1] = paramFloat2;
    if (this.yb != 0.0F)
    {
      s.setRotate(-this.yb, this.yc, this.yd);
      s.mapPoints(cS);
    }
    cS[0] = akpp.d(cS[0], this.aJ.left - paramFloat3, this.aJ.right + paramFloat3);
    cS[1] = akpp.d(cS[1], this.aJ.top - paramFloat4, this.aJ.bottom + paramFloat4);
    if (this.yb != 0.0F)
    {
      s.setRotate(this.yb, this.yc, this.yd);
      s.mapPoints(cS);
    }
    paramPointF.set(cS[0], cS[1]);
  }
  
  public void a(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    a(paramFloat1, paramFloat2, 0.0F, 0.0F, paramPointF);
  }
  
  public void d(RectF paramRectF)
  {
    if (this.yb == 0.0F)
    {
      paramRectF.set(this.aJ);
      return;
    }
    s.setRotate(this.yb, this.yc, this.yd);
    s.mapRect(paramRectF, this.aJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpi
 * JD-Core Version:    0.7.0.1
 */