package dov.com.qq.im.capture.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import axxj;
import com.tencent.qphone.base.util.QLog;

public class QIMLoadingViewWithRetry
  extends QIMCommonLoadingView
{
  protected Paint de;
  protected int eIB;
  protected Bitmap hz;
  protected int mBitmapHeight;
  protected int mBitmapWidth;
  
  public QIMLoadingViewWithRetry(Context paramContext)
  {
    super(paramContext);
  }
  
  public QIMLoadingViewWithRetry(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QIMLoadingViewWithRetry(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aeR(int paramInt)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 1;
      localOptions.inJustDecodeBounds = false;
      this.hz = BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
      this.mBitmapHeight = this.hz.getWidth();
      this.mBitmapWidth = this.hz.getHeight();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      do
      {
        this.hz = null;
      } while (!QLog.isColorLevel());
      QLog.e("QIMLoadingViewWithRetry", 2, "OutOfMemoryError retry bitmap", localOutOfMemoryError.getCause());
    }
  }
  
  protected void init()
  {
    super.init();
    this.de = new Paint(1);
    this.de.setStyle(Paint.Style.FILL);
    this.eIB = 2130845475;
    aeR(this.eIB);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mProgress == -1L) && (this.hz != null))
    {
      paramCanvas.drawRoundRect(this.aP, this.zc, this.zc, this.ci);
      int i = this.centerX;
      int j = this.mBitmapWidth / 2;
      int k = this.centerY;
      int m = this.mBitmapHeight / 2;
      paramCanvas.drawBitmap(this.hz, i - j, k - m, this.de);
    }
    do
    {
      do
      {
        return;
      } while ((this.mProgress == 0L) || (this.mProgress == this.afV));
      paramCanvas.drawRoundRect(this.aP, this.zc, this.zc, this.ci);
      paramCanvas.drawCircle(this.centerX, this.centerY, this.mRadius, this.cI);
      paramCanvas.drawCircle(this.centerX, this.centerY, this.mRadius - this.aU, this.ci);
      float f = (float)this.mProgress * 360.0F / (float)this.afV;
      this.N.reset();
      this.N.moveTo(this.centerX, this.centerY);
      this.N.arcTo(this.aQ, 270.0F, f);
      paramCanvas.drawPath(this.N, this.cI);
    } while (!this.dxc);
    if ((this.mProgress != this.afV) && (this.a != null))
    {
      setProgress(Math.round(this.a.getProgress() * (float)this.afV));
      return;
    }
    this.dxc = false;
  }
  
  public void setProgress(long paramLong)
  {
    if ((paramLong == 0L) && (this.a != null) && (this.a.bJ == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMLoadingViewWithRetry", 2, "progress=" + paramLong);
      }
      this.mProgress = -1L;
      invalidate();
      return;
    }
    super.setProgress(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMLoadingViewWithRetry
 * JD-Core Version:    0.7.0.1
 */