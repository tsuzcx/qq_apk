import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class arge
{
  private static boolean dap;
  private Rect bx = new Rect();
  private boolean dao;
  private int egK = 10;
  private Bitmap gK;
  private Paint mPaint = new Paint(5);
  private View mView;
  private Canvas r = new Canvas();
  
  public arge(int paramInt)
  {
    this.egK = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    long l = SystemClock.uptimeMillis();
    int i = this.mView.getWidth() / this.egK;
    int j = this.mView.getHeight() / this.egK;
    if ((this.gK == null) || (this.gK.getWidth() != i) || (this.gK.getHeight() != j))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MosaicEffect", 2, "draw: try to alloc bitmap w x h=[" + i + "x" + j + "]");
      }
      if (i > 0) {
        break label406;
      }
      QLog.e("MosaicEffect", 1, "draw: mosaicWidth <= 0");
      i = 1;
    }
    label406:
    for (;;)
    {
      if (j <= 0)
      {
        QLog.e("MosaicEffect", 1, "draw: mosaicHeight <= 0");
        j = 1;
      }
      for (;;)
      {
        try
        {
          this.gK = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          if (this.gK == null)
          {
            QLog.e("MosaicEffect", 1, "draw: Bitmap is NULL");
            return;
          }
        }
        catch (Exception localException1)
        {
          QLog.e("MosaicEffect", 1, "draw: createBitmap failed ", localException1);
          try
          {
            this.gK = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
          }
          catch (Exception localException2)
          {
            QLog.e("MosaicEffect", 1, "draw: alloc memory failed, do nothing", localException2);
          }
          continue;
          this.gK.eraseColor(0);
          this.r.setBitmap(this.gK);
          this.mView.computeScroll();
          i = this.r.save();
          float f = 1.0F / this.egK;
          this.r.scale(f, f);
          this.r.translate(-this.mView.getScrollX(), -this.mView.getScrollY());
          this.dao = false;
          if ((this.mView instanceof arge.a)) {
            ((arge.a)this.mView).aX(this.r);
          }
          this.r.restoreToCount(i);
          this.r.setBitmap(null);
          this.dao = true;
          if ((this.mView instanceof arge.a)) {
            ((arge.a)this.mView).aX(paramCanvas);
          }
          if (QLog.isColorLevel())
          {
            QLog.i("MosaicEffect", 2, "draw: " + (SystemClock.uptimeMillis() - l) + " ms");
            return;
          }
        }
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.dao)
    {
      this.mPaint.setFilterBitmap(false);
      if (this.gK != null)
      {
        if (!paramCanvas.getClipBounds(this.bx)) {
          break label159;
        }
        if ((!paramCanvas.isHardwareAccelerated()) && (this.mView != null) && ((this.mView.getWidth() < this.bx.width()) || (this.mView.getHeight() < this.bx.height()))) {
          this.bx.set(0, 0, this.mView.getWidth(), this.mView.getHeight());
        }
        if (dap)
        {
          this.mPaint.setStyle(Paint.Style.FILL);
          this.mPaint.setColor(-65536);
          paramCanvas.drawRect(this.bx, this.mPaint);
        }
        paramCanvas.drawBitmap(this.gK, null, this.bx, this.mPaint);
      }
    }
    label159:
    while (!(this.mView instanceof arge.a))
    {
      return;
      QLog.e("MosaicEffect", 1, "onDraw: clipBound is empty " + this.bx);
      return;
    }
    ((arge.a)this.mView).aY(this.r);
  }
  
  public void setView(View paramView)
  {
    this.mView = paramView;
  }
  
  public static abstract interface a
  {
    public abstract void aX(Canvas paramCanvas);
    
    public abstract void aY(Canvas paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arge
 * JD-Core Version:    0.7.0.1
 */