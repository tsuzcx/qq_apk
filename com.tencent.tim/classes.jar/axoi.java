import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import dov.com.qq.im.aeeditor.view.ClipConstant;
import dov.com.qq.im.aeeditor.view.ClipConstant.Anchor;
import java.lang.reflect.Array;

public class axoi
  implements ClipConstant
{
  private Matrix Q = new Matrix();
  private RectF bp = new RectF();
  private RectF bq = new RectF();
  private RectF br = new RectF();
  private RectF bs = new RectF();
  private Paint da = new Paint(1);
  private boolean dvA;
  private boolean dvB;
  private boolean dvz;
  private float[][] e = (float[][])Array.newInstance(Float.TYPE, new int[] { 2, 4 });
  private float[] ed = new float[16];
  private float[] ee = new float[32];
  private boolean isResetting = true;
  private Paint mPaint = new Paint(1);
  
  public axoi()
  {
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.da.setStyle(Paint.Style.STROKE);
    this.da.setStrokeCap(Paint.Cap.SQUARE);
    this.da.setColor(201326592);
    this.da.setStrokeWidth(24.0F);
  }
  
  private void ag(float paramFloat1, float paramFloat2)
  {
    YE(true);
    this.bp.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    ayku.a(this.bs, this.bp, 10.0F);
    this.br.set(this.bp);
  }
  
  public void YC(boolean paramBoolean)
  {
    this.dvB = paramBoolean;
  }
  
  public void YD(boolean paramBoolean)
  {
    this.dvz = paramBoolean;
  }
  
  public void YE(boolean paramBoolean)
  {
    this.isResetting = paramBoolean;
  }
  
  public void YF(boolean paramBoolean)
  {
    this.dvA = paramBoolean;
  }
  
  public RectF a(float paramFloat1, float paramFloat2)
  {
    RectF localRectF = new RectF(this.bp);
    localRectF.offset(paramFloat1, paramFloat2);
    return localRectF;
  }
  
  public ClipConstant.Anchor a(float paramFloat1, float paramFloat2)
  {
    if ((ClipConstant.Anchor.isCohesionContains(this.bp, -48.0F, paramFloat1, paramFloat2)) && (!ClipConstant.Anchor.isCohesionContains(this.bp, 48.0F, paramFloat1, paramFloat2)))
    {
      Object localObject = ClipConstant.Anchor.cohesion(this.bp, 0.0F);
      int i = 0;
      int k;
      for (int j = 0; i < localObject.length; j = k)
      {
        k = j;
        if (Math.abs(localObject[i] - new float[] { paramFloat1, paramFloat2 }[(i >> 1)]) < 48.0F) {
          k = j | 1 << i;
        }
        i += 1;
      }
      localObject = ClipConstant.Anchor.valueOf(j);
      if (localObject != null) {
        this.dvB = false;
      }
      return localObject;
    }
    return null;
  }
  
  public void a(RectF paramRectF, float paramFloat)
  {
    RectF localRectF = new RectF();
    this.Q.setRotate(paramFloat, paramRectF.centerX(), paramRectF.centerY());
    this.Q.mapRect(localRectF, paramRectF);
    ag(localRectF.width(), localRectF.height());
  }
  
  public void a(ClipConstant.Anchor paramAnchor, float paramFloat1, float paramFloat2)
  {
    paramAnchor.moveFrame(this.bs, this.bp, paramFloat1, paramFloat2);
  }
  
  public boolean aPh()
  {
    this.bq.set(this.bp);
    this.br.set(this.bp);
    ayku.a(this.bs, this.br, 10.0F);
    if (!this.br.equals(this.bq)) {}
    for (boolean bool = true;; bool = false)
    {
      this.dvB = bool;
      return bool;
    }
  }
  
  public boolean aPi()
  {
    return this.dvB;
  }
  
  public boolean aPj()
  {
    return this.dvz;
  }
  
  public void af(float paramFloat1, float paramFloat2)
  {
    this.bs.set(0.0F, 0.0F, paramFloat1, 1.0F * paramFloat2);
    if (!this.bp.isEmpty())
    {
      axiy.e("yk", "before setClipWinSize frame::" + this.bp);
      ayku.b(this.bs, this.bp);
      axiy.e("yk", "setClipWinSize frame::" + this.bp);
      this.br.set(this.bp);
    }
  }
  
  public void bt(float paramFloat)
  {
    if (this.dvB) {
      this.bp.set(this.bq.left + (this.br.left - this.bq.left) * paramFloat, this.bq.top + (this.br.top - this.bq.top) * paramFloat, this.bq.right + (this.br.right - this.bq.right) * paramFloat, this.bq.bottom + (this.br.bottom - this.bq.bottom) * paramFloat);
    }
  }
  
  public boolean isResetting()
  {
    return this.isResetting;
  }
  
  public RectF j()
  {
    return this.br;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    if (this.isResetting) {
      return;
    }
    float f1 = this.bp.width();
    float f2 = this.bp.height();
    int i = 0;
    int j;
    while (i < this.e.length)
    {
      j = 0;
      while (j < this.e[i].length)
      {
        this.e[i][j] = (new float[] { f1, f2 }[i] * ea[j]);
        j += 1;
      }
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.ed.length) {
        break;
      }
      this.ed[i] = this.e[(i & 0x1)][(1935858840 >>> (i << 1) & 0x3)];
      i += 1;
    }
    while (j < this.ee.length)
    {
      this.ee[j] = (this.e[(j & 0x1)][(179303760 >>> j & 0x1)] + ec[(hZ[j] & 0x3)] + eb[(hZ[j] >> 2)]);
      j += 1;
    }
    paramCanvas.translate(this.bp.left, this.bp.top);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(-2130706433);
    this.mPaint.setStrokeWidth(3.0F);
    paramCanvas.drawLines(this.ed, this.mPaint);
    paramCanvas.translate(-this.bp.left, -this.bp.top);
    this.mPaint.setColor(-1);
    this.mPaint.setStrokeWidth(5.0F);
    paramCanvas.drawRect(this.bp, this.da);
    paramCanvas.drawRect(this.bp, this.mPaint);
    paramCanvas.translate(this.bp.left, this.bp.top);
    this.mPaint.setColor(-1);
    this.mPaint.setStrokeWidth(10.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axoi
 * JD-Core Version:    0.7.0.1
 */