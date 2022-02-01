package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import arge;
import arge.a;

public class CommonImageView
  extends ImageView
  implements arge.a
{
  private arge a;
  
  public CommonImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void aX(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void aY(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setMosaicEffect(arge paramarge)
  {
    arge localarge = this.a;
    if (localarge != null) {
      localarge.setView(null);
    }
    this.a = paramarge;
    if (paramarge != null) {
      paramarge.setView(this);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonImageView
 * JD-Core Version:    0.7.0.1
 */