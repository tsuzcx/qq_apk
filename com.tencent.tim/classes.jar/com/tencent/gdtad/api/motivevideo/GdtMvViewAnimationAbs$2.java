package com.tencent.gdtad.api.motivevideo;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import tjd;

public class GdtMvViewAnimationAbs$2
  implements Runnable
{
  public GdtMvViewAnimationAbs$2(tjd paramtjd, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, View paramView) {}
  
  public void run()
  {
    this.r.topMargin = (this.val$topMargin + (int)(this.bBS * 1.0F));
    this.r.leftMargin = (this.bBT + (int)(this.bBU * 1.0F));
    RelativeLayout.LayoutParams localLayoutParams = this.r;
    if (this.bBV == -1) {}
    for (int i = this.r.leftMargin;; i = this.bBW + (int)(this.bBV * 1.0F))
    {
      localLayoutParams.rightMargin = i;
      if (this.ra != null) {
        this.ra.setLayoutParams(this.r);
      }
      tjd.em(this.ra);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs.2
 * JD-Core Version:    0.7.0.1
 */