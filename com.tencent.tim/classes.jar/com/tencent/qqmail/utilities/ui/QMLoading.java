package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.androidqqmail.R.styleable;

public class QMLoading
  extends View
{
  public static final int SIZE_DEFAULT = QMUIKit.dpToPx(36);
  public static final int SIZE_MINI = QMUIKit.dpToPx(18);
  public static final int SIZE_SMALL = QMUIKit.dpToPx(19);
  public static final int SIZE_TIPS = QMUIKit.dpToPx(36);
  public static final int TYPE_DARKBG = 1;
  public static final int TYPE_DEFAULT = 0;
  private int PAINT_COLOR = -8224126;
  private AnimationDrawable mAnimationDrawable;
  private int mSize;
  
  public QMLoading(Context paramContext)
  {
    this(paramContext, SIZE_DEFAULT, 0);
  }
  
  public QMLoading(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 0);
  }
  
  public QMLoading(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.mSize = paramInt1;
    if (paramInt2 == 1) {
      this.PAINT_COLOR = -1;
    }
    initAnimation();
  }
  
  public QMLoading(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, SIZE_DEFAULT, 0);
  }
  
  public QMLoading(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.QMLoading);
    this.mSize = paramContext.getDimensionPixelSize(R.styleable.QMLoading_loading_size, SIZE_DEFAULT);
    if (paramInt2 == 1) {
      this.PAINT_COLOR = -1;
    }
    this.PAINT_COLOR = paramContext.getColor(R.styleable.QMLoading_loading_color, this.PAINT_COLOR);
    initAnimation();
  }
  
  private Drawable getLoadingBitmap(int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.mSize, this.mSize, Bitmap.Config.ARGB_8888);
    int i = this.mSize / 12;
    int j = this.mSize / 6;
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(this.PAINT_COLOR);
    localPaint.setStrokeWidth(i);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.rotate(paramInt, this.mSize / 2, this.mSize / 2);
    localCanvas.translate(this.mSize / 2, this.mSize / 2);
    paramInt = 0;
    while (paramInt < 12)
    {
      localCanvas.rotate(30.0F);
      localPaint.setAlpha((int)((paramInt + 1) * 255 / 12.0F));
      localCanvas.translate(0.0F, -this.mSize / 2 + i / 2);
      localCanvas.drawLine(0.0F, 0.0F, 0.0F, j, localPaint);
      localCanvas.translate(0.0F, this.mSize / 2 - i / 2);
      paramInt += 1;
    }
    return new BitmapDrawable(getResources(), localBitmap);
  }
  
  private void initAnimation()
  {
    int i = 0;
    if (this.mAnimationDrawable != null) {
      release();
    }
    this.mAnimationDrawable = new AnimationDrawable();
    this.mAnimationDrawable.setOneShot(false);
    while (i < 12)
    {
      this.mAnimationDrawable.addFrame(getLoadingBitmap(i * 30), 50);
      i += 1;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      setBackgroundDrawable(this.mAnimationDrawable);
      return;
    }
    setBackground(this.mAnimationDrawable);
  }
  
  private void release()
  {
    if (Build.VERSION.SDK_INT < 16) {
      setBackgroundDrawable(null);
    }
    for (;;)
    {
      if (this.mAnimationDrawable != null)
      {
        this.mAnimationDrawable.stop();
        this.mAnimationDrawable = null;
      }
      return;
      setBackground(null);
    }
  }
  
  public void checkValidate()
  {
    if (this.mAnimationDrawable == null) {
      initAnimation();
    }
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  public boolean isRunning()
  {
    if (this.mAnimationDrawable != null) {
      return this.mAnimationDrawable.isRunning();
    }
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    checkValidate();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    release();
  }
  
  protected void onDraw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.mSize, this.mSize);
    Drawable localDrawable = getBackground();
    if ((localDrawable != null) && ((localDrawable instanceof AnimationDrawable))) {
      ((AnimationDrawable)localDrawable).start();
    }
  }
  
  public void start()
  {
    if (this.mAnimationDrawable != null) {
      this.mAnimationDrawable.start();
    }
  }
  
  public void stop()
  {
    if (this.mAnimationDrawable != null) {
      this.mAnimationDrawable.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMLoading
 * JD-Core Version:    0.7.0.1
 */