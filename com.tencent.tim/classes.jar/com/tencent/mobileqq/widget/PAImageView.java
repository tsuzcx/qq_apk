package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.util.VersionUtils;

public class PAImageView
  extends AnyScaleTypeImageView
{
  float[] aC;
  private int cQI;
  private int cQJ;
  private boolean dat;
  private BitmapShader e;
  private int mDrawMode;
  private Bitmap mMaskBitmap;
  Paint mPaint;
  Path mPath;
  RectF mRect;
  private Canvas p;
  private Paint paint;
  float radius = 10.0F;
  
  public PAImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PAImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PAImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.dat) {
      super.draw(paramCanvas);
    }
    int i;
    do
    {
      return;
      this.cQI = getWidth();
      this.cQJ = getHeight();
      if ((this.cQI <= 0) || (this.cQJ <= 0))
      {
        super.draw(paramCanvas);
        return;
      }
      if (this.mDrawMode == 1)
      {
        i = paramCanvas.getSaveCount();
        paramCanvas.save();
        super.draw(paramCanvas);
        paramCanvas.drawPath(this.mPath, this.mPaint);
        paramCanvas.restoreToCount(i);
        return;
      }
    } while (this.mDrawMode != 2);
    if ((this.mMaskBitmap != null) && ((this.mMaskBitmap.getWidth() != this.cQI) || (this.mMaskBitmap.getHeight() != this.cQJ)))
    {
      this.mMaskBitmap = null;
      this.e = null;
    }
    if (this.mMaskBitmap == null) {}
    try
    {
      this.mMaskBitmap = Bitmap.createBitmap(this.cQI, this.cQJ, Bitmap.Config.RGB_565);
      if (this.p != null) {
        this.p.setBitmap(this.mMaskBitmap);
      }
      if (this.mMaskBitmap == null)
      {
        super.draw(paramCanvas);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.mMaskBitmap = Bitmap.createBitmap(this.cQI, this.cQJ, Bitmap.Config.RGB_565);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          URLDrawable.clearMemoryCache();
          try
          {
            this.mMaskBitmap = Bitmap.createBitmap(this.cQI, this.cQJ, Bitmap.Config.RGB_565);
          }
          catch (OutOfMemoryError localOutOfMemoryError3) {}
        }
      }
      if (this.p == null)
      {
        this.p = new Canvas(this.mMaskBitmap);
        this.p.setBitmap(this.mMaskBitmap);
      }
      if (this.e == null)
      {
        this.e = new BitmapShader(this.mMaskBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.paint.setShader(this.e);
      }
      super.draw(this.p);
      RectF localRectF = new RectF(0.0F, 0.0F, this.cQI, this.cQJ + 2.0F * this.radius);
      i = paramCanvas.save();
      paramCanvas.drawRoundRect(localRectF, this.radius, this.radius, this.paint);
      paramCanvas.restoreToCount(i);
    }
  }
  
  @TargetApi(11)
  public void init()
  {
    if (VersionUtils.isHoneycomb())
    {
      this.mDrawMode = 2;
      if (this.mDrawMode != 1) {
        break label136;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        setLayerType(2, null);
      }
      this.mPaint = new Paint();
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setFilterBitmap(true);
      this.mPaint.setColor(-16777216);
      this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.mPath = new Path();
      this.mRect = new RectF();
      this.aC = new float[8];
    }
    label136:
    while (this.mDrawMode != 2)
    {
      return;
      this.mDrawMode = 2;
      break;
    }
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.mDrawMode == 1)) {
      onResize(getWidth(), getHeight());
    }
  }
  
  public void onResize(float paramFloat1, float paramFloat2)
  {
    this.mRect.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    this.mPath.addRoundRect(this.mRect, this.aC, Path.Direction.CW);
  }
  
  public void setUseRadiusRound(boolean paramBoolean, float paramFloat)
  {
    this.dat = paramBoolean;
    this.radius = paramFloat;
    if (this.aC != null)
    {
      float[] arrayOfFloat1 = this.aC;
      float[] arrayOfFloat2 = this.aC;
      float[] arrayOfFloat3 = this.aC;
      this.aC[3] = paramFloat;
      arrayOfFloat3[2] = paramFloat;
      arrayOfFloat2[1] = paramFloat;
      arrayOfFloat1[0] = paramFloat;
      arrayOfFloat1 = this.aC;
      arrayOfFloat2 = this.aC;
      arrayOfFloat3 = this.aC;
      this.aC[7] = 0.0F;
      arrayOfFloat3[6] = 0.0F;
      arrayOfFloat2[5] = 0.0F;
      arrayOfFloat1[4] = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAImageView
 * JD-Core Version:    0.7.0.1
 */