package com.tencent.mobileqq.vipav;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.widget.VideoView;

public class VipFullScreenVideoView
  extends VideoView
{
  public VipFullScreenVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VipFullScreenVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VipFullScreenVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f;
    if ((getHolder() != null) && (getHolder().getSurfaceFrame() != null))
    {
      int i = getHolder().getSurfaceFrame().width();
      int j = getHolder().getSurfaceFrame().height();
      if ((i > 0) && (j > 0) && (getHeight() > 0) && (getWidth() > 0))
      {
        f = j / i;
        paramInt1 = getDefaultSize(getResources().getDisplayMetrics().widthPixels, paramInt1);
        paramInt2 = getDefaultSize(getResources().getDisplayMetrics().heightPixels, paramInt2);
        if (f >= paramInt2 / paramInt1) {
          break label138;
        }
        paramInt1 = (int)(paramInt2 / f);
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      label138:
      paramInt2 = (int)(paramInt1 * f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFullScreenVideoView
 * JD-Core Version:    0.7.0.1
 */