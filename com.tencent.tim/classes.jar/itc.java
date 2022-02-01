import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class itc
{
  public Bitmap mBitmap;
  public Rect mRect = new Rect();
  
  public itc(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      this.mRect.right = this.mBitmap.getWidth();
      this.mRect.bottom = this.mBitmap.getHeight();
    }
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.mBitmap, this.mRect, paramRect, paramPaint);
    }
  }
  
  public void recycle()
  {
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      this.mBitmap.recycle();
    }
    this.mBitmap = null;
    this.mRect = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itc
 * JD-Core Version:    0.7.0.1
 */