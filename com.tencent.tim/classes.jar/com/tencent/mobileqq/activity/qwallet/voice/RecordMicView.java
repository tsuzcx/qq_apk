package com.tencent.mobileqq.activity.qwallet.voice;

import aagk;
import acfp;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import aqcx;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordMicView
  extends View
{
  private b a;
  private ValueAnimator aj;
  private int bQi = 10000;
  public boolean bvt = true;
  private int cgu;
  private int cgv;
  private int cgz;
  private Handler cm = new Handler(ThreadManager.getSubThreadLooper());
  private Paint mPaint = new Paint(5);
  private RectF mRectF = new RectF();
  private int mStatus = 0;
  private float mStrokeWidth = aqcx.dip2px(getContext(), 2.0F);
  float rn = 0.0F;
  private List<a> vk = new ArrayList();
  
  public RecordMicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = aqcx.dip2px(getContext(), 120.0F);
    this.cgv = i;
    this.cgu = i;
    this.cgz = aqcx.dip2px(getContext(), 33.0F);
    ViewCompat.setImportantForAccessibility(this, 1);
    setContentDescription(acfp.m(2131713770));
    setClickable(true);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2)
  {
    a locala = new a(aqcx.dip2px(getContext(), paramFloat1), aqcx.dip2px(getContext(), paramFloat2), paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramInt1, paramInt2);
    this.vk.add(locala);
  }
  
  private void cud()
  {
    if (this.aj != null) {
      this.aj.cancel();
    }
    this.aj = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.aj.setRepeatCount(-1);
    this.aj.setRepeatMode(2);
    this.aj.setDuration(400L);
    this.aj.addUpdateListener(new aagk(this));
    this.aj.start();
  }
  
  public void cuc()
  {
    this.mStatus = 2;
    this.vk.clear();
    a(112.0F, 120.0F, 0.8F, 0.1F, 1.0F, 1.05F, 1.0F, 0.95F, 0, 30);
    a(124.0F, 117.0F, 0.5F, 0.1F, 1.0F, 0.95F, 1.0F, 0.95F, 0, -30);
    a(124.0F, 132.0F, 0.1F, 0.5F, 1.0F, 0.95F, 1.0F, 0.95F, 0, 30);
    a(128.0F, 122.0F, 0.1F, 0.8F, 1.0F, 0.9F, 1.0F, 0.95F, 0, 30);
    cud();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.1F, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.1F, 1.0F }) });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setInterpolator(new LinearInterpolator());
    localObjectAnimator.start();
  }
  
  public void cue()
  {
    this.cm.removeCallbacksAndMessages(null);
    this.cm.postDelayed(new RecordMicView.2(this), this.bQi);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.cm != null) {
      this.cm.removeCallbacksAndMessages(null);
    }
    if (this.aj != null) {
      this.aj.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 1.0F;
    super.onDraw(paramCanvas);
    Object localObject;
    int i;
    if (this.mStatus == 2)
    {
      this.mStrokeWidth = aqcx.dip2px(getContext(), 1.0F);
      localObject = this.vk.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        paramCanvas.save();
        float f2 = locala.width;
        f1 = locala.height;
        f2 = (getWidth() - f2) / 2.0F;
        f1 = (getHeight() - f1) / 2.0F;
        i = (int)(255.0F * locala.alpha);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(-3405);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setAlpha(i);
        this.mRectF.set(this.mStrokeWidth * 0.5F + f2, this.mStrokeWidth * 0.5F + f1, getWidth() - this.mStrokeWidth * 0.5F - f2, getHeight() - this.mStrokeWidth * 0.5F - f1);
        paramCanvas.scale(locala.scaleX, locala.scaleY, getWidth() / 2, getHeight() / 2);
        paramCanvas.rotate(locala.rotate, getWidth() / 2, getHeight() / 2);
        paramCanvas.drawOval(this.mRectF, this.mPaint);
        paramCanvas.restore();
      }
      paramCanvas.save();
      paramCanvas.translate((getWidth() - yA()) / 2, (getHeight() - yB()) / 2);
      localObject = getResources().getDrawable(2130848197);
      ((Drawable)localObject).setBounds(0, 0, yA(), yB());
      ((Drawable)localObject).setAlpha(127);
      ((Drawable)localObject).draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    this.mStrokeWidth = aqcx.dip2px(getContext(), 2.0F);
    paramCanvas.save();
    paramCanvas.translate((getWidth() - yA()) / 2, (getHeight() - yB()) / 2);
    if (this.mStatus == 0)
    {
      i = 255;
      if (this.mStatus != 0) {
        break label660;
      }
    }
    for (;;)
    {
      paramCanvas.scale(f1, f1, getWidth() / 2, getHeight() / 2);
      this.mPaint.setColor(16728412);
      this.mRectF.set(0.0F, 0.0F, yA(), yB());
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setAlpha(i);
      paramCanvas.drawOval(this.mRectF, this.mPaint);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setColor(-3405);
      this.mPaint.setStrokeWidth(this.mStrokeWidth);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setAlpha(i);
      this.mRectF.set(this.mStrokeWidth * 0.5F, this.mStrokeWidth * 0.5F, yA() - this.mStrokeWidth * 0.5F, yB() - this.mStrokeWidth * 0.5F);
      paramCanvas.drawOval(this.mRectF, this.mPaint);
      localObject = getResources().getDrawable(2130848197);
      ((Drawable)localObject).setBounds(0, 0, yA(), yB());
      ((Drawable)localObject).setAlpha(i);
      ((Drawable)localObject).draw(paramCanvas);
      paramCanvas.restore();
      return;
      i = 127;
      break;
      label660:
      f1 = 0.95F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool2 = true;
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      boolean bool1 = super.onTouchEvent(paramMotionEvent);
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.mStatus == 2);
        bool1 = bool2;
      } while (this.mStatus != 0);
      this.mStatus = 1;
      invalidate();
      cue();
      if (this.a != null) {
        this.a.onBegin();
      }
      this.rn = paramMotionEvent.getRawY();
      return true;
    } while (this.mStatus != 1);
    if (this.rn - paramMotionEvent.getRawY() > this.cgz) {}
    for (;;)
    {
      if (i != 0)
      {
        if (this.a != null) {
          this.a.onCancel();
        }
        reset();
        break;
      }
      this.cm.removeCallbacksAndMessages(null);
      if (this.bvt) {
        cuc();
      }
      for (;;)
      {
        if (this.a == null) {
          break label204;
        }
        this.a.onEnd();
        break;
        reset();
      }
      label204:
      break;
      i = 0;
    }
  }
  
  public void reset()
  {
    this.cm.removeCallbacksAndMessages(null);
    this.mStatus = 0;
    if (this.aj != null) {
      this.aj.cancel();
    }
    invalidate();
  }
  
  public void setRecordTime(int paramInt)
  {
    this.bQi = paramInt;
  }
  
  public void setStatusListener(b paramb)
  {
    this.a = paramb;
  }
  
  public int yA()
  {
    return this.cgu;
  }
  
  public int yB()
  {
    return this.cgv;
  }
  
  public static class a
  {
    public float alpha;
    public int cgA;
    public int cgB;
    public float hc;
    public float hd;
    public float height;
    public float hf;
    public float hg;
    public float hh;
    public float hi;
    public int rotate;
    public float scaleX;
    public float scaleY;
    public float width;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt1, int paramInt2)
    {
      this.width = paramFloat1;
      this.height = paramFloat2;
      this.alpha = paramFloat3;
      this.hc = paramFloat3;
      this.scaleX = paramFloat5;
      this.hf = paramFloat5;
      this.scaleY = paramFloat7;
      this.hg = paramFloat7;
      this.rotate = paramInt1;
      this.cgA = paramInt1;
      this.hd = paramFloat4;
      this.hh = paramFloat6;
      this.hi = paramFloat8;
      this.cgB = paramInt2;
    }
  }
  
  public static abstract interface b
  {
    public abstract void csS();
    
    public abstract void onBegin();
    
    public abstract void onCancel();
    
    public abstract void onEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.RecordMicView
 * JD-Core Version:    0.7.0.1
 */