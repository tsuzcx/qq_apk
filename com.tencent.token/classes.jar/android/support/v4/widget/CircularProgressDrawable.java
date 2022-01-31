package android.support.v4.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Cap;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.util.Preconditions;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class CircularProgressDrawable
  extends Drawable
  implements Animatable
{
  private static final int ANIMATION_DURATION = 1332;
  private static final int ARROW_HEIGHT = 5;
  private static final int ARROW_HEIGHT_LARGE = 6;
  private static final int ARROW_WIDTH = 10;
  private static final int ARROW_WIDTH_LARGE = 12;
  private static final float CENTER_RADIUS = 7.5F;
  private static final float CENTER_RADIUS_LARGE = 11.0F;
  private static final int[] COLORS = { -16777216 };
  private static final float COLOR_CHANGE_OFFSET = 0.75F;
  public static final int DEFAULT = 1;
  private static final float GROUP_FULL_ROTATION = 216.0F;
  public static final int LARGE = 0;
  private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
  private static final float MAX_PROGRESS_ARC = 0.8F;
  private static final float MIN_PROGRESS_ARC = 0.01F;
  private static final float RING_ROTATION = 0.21F;
  private static final float SHRINK_OFFSET = 0.5F;
  private static final float STROKE_WIDTH = 2.5F;
  private static final float STROKE_WIDTH_LARGE = 3.0F;
  private Animator mAnimator;
  private boolean mFinishing;
  private Resources mResources;
  private final CircularProgressDrawable.Ring mRing;
  private float mRotation;
  private float mRotationCount;
  
  public CircularProgressDrawable(@NonNull Context paramContext)
  {
    this.mResources = ((Context)Preconditions.checkNotNull(paramContext)).getResources();
    this.mRing = new CircularProgressDrawable.Ring();
    this.mRing.setColors(COLORS);
    setStrokeWidth(2.5F);
    setupAnimators();
  }
  
  private void applyFinishTranslation(float paramFloat, CircularProgressDrawable.Ring paramRing)
  {
    updateRingColor(paramFloat, paramRing);
    float f1 = (float)(Math.floor(paramRing.getStartingRotation() / 0.8F) + 1.0D);
    paramRing.setStartTrim(paramRing.getStartingStartTrim() + (paramRing.getStartingEndTrim() - 0.01F - paramRing.getStartingStartTrim()) * paramFloat);
    paramRing.setEndTrim(paramRing.getStartingEndTrim());
    float f2 = paramRing.getStartingRotation();
    paramRing.setRotation((f1 - paramRing.getStartingRotation()) * paramFloat + f2);
  }
  
  private void applyTransformation(float paramFloat, CircularProgressDrawable.Ring paramRing, boolean paramBoolean)
  {
    if (this.mFinishing) {
      applyFinishTranslation(paramFloat, paramRing);
    }
    while ((paramFloat == 1.0F) && (!paramBoolean)) {
      return;
    }
    float f3 = paramRing.getStartingRotation();
    float f1;
    float f2;
    if (paramFloat < 0.5F)
    {
      f1 = paramFloat / 0.5F;
      f2 = paramRing.getStartingStartTrim();
      f1 = MATERIAL_INTERPOLATOR.getInterpolation(f1) * 0.79F + 0.01F + f2;
    }
    for (;;)
    {
      float f4 = this.mRotationCount;
      paramRing.setStartTrim(f2);
      paramRing.setEndTrim(f1);
      paramRing.setRotation(f3 + 0.21F * paramFloat);
      setRotation(216.0F * (f4 + paramFloat));
      return;
      f2 = (paramFloat - 0.5F) / 0.5F;
      f1 = paramRing.getStartingStartTrim() + 0.79F;
      f2 = f1 - ((1.0F - MATERIAL_INTERPOLATOR.getInterpolation(f2)) * 0.79F + 0.01F);
    }
  }
  
  private int evaluateColorChange(float paramFloat, int paramInt1, int paramInt2)
  {
    int i = paramInt1 >> 24 & 0xFF;
    int j = paramInt1 >> 16 & 0xFF;
    int k = paramInt1 >> 8 & 0xFF;
    paramInt1 &= 0xFF;
    return i + (int)(((paramInt2 >> 24 & 0xFF) - i) * paramFloat) << 24 | j + (int)(((paramInt2 >> 16 & 0xFF) - j) * paramFloat) << 16 | (int)(((paramInt2 >> 8 & 0xFF) - k) * paramFloat) + k << 8 | (int)(((paramInt2 & 0xFF) - paramInt1) * paramFloat) + paramInt1;
  }
  
  private float getRotation()
  {
    return this.mRotation;
  }
  
  private void setRotation(float paramFloat)
  {
    this.mRotation = paramFloat;
  }
  
  private void setSizeParameters(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    CircularProgressDrawable.Ring localRing = this.mRing;
    float f = this.mResources.getDisplayMetrics().density;
    localRing.setStrokeWidth(paramFloat2 * f);
    localRing.setCenterRadius(paramFloat1 * f);
    localRing.setColorIndex(0);
    localRing.setArrowDimensions(paramFloat3 * f, f * paramFloat4);
  }
  
  private void setupAnimators()
  {
    CircularProgressDrawable.Ring localRing = this.mRing;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new CircularProgressDrawable.1(this, localRing));
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(LINEAR_INTERPOLATOR);
    localValueAnimator.addListener(new CircularProgressDrawable.2(this, localRing));
    this.mAnimator = localValueAnimator;
  }
  
  private void updateRingColor(float paramFloat, CircularProgressDrawable.Ring paramRing)
  {
    if (paramFloat > 0.75F)
    {
      paramRing.setColor(evaluateColorChange((paramFloat - 0.75F) / 0.25F, paramRing.getStartingColor(), paramRing.getNextColor()));
      return;
    }
    paramRing.setColor(paramRing.getStartingColor());
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.mRotation, localRect.exactCenterX(), localRect.exactCenterY());
    this.mRing.draw(paramCanvas, localRect);
    paramCanvas.restore();
  }
  
  public int getAlpha()
  {
    return this.mRing.getAlpha();
  }
  
  public boolean getArrowEnabled()
  {
    return this.mRing.getShowArrow();
  }
  
  public float getArrowHeight()
  {
    return this.mRing.getArrowHeight();
  }
  
  public float getArrowScale()
  {
    return this.mRing.getArrowScale();
  }
  
  public float getArrowWidth()
  {
    return this.mRing.getArrowWidth();
  }
  
  public int getBackgroundColor()
  {
    return this.mRing.getBackgroundColor();
  }
  
  public float getCenterRadius()
  {
    return this.mRing.getCenterRadius();
  }
  
  @NonNull
  public int[] getColorSchemeColors()
  {
    return this.mRing.getColors();
  }
  
  public float getEndTrim()
  {
    return this.mRing.getEndTrim();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public float getProgressRotation()
  {
    return this.mRing.getRotation();
  }
  
  public float getStartTrim()
  {
    return this.mRing.getStartTrim();
  }
  
  @NonNull
  public Paint.Cap getStrokeCap()
  {
    return this.mRing.getStrokeCap();
  }
  
  public float getStrokeWidth()
  {
    return this.mRing.getStrokeWidth();
  }
  
  public boolean isRunning()
  {
    return this.mAnimator.isRunning();
  }
  
  public void setAlpha(int paramInt)
  {
    this.mRing.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setArrowDimensions(float paramFloat1, float paramFloat2)
  {
    this.mRing.setArrowDimensions(paramFloat1, paramFloat2);
    invalidateSelf();
  }
  
  public void setArrowEnabled(boolean paramBoolean)
  {
    this.mRing.setShowArrow(paramBoolean);
    invalidateSelf();
  }
  
  public void setArrowScale(float paramFloat)
  {
    this.mRing.setArrowScale(paramFloat);
    invalidateSelf();
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mRing.setBackgroundColor(paramInt);
    invalidateSelf();
  }
  
  public void setCenterRadius(float paramFloat)
  {
    this.mRing.setCenterRadius(paramFloat);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mRing.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setColorSchemeColors(@NonNull int... paramVarArgs)
  {
    this.mRing.setColors(paramVarArgs);
    this.mRing.setColorIndex(0);
    invalidateSelf();
  }
  
  public void setProgressRotation(float paramFloat)
  {
    this.mRing.setRotation(paramFloat);
    invalidateSelf();
  }
  
  public void setStartEndTrim(float paramFloat1, float paramFloat2)
  {
    this.mRing.setStartTrim(paramFloat1);
    this.mRing.setEndTrim(paramFloat2);
    invalidateSelf();
  }
  
  public void setStrokeCap(@NonNull Paint.Cap paramCap)
  {
    this.mRing.setStrokeCap(paramCap);
    invalidateSelf();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.mRing.setStrokeWidth(paramFloat);
    invalidateSelf();
  }
  
  public void setStyle(int paramInt)
  {
    if (paramInt == 0) {
      setSizeParameters(11.0F, 3.0F, 12.0F, 6.0F);
    }
    for (;;)
    {
      invalidateSelf();
      return;
      setSizeParameters(7.5F, 2.5F, 10.0F, 5.0F);
    }
  }
  
  public void start()
  {
    this.mAnimator.cancel();
    this.mRing.storeOriginals();
    if (this.mRing.getEndTrim() != this.mRing.getStartTrim())
    {
      this.mFinishing = true;
      this.mAnimator.setDuration(666L);
      this.mAnimator.start();
      return;
    }
    this.mRing.setColorIndex(0);
    this.mRing.resetOriginals();
    this.mAnimator.setDuration(1332L);
    this.mAnimator.start();
  }
  
  public void stop()
  {
    this.mAnimator.cancel();
    setRotation(0.0F);
    this.mRing.setShowArrow(false);
    this.mRing.setColorIndex(0);
    this.mRing.resetOriginals();
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.CircularProgressDrawable
 * JD-Core Version:    0.7.0.1
 */