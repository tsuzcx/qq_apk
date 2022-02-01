package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class HongBaoJumpLayout
  extends View
{
  public int dqv;
  public int dqw;
  public int dqx;
  public int dqy;
  
  public HongBaoJumpLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public HongBaoJumpLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void init()
  {
    this.dqv = getResources().getDimensionPixelOffset(2131298664);
    this.dqw = getResources().getDimensionPixelOffset(2131298663);
    this.dqx = getResources().getDimensionPixelOffset(2131298661);
    this.dqy = getResources().getDimensionPixelOffset(2131298662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongBaoJumpLayout
 * JD-Core Version:    0.7.0.1
 */