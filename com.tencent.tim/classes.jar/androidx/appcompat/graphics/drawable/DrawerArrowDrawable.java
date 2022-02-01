package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import b.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable
  extends Drawable
{
  public static final int ARROW_DIRECTION_END = 3;
  public static final int ARROW_DIRECTION_LEFT = 0;
  public static final int ARROW_DIRECTION_RIGHT = 1;
  public static final int ARROW_DIRECTION_START = 2;
  private static final float ARROW_HEAD_ANGLE = (float)Math.toRadians(45.0D);
  private float mArrowHeadLength;
  private float mArrowShaftLength;
  private float mBarGap;
  private float mBarLength;
  private int mDirection = 2;
  private float mMaxCutForBarSize;
  private final Paint mPaint = new Paint();
  private final Path mPath = new Path();
  private float mProgress;
  private final int mSize;
  private boolean mSpin;
  private boolean mVerticalMirror = false;
  
  public DrawerArrowDrawable(Context paramContext)
  {
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeJoin(Paint.Join.MITER);
    this.mPaint.setStrokeCap(Paint.Cap.BUTT);
    this.mPaint.setAntiAlias(true);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, b.a.DrawerArrowToggle, 2131034525, 2131755218);
    setColor(paramContext.getColor(b.a.DrawerArrowToggle_color, 0));
    setBarThickness(paramContext.getDimension(b.a.DrawerArrowToggle_thickness, 0.0F));
    setSpinEnabled(paramContext.getBoolean(b.a.DrawerArrowToggle_spinBars, true));
    setGapSize(Math.round(paramContext.getDimension(b.a.DrawerArrowToggle_gapBetweenBars, 0.0F)));
    this.mSize = paramContext.getDimensionPixelSize(b.a.DrawerArrowToggle_drawableSize, 0);
    this.mBarLength = Math.round(paramContext.getDimension(b.a.DrawerArrowToggle_barLength, 0.0F));
    this.mArrowHeadLength = Math.round(paramContext.getDimension(b.a.DrawerArrowToggle_arrowHeadLength, 0.0F));
    this.mArrowShaftLength = paramContext.getDimension(b.a.DrawerArrowToggle_arrowShaftLength, 0.0F);
    paramContext.recycle();
  }
  
  private static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i;
    float f1;
    label137:
    float f2;
    switch (this.mDirection)
    {
    case 2: 
    default: 
      if (DrawableCompat.getLayoutDirection(this) == 1)
      {
        i = 1;
        f1 = (float)Math.sqrt(this.mArrowHeadLength * this.mArrowHeadLength * 2.0F);
        float f5 = lerp(this.mBarLength, f1, this.mProgress);
        float f3 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
        float f4 = Math.round(lerp(0.0F, this.mMaxCutForBarSize, this.mProgress));
        float f6 = lerp(0.0F, ARROW_HEAD_ANGLE, this.mProgress);
        if (i == 0) {
          break label454;
        }
        f1 = 0.0F;
        if (i == 0) {
          break label461;
        }
        f2 = 180.0F;
        label145:
        f1 = lerp(f1, f2, this.mProgress);
        f2 = (float)Math.round(f5 * Math.cos(f6));
        f5 = (float)Math.round(f5 * Math.sin(f6));
        this.mPath.rewind();
        f6 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
        float f7 = -f3 / 2.0F;
        this.mPath.moveTo(f7 + f4, 0.0F);
        this.mPath.rLineTo(f3 - f4 * 2.0F, 0.0F);
        this.mPath.moveTo(f7, f6);
        this.mPath.rLineTo(f2, f5);
        this.mPath.moveTo(f7, -f6);
        this.mPath.rLineTo(f2, -f5);
        this.mPath.close();
        paramCanvas.save();
        f2 = this.mPaint.getStrokeWidth();
        f3 = (int)(localRect.height() - 3.0F * f2 - this.mBarGap * 2.0F) / 4 * 2;
        f4 = this.mBarGap;
        paramCanvas.translate(localRect.centerX(), f2 * 1.5F + f4 + f3);
        if (!this.mSpin) {
          break label472;
        }
        if ((i ^ this.mVerticalMirror) == 0) {
          break label466;
        }
        i = -1;
        label391:
        paramCanvas.rotate(i * f1);
      }
      break;
    }
    for (;;)
    {
      paramCanvas.drawPath(this.mPath, this.mPaint);
      paramCanvas.restore();
      return;
      i = 0;
      break;
      i = 1;
      break;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      i = 0;
      break;
      label454:
      f1 = -180.0F;
      break label137;
      label461:
      f2 = 0.0F;
      break label145;
      label466:
      i = 1;
      break label391;
      label472:
      if (i != 0) {
        paramCanvas.rotate(180.0F);
      }
    }
  }
  
  public float getArrowHeadLength()
  {
    return this.mArrowHeadLength;
  }
  
  public float getArrowShaftLength()
  {
    return this.mArrowShaftLength;
  }
  
  public float getBarLength()
  {
    return this.mBarLength;
  }
  
  public float getBarThickness()
  {
    return this.mPaint.getStrokeWidth();
  }
  
  @ColorInt
  public int getColor()
  {
    return this.mPaint.getColor();
  }
  
  public int getDirection()
  {
    return this.mDirection;
  }
  
  public float getGapSize()
  {
    return this.mBarGap;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mSize;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mSize;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public final Paint getPaint()
  {
    return this.mPaint;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getProgress()
  {
    return this.mProgress;
  }
  
  public boolean isSpinEnabled()
  {
    return this.mSpin;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setArrowHeadLength(float paramFloat)
  {
    if (this.mArrowHeadLength != paramFloat)
    {
      this.mArrowHeadLength = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setArrowShaftLength(float paramFloat)
  {
    if (this.mArrowShaftLength != paramFloat)
    {
      this.mArrowShaftLength = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setBarLength(float paramFloat)
  {
    if (this.mBarLength != paramFloat)
    {
      this.mBarLength = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setBarThickness(float paramFloat)
  {
    if (this.mPaint.getStrokeWidth() != paramFloat)
    {
      this.mPaint.setStrokeWidth(paramFloat);
      this.mMaxCutForBarSize = ((float)(paramFloat / 2.0F * Math.cos(ARROW_HEAD_ANGLE)));
      invalidateSelf();
    }
  }
  
  public void setColor(@ColorInt int paramInt)
  {
    if (paramInt != this.mPaint.getColor())
    {
      this.mPaint.setColor(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDirection(int paramInt)
  {
    if (paramInt != this.mDirection)
    {
      this.mDirection = paramInt;
      invalidateSelf();
    }
  }
  
  public void setGapSize(float paramFloat)
  {
    if (paramFloat != this.mBarGap)
    {
      this.mBarGap = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.mProgress != paramFloat)
    {
      this.mProgress = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setSpinEnabled(boolean paramBoolean)
  {
    if (this.mSpin != paramBoolean)
    {
      this.mSpin = paramBoolean;
      invalidateSelf();
    }
  }
  
  public void setVerticalMirror(boolean paramBoolean)
  {
    if (this.mVerticalMirror != paramBoolean)
    {
      this.mVerticalMirror = paramBoolean;
      invalidateSelf();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface ArrowDirection {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.DrawerArrowDrawable
 * JD-Core Version:    0.7.0.1
 */