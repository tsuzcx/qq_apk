import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyAdSuperBgDrawable.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class kor
  extends Drawable
{
  private Bitmap mBitmap;
  private int mDrawLeft;
  private int mDrawTop;
  private Paint mPaint = new Paint();
  
  public kor(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.mPaint.setAntiAlias(true);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      ThreadManager.executeOnSubThread(new ReadInjoyAdSuperBgDrawable.1(this, paramDrawable, paramInt1, paramInt2));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInjoyAdSuperBgDrawable", 2, "Illegal target: width=" + paramInt1 + ", height=" + paramInt2);
  }
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    return Bitmap.createBitmap(paramBitmap, (paramInt1 - paramInt3) / 2, (paramInt2 - paramInt4) / 2, paramInt3, paramInt4);
  }
  
  private Bitmap a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    Object localObject1;
    if (paramBitmap == null)
    {
      localObject1 = null;
      return localObject1;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i == 0) || (j == 0)) {
      return null;
    }
    Bitmap localBitmap;
    if ((i >= paramInt1) && (j >= paramInt2))
    {
      localObject1 = a(i, j, paramInt1, paramInt2, paramBitmap);
      localBitmap = null;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localBitmap != null) {
          localObject2 = a(localBitmap.getWidth(), localBitmap.getHeight(), paramInt1, paramInt2, localBitmap);
        }
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      localObject1 = localObject2;
      if (paramBitmap.isRecycled()) {
        break;
      }
      paramBitmap.recycle();
      return localObject2;
      if ((i >= paramInt1) && (j < paramInt2))
      {
        localBitmap = b(i, j, paramInt1, paramInt2, paramBitmap);
        localObject1 = null;
      }
      else if ((i < paramInt1) && (j >= paramInt2))
      {
        localBitmap = c(i, j, paramInt1, paramInt2, paramBitmap);
        localObject1 = null;
      }
      else
      {
        localBitmap = d(i, j, paramInt1, paramInt2, paramBitmap);
        localObject1 = null;
      }
    }
  }
  
  private Bitmap b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    if (paramInt2 <= 0) {
      return null;
    }
    return Bitmap.createScaledBitmap(paramBitmap, (int)(paramInt4 * 1.0F / paramInt2 * paramInt1), paramInt4, false);
  }
  
  private Bitmap c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    if (paramInt1 <= 0) {
      return null;
    }
    return Bitmap.createScaledBitmap(paramBitmap, paramInt3, (int)(paramInt3 * 1.0F / paramInt1 * paramInt4), false);
  }
  
  private Bitmap d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return null;
    }
    float f1 = paramInt3 * 1.0F / paramInt1;
    float f2 = paramInt4 * 1.0F / paramInt2;
    if (f1 > f2) {
      paramInt4 = (int)(f1 * paramInt2);
    }
    for (;;)
    {
      return Bitmap.createScaledBitmap(paramBitmap, paramInt3, paramInt4, false);
      paramInt3 = (int)(paramInt1 * f2);
    }
  }
  
  private Bitmap d(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    try
    {
      paramDrawable = a(paramInt1, paramInt2, getBitmapFromDrawable(paramDrawable));
      return paramDrawable;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
    return null;
  }
  
  private Bitmap getBitmapFromDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    if (f != 0.0D)
    {
      i = (int)(i / f);
      j = (int)(j / f);
      try
      {
        for (;;)
        {
          if (paramDrawable.getOpacity() != -1) {}
          for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
          {
            localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
            Canvas localCanvas = new Canvas((Bitmap)localObject);
            paramDrawable.setBounds(0, 0, i, j);
            paramDrawable.draw(localCanvas);
            return localObject;
          }
        }
      }
      catch (OutOfMemoryError paramDrawable)
      {
        return null;
      }
    }
  }
  
  public void cr(int paramInt1, int paramInt2)
  {
    this.mDrawLeft = paramInt1;
    this.mDrawTop = paramInt2;
    if (this.mBitmap != null) {
      invalidateSelf();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInjoyAdSuperBgDrawable", 2, "updateDrawRect mBitmap is NULL.");
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mBitmap != null) {
      paramCanvas.drawBitmap(this.mBitmap, -this.mDrawLeft, this.mDrawTop, this.mPaint);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void reset()
  {
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      this.mBitmap.recycle();
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kor
 * JD-Core Version:    0.7.0.1
 */