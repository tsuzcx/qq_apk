package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

public class GestureCropImageView
  extends CropImageView
{
  private ScaleGestureDetector a;
  private boolean aub = true;
  private boolean auc = true;
  private boolean aud = true;
  private int bbi = 5;
  private float kO;
  private float kP;
  private GestureDetector mGestureDetector;
  
  public GestureCropImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GestureCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GestureCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void baj()
  {
    this.mGestureDetector = new GestureDetector(getContext(), new a(null), null, true);
    this.a = new ScaleGestureDetector(getContext(), new b(null));
  }
  
  protected float an()
  {
    return ao() * (float)Math.pow(getMaxScale() / getMinScale(), 1.0F / this.bbi);
  }
  
  protected void init()
  {
    super.init();
    baj();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      bag();
    }
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.kO = ((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F);
      this.kP = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.auc) {
      this.a.onTouchEvent(paramMotionEvent);
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 1)
    {
      setImageToWrapCropBounds();
      setImageToLowerMaxScale();
    }
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setDoubleTapScaleSteps(int paramInt)
  {
    this.bbi = paramInt;
  }
  
  public void setIsDoubleTapEnabled(boolean paramBoolean)
  {
    this.aud = paramBoolean;
  }
  
  public void setRotateEnabled(boolean paramBoolean)
  {
    this.aub = paramBoolean;
  }
  
  public void setScaleEnabled(boolean paramBoolean)
  {
    this.auc = paramBoolean;
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      if (GestureCropImageView.a(GestureCropImageView.this)) {
        GestureCropImageView.this.a(GestureCropImageView.this.an(), paramMotionEvent.getX(), paramMotionEvent.getY(), 200L);
      }
      return super.onDoubleTap(paramMotionEvent);
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      GestureCropImageView.this.postTranslate(-paramFloat1, -paramFloat2);
      return true;
    }
  }
  
  class b
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private b() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      GestureCropImageView.this.a(paramScaleGestureDetector.getScaleFactor(), GestureCropImageView.a(GestureCropImageView.this), GestureCropImageView.b(GestureCropImageView.this), true);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.GestureCropImageView
 * JD-Core Version:    0.7.0.1
 */