package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import atau.a;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QCircleMaxHeightScrollView
  extends ScrollView
{
  private int maxHeight;
  
  public QCircleMaxHeightScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleMaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleMaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rt);
    this.maxHeight = paramContext.getDimensionPixelSize(0, ImmersiveUtils.dpToPx(300.0F));
    paramContext.recycle();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.maxHeight, -2147483648));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleMaxHeightScrollView
 * JD-Core Version:    0.7.0.1
 */