import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class adxl
  extends Drawable
{
  public boolean bRE;
  public Bitmap mBitmap;
  public int mHeight = -1;
  private Paint mPaint = new Paint(6);
  public int mWidth = -1;
  
  public adxl(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = super.getBounds();
    if (this.bRE)
    {
      paramCanvas.save();
      paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
    }
    paramCanvas.drawBitmap(this.mBitmap, null, super.getBounds(), this.mPaint);
    if (this.bRE) {
      paramCanvas.restore();
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.mWidth;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mHeight;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mPaint.setDither(paramBoolean);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxl
 * JD-Core Version:    0.7.0.1
 */