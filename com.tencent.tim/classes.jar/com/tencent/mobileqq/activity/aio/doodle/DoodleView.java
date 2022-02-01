package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;
import wrb;
import wro;
import wrr;
import wrx;

public class DoodleView
  extends View
{
  private a jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView$a;
  private LineLayer jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void bux()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer = new LineLayer(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.init();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(new wrr(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.setLineColor(LineLayer.brD);
    super.requestLayout();
  }
  
  public wrb a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer == null) {
      return null;
    }
    wrb localwrb = new wrb();
    localwrb.i(cL(), paramBoolean, true);
    localwrb.a().a(a());
    return localwrb;
  }
  
  public wro a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a();
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView$a = parama;
    bux();
  }
  
  public List<wrx> cL()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.getPathList();
    }
    return null;
  }
  
  public Bitmap j(int paramInt)
  {
    int i = getWidth();
    i = (int)(getHeight() * 1.0F / i * paramInt);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt, i, Bitmap.Config.ARGB_8888);
      if (localBitmap == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.c(localCanvas);
      }
      return localBitmap;
    }
    catch (Exception localException)
    {
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.draw(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.setSize(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.M(paramMotionEvent);
    }
    return false;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
    if (paramInt != 0) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.tp() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.clear(true);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.RJ();
  }
  
  public void setLineColor(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.setLineColor(paramInt);
    }
  }
  
  public void setLineTexture(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.setLineTexture(paramInt);
    }
  }
  
  public int t(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.tp();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.wa();
    }
    return 0;
  }
  
  public void unInit()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.unInit();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView$a = null;
  }
  
  public void undo()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.undo();
    }
  }
  
  public void yS(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.clear(paramBoolean);
    }
    super.invalidate();
  }
  
  public static abstract interface a
  {
    public abstract void cbi();
    
    public abstract void ft(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */