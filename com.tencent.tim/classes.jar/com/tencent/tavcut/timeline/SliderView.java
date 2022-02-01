package com.tencent.tavcut.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.tavcut.util.FloatUtils;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.Util;
import java.util.Locale;

public class SliderView
  extends FrameLayout
{
  private static final String TAG = "SliderView";
  private boolean canAdjust;
  private int frameColor = Color.parseColor("#ffffffff");
  private int mBarWidth;
  private boolean mDragging;
  private String mDuration = "00:00";
  private Bitmap mDurationBgBitmap;
  private Paint mDurationBgPaint;
  private float mDurationBgRadius;
  private Paint mDurationTextPaint;
  private float mDurationTextSize;
  private Paint mFramePaint;
  private int mFrameRadius;
  private int mFrameStrokeWidth;
  private Drawable mImgLockLeft;
  private Drawable mImgLockRight;
  private Drawable mImgRangeLeft;
  private Drawable mImgRangeRight;
  private Bitmap mIndicatorBitmap;
  private boolean mIndicatorMoved;
  private Paint mIndicatorPaint;
  private boolean mIndicatorPressed;
  private float mIndicatorProgress;
  private float mIndicatorWidth;
  private int mLastX;
  private boolean mLeftBarHandle;
  private ImageView mLeftBarIv;
  private boolean mLeftBarMoved;
  private boolean mLeftBarPressed;
  private boolean mLockMode;
  private String mMaxDurationTips;
  private int mMaxSelectAreaWidth;
  private long mMaxSelectDurationMs;
  private int mMinSelectAreaWidth;
  private int mOriginX;
  private int mPaddingBottom;
  private int mPaddingTop;
  private ImageView mRightBarIv;
  private boolean mRightBarMoved;
  private boolean mRightBarPressed;
  private Paint mSelectAreaPaint;
  private Rect mSelectAreaRect;
  private boolean mShowDuration = true;
  private boolean mSliderBarMode = true;
  private SliderChangeListener mSliderChangeListener;
  private long mTotalDurationMs;
  private int mTouchSlop;
  
  public SliderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SliderView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext, null, 0);
    this.mImgLockLeft = paramContext.getResources().getDrawable(paramInt1);
    this.mImgLockRight = paramContext.getResources().getDrawable(paramInt2);
    this.mImgRangeLeft = paramContext.getResources().getDrawable(paramInt3);
    this.mImgRangeRight = paramContext.getResources().getDrawable(paramInt4);
    init();
  }
  
  public SliderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SliderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void drawDuration(Canvas paramCanvas)
  {
    if (!this.mShowDuration) {
      return;
    }
    Object localObject1 = new Rect();
    this.mDurationTextPaint.getTextBounds(this.mDuration, 0, this.mDuration.length(), (Rect)localObject1);
    int i = ((Rect)localObject1).width();
    int j = ((Rect)localObject1).height();
    float f1 = (int)Util.dp2px(getContext(), 4.0F);
    float f2 = (int)Util.dp2px(getContext(), 3.0F);
    f2 = i + f2 * 2.0F;
    f1 = j + f1 * 2.0F;
    localObject1 = new RectF();
    float f3;
    float f4;
    float f5;
    float f6;
    float f7;
    Object localObject2;
    if (f2 < this.mSelectAreaRect.width())
    {
      f3 = this.mSelectAreaRect.centerX();
      f4 = f2 / 2.0F;
      f5 = this.mSelectAreaRect.centerY();
      f6 = f1 / 2.0F;
      f7 = this.mSelectAreaRect.centerX();
      f2 /= 2.0F;
      float f8 = this.mSelectAreaRect.centerY();
      ((RectF)localObject1).set(f3 - f4, f5 - f6, f2 + f7, f1 / 2.0F + f8);
      if (this.mDurationBgBitmap == null) {
        break label471;
      }
      localObject2 = new Rect(0, 0, this.mDurationBgBitmap.getWidth(), this.mDurationBgBitmap.getHeight());
      paramCanvas.drawBitmap(this.mDurationBgBitmap, (Rect)localObject2, (RectF)localObject1, this.mDurationBgPaint);
    }
    for (;;)
    {
      localObject2 = this.mDurationTextPaint.getFontMetrics();
      f1 = (((RectF)localObject1).bottom + ((RectF)localObject1).top - ((Paint.FontMetrics)localObject2).bottom - ((Paint.FontMetrics)localObject2).top) / 2.0F;
      paramCanvas.drawText(this.mDuration, ((RectF)localObject1).centerX(), f1, this.mDurationTextPaint);
      return;
      if (this.mSelectAreaRect.centerX() * 2 < getWidth())
      {
        f3 = this.mSelectAreaRect.right + this.mBarWidth;
        f4 = this.mSelectAreaRect.centerY();
        f5 = f1 / 2.0F;
        f6 = this.mSelectAreaRect.right + this.mBarWidth;
        f7 = this.mSelectAreaRect.centerY();
        ((RectF)localObject1).set(f3, f4 - f5, f2 + f6, f1 / 2.0F + f7);
        break;
      }
      f3 = this.mSelectAreaRect.left - this.mBarWidth;
      f4 = this.mSelectAreaRect.centerY();
      f5 = f1 / 2.0F;
      f6 = this.mSelectAreaRect.left - this.mBarWidth;
      f7 = this.mSelectAreaRect.centerY();
      ((RectF)localObject1).set(f3 - f2, f4 - f5, f6, f1 / 2.0F + f7);
      break;
      label471:
      paramCanvas.drawRoundRect((RectF)localObject1, this.mDurationBgRadius, this.mDurationBgRadius, this.mDurationBgPaint);
    }
  }
  
  private void drawFrame(Canvas paramCanvas)
  {
    if (this.mSelectAreaRect == null) {
      this.mSelectAreaRect = new Rect();
    }
    if (this.mSliderBarMode)
    {
      this.mFramePaint.setColor(this.frameColor);
      this.mFramePaint.setStrokeWidth(0.0F);
      this.mFramePaint.setStyle(Paint.Style.FILL);
      this.mSelectAreaRect.set((int)(this.mLeftBarIv.getX() + this.mBarWidth), this.mPaddingTop, (int)this.mRightBarIv.getX(), getMeasuredHeight() - this.mPaddingBottom);
      paramCanvas.drawRect(this.mSelectAreaRect.left - (this.mBarWidth >> 1), this.mSelectAreaRect.top, this.mSelectAreaRect.right + (this.mBarWidth >> 1), this.mSelectAreaRect.top + this.mFrameStrokeWidth, this.mFramePaint);
      paramCanvas.drawRect(this.mSelectAreaRect.left - (this.mBarWidth >> 1), this.mSelectAreaRect.bottom - this.mFrameStrokeWidth, this.mSelectAreaRect.right + (this.mBarWidth >> 1), this.mSelectAreaRect.bottom, this.mFramePaint);
      return;
    }
    this.mFramePaint.setColor(Color.parseColor("#66FFFFFF"));
    this.mFramePaint.setStrokeWidth(this.mFrameStrokeWidth);
    this.mFramePaint.setStyle(Paint.Style.STROKE);
    this.mSelectAreaRect.set(getPaddingLeft(), this.mPaddingTop, getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - this.mPaddingBottom);
    RectF localRectF = new RectF();
    localRectF.set(this.mSelectAreaRect.left, this.mSelectAreaRect.top, this.mSelectAreaRect.right, this.mSelectAreaRect.bottom);
    paramCanvas.drawRoundRect(localRectF, this.mFrameRadius, this.mFrameRadius, this.mFramePaint);
  }
  
  private void drawIndicator(Canvas paramCanvas)
  {
    float f1 = this.mSelectAreaRect.left;
    float f2 = Util.dp2px(getContext(), 8.0F);
    f1 = (this.mSelectAreaRect.width() - Util.dp2px(getContext(), 4.0F)) * this.mIndicatorProgress + (f1 - f2);
    if (this.mIndicatorBitmap != null)
    {
      Rect localRect1 = new Rect(0, 0, this.mIndicatorBitmap.getWidth(), this.mIndicatorBitmap.getHeight());
      Rect localRect2 = new Rect((int)f1, 0, (int)(f1 + this.mIndicatorWidth), getMeasuredHeight());
      paramCanvas.drawBitmap(this.mIndicatorBitmap, localRect1, localRect2, this.mIndicatorPaint);
      return;
    }
    paramCanvas.drawRect(f1, 0.0F, f1 + this.mIndicatorWidth, getMeasuredHeight(), this.mIndicatorPaint);
  }
  
  private void init()
  {
    initConfig();
    initView();
  }
  
  private void initConfig()
  {
    this.mPaddingTop = ((int)Util.dp2px(getContext(), 12.5F));
    this.mPaddingBottom = ((int)Util.dp2px(getContext(), 11.5F));
    this.mBarWidth = ((int)Util.dp2px(getContext(), 17.0F));
    this.mFrameStrokeWidth = ((int)Util.dp2px(getContext(), 1.0F));
    this.mFrameRadius = ((int)Util.dp2px(getContext(), 4.0F));
    this.mIndicatorWidth = ((int)Util.dp2px(getContext(), 3.0F));
    this.mSelectAreaPaint = new Paint();
    this.mSelectAreaPaint.setColor(Color.parseColor("#33FFFFFF"));
    this.mFramePaint = new Paint();
    Object localObject = this.mFramePaint;
    int i;
    if (this.mSliderBarMode)
    {
      i = Color.parseColor("#FFFFFFFF");
      ((Paint)localObject).setColor(i);
      Paint localPaint = this.mFramePaint;
      if (!this.mSliderBarMode) {
        break label370;
      }
      localObject = Paint.Style.FILL;
      label163:
      localPaint.setStyle((Paint.Style)localObject);
      localObject = this.mFramePaint;
      if (!this.mSliderBarMode) {
        break label377;
      }
    }
    label370:
    label377:
    for (float f = 0.0F;; f = this.mFrameStrokeWidth)
    {
      ((Paint)localObject).setStrokeWidth(f);
      this.mIndicatorPaint = new Paint();
      this.mIndicatorPaint.setColor(Color.parseColor("#FFFFFFFF"));
      this.mMaxDurationTips = "已达到模板最大时长";
      this.mDurationTextSize = ((int)Util.dp2px(getContext(), 10.0F));
      this.mDurationTextPaint = new Paint();
      this.mDurationTextPaint.setColor(Color.parseColor("#FFFFFFFF"));
      this.mDurationTextPaint.setAntiAlias(true);
      this.mDurationTextPaint.setTextAlign(Paint.Align.CENTER);
      this.mDurationTextPaint.setTextSize(this.mDurationTextSize);
      this.mDurationTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
      this.mDurationBgRadius = ((int)Util.dp2px(getContext(), 1.0F));
      this.mDurationBgPaint = new Paint();
      this.mDurationBgPaint.setColor(Color.parseColor("#80000000"));
      this.mDurationBgPaint.setAntiAlias(true);
      this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      return;
      i = Color.parseColor("#66FFFFFF");
      break;
      localObject = Paint.Style.STROKE;
      break label163;
    }
  }
  
  private void initSliderBar()
  {
    this.mLeftBarIv = new ImageView(getContext());
    this.mLeftBarIv.setImageDrawable(this.mImgLockLeft);
    this.mLeftBarIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.mBarWidth, -1);
    localLayoutParams.gravity = 8388611;
    this.mLeftBarIv.setLayoutParams(localLayoutParams);
    this.mLeftBarIv.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.mLeftBarIv);
    this.mRightBarIv = new ImageView(getContext());
    this.mRightBarIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
    this.mRightBarIv.setImageDrawable(this.mImgLockRight);
    localLayoutParams = new FrameLayout.LayoutParams(this.mBarWidth, -1);
    localLayoutParams.gravity = 8388613;
    this.mRightBarIv.setLayoutParams(localLayoutParams);
    this.mRightBarIv.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.mRightBarIv);
  }
  
  private void initView()
  {
    initSliderBar();
    setWillNotDraw(false);
  }
  
  private boolean isPressBar(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    if (paramBoolean) {
      this.mLeftBarIv.getHitRect(localRect);
    }
    for (;;)
    {
      localRect.left -= this.mTouchSlop;
      localRect.top -= this.mTouchSlop;
      localRect.right += this.mTouchSlop;
      localRect.bottom += this.mTouchSlop;
      return localRect.contains(paramInt1, paramInt2);
      this.mRightBarIv.getHitRect(localRect);
    }
  }
  
  private boolean isPressIndicator(int paramInt)
  {
    float f = this.mSelectAreaRect.left + this.mSelectAreaRect.width() * this.mIndicatorProgress - this.mIndicatorWidth / 2.0F;
    return (paramInt >= f - this.mIndicatorWidth * 2.0F) && (paramInt <= f + this.mIndicatorWidth * 2.0F);
  }
  
  private void moveIndicator(int paramInt)
  {
    float f2 = this.mSelectAreaRect.left + this.mSelectAreaRect.width() * this.mIndicatorProgress - this.mIndicatorWidth / 2.0F + paramInt;
    float f1 = f2;
    if (this.mIndicatorWidth / 2.0F + f2 > this.mSelectAreaRect.left + this.mSelectAreaRect.width()) {
      f1 = this.mSelectAreaRect.left + this.mSelectAreaRect.width() - this.mIndicatorWidth / 2.0F;
    }
    this.mIndicatorProgress = Math.max(0.0F, (f1 - this.mSelectAreaRect.left + this.mIndicatorWidth / 2.0F) / this.mSelectAreaRect.width());
    this.mIndicatorMoved = true;
  }
  
  private void moveLeftBar(int paramInt)
  {
    if ((!this.canAdjust) && (paramInt > 0)) {}
    float f1;
    do
    {
      return;
      float f2 = this.mLeftBarIv.getX() + paramInt;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = 0.0F;
      }
      f2 = f1;
      if (this.mRightBarIv.getX() - f1 - this.mBarWidth < this.mMinSelectAreaWidth) {
        f2 = this.mRightBarIv.getX() - this.mBarWidth - this.mMinSelectAreaWidth;
      }
      f1 = f2;
      if (this.mRightBarIv.getX() - f2 - this.mBarWidth > this.mMaxSelectAreaWidth) {
        f1 = this.mRightBarIv.getX() - this.mBarWidth - this.mMaxSelectAreaWidth;
      }
    } while (FloatUtils.isEquals(f1, this.mLeftBarIv.getX()));
    this.mLeftBarIv.setX(f1);
    this.mLeftBarMoved = true;
    this.mIndicatorProgress = 0.0F;
    notifySliderBarMove();
  }
  
  private void moveRightBar(int paramInt)
  {
    if ((!this.canAdjust) && (paramInt < 0)) {
      return;
    }
    float f1 = this.mRightBarIv.getX();
    float f2 = paramInt + f1;
    f1 = getMeasuredWidth() - this.mBarWidth;
    if (f2 > f1) {
      f2 = f1;
    }
    for (;;)
    {
      f1 = f2;
      if (f2 - this.mLeftBarIv.getX() - this.mBarWidth < this.mMinSelectAreaWidth) {
        f1 = this.mLeftBarIv.getX() + this.mBarWidth + this.mMinSelectAreaWidth;
      }
      f2 = f1;
      if (f1 - this.mLeftBarIv.getX() - this.mBarWidth > this.mMaxSelectAreaWidth) {
        f2 = this.mLeftBarIv.getX() + this.mBarWidth + this.mMaxSelectAreaWidth;
      }
      if (FloatUtils.isEquals(f2, this.mRightBarIv.getX())) {
        break;
      }
      this.mRightBarIv.setX(f2);
      this.mRightBarMoved = true;
      this.mIndicatorProgress = 1.0F;
      notifySliderBarMove();
      return;
    }
  }
  
  private void notifyIndicatorMove()
  {
    if (this.mSliderChangeListener != null)
    {
      Logger.d("SliderView", "notifyIndicatorMove: indicatorProgress is " + this.mIndicatorProgress);
      this.mSliderChangeListener.onIndicatorMove(this.mIndicatorProgress);
    }
  }
  
  private void notifyIndicatorPress()
  {
    if (this.mSliderChangeListener != null) {
      this.mSliderChangeListener.onIndicatorPress();
    }
  }
  
  private void notifyIndicatorRelease()
  {
    if (this.mSliderChangeListener != null) {
      this.mSliderChangeListener.onIndicatorRelease();
    }
  }
  
  private void notifySliderBarMove()
  {
    if (this.mSliderChangeListener != null) {
      this.mSliderChangeListener.onSliderBarMove(this.mLeftBarHandle, this.mLeftBarIv.getX() + this.mLeftBarIv.getWidth(), this.mRightBarIv.getX());
    }
  }
  
  private void notifySliderBarRelease()
  {
    if (this.mSliderChangeListener != null) {
      this.mSliderChangeListener.onSliderBarRelease(this.mLeftBarHandle);
    }
  }
  
  private String translateDuration(long paramLong)
  {
    long l1 = Math.round((float)paramLong / 1000.0F);
    long l2 = l1 % 60L;
    long l3 = l1 / 60L % 60L;
    l1 = l1 / 3600L % 24L;
    if (l1 > 0L) {
      return String.format(Locale.US, "%d:%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2) });
    }
    l1 = l2;
    if (paramLong < 1000L)
    {
      l1 = l2;
      if (paramLong > 0L) {
        l1 = 1L;
      }
    }
    return String.format(Locale.US, "%02d:%02d", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
  }
  
  private void updateSliderBarSource()
  {
    boolean bool2 = true;
    ImageView localImageView;
    Object localObject;
    if (this.mLeftBarIv != null)
    {
      localImageView = this.mLeftBarIv;
      if (this.mLockMode)
      {
        localObject = this.mImgLockLeft;
        localImageView.setImageDrawable((Drawable)localObject);
        localObject = this.mLeftBarIv;
        if (this.mLockMode) {
          break label111;
        }
        bool1 = true;
        label47:
        ((ImageView)localObject).setEnabled(bool1);
      }
    }
    else if (this.mRightBarIv != null)
    {
      localImageView = this.mRightBarIv;
      if (!this.mLockMode) {
        break label116;
      }
      localObject = this.mImgLockRight;
      label77:
      localImageView.setImageDrawable((Drawable)localObject);
      localObject = this.mRightBarIv;
      if (this.mLockMode) {
        break label124;
      }
    }
    label111:
    label116:
    label124:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((ImageView)localObject).setEnabled(bool1);
      return;
      localObject = this.mImgRangeLeft;
      break;
      bool1 = false;
      break label47;
      localObject = this.mImgRangeRight;
      break label77;
    }
  }
  
  private void updateSliderBarVisible()
  {
    int j = 0;
    ImageView localImageView;
    if (this.mLeftBarIv != null)
    {
      localImageView = this.mLeftBarIv;
      if (this.mSliderBarMode)
      {
        i = 0;
        localImageView.setVisibility(i);
      }
    }
    else if (this.mRightBarIv != null)
    {
      localImageView = this.mRightBarIv;
      if (!this.mSliderBarMode) {
        break label61;
      }
    }
    label61:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  public float getIndicatorProgress()
  {
    return this.mIndicatorProgress;
  }
  
  public ImageView getLeftBarIv()
  {
    return this.mLeftBarIv;
  }
  
  public ImageView getRightBarIv()
  {
    return this.mRightBarIv;
  }
  
  public int getSelectAreaWidth()
  {
    if (this.mSelectAreaRect == null) {
      this.mSelectAreaRect = new Rect();
    }
    if (this.mSliderBarMode) {
      this.mSelectAreaRect.set(this.mLeftBarIv.getWidth(), this.mPaddingTop, getMeasuredWidth() - this.mRightBarIv.getWidth(), getMeasuredHeight() - this.mPaddingBottom);
    }
    for (;;)
    {
      return this.mSelectAreaRect.width();
      this.mSelectAreaRect.set(getPaddingLeft(), this.mPaddingTop, getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - this.mPaddingBottom);
    }
  }
  
  public boolean isDragging()
  {
    return this.mDragging;
  }
  
  public boolean isIndicatorMoving()
  {
    return this.mIndicatorMoved;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    drawFrame(paramCanvas);
    drawDuration(paramCanvas);
    paramCanvas.restore();
    drawIndicator(paramCanvas);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i;
    int j;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      do
      {
        return false;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        this.mLeftBarPressed = false;
        this.mRightBarPressed = false;
        this.mIndicatorPressed = false;
        this.mOriginX = i;
        this.mLastX = i;
        this.mDragging = false;
        if ((isPressBar(true, i, j)) && (this.mLeftBarIv.isEnabled()))
        {
          this.mLeftBarPressed = true;
          return true;
        }
        if ((isPressBar(false, i, j)) && (this.mRightBarIv.isEnabled()))
        {
          this.mRightBarPressed = true;
          return true;
        }
      } while (!isPressIndicator(i));
      this.mIndicatorPressed = true;
      notifyIndicatorPress();
      return true;
    case 2: 
      this.mLeftBarMoved = false;
      this.mRightBarMoved = false;
      this.mIndicatorMoved = false;
      i = (int)paramMotionEvent.getX();
      if ((!this.mDragging) && (Math.abs(i - this.mOriginX) > this.mTouchSlop)) {
        this.mDragging = true;
      }
      if (this.mDragging)
      {
        j = i - this.mLastX;
        if ((this.mLeftBarPressed) || (this.mRightBarPressed))
        {
          getParent().requestDisallowInterceptTouchEvent(true);
          if (this.mLeftBarPressed)
          {
            this.mLeftBarMoved = true;
            this.mLeftBarHandle = true;
            moveLeftBar(j);
            invalidate();
          }
        }
      }
      break;
    }
    for (;;)
    {
      label266:
      if ((this.mLeftBarMoved) || (this.mRightBarMoved)) {
        notifySliderBarMove();
      }
      for (;;)
      {
        this.mLastX = i;
        return bool;
        if (!this.mRightBarPressed) {
          break;
        }
        this.mRightBarMoved = true;
        this.mLeftBarHandle = false;
        moveRightBar(j);
        break;
        if (!this.mIndicatorPressed) {
          break label473;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        moveIndicator(j);
        invalidate();
        break label266;
        if (this.mIndicatorMoved) {
          notifyIndicatorMove();
        }
      }
      this.mDragging = false;
      this.mOriginX = 0;
      this.mLastX = 0;
      if ((this.mLeftBarMoved) || (this.mRightBarMoved))
      {
        this.mLeftBarMoved = false;
        this.mRightBarMoved = false;
        this.mLeftBarPressed = false;
        this.mRightBarPressed = false;
        getParent().requestDisallowInterceptTouchEvent(false);
        invalidate();
        notifySliderBarRelease();
        return true;
      }
      if ((!this.mIndicatorMoved) && (!this.mIndicatorPressed)) {
        break;
      }
      this.mIndicatorPressed = false;
      this.mIndicatorMoved = false;
      getParent().requestDisallowInterceptTouchEvent(false);
      invalidate();
      notifyIndicatorRelease();
      return true;
      label473:
      bool = false;
    }
  }
  
  public void release()
  {
    this.mSliderChangeListener = null;
  }
  
  public void setCanAdjust(boolean paramBoolean)
  {
    this.canAdjust = paramBoolean;
  }
  
  public void setDurationBgRes(int paramInt)
  {
    this.mDurationBgBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
  }
  
  public void setFrameColor(int paramInt)
  {
    this.frameColor = paramInt;
    invalidate();
  }
  
  public void setIndicatorProgress(float paramFloat)
  {
    if (FloatUtils.isEquals(paramFloat, this.mIndicatorProgress)) {
      return;
    }
    this.mIndicatorProgress = paramFloat;
    Logger.d("SliderView", "setIndicatorProgress: indicatorProgress is " + paramFloat);
    invalidate();
  }
  
  public void setIndicatorRes(int paramInt)
  {
    this.mIndicatorBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
    this.mIndicatorWidth = this.mIndicatorBitmap.getWidth();
  }
  
  public void setLockMode(boolean paramBoolean)
  {
    this.mLockMode = paramBoolean;
    updateSliderBarSource();
  }
  
  public void setMaxDurationTips(String paramString)
  {
    this.mMaxDurationTips = paramString;
  }
  
  public void setMaxSelectAreaWidth(int paramInt)
  {
    this.mMaxSelectAreaWidth = paramInt;
  }
  
  public void setMaxSelectDuration(long paramLong)
  {
    this.mMaxSelectDurationMs = paramLong;
  }
  
  public void setMinSelectAreaWidth(int paramInt)
  {
    this.mMinSelectAreaWidth = paramInt;
  }
  
  public void setSelectDuration(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mDuration = translateDuration(Long.parseLong(paramString));
    if ((Long.parseLong(paramString) == this.mMaxSelectDurationMs) && ((this.mLeftBarMoved) || (this.mRightBarMoved)) && (this.mTotalDurationMs != this.mMaxSelectDurationMs) && (!TextUtils.isEmpty(this.mMaxDurationTips))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.mDuration = this.mMaxDurationTips;
      }
      invalidate();
      return;
    }
  }
  
  public void setShowDuration(boolean paramBoolean)
  {
    this.mShowDuration = paramBoolean;
  }
  
  public void setSliderBarMode(boolean paramBoolean)
  {
    this.mSliderBarMode = paramBoolean;
    updateSliderBarVisible();
    invalidate();
  }
  
  public void setSliderBarPosition(float paramFloat1, float paramFloat2)
  {
    if (this.mLeftBarIv != null) {
      this.mLeftBarIv.setX(paramFloat1);
    }
    if (this.mRightBarIv != null) {
      this.mRightBarIv.setX(paramFloat2);
    }
  }
  
  public void setSliderChangeListener(SliderChangeListener paramSliderChangeListener)
  {
    this.mSliderChangeListener = paramSliderChangeListener;
  }
  
  public void setTotalDurationMs(long paramLong)
  {
    this.mTotalDurationMs = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.timeline.SliderView
 * JD-Core Version:    0.7.0.1
 */