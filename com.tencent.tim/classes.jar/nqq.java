import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class nqq
  extends Drawable
{
  private Bitmap mBitmap;
  
  public nqq(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, null);
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mBitmap.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mBitmap.getWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.mBitmap.getHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.mBitmap.getWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nqq
 * JD-Core Version:    0.7.0.1
 */