package com.tencent.moai.nativepages.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.util.Map;

public class AdLandingControlView
  extends PageControlView
{
  public AdLandingControlView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdLandingControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void generatePageControl(int paramInt)
  {
    removeAllViews();
    if (paramInt >= this.count) {
      return;
    }
    int j = this.count;
    int i = 0;
    label20:
    if (i < j)
    {
      this.imageView = null;
      if (paramInt != i) {
        break label140;
      }
      if (this.map.size() > i) {
        this.imageView = ((ImageView)this.map.get(Integer.valueOf(i)));
      }
      if (this.imageView == null)
      {
        this.imageView = ((ImageView)View.inflate(this.context, this.resIndicatorLayout, null).findViewById(2131372817));
        this.map.put(Integer.valueOf(i), this.imageView);
      }
      this.imageView.setSelected(true);
    }
    for (;;)
    {
      addView(this.imageView);
      i += 1;
      break label20;
      break;
      label140:
      if (this.map.size() > i) {
        this.imageView = ((ImageView)this.map.get(Integer.valueOf(i)));
      }
      if (this.imageView == null)
      {
        this.imageView = ((ImageView)View.inflate(this.context, this.resIndicatorLayout, null).findViewById(2131372817));
        this.map.put(Integer.valueOf(i), this.imageView);
      }
      this.imageView.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.AdLandingControlView
 * JD-Core Version:    0.7.0.1
 */