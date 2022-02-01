import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class wye
  extends Drawable
{
  private static final Rect ba = new Rect();
  private static final RectF sTmpRectF = new RectF();
  private int alpha;
  private ColorFilter color;
  private Paint mPaint = new Paint(1);
  private float mRoundRadius;
  
  public wye(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mPaint.setColor(paramInt1);
    this.mPaint.setAlpha(paramInt2);
    this.mRoundRadius = paramFloat;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    if ((i > 0) && (j > 0))
    {
      paramCanvas.save();
      sTmpRectF.set(localRect);
      paramCanvas.drawRoundRect(sTmpRectF, this.mRoundRadius, this.mRoundRadius, this.mPaint);
      paramCanvas.restore();
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.alpha = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.color = paramColorFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wye
 * JD-Core Version:    0.7.0.1
 */