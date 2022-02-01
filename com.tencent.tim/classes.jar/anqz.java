import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class anqz
  extends Drawable
{
  private int height;
  private int mColor = -16777216;
  private final Paint mPaint = new Paint();
  private float mRadius;
  private RectF mRect;
  private int width;
  
  public anqz(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mColor = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.mRect = new RectF();
    this.mRadius = paramInt4;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mPaint.setColor(this.mColor);
    Rect localRect = getBounds();
    this.mRect.top = localRect.top;
    this.mRect.left = localRect.left;
    this.mRect.right = localRect.right;
    this.mRect.bottom = localRect.bottom;
    paramCanvas.drawRoundRect(this.mRect, this.mRadius, this.mRadius, this.mPaint);
  }
  
  public int getIntrinsicHeight()
  {
    return this.height;
  }
  
  public int getIntrinsicWidth()
  {
    return this.width;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqz
 * JD-Core Version:    0.7.0.1
 */