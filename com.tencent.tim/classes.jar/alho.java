import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mobileqq.profile.view.helper.HeartRiseLayerDrawable.1;

public class alho
  extends LayerDrawable
{
  public alho(int paramInt, Resources paramResources)
  {
    super(alho.a.a(paramInt, paramResources, a(paramResources)));
  }
  
  public static Bitmap a(Resources paramResources)
  {
    Paint localPaint = new Paint();
    localPaint.setColor(paramResources.getColor(2131166850));
    Bitmap localBitmap = Bitmap.createBitmap(126, 126, Bitmap.Config.ARGB_4444);
    localBitmap.setDensity(paramResources.getDisplayMetrics().densityDpi);
    paramResources = new Canvas(localBitmap);
    paramResources.rotate(45.0F);
    paramResources.translate(0.0F, -88.0F);
    paramResources.drawRect(56, 56, 126, 126, localPaint);
    paramResources.drawCircle(56, 91, 35, localPaint);
    paramResources.drawCircle(91, 56, 35, localPaint);
    return localBitmap;
  }
  
  public void c(Handler paramHandler, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < getNumberOfLayers())
    {
      HeartRiseLayerDrawable.1 local1 = new HeartRiseLayerDrawable.1(this, i, paramInt1, paramInt2);
      if (i % 2 == 0) {}
      for (long l = i * 200;; l = i * 130)
      {
        paramHandler.postDelayed(local1, l);
        i += 1;
        break;
      }
    }
  }
  
  public static class a
    extends BitmapDrawable
  {
    private static int mPivotX;
    private static int mPivotY;
    private AccelerateInterpolator a = new AccelerateInterpolator(1.5F);
    private int dtV;
    private int dtW = 50;
    private int mCurrentState;
    private float mScale = 0.5F;
    private long mStartTime;
    private float yG;
    
    public a(Resources paramResources, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    public static a[] a(int paramInt, Resources paramResources, Bitmap paramBitmap)
    {
      if ((paramBitmap != null) && (paramResources != null))
      {
        a[] arrayOfa2 = new a[paramInt];
        mPivotX = paramBitmap.getWidth() / 2;
        mPivotY = paramBitmap.getHeight() / 2;
        int i = 0;
        for (;;)
        {
          arrayOfa1 = arrayOfa2;
          if (i >= paramInt) {
            break;
          }
          arrayOfa2[i] = new a(paramResources, paramBitmap);
          i += 1;
        }
      }
      a[] arrayOfa1 = null;
      return arrayOfa1;
    }
    
    public void aP(long paramLong, int paramInt)
    {
      this.yG = ((float)paramLong);
      this.dtV = paramInt;
      this.mCurrentState = 1;
      invalidateSelf();
    }
    
    public void draw(Canvas paramCanvas)
    {
      int j = 1;
      int i = j;
      switch (this.mCurrentState)
      {
      default: 
        i = j;
      }
      float f2;
      for (;;)
      {
        if (i == 0) {
          invalidateSelf();
        }
        return;
        this.mStartTime = SystemClock.uptimeMillis();
        this.mCurrentState = 2;
        i = 0;
        continue;
        f2 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / this.yG;
        if (f2 <= 1.0F) {
          break;
        }
        this.mCurrentState = 3;
        i = j;
      }
      paramCanvas.save();
      float f3 = this.a.getInterpolation(f2);
      if (f3 > 0.5F) {}
      for (float f1 = -f3 * this.dtW;; f1 = -(1.0F - f3) * this.dtW)
      {
        paramCanvas.translate(f1, this.dtV - f3 * this.dtV);
        paramCanvas.scale(this.mScale * f2, this.mScale * f2, mPivotX, mPivotY);
        setAlpha((int)(255.0F - f2 * 255.0F));
        super.draw(paramCanvas);
        paramCanvas.restore();
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alho
 * JD-Core Version:    0.7.0.1
 */