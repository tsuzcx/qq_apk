package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aaeg;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;
import wrb;
import wro;
import wrx;

public class DoodleView
  extends View
{
  private a jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView$a;
  private LineLayer jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void bux()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer = new LineLayer(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.init();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a(new aaeg(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.setLineColor(LineLayer.brD);
    super.requestLayout();
  }
  
  public wrb a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer == null) {
      return null;
    }
    wrb localwrb = new wrb();
    localwrb.i(cL(), paramBoolean, true);
    localwrb.a().a(a());
    return localwrb;
  }
  
  public wro a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a();
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDoodleView$a = parama;
    bux();
  }
  
  public List<wrx> cL()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.getPathList();
    }
    return null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.draw(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.setSize(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.M(paramMotionEvent);
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.tp() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.clear(true);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.RJ();
  }
  
  public void setLineColor(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.setLineColor(paramInt);
    }
  }
  
  public void setLineTexture(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.setLineTexture(paramInt);
    }
  }
  
  public int t(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.tp();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.wa();
    }
    return 0;
  }
  
  public void undo()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.undo();
    }
  }
  
  public void yS(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.clear(paramBoolean);
    }
    super.invalidate();
  }
  
  public static abstract interface a
  {
    public abstract void cbi();
    
    public abstract void ctQ();
    
    public abstract void ft(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleView
 * JD-Core Version:    0.7.0.1
 */