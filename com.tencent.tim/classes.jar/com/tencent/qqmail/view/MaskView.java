package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class MaskView
  extends FrameLayout
{
  public MaskView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void attach(ViewGroup paramViewGroup, View paramView)
  {
    init(paramView);
    paramViewGroup.addView(this);
  }
  
  public void init(View paramView)
  {
    setLayoutParams(new FrameLayout.LayoutParams(paramView.getWidth(), paramView.getHeight()));
    setBackgroundColor(getResources().getColor(2131167654));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.MaskView
 * JD-Core Version:    0.7.0.1
 */