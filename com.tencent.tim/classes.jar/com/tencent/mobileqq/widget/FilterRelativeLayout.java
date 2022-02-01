package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class FilterRelativeLayout
  extends RelativeLayout
{
  private Paint cu;
  
  public FilterRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FilterRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FilterRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.cu != null) {
      paramCanvas.saveLayer(null, this.cu, 31);
    }
    super.dispatchDraw(paramCanvas);
    if (this.cu != null) {
      paramCanvas.restore();
    }
  }
  
  public void setFilter(int paramInt)
  {
    if (this.cu == null) {
      this.cu = new Paint();
    }
    this.cu.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FilterRelativeLayout
 * JD-Core Version:    0.7.0.1
 */