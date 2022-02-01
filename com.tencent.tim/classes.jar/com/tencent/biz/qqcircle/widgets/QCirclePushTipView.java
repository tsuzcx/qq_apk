package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class QCirclePushTipView
  extends TextView
{
  public QCirclePushTipView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCirclePushTipView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCirclePushTipView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    setBackgroundDrawable(getResources().getDrawable(2130844904));
    setTextColor(getResources().getColor(2131167654));
    setTextSize(1, 14.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushTipView
 * JD-Core Version:    0.7.0.1
 */