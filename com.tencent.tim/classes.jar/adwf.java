import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class adwf
  extends Drawable
{
  private static Bitmap eX;
  boolean bRv = false;
  private Bitmap mBitmap;
  private final Rect mDstRect = new Rect();
  int mGravity = 119;
  Paint mPaint = new Paint(7);
  int mTargetDensity = 160;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public adwf(Bitmap paramBitmap, Resources paramResources)
  {
    this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    setBitmap(paramBitmap);
  }
  
  private void computeImageSize()
  {
    if (this.mBitmap != null)
    {
      this.mVideoWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
      this.mVideoHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }
  }
  
  public void GL(boolean paramBoolean)
  {
    this.bRv = paramBoolean;
  }
  
  @TargetApi(21)
  public void draw(Canvas paramCanvas)
  {
    if (this.mBitmap != null)
    {
      copyBounds(this.mDstRect);
      if ((!this.bRv) || (eX != null)) {}
    }
    try
    {
      eX = Bitmap.createBitmap(this.mDstRect.width(), this.mDstRect.height(), Bitmap.Config.ARGB_4444);
      Canvas localCanvas = new Canvas(eX);
      this.mPaint.setColor(-1);
      localCanvas.drawOval(new RectF(0.0F, 0.0F, this.mDstRect.width(), this.mDstRect.height()), this.mPaint);
      if (Build.VERSION.SDK_INT >= 21)
      {
        int i = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
        paramCanvas.drawBitmap(this.mBitmap, null, this.mDstRect, this.mPaint);
        if ((this.bRv) && (eX != null))
        {
          this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          paramCanvas.drawBitmap(eX, null, this.mDstRect, this.mPaint);
          this.mPaint.setXfermode(null);
        }
        paramCanvas.restoreToCount(i);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoDrawable", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
        }
      }
      paramCanvas.drawBitmap(this.mBitmap, null, this.mDstRect, this.mPaint);
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mVideoHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mVideoWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != this.mBitmap)
    {
      this.mBitmap = paramBitmap;
      computeImageSize();
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mPaint.setFilterBitmap(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adwf
 * JD-Core Version:    0.7.0.1
 */