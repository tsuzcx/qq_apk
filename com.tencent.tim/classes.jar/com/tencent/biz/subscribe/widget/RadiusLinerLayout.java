package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import aqcx;
import com.tencent.common.app.BaseApplicationImpl;

public class RadiusLinerLayout
  extends LinearLayout
{
  public static final int DEFAULT_RADIUS = aqcx.dip2px(BaseApplicationImpl.context, 8.0F);
  private int mRadius = DEFAULT_RADIUS;
  
  public RadiusLinerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RadiusLinerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RadiusLinerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setWillNotDraw(false);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.RadiusLinerLayout
 * JD-Core Version:    0.7.0.1
 */