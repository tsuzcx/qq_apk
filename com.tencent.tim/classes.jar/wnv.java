import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;

public class wnv
{
  public Bitmap mBitmap;
  public NinePatch mNinePatch;
  
  public void D(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.mBitmap = paramBitmap;
      paramBitmap = this.mBitmap.getNinePatchChunk();
      if ((paramBitmap != null) && (NinePatch.isNinePatchChunk(paramBitmap))) {
        this.mNinePatch = new NinePatch(this.mBitmap, paramBitmap, null);
      }
    }
    else
    {
      return;
    }
    this.mNinePatch = null;
  }
  
  public void a(Canvas paramCanvas, Rect paramRect1, Rect paramRect2, Paint paramPaint)
  {
    if (this.mNinePatch != null) {
      if (paramPaint != null) {
        this.mNinePatch.draw(paramCanvas, paramRect2, paramPaint);
      }
    }
    while ((this.mBitmap == null) || (paramPaint == null)) {
      return;
    }
    paramCanvas.drawBitmap(this.mBitmap, paramRect1, paramRect2, paramPaint);
  }
  
  public void recycle()
  {
    if (this.mBitmap != null)
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnv
 * JD-Core Version:    0.7.0.1
 */