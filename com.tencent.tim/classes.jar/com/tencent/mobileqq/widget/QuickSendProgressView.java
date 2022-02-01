package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QuickSendProgressView
  extends View
{
  private RefreshProgressRunnable a;
  private RectF aZ;
  private Paint as;
  private String cAy;
  private boolean dbm;
  private Drawable eQ;
  private int egH = 0;
  private int ehS;
  private int ehT;
  private int ehU;
  private int ehV;
  private int ehW;
  private int ehX;
  private Drawable gn;
  private Drawable go;
  private Drawable gp;
  private Drawable mBackgroundDrawable;
  private Drawable mDrawable;
  private Rect mImageRect;
  private Path mPath;
  private int mProgress;
  private int mProgressColor;
  private int mSpacing;
  private Paint mTextPaint;
  private Drawable t;
  
  public QuickSendProgressView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QuickSendProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QuickSendProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(Canvas paramCanvas, Drawable paramDrawable)
  {
    int j;
    if (paramDrawable != null)
    {
      i = getWidth();
      j = getHeight();
      if ((i > 0) && (j > 0)) {}
    }
    else
    {
      return;
    }
    this.t = paramDrawable;
    int i = Math.min(i, j);
    paramCanvas.save();
    this.mPath.reset();
    this.mImageRect.set(0, 0, i - this.mSpacing * 2 - this.ehV * 2, i - this.mSpacing * 2 - this.ehV * 2);
    this.mImageRect.offset((i - this.mImageRect.width()) / 2, (i - this.mImageRect.height()) / 2);
    this.mPath.addCircle(this.mImageRect.centerX(), this.mImageRect.centerY(), this.mImageRect.width() * 1.0F / 2.0F, Path.Direction.CCW);
    paramCanvas.clipPath(this.mPath);
    if (this.egH == 0) {
      this.mImageRect.set(0, 0, i - this.ehV * 2 - this.ehW * 2, i - this.ehV * 2 - this.ehW * 2);
    }
    for (;;)
    {
      this.mImageRect.offset((i - this.mImageRect.width()) / 2, (i - this.mImageRect.height()) / 2);
      paramDrawable.setBounds(this.mImageRect);
      paramCanvas.translate(this.ehX, -this.ehX);
      paramDrawable.draw(paramCanvas);
      paramCanvas.restore();
      return;
      this.mImageRect.set(0, 0, i - this.mSpacing * 2 - this.ehV * 2 - this.ehW * 2, i - this.mSpacing * 2 - this.ehV * 2 - this.ehW * 2);
    }
  }
  
  private void af(Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (paramDrawable.isStateful()) && (paramDrawable.setState(getDrawableState()))) {
      invalidateDrawable(paramDrawable);
    }
  }
  
  private void bA(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    if ((i <= 0) || (j <= 0)) {}
    while ((this.egH != 1) && (this.egH != 2)) {
      return;
    }
    switch (this.egH)
    {
    }
    for (;;)
    {
      i = Math.min(i, j);
      this.aZ.set(this.ehV, this.ehV, i - this.ehV, i - this.ehV);
      paramCanvas.drawArc(this.aZ, 0.0F, 360.0F, false, this.as);
      return;
      this.as.setColor(this.ehT);
      continue;
      this.as.setColor(this.ehU);
    }
  }
  
  private void by(Canvas paramCanvas)
  {
    int j;
    if (this.cAy != null)
    {
      i = getWidth();
      j = getHeight();
      if ((i > 0) && (j > 0)) {}
    }
    else
    {
      return;
    }
    int i = Math.min(i, j);
    paramCanvas.drawText(this.cAy, 0.0F, i / 2.0F, this.mTextPaint);
  }
  
  private void bz(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    if ((i <= 0) || (j <= 0)) {
      return;
    }
    i = Math.min(i, j);
    Drawable localDrawable;
    if (this.egH == 0)
    {
      this.mImageRect.set(0, 0, i - this.ehV * 2, i - this.ehV * 2);
      this.mImageRect.offset((i - this.mImageRect.width()) / 2, (i - this.mImageRect.height()) / 2);
      paramCanvas.save();
      localDrawable = null;
      switch (this.egH)
      {
      }
    }
    for (;;)
    {
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.mImageRect);
        this.mPath.reset();
        this.mPath.addCircle(this.mImageRect.centerX(), this.mImageRect.centerY(), this.mImageRect.width() * 1.0F / 2.0F, Path.Direction.CCW);
        paramCanvas.clipPath(this.mPath);
        localDrawable.draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
      this.mImageRect.set(0, 0, i - this.mSpacing * 2 - this.ehV * 2, i - this.mSpacing * 2 - this.ehV * 2);
      break;
      localDrawable = this.gn;
      continue;
      localDrawable = this.go;
      continue;
      localDrawable = this.mBackgroundDrawable;
    }
  }
  
  private int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void eiI()
  {
    af(this.mBackgroundDrawable);
    af(this.gn);
    af(this.go);
    af(this.t);
  }
  
  private void eiJ()
  {
    l(this.mBackgroundDrawable);
    l(this.gn);
    l(this.go);
    l(this.t);
  }
  
  private void f(Canvas paramCanvas, @ColorInt int paramInt)
  {
    int i = getWidth();
    int j = getHeight();
    if ((i <= 0) || (j <= 0)) {
      return;
    }
    i = Math.min(i, j);
    this.as.setColor(paramInt);
    this.aZ.set(this.ehV, this.ehV, i - this.ehV, i - this.ehV);
    paramCanvas.drawArc(this.aZ, -90.0F, this.mProgress * 1.0F / 100.0F * 360.0F, false, this.as);
  }
  
  private float g(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat2) * paramFloat1 + paramFloat2;
  }
  
  private boolean l(Drawable paramDrawable)
  {
    return (paramDrawable != null) && (paramDrawable.isStateful()) && (paramDrawable.setState(StateSet.NOTHING));
  }
  
  private void update(float paramFloat)
  {
    int i = getWidth();
    int j = getHeight();
    if ((i <= 0) || (j <= 0)) {
      return;
    }
    i = Math.min(i, j);
    this.ehX = ((int)Math.ceil(g(paramFloat, -i / 2.0F, i / 2.0F)));
    invalidate();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    eiI();
  }
  
  public void init()
  {
    this.dbm = false;
    this.ehV = dp2px(2.0F, getResources());
    this.mSpacing = dp2px(3.0F, getResources());
    this.ehW = dp2px(1.0F, getResources());
    this.cAy = getResources().getString(2131693980);
    this.mBackgroundDrawable = getResources().getDrawable(2130847005);
    this.mProgressColor = Color.parseColor("#19BAFF");
    this.gn = getResources().getDrawable(2130847007);
    this.ehT = Color.parseColor("#3300CAFC");
    this.ehU = Color.parseColor("#33FF596A");
    this.go = getResources().getDrawable(2130847003);
    this.ehS = Color.parseColor("#FF596A");
    this.as = new Paint();
    this.as.setStrokeWidth(this.ehV);
    this.as.setStyle(Paint.Style.STROKE);
    this.as.setAntiAlias(true);
    this.as.setStrokeCap(Paint.Cap.ROUND);
    this.mTextPaint = new Paint();
    this.mTextPaint.setStyle(Paint.Style.FILL);
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setTextSize(dp2px(14.0F, getResources()));
    this.mTextPaint.setColor(getResources().getColor(2131165712));
    this.mImageRect = new Rect();
    this.aZ = new RectF();
    this.mPath = new Path();
    this.mDrawable = getResources().getDrawable(2130847006);
    this.gp = getResources().getDrawable(2130847009);
    this.eQ = getResources().getDrawable(2130847004);
    setContentDescription(getResources().getString(2131691441));
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.t != null) {
      this.t.jumpToCurrentState();
    }
    if (this.mBackgroundDrawable != null) {
      this.mBackgroundDrawable.jumpToCurrentState();
    }
    if (this.gn != null) {
      this.gn.jumpToCurrentState();
    }
    if (this.go != null) {
      this.go.jumpToCurrentState();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.a != null)
    {
      this.a.stopAnimation();
      this.a = null;
    }
    if (this.egH == 1)
    {
      this.a = new RefreshProgressRunnable();
      this.a.a(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.a != null)
    {
      this.a.stopAnimation();
      this.a = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.t = null;
    bz(paramCanvas);
    bA(paramCanvas);
    switch (this.egH)
    {
    default: 
      a(paramCanvas, this.mDrawable);
      return;
    case 1: 
      a(paramCanvas, this.gp);
      f(paramCanvas, this.mProgressColor);
      return;
    case 2: 
      a(paramCanvas, this.eQ);
      f(paramCanvas, this.ehS);
      return;
    }
    by(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    int k;
    if (this.mDrawable == null)
    {
      k = 0;
      i = 0;
    }
    for (;;)
    {
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      int j = getPaddingTop();
      int m = getPaddingBottom();
      int i5 = this.mSpacing;
      int i6 = this.ehV;
      int i7 = this.ehW;
      int n = this.mSpacing;
      int i1 = this.ehV;
      int i2 = this.ehW;
      k = Math.max(k + (i3 + i4 + i5 * 2 + i6 * 2 + i7 * 2), getSuggestedMinimumWidth());
      j = Math.max(i + (j + m + n * 2 + i1 * 2 + i2 * 2), getSuggestedMinimumHeight());
      i = resolveSizeAndState(k, paramInt1, 0);
      paramInt2 = resolveSizeAndState(j, paramInt2, 0);
      paramInt1 = i;
      if (this.dbm)
      {
        paramInt1 = i;
        if (this.cAy != null)
        {
          paramInt1 = i;
          if (this.mTextPaint != null) {
            paramInt1 = Math.max(i, (int)this.mTextPaint.measureText(this.cAy) + this.ehV);
          }
        }
      }
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      k = this.mDrawable.getIntrinsicWidth();
      m = this.mDrawable.getIntrinsicHeight();
      j = k;
      if (k <= 0) {
        j = 1;
      }
      k = j;
      if (m > 0)
      {
        i = m;
        k = j;
      }
    }
  }
  
  public void setProgress(@IntRange(from=0L, to=100L) int paramInt)
  {
    if (this.mProgress == paramInt) {
      return;
    }
    this.mProgress = paramInt;
    if (this.mProgress >= 100) {
      this.mProgress = 100;
    }
    invalidate();
  }
  
  public void setSpacing(int paramInt)
  {
    this.mSpacing = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    setStatus(paramInt, true);
  }
  
  public void setStatus(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if (this.egH == paramInt) {
      return;
    }
    this.ehX = 0;
    this.egH = paramInt;
    if (this.egH == 0)
    {
      setContentDescription(getResources().getString(2131691441));
      label42:
      eiJ();
      if (this.a != null)
      {
        this.a.stopAnimation();
        this.a = null;
      }
      if (this.egH == 1)
      {
        this.a = new RefreshProgressRunnable();
        this.a.a(this);
      }
      if (this.egH != 3) {
        break label194;
      }
    }
    for (;;)
    {
      if (this.dbm != bool)
      {
        this.dbm = bool;
        requestLayout();
      }
      if (!paramBoolean) {
        break;
      }
      invalidate();
      return;
      if (this.egH == 1)
      {
        setContentDescription(getResources().getString(2131691403));
        break label42;
      }
      if (this.egH == 2)
      {
        setContentDescription(getResources().getString(2131718845));
        break label42;
      }
      if (this.cAy == null) {
        break label42;
      }
      setContentDescription(this.cAy);
      break label42;
      label194:
      bool = false;
    }
  }
  
  public void setSuccessText(String paramString)
  {
    this.cAy = paramString;
  }
  
  public void setmArcStrokeWidth(int paramInt)
  {
    this.ehV = paramInt;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool = false;
    int i;
    if (paramDrawable != null) {
      if ((this.mBackgroundDrawable == paramDrawable) || (this.gn == paramDrawable) || (this.go == paramDrawable) || (this.t == paramDrawable)) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) || (super.verifyDrawable(paramDrawable))) {
        bool = true;
      }
      return bool;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  static class RefreshProgressRunnable
    implements Runnable
  {
    private long avR = 800L;
    private volatile long beginTime = -1L;
    private volatile boolean isStopped = true;
    private WeakReference<QuickSendProgressView> mView;
    
    public void a(QuickSendProgressView paramQuickSendProgressView)
    {
      if ((aGC()) || (paramQuickSendProgressView == null)) {
        return;
      }
      this.beginTime = -1L;
      this.isStopped = false;
      this.mView = new WeakReference(paramQuickSendProgressView);
      ViewCompat.postOnAnimation(paramQuickSendProgressView, this);
    }
    
    public boolean aGC()
    {
      return !this.isStopped;
    }
    
    public void run()
    {
      if (this.isStopped)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QuickSendProgressView", 2, " stopAnim in isStopped");
        }
        this.mView = null;
      }
      for (;;)
      {
        return;
        QuickSendProgressView localQuickSendProgressView;
        if (this.mView != null)
        {
          localQuickSendProgressView = (QuickSendProgressView)this.mView.get();
          if (localQuickSendProgressView != null) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("QuickSendProgressView", 2, "mView is null, stopAnim in isStopped");
          }
          this.isStopped = true;
          this.mView = null;
          return;
        }
        if (this.beginTime == -1L) {
          this.beginTime = SystemClock.uptimeMillis();
        }
        long l = SystemClock.uptimeMillis() - this.beginTime;
        if (l >= this.avR)
        {
          QuickSendProgressView.a(localQuickSendProgressView, 1.0F);
          this.beginTime = SystemClock.uptimeMillis();
        }
        while (!this.isStopped)
        {
          ViewCompat.postOnAnimation(localQuickSendProgressView, this);
          return;
          QuickSendProgressView.a(localQuickSendProgressView, (float)l * 1.0F / (float)this.avR);
        }
      }
    }
    
    public void stopAnimation()
    {
      this.isStopped = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QuickSendProgressView
 * JD-Core Version:    0.7.0.1
 */