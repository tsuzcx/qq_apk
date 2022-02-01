import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class aysx
{
  private float GB;
  private float GC;
  private RectF bS = new RectF();
  private Paint dn;
  private int eML = -1;
  private int mCount = 6;
  private float mRadius;
  
  public boolean a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mCount = paramInt2;
    this.GB = paramFloat2;
    this.GC = paramFloat3;
    this.eML = paramInt1;
    if (this.dn == null)
    {
      this.dn = new Paint();
      this.dn.setAntiAlias(true);
    }
    this.dn.setColor(this.eML);
    this.mRadius = paramFloat1;
    return true;
  }
  
  public RectF c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mCount)) {}
    while (this.bS.isEmpty()) {
      return null;
    }
    float f2 = this.bS.height() / (this.mCount + 1);
    float f1 = this.bS.width() / 2.0F;
    float f3 = paramInt;
    f2 = this.bS.top + (f2 + f3 * f2);
    return new RectF(f1 - this.mRadius, f2 - this.mRadius, f1 + this.mRadius, f2 + this.mRadius);
  }
  
  public void d(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramCanvas == null) {
      return;
    }
    float f2 = this.bS.width();
    float f3 = this.GC;
    float f4 = this.GB;
    float f1 = this.bS.height() / (this.mCount + 1);
    f2 = (f2 - f3 - f4) / 2.0F;
    f2 = this.GB + f2;
    int i = 0;
    label67:
    if (i < this.mCount)
    {
      f3 = i * f1 + f1 + this.bS.top;
      if ((i != this.mCount - 1) || (i != paramInt2)) {
        break label121;
      }
    }
    for (;;)
    {
      i += 1;
      break label67;
      break;
      label121:
      int j;
      if (i == this.mCount - 1)
      {
        j = this.dn.getAlpha();
        this.dn.setAlpha(paramInt1);
        paramCanvas.drawCircle(f2, f3, this.mRadius, this.dn);
        this.dn.setAlpha(j);
      }
      else if (i == paramInt2)
      {
        j = this.dn.getAlpha();
        this.dn.setAlpha(paramInt3);
        paramCanvas.drawCircle(f2, f3, this.mRadius, this.dn);
        this.dn.setAlpha(j);
      }
      else
      {
        j = this.dn.getAlpha();
        this.dn.setAlpha(paramInt4);
        paramCanvas.drawCircle(f2, f3, this.mRadius, this.dn);
        this.dn.setAlpha(j);
      }
    }
  }
  
  public void e(RectF paramRectF)
  {
    if (paramRectF != null) {
      this.bS.set(paramRectF);
    }
  }
  
  public void unInit() {}
  
  public int y(float paramFloat)
  {
    int k = 0;
    int j = k;
    float f2;
    int i;
    float f3;
    if (!this.bS.isEmpty())
    {
      float f4 = this.bS.height() / (this.mCount + 1);
      float f1 = 0.0F;
      f2 = 0.0F;
      i = 0;
      for (;;)
      {
        f3 = f1;
        if (i >= this.mCount) {
          break;
        }
        f1 = i * f4 + f4 + this.bS.top;
        f3 = f1;
        if (paramFloat <= f1) {
          break;
        }
        i += 1;
        f2 = f1;
      }
      if (i != this.mCount) {
        break label111;
      }
      j = this.mCount - 1;
    }
    label111:
    do
    {
      return j;
      j = k;
    } while (i == 0);
    if (paramFloat - f2 > f3 - paramFloat) {
      return i;
    }
    return i - 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aysx
 * JD-Core Version:    0.7.0.1
 */