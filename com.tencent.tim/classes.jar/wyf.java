import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

public class wyf
  extends Drawable
{
  private static final Rect ba = new Rect();
  private static final RectF sTmpRectF = new RectF();
  private String aUy;
  private boolean bgt;
  private Paint mPaint = new Paint(1);
  private float mRoundRadius;
  private Paint mTextPaint;
  private Rect textRect;
  
  public wyf(int paramInt, float paramFloat)
  {
    this.mPaint.setColor(paramInt);
    this.mRoundRadius = paramFloat;
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    int i = getLevel();
    if (i == 0) {}
    Rect localRect1;
    Rect localRect2;
    int j;
    int k;
    int m;
    do
    {
      return;
      localRect1 = ba;
      localRect2 = getBounds();
      j = localRect2.width();
      k = localRect2.height();
      k -= (10000 - i) * k / 10000;
      m = paramCanvas.getHeight();
      Gravity.apply(48, j, k, localRect2, localRect1);
    } while ((j <= 0) || (k <= 0));
    this.aUy = (100 - i / 100 + "%");
    paramCanvas.save();
    float f2;
    if (this.bgt)
    {
      this.mTextPaint.getTextBounds(this.aUy, 0, this.aUy.length(), this.textRect);
      f2 = (paramCanvas.getWidth() - this.textRect.width()) / 2;
      f1 = (this.textRect.height() + m) / 2;
      paramCanvas.drawText(this.aUy, f2, f1, this.mTextPaint);
    }
    for (;;)
    {
      paramCanvas.clipRect(localRect1);
      sTmpRectF.set(localRect2);
      paramCanvas.drawRoundRect(sTmpRectF, this.mRoundRadius, this.mRoundRadius, this.mPaint);
      if (this.bgt) {
        paramCanvas.drawText(this.aUy, f2, f1, this.mTextPaint);
      }
      paramCanvas.restore();
      return;
      f2 = 0.0F;
    }
  }
  
  public void fH(int paramInt1, int paramInt2)
  {
    this.bgt = true;
    this.mTextPaint = new Paint(1);
    this.mTextPaint.setTextSize(paramInt1);
    this.mTextPaint.setColor(paramInt2);
    this.textRect = new Rect();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyf
 * JD-Core Version:    0.7.0.1
 */