package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import aaux;
import aauy;
import aauy.b;
import aavb;
import aavb.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import aqnm;

public class VideoFrameSelectBar
  extends View
  implements aaux, aauy.b, aavb.a
{
  private static final int ckN = aqnm.dip2px(13.0F);
  private aavb jdField_a_of_type_Aavb;
  private a jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a;
  private aauy b;
  private String bes = "";
  private boolean bzG;
  private boolean bzH;
  private int ckO = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private int ckP = 3000;
  private float fX;
  private float fY;
  private boolean mIsDragging;
  private boolean mIsInited;
  private Paint mPaint = new Paint();
  private float sf;
  private float sg;
  private float sh;
  private float si;
  private float sj;
  private float sk;
  
  public VideoFrameSelectBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private final void V(MotionEvent paramMotionEvent)
  {
    if (this.bzG) {
      this.jdField_a_of_type_Aavb.processTouchEvent(paramMotionEvent);
    }
    while (!this.bzH) {
      return;
    }
    this.b.processTouchEvent(paramMotionEvent);
  }
  
  private void cyI()
  {
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void cyL()
  {
    this.bes = String.format("%.1f''", new Object[] { Float.valueOf(this.sj / 1000.0F) });
    this.sk = this.mPaint.measureText(this.bes);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a.F(this.sj);
    }
  }
  
  private float v(float paramFloat)
  {
    return paramFloat / this.fX * this.ckP;
  }
  
  public void K(float paramFloat1, float paramFloat2)
  {
    this.si = v((int)(paramFloat1 - this.jdField_a_of_type_Aavb.aR()));
    this.sj = v(paramFloat2 - paramFloat1);
    cyL();
    this.b.Gz((int)paramFloat1);
    this.b.GA((int)paramFloat2);
    invalidate();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a.bd((int)aT(), (int)aU());
    }
  }
  
  boolean Xq()
  {
    return this.mIsDragging;
  }
  
  public float aT()
  {
    return this.sh + this.si;
  }
  
  public float aU()
  {
    return this.sh + this.si + this.sj;
  }
  
  void cyJ()
  {
    this.mIsDragging = true;
  }
  
  void cyK()
  {
    this.mIsDragging = false;
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Aavb != null) {
      this.jdField_a_of_type_Aavb.destroy();
    }
    if (this.b != null) {
      this.b.destroy();
    }
    this.mIsInited = false;
    this.sh = 0.0F;
    this.si = 0.0F;
    this.sj = 0.0F;
  }
  
  public void e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.sh = v(paramFloat1);
    cyL();
    if (this.jdField_a_of_type_Aavb != null) {
      this.jdField_a_of_type_Aavb.J(paramFloat2, paramFloat3);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a.bd((int)aT(), (int)aU());
    }
  }
  
  public boolean hasChanged()
  {
    if ((this.b == null) || (this.jdField_a_of_type_Aavb == null)) {}
    while ((!this.b.hasChanged()) && (!this.jdField_a_of_type_Aavb.hasChanged())) {
      return false;
    }
    return true;
  }
  
  public void init(int paramInt, String paramString)
  {
    if (paramInt < 12000) {
      this.ckP = 2000;
    }
    for (int i = (int)Math.ceil(1.0F * paramInt / 2000.0F);; i = 6)
    {
      int j = getResources().getDisplayMetrics().widthPixels;
      float f = j * 0.925F / 6.0F;
      this.fX = f;
      this.fY = f;
      this.jdField_a_of_type_Aavb = new aavb(this, this.fX, this.fY, i, this.ckP, j, paramInt);
      this.jdField_a_of_type_Aavb.a(this);
      this.sj = v(this.jdField_a_of_type_Aavb.aS());
      cyL();
      this.b = new aauy(this, paramString, paramInt, i, this.fX, this.fY, j, this.jdField_a_of_type_Aavb.aR(), this.ckP);
      this.b.a(this);
      this.mPaint.setAntiAlias(true);
      this.mIsInited = true;
      return;
      this.ckP = (paramInt / 6);
    }
  }
  
  public boolean isInited()
  {
    return this.mIsInited;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Aavb == null) || (this.b == null)) {
      return;
    }
    this.mPaint.setTextSize(40.0F);
    this.mPaint.setColor(-1);
    paramCanvas.translate(0.0F, ckN + 50);
    if (this.b != null) {
      this.b.draw(paramCanvas);
    }
    if (this.jdField_a_of_type_Aavb != null) {
      this.jdField_a_of_type_Aavb.draw(paramCanvas);
    }
    paramCanvas.translate(0.0F, -ckN - 50);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Aavb == null) || (this.b == null))
    {
      setMeasuredDimension(0, 0);
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), (int)(50.0F + this.jdField_a_of_type_Aavb.getHeight() + ckN));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_Aavb != null) && (this.b != null))
      {
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        }
        while ((this.bzH) || (this.bzG))
        {
          return true;
          this.sf = paramMotionEvent.getX();
          this.sg = paramMotionEvent.getY();
          this.bzG = this.jdField_a_of_type_Aavb.F(this.sf, this.sg - 50.0F);
          this.bzH = false;
          if ((!this.bzH) && (!this.bzG)) {
            return super.onTouchEvent(paramMotionEvent);
          }
          setPressed(true);
          invalidate();
          cyJ();
          V(paramMotionEvent);
          cyI();
          continue;
          if (Xq())
          {
            V(paramMotionEvent);
          }
          else if (Math.abs(paramMotionEvent.getX() - this.sf) > this.ckO)
          {
            setPressed(true);
            invalidate();
            cyJ();
            V(paramMotionEvent);
            cyI();
            continue;
            if (Xq())
            {
              V(paramMotionEvent);
              cyK();
              setPressed(false);
            }
            for (;;)
            {
              invalidate();
              break;
              cyJ();
              V(paramMotionEvent);
              cyK();
            }
            if (Xq())
            {
              cyK();
              V(paramMotionEvent);
              setPressed(false);
            }
            invalidate();
          }
        }
      }
    }
  }
  
  public void postInvalidate()
  {
    super.postInvalidate();
  }
  
  public void reset()
  {
    if (this.jdField_a_of_type_Aavb != null) {
      this.jdField_a_of_type_Aavb.reset();
    }
    if (this.b != null) {
      this.b.destroy();
    }
    this.bes = "";
    this.mIsInited = false;
    this.sh = 0.0F;
    this.si = 0.0F;
    this.sj = 0.0F;
  }
  
  public void setOnFramesClipChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void F(float paramFloat);
    
    public abstract void bd(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */