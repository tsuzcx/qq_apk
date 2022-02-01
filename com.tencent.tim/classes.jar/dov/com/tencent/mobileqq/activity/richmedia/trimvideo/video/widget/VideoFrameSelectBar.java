package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import aqnm;
import ayvq;
import ayvr;
import ayvr.b;
import ayvt;
import ayvt.a;

public class VideoFrameSelectBar
  extends View
  implements ayvq, ayvr.b, ayvt.a
{
  private static final int ckN = aqnm.dip2px(13.0F);
  private ayvr jdField_a_of_type_Ayvr;
  private ayvt jdField_a_of_type_Ayvt;
  private a jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a;
  private String bes = "";
  private boolean bzG;
  private boolean bzH;
  private int ckO = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private int ckP = 3000;
  private float fX;
  private boolean mIsDragging;
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
      this.jdField_a_of_type_Ayvt.processTouchEvent(paramMotionEvent);
    }
    while (!this.bzH) {
      return;
    }
    this.jdField_a_of_type_Ayvr.processTouchEvent(paramMotionEvent);
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
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a != null) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a.F(this.sj);
    }
  }
  
  private float v(float paramFloat)
  {
    return paramFloat / this.fX * this.ckP;
  }
  
  public void K(float paramFloat1, float paramFloat2)
  {
    this.si = v((int)(paramFloat1 - this.jdField_a_of_type_Ayvt.aR()));
    this.sj = v(paramFloat2 - paramFloat1);
    cyL();
    this.jdField_a_of_type_Ayvr.Gz((int)paramFloat1);
    this.jdField_a_of_type_Ayvr.GA((int)paramFloat2);
    invalidate();
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a != null) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a.bd((int)aT(), (int)aU());
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
  
  public void e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.sh = v(paramFloat1);
    cyL();
    if (this.jdField_a_of_type_Ayvt != null) {
      this.jdField_a_of_type_Ayvt.J(paramFloat2, paramFloat3);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a != null) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a.bd((int)aT(), (int)aU());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Ayvt == null) || (this.jdField_a_of_type_Ayvr == null)) {
      return;
    }
    this.mPaint.setTextSize(40.0F);
    this.mPaint.setColor(-1);
    paramCanvas.translate(0.0F, ckN + 50);
    if (this.jdField_a_of_type_Ayvr != null) {
      this.jdField_a_of_type_Ayvr.draw(paramCanvas);
    }
    if (this.jdField_a_of_type_Ayvt != null) {
      this.jdField_a_of_type_Ayvt.draw(paramCanvas);
    }
    paramCanvas.translate(0.0F, -ckN - 50);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Ayvt == null) || (this.jdField_a_of_type_Ayvr == null))
    {
      setMeasuredDimension(0, 0);
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), (int)(50.0F + this.jdField_a_of_type_Ayvt.getHeight() + ckN));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_Ayvt != null) && (this.jdField_a_of_type_Ayvr != null))
      {
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        }
        while ((this.bzH) || (this.bzG))
        {
          return true;
          this.sf = paramMotionEvent.getX();
          this.sg = paramMotionEvent.getY();
          this.bzG = this.jdField_a_of_type_Ayvt.F(this.sf, this.sg - 50.0F);
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
  
  public void setOnFramesClipChangeListener(a parama)
  {
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void F(float paramFloat);
    
    public abstract void bd(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */