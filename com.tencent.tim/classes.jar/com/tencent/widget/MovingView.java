package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import auuj;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class MovingView
  extends View
{
  private float CT;
  private float CU;
  Point M;
  a a;
  a b;
  Bitmap bitmap;
  private boolean dkH;
  int dx;
  int dy;
  private int etR;
  Bitmap gZ;
  public Handler handler = new auuj(this, Looper.getMainLooper());
  public int lastX;
  public int lastY;
  public int left;
  private int mAlpha;
  int mCurPos;
  private int mDuration;
  private int mFrom;
  public boolean mIsAnimStart;
  public boolean mIsPause;
  private Paint mPaint;
  public Scroller mScroller;
  private long mStartTimeMillis;
  private int mTo;
  Matrix matrix;
  Random random;
  public int top;
  
  public MovingView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MovingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MovingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(Bitmap paramBitmap, a parama)
  {
    float f3 = paramBitmap.getWidth();
    float f4 = paramBitmap.getHeight();
    float f1 = this.CT / f3;
    float f2 = this.CU / f4;
    if (f1 > f2) {
      f2 = this.CT;
    }
    for (f1 *= f4;; f1 = this.CU)
    {
      parama.ym = (f2 / f3);
      parama.yn = (f1 / f4);
      parama.dx = ((this.CT - f2) / 2.0F);
      parama.dy = ((this.CU - f1) / 2.0F);
      return;
      f2 *= f3;
    }
  }
  
  private Point b(int paramInt1, int paramInt2)
  {
    int i = this.random.nextInt(3);
    switch (this.mCurPos)
    {
    }
    for (;;)
    {
      return this.M;
      if (i == 0)
      {
        this.mCurPos = 2;
        this.M.x = (-paramInt1);
        this.M.y = 0;
      }
      else if (i == 1)
      {
        this.mCurPos = 3;
        this.M.x = (-paramInt1);
        this.M.y = (-paramInt2);
      }
      else if (i == 2)
      {
        this.mCurPos = 1;
        this.M.x = 0;
        this.M.y = (-paramInt2);
        continue;
        if (i == 0)
        {
          this.mCurPos = 0;
          this.M.x = 0;
          this.M.y = paramInt2;
        }
        else if (i == 1)
        {
          this.mCurPos = 2;
          this.M.x = (-paramInt1);
          this.M.y = paramInt2;
        }
        else if (i == 2)
        {
          this.mCurPos = 3;
          this.M.x = (-paramInt1);
          this.M.y = 0;
          continue;
          if (i == 0)
          {
            this.mCurPos = 3;
            this.M.x = 0;
            this.M.y = (-paramInt2);
          }
          else if (i == 1)
          {
            this.mCurPos = 1;
            this.M.x = paramInt1;
            this.M.y = (-paramInt2);
          }
          else if (i == 2)
          {
            this.mCurPos = 0;
            this.M.x = paramInt1;
            this.M.y = 0;
            continue;
            if (i == 0)
            {
              this.mCurPos = 1;
              this.M.x = paramInt1;
              this.M.y = 0;
            }
            else if (i == 1)
            {
              this.mCurPos = 0;
              this.M.x = paramInt1;
              this.M.y = paramInt2;
            }
            else if (i == 2)
            {
              this.mCurPos = 2;
              this.M.x = 0;
              this.M.y = paramInt2;
            }
          }
        }
      }
    }
  }
  
  private void init()
  {
    this.mScroller = new Scroller(getContext(), new LinearInterpolator());
    this.random = new Random(System.currentTimeMillis());
    this.mCurPos = 0;
    this.M = new Point(0, 0);
    this.left = 0;
    this.top = 0;
    this.mIsAnimStart = false;
    this.etR = 2;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setFilterBitmap(true);
    this.matrix = new Matrix();
  }
  
  int C(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        break label26;
      }
      label8:
      if (paramInt1 <= paramInt2) {
        break label32;
      }
    }
    for (;;)
    {
      return (int)(paramInt1 * 54.700001F);
      paramInt1 = -paramInt1;
      break;
      label26:
      paramInt2 = -paramInt2;
      break label8;
      label32:
      paramInt1 = paramInt2;
    }
  }
  
  public void Yc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "startTranslate");
    }
    switch (this.mCurPos)
    {
    }
    for (;;)
    {
      Point localPoint = b(this.dx, this.dy);
      this.lastX = 0;
      this.lastY = 0;
      this.mScroller.forceFinished(true);
      this.mScroller.startScroll(0, 0, localPoint.x, localPoint.y, C(localPoint.x, localPoint.y));
      this.handler.sendEmptyMessage(1);
      return;
      this.left = 0;
      this.top = (-this.dy);
      continue;
      this.left = 0;
      this.top = 0;
      continue;
      this.left = (-this.dx);
      this.top = (-this.dy);
      continue;
      this.left = (-this.dx);
      this.top = 0;
    }
  }
  
  public void am(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (this.bitmap == paramBitmap) {
        this.gZ = null;
      }
      for (;;)
      {
        this.mDuration = 1000;
        this.mFrom = 0;
        this.mTo = 255;
        this.mAlpha = 0;
        this.dkH = true;
        this.etR = 0;
        if (this.gZ == null) {
          this.mIsAnimStart = false;
        }
        if (!this.mIsAnimStart)
        {
          this.mIsAnimStart = true;
          if (!this.handler.hasMessages(2)) {
            this.handler.sendEmptyMessage(2);
          }
        }
        invalidate();
        return;
        this.gZ = this.bitmap;
        this.bitmap = paramBitmap;
        if (this.gZ != null)
        {
          if (this.b == null) {
            this.b = new a();
          }
          this.b.ym = this.a.ym;
          this.b.yn = this.a.yn;
          this.b.dx = this.a.dx;
          this.b.dy = this.a.dy;
        }
        if (this.a == null) {
          this.a = new a();
        }
        a(paramBitmap, this.a);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "startTranslate, bitmap = null");
    }
    clearAnimation();
    postInvalidate();
  }
  
  protected void exg()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MovingView", 2, "stopTranslate()");
    }
    this.mIsAnimStart = false;
    this.handler.removeMessages(2);
    this.handler.removeMessages(1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    super.onDraw(paramCanvas);
    if (getVisibility() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "onDraw, getVisibility() != View.VISIBLE");
      }
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      return;
    }
    switch (this.etR)
    {
    }
    while (i != 0)
    {
      this.etR = 2;
      this.gZ = null;
      if (this.bitmap != null)
      {
        this.matrix.reset();
        this.matrix.postScale(this.a.ym, this.a.yn);
        this.matrix.postTranslate(this.a.dx + this.left, this.a.dy + this.top);
        paramCanvas.drawBitmap(this.bitmap, this.matrix, this.mPaint);
        return;
        this.mStartTimeMillis = SystemClock.uptimeMillis();
        this.etR = 1;
        i = 0;
        continue;
        if (this.mStartTimeMillis >= 0L)
        {
          float f = (float)(SystemClock.uptimeMillis() - this.mStartTimeMillis) / this.mDuration;
          if (f >= 1.0D) {}
          for (i = j;; i = 0)
          {
            this.mAlpha = ((int)(this.mFrom + f * (this.mTo - this.mFrom)));
            break;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("MovingView", 2, "onDraw, bitmap = null 1");
        }
        paramCanvas.drawColor(17170445, PorterDuff.Mode.CLEAR);
        return;
      }
    }
    i = this.mAlpha;
    if (this.gZ != null)
    {
      boolean bool = this.dkH;
      if (bool) {
        this.mPaint.setAlpha(255 - i);
      }
      this.matrix.reset();
      this.matrix.postScale(this.b.ym, this.b.yn);
      this.matrix.postTranslate(this.b.dx + this.left, this.b.dy + this.top);
      paramCanvas.drawBitmap(this.gZ, this.matrix, this.mPaint);
      if (bool) {
        this.mPaint.setAlpha(255);
      }
    }
    if (i > 0)
    {
      if (this.bitmap == null) {
        break label520;
      }
      this.mPaint.setAlpha(i);
      this.matrix.reset();
      this.matrix.postScale(this.a.ym, this.a.yn);
      this.matrix.postTranslate(this.a.dx + this.left, this.a.dy + this.top);
      paramCanvas.drawBitmap(this.bitmap, this.matrix, this.mPaint);
      this.mPaint.setAlpha(255);
    }
    for (;;)
    {
      invalidate();
      return;
      label520:
      if (QLog.isColorLevel()) {
        QLog.i("MovingView", 2, "onDraw, bitmap = null 2");
      }
      paramCanvas.drawColor(17170445, PorterDuff.Mode.CLEAR);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      exg();
    }
    for (;;)
    {
      postInvalidate();
      return;
      if (paramInt == 0) {
        if (this.bitmap != null) {
          am(this.bitmap);
        } else if (QLog.isColorLevel()) {
          QLog.i("MovingView", 2, "setVisibility, bitmap = null");
        }
      }
    }
  }
  
  public class a
  {
    public float dx;
    public float dy;
    public float ym;
    public float yn;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.MovingView
 * JD-Core Version:    0.7.0.1
 */