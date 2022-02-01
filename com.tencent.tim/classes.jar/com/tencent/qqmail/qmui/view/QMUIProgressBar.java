package com.tencent.qqmail.qmui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class QMUIProgressBar
  extends View
{
  public static int DEFAULT_BACKGROUND_COLOR;
  public static int DEFAULT_PROGRESS_COLOR;
  public static int DEFAULT_STROKE_WIDTH = QMUIKit.dpToPx(40);
  public static int DEFAULT_TEXT_COLOR;
  public static int DEFAULT_TEXT_SIZE;
  public static int TOTAL_DURATION;
  public static int TYPE_CIRCLE;
  public static int TYPE_RECT = 0;
  private boolean isAnimating = false;
  private ValueAnimator mAnimator;
  private RectF mArcOval = new RectF();
  private int mBackgroundColor;
  private Paint mBackgroundPaint = new Paint();
  RectF mBgRect;
  private Point mCenterPoint;
  private int mCircleRadius;
  private Context mContext;
  private int mHeight;
  private int mMaxValue;
  private Paint mPaint = new Paint();
  private int mProgressColor;
  RectF mProgressRect;
  QMUOProgressBarValueListener mQMUOProgressBarValueListener;
  private int mStrokeWidth;
  private String mText = "";
  private int mTextColor = DEFAULT_TEXT_COLOR;
  private Paint mTextPaint = new Paint(1);
  private int mTextSize = DEFAULT_TEXT_SIZE;
  private int mType;
  private int mValue;
  private int mWidth;
  
  static
  {
    TYPE_CIRCLE = 1;
    TOTAL_DURATION = 1000;
    DEFAULT_PROGRESS_COLOR = -16776961;
    DEFAULT_BACKGROUND_COLOR = -7829368;
    DEFAULT_TEXT_SIZE = 20;
    DEFAULT_TEXT_COLOR = -16777216;
  }
  
  public QMUIProgressBar(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    setup(paramContext, null);
  }
  
  public QMUIProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    setup(paramContext, paramAttributeSet);
  }
  
  public QMUIProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    setup(paramContext, paramAttributeSet);
  }
  
  private void configPaint()
  {
    this.mPaint.setColor(this.mProgressColor);
    this.mBackgroundPaint.setColor(this.mBackgroundColor);
    if (this.mType == TYPE_RECT)
    {
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mBackgroundPaint.setStyle(Paint.Style.FILL);
    }
    for (;;)
    {
      this.mPaint.setAntiAlias(true);
      this.mBackgroundPaint.setAntiAlias(true);
      this.mTextPaint.setColor(this.mTextColor);
      this.mTextPaint.setTextSize(this.mTextSize);
      this.mTextPaint.setTextAlign(Paint.Align.CENTER);
      return;
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(this.mStrokeWidth);
      this.mBackgroundPaint.setStyle(Paint.Style.STROKE);
      this.mBackgroundPaint.setStrokeWidth(this.mStrokeWidth);
    }
  }
  
  private void configShape()
  {
    if (this.mType == TYPE_RECT)
    {
      this.mBgRect = new RectF(getPaddingLeft(), getPaddingTop(), this.mWidth + getPaddingLeft(), this.mHeight + getPaddingTop());
      this.mProgressRect = new RectF();
      return;
    }
    this.mCircleRadius = ((Math.min(this.mWidth, this.mHeight) - this.mStrokeWidth) / 2);
    this.mCenterPoint = new Point(this.mWidth / 2, this.mHeight / 2);
  }
  
  private void drawCircle(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.mCenterPoint.x, this.mCenterPoint.y, this.mCircleRadius, this.mBackgroundPaint);
    this.mArcOval.left = (this.mCenterPoint.x - this.mCircleRadius);
    this.mArcOval.right = (this.mCenterPoint.x + this.mCircleRadius);
    this.mArcOval.top = (this.mCenterPoint.y - this.mCircleRadius);
    this.mArcOval.bottom = (this.mCenterPoint.y + this.mCircleRadius);
    paramCanvas.drawArc(this.mArcOval, 270.0F, this.mValue * 360 / this.mMaxValue, false, this.mPaint);
    if ((this.mText != null) && (this.mText != ""))
    {
      Paint.FontMetricsInt localFontMetricsInt = this.mTextPaint.getFontMetricsInt();
      float f1 = this.mArcOval.top;
      float f2 = (this.mArcOval.height() - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2.0F;
      float f3 = localFontMetricsInt.top;
      paramCanvas.drawText(this.mText, this.mCenterPoint.x, f1 + f2 - f3, this.mTextPaint);
    }
  }
  
  private void drawRect(Canvas paramCanvas)
  {
    paramCanvas.drawRect(this.mBgRect, this.mBackgroundPaint);
    this.mProgressRect.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + parseValueToWidth(), getPaddingTop() + this.mHeight);
    paramCanvas.drawRect(this.mProgressRect, this.mPaint);
    if ((this.mText != null) && (this.mText != ""))
    {
      Paint.FontMetricsInt localFontMetricsInt = this.mTextPaint.getFontMetricsInt();
      float f1 = this.mBgRect.top;
      float f2 = (this.mBgRect.height() - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2.0F;
      float f3 = localFontMetricsInt.top;
      paramCanvas.drawText(this.mText, this.mBgRect.centerX(), f1 + f2 - f3, this.mTextPaint);
    }
  }
  
  private int parseValueToWidth()
  {
    return this.mWidth * this.mValue / this.mMaxValue;
  }
  
  private void startAnimation(int paramInt1, int paramInt2)
  {
    this.mAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    paramInt1 = Math.abs(TOTAL_DURATION * (paramInt2 - paramInt1) / this.mMaxValue);
    this.mAnimator.setDuration(paramInt1);
    this.mAnimator.addUpdateListener(new QMUIProgressBar.1(this));
    this.mAnimator.addListener(new QMUIProgressBar.2(this));
    this.mAnimator.start();
  }
  
  public int getMaxValue()
  {
    return this.mMaxValue;
  }
  
  public int getProgress()
  {
    return this.mValue;
  }
  
  public QMUOProgressBarValueListener getQMUOProgressBarValueListener()
  {
    return this.mQMUOProgressBarValueListener;
  }
  
  public void initProcess(int paramInt)
  {
    if (this.isAnimating)
    {
      this.isAnimating = false;
      this.mAnimator.cancel();
    }
    this.mValue = paramInt;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mQMUOProgressBarValueListener != null) {
      this.mText = this.mQMUOProgressBarValueListener.generateText(this.mValue, this.mMaxValue);
    }
    if (this.mType == TYPE_RECT)
    {
      drawRect(paramCanvas);
      return;
    }
    drawCircle(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mWidth = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
    this.mHeight = (getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
    configShape();
    setMeasuredDimension(this.mWidth, this.mHeight);
  }
  
  public void setMaxValue(int paramInt)
  {
    this.mMaxValue = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt > this.mValue) && (paramInt < 0)) {
      return;
    }
    if (this.isAnimating)
    {
      this.isAnimating = false;
      this.mAnimator.cancel();
    }
    int i = this.mValue;
    this.mValue = paramInt;
    startAnimation(i, paramInt);
  }
  
  public void setQMUOProgressBarValueListener(QMUOProgressBarValueListener paramQMUOProgressBarValueListener)
  {
    this.mQMUOProgressBarValueListener = paramQMUOProgressBarValueListener;
  }
  
  public void setText() {}
  
  public void setup(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QMUIProgressBar);
    this.mType = paramContext.getInt(R.styleable.QMUIProgressBar_progress_type, TYPE_RECT);
    this.mProgressColor = paramContext.getColor(R.styleable.QMUIProgressBar_progress_color, DEFAULT_PROGRESS_COLOR);
    this.mBackgroundColor = paramContext.getColor(R.styleable.QMUIProgressBar_background_color, DEFAULT_BACKGROUND_COLOR);
    this.mMaxValue = paramContext.getInt(R.styleable.QMUIProgressBar_max_value, 100);
    this.mValue = paramContext.getInt(R.styleable.QMUIProgressBar_value, 0);
    if (paramContext.hasValue(R.styleable.QMUIProgressBar_text_size)) {
      this.mTextSize = paramContext.getDimensionPixelSize(R.styleable.QMUIProgressBar_text_size, DEFAULT_TEXT_SIZE);
    }
    if (paramContext.hasValue(R.styleable.QMUIProgressBar_text_color)) {
      this.mTextColor = paramContext.getColor(R.styleable.QMUIProgressBar_text_color, DEFAULT_TEXT_COLOR);
    }
    if (this.mType == TYPE_CIRCLE) {
      this.mStrokeWidth = paramContext.getDimensionPixelSize(R.styleable.QMUIProgressBar_stroke_width, DEFAULT_STROKE_WIDTH);
    }
    paramContext.recycle();
    configPaint();
    setProgress(this.mValue);
  }
  
  public static abstract interface QMUOProgressBarValueListener
  {
    public abstract String generateText(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.view.QMUIProgressBar
 * JD-Core Version:    0.7.0.1
 */