package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class FeedBannerItemGradientLinearLayout
  extends LinearLayout
{
  private View Cw;
  private View Cx;
  
  public FeedBannerItemGradientLinearLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public FeedBannerItemGradientLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public FeedBannerItemGradientLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.Cw = new View(getContext());
    this.Cx = new View(getContext());
    setOrientation(1);
    addView(this.Cw, new LinearLayout.LayoutParams(-1, -2));
    addView(this.Cx, new LinearLayout.LayoutParams(-1, -1));
  }
  
  public void aO(int paramInt1, int paramInt2, int paramInt3)
  {
    this.Cw.getLayoutParams().height = paramInt1;
    this.Cw.setBackgroundColor(paramInt2);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setGradientType(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localGradientDrawable.setColors(new int[] { paramInt2, paramInt3 });
    }
    for (;;)
    {
      this.Cx.setBackgroundDrawable(localGradientDrawable);
      return;
      localGradientDrawable.setColor(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.FeedBannerItemGradientLinearLayout
 * JD-Core Version:    0.7.0.1
 */