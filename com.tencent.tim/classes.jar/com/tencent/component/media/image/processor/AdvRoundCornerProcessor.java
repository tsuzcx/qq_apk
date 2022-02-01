package com.tencent.component.media.image.processor;

import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;

@Public
public class AdvRoundCornerProcessor
  extends ImageProcessor
{
  private static final String TAG = "AdvRoundCornerProcessor";
  private float mRadius = -1.0F;
  private float[] mRadiusArray;
  private int requestedHeight = 0;
  private int requestedWidth = 0;
  
  @Public
  public AdvRoundCornerProcessor(float paramFloat)
  {
    setRadius(paramFloat);
  }
  
  @Public
  public AdvRoundCornerProcessor(float[] paramArrayOfFloat)
  {
    setRadiusArray(paramArrayOfFloat);
  }
  
  @Public
  public AdvRoundCornerProcessor(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    setRadiusArray(paramArrayOfFloat);
    this.requestedWidth = paramInt1;
    this.requestedHeight = paramInt2;
  }
  
  public static BitmapReference getRoundedCornerBitmap(BitmapReference paramBitmapReference, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f1 = paramBitmapReference.getWidth();
    float f2 = paramBitmapReference.getHeight();
    int i = paramInt2;
    if (paramInt2 * f1 > paramInt1 * f2) {
      i = (int)(f2 / f1 * paramInt1 + 0.5F);
    }
    try
    {
      BitmapReference localBitmapReference1 = ImageManager.getInstance().getBitmap(paramInt1, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmapReference1.getBitmap());
      RectF localRectF = new RectF(0.0F, 0.0F, paramInt1, i);
      Path localPath = new Path();
      Paint localPaint = new Paint();
      localPath.addRoundRect(localRectF, paramArrayOfFloat, Path.Direction.CW);
      localPaint.setAntiAlias(true);
      localCanvas.drawPath(localPath, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmapReference.getBitmap(), null, localRectF, localPaint);
      return localBitmapReference1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ImageManagerEnv.getLogger().e("AdvRoundCornerProcessor", new Object[] { "OOM," + localOutOfMemoryError.toString() });
        BitmapReference localBitmapReference2 = ImageManager.getInstance().getBitmap(paramInt1, i, Bitmap.Config.ARGB_4444);
      }
    }
  }
  
  @Public
  public float getRadius()
  {
    float f = 0.0F;
    if (this.mRadius > 0.0F) {
      f = this.mRadius;
    }
    return f;
  }
  
  @Public
  public float[] getRadiusArray()
  {
    return this.mRadiusArray;
  }
  
  public int getType()
  {
    return 2;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    if (this.mRadiusArray == null) {}
    BitmapReference localBitmapReference;
    do
    {
      return paramDrawable;
      localBitmapReference = ImageManagerEnv.g().drawableToBitmap(paramDrawable);
    } while (localBitmapReference == null);
    paramDrawable = getRoundedCornerBitmap(localBitmapReference, this.mRadiusArray, this.requestedWidth, this.requestedHeight);
    if (paramDrawable == null) {
      return null;
    }
    return new SpecifiedBitmapDrawable(paramDrawable);
  }
  
  @Public
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
    this.mRadiusArray = new float[8];
    int i = 0;
    while (i < this.mRadiusArray.length)
    {
      this.mRadiusArray[i] = paramFloat;
      i += 1;
    }
  }
  
  @Public
  public void setRadiusArray(float[] paramArrayOfFloat)
  {
    this.mRadiusArray = paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.processor.AdvRoundCornerProcessor
 * JD-Core Version:    0.7.0.1
 */