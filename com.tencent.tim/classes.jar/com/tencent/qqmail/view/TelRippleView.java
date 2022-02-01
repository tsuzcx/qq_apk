package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.androidqqmail.R.styleable;

public class TelRippleView
  extends View
{
  public static int DEFAULT_RIPPLE_COLOR = -7829368;
  public static int DEFAULT_RIPPLE_COUNT = 3;
  public static int DEFAULT_RIPPLE_WIDTH = 10;
  private ValueAnimator animator;
  private int mAlphaGradient;
  private Point mCenterPoint = new Point();
  private int mColor;
  private long mDrawDuration;
  private int mEndAlpha;
  private int mEndRadius;
  private int mHeight;
  private Paint mPaint = null;
  private int mRadiusGradient;
  private int mRippleCount;
  private int mRippleWidth;
  private int mStartAlpha;
  private int mStartRadius;
  private int mWidth;
  
  public TelRippleView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public TelRippleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public TelRippleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void calcuteGradient()
  {
    this.mRadiusGradient = ((this.mEndRadius - this.mStartRadius - this.mRippleWidth * this.mRippleCount) / this.mRippleCount - 1);
    this.mAlphaGradient = ((this.mStartAlpha - this.mEndAlpha) / this.mRippleCount);
  }
  
  private void drawRipple(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.mPaint.setAlpha(paramInt2);
    paramCanvas.drawCircle(this.mCenterPoint.x, this.mCenterPoint.y, paramInt1, this.mPaint);
  }
  
  private void drawRipples(Canvas paramCanvas, float paramFloat)
  {
    int i = this.mStartRadius;
    int j = (int)(this.mRadiusGradient * paramFloat) + i;
    i = this.mStartAlpha - (int)(this.mAlphaGradient * paramFloat);
    while (j < this.mEndRadius)
    {
      drawRipple(paramCanvas, j, i);
      j += this.mRadiusGradient;
      i -= this.mAlphaGradient;
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.STROKE);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TelRippleView);
    this.mStartRadius = paramContext.getDimensionPixelSize(R.styleable.TelRippleView_ripple_radius_start, 0);
    this.mColor = paramContext.getColor(R.styleable.TelRippleView_ripple_color, DEFAULT_RIPPLE_COLOR);
    this.mStartAlpha = paramContext.getInt(R.styleable.TelRippleView_ripple_alpha_start, 255);
    this.mEndRadius = paramContext.getDimensionPixelSize(R.styleable.TelRippleView_ripple_radius_end, 0);
    this.mEndRadius = paramContext.getDimensionPixelSize(R.styleable.TelRippleView_ripple_radius_end, 0);
    this.mRippleCount = paramContext.getInt(R.styleable.TelRippleView_ripple_count, DEFAULT_RIPPLE_COUNT);
    this.mRippleWidth = paramContext.getDimensionPixelSize(R.styleable.TelRippleView_ripple_width, DEFAULT_RIPPLE_WIDTH);
    this.mEndAlpha = (this.mStartAlpha / this.mRippleCount);
    paramContext.recycle();
    this.mPaint.setColor(this.mColor);
    this.mPaint.setStrokeWidth(this.mRippleWidth);
    this.mDrawDuration = 800L;
    startAnimator();
  }
  
  private void startAnimator()
  {
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.animator.setDuration(this.mDrawDuration);
    this.animator.setRepeatMode(1);
    this.animator.setRepeatCount(-1);
    this.animator.start();
    this.animator.addUpdateListener(new TelRippleView.1(this));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.animator != null) && (this.animator.isRunning()))
    {
      drawRipples(paramCanvas, ((Float)this.animator.getAnimatedValue()).floatValue());
      return;
    }
    drawRipples(paramCanvas, 0.0F);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mWidth = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
    this.mHeight = (getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
    this.mCenterPoint.x = (this.mWidth / 2);
    this.mCenterPoint.y = (this.mHeight / 2);
    calcuteGradient();
    setMeasuredDimension(this.mWidth, this.mHeight);
  }
  
  public void stopAnimation()
  {
    if (this.animator.isRunning()) {
      this.animator.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.TelRippleView
 * JD-Core Version:    0.7.0.1
 */