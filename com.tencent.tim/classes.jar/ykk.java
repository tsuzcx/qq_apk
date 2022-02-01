import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class ykk
  extends NativeGifImage
{
  private yla.a a;
  private boolean bmS;
  private Paint bq;
  private Paint br;
  
  public ykk(File paramFile, boolean paramBoolean, float paramFloat)
    throws IOException
  {
    super(paramFile, paramBoolean, false, 0, 0, paramFloat);
  }
  
  private void c(Canvas paramCanvas, Rect paramRect)
  {
    float f2 = 1.0F;
    if ((QLog.isColorLevel()) && (!this.bmS))
    {
      QLog.d("ZhituManager", 2, " dst rect is " + paramRect + " but bitmap is " + getWidth() + " / " + getHeight());
      this.bmS = true;
    }
    float f1 = paramRect.width() / getWidth();
    if (Math.abs(f1 - 1.0F) < 0.01D)
    {
      f1 = f2;
      if (this.bq == null)
      {
        this.bq = this.a.bs;
        this.br = this.a.strokePaint;
        f1 = f2;
      }
    }
    for (;;)
    {
      int i = 0;
      while (i < this.a.aP.length)
      {
        f2 = paramRect.top + this.a.aP[i] * f1;
        if (this.br != null) {
          paramCanvas.drawText(this.a.cN[i], paramRect.exactCenterX(), f2, this.br);
        }
        paramCanvas.drawText(this.a.cN[i], paramRect.exactCenterX(), f2, this.bq);
        i += 1;
      }
      if (this.bq == null)
      {
        this.bq = new Paint(this.a.bs);
        this.bq.setTextSize(this.a.bs.getTextSize() * f1);
        if (this.a.strokePaint != null)
        {
          this.br = new Paint(this.a.strokePaint);
          this.br.setTextSize(this.a.strokePaint.getTextSize() * f1);
        }
      }
    }
  }
  
  public void a(yla.a parama)
  {
    this.a = parama;
  }
  
  public Bitmap an()
  {
    return this.mCurrentFrameBitmap;
  }
  
  public void chU()
  {
    getNextFrame();
    applyNextFrame();
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
    c(paramCanvas, paramRect);
  }
  
  public void drawFirstFrame(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    super.drawFirstFrame(paramCanvas, paramRect, paramPaint);
    c(paramCanvas, paramRect);
  }
  
  public void drawText(Canvas paramCanvas)
  {
    Rect localRect = new Rect(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "draw text to file dst rect is " + localRect + " and bitmap is " + getWidth() + " / " + getHeight());
    }
    c(paramCanvas, localRect);
  }
  
  public int getCurrentFrameIndex()
  {
    return this.mCurrentFrameIndex;
  }
  
  public int getFrameCount()
  {
    return this.mMetaData[FRAME_COUNT_INDEX];
  }
  
  public int getFrameDelay()
  {
    return this.mMetaData[POST_INVALIDATION_TIME_INDEX];
  }
  
  public int getRealWidth()
  {
    return this.mMetaData[WIDTH_INDEX];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykk
 * JD-Core Version:    0.7.0.1
 */