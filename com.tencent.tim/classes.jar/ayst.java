import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class ayst
{
  private float GB;
  private float GC;
  private float GD = 1.0F;
  private RectF bS = new RectF();
  private int mBgColor = 0;
  private Paint mPaint;
  
  public void d(Canvas paramCanvas, int paramInt)
  {
    if (paramCanvas == null) {
      return;
    }
    this.mPaint.setAlpha(paramInt);
    float f1 = this.bS.width() - this.GB - this.GC;
    float f2 = this.GD * f1;
    paramCanvas.save();
    RectF localRectF = new RectF(this.bS.left + this.GB, this.bS.top, f1 + (this.bS.left + this.GB), this.bS.top + f2);
    paramCanvas.clipRect(localRectF.left, localRectF.top, localRectF.right, localRectF.top + f2 / 2.0F);
    paramCanvas.drawOval(localRectF, this.mPaint);
    paramCanvas.restore();
    paramCanvas.save();
    localRectF.top = (this.bS.bottom - f2);
    localRectF.bottom = this.bS.bottom;
    paramCanvas.clipRect(localRectF.left, localRectF.top + f2 / 2.0F, localRectF.right, localRectF.bottom);
    paramCanvas.drawOval(localRectF, this.mPaint);
    paramCanvas.restore();
    localRectF.top = Math.round(this.bS.top + f2 / 2.0F);
    localRectF.bottom = Math.round(this.bS.bottom - f2 / 2.0F);
    paramCanvas.drawRect(localRectF, this.mPaint);
  }
  
  public void e(RectF paramRectF)
  {
    this.bS.set(paramRectF);
  }
  
  public void g(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.mBgColor = paramInt;
    this.GB = paramFloat1;
    this.GC = paramFloat2;
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
    }
    this.mPaint.setColor(this.mBgColor);
  }
  
  public void unInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayst
 * JD-Core Version:    0.7.0.1
 */