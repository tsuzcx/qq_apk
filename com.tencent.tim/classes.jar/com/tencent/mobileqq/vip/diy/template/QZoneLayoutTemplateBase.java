package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import rpq;

public class QZoneLayoutTemplateBase
  extends ViewGroup
{
  protected int AD;
  protected int borderColor = -16777216;
  protected int borderWidth;
  protected Drawable fU;
  protected int height;
  protected int width;
  
  public QZoneLayoutTemplateBase(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QZoneLayoutTemplateBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QZoneLayoutTemplateBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.AD = rpq.dip2px(paramContext, 5.0F);
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    paramView.setPadding(this.borderWidth, this.borderWidth, this.borderWidth, this.borderWidth);
    if (this.fU != null)
    {
      paramView.setBackgroundDrawable(this.fU);
      return;
    }
    paramView.setBackgroundColor(this.borderColor);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getChildCount();
    if (paramInt1 > 0) {
      getChildAt(0).layout(0, 0, this.height, this.height);
    }
    if (paramInt1 > 1) {
      getChildAt(1).layout(this.height + this.AD, 0, this.height * 2 + this.AD, this.height);
    }
    if (paramInt1 > 2) {
      getChildAt(2).layout(this.height * 2 + this.AD * 2, 0, this.height * 3 + this.AD * 2, this.height);
    }
    if (paramInt1 > 3) {
      getChildAt(3).layout(this.height * 3 + this.AD * 3, 0, this.width, this.height);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.width = View.MeasureSpec.getSize(paramInt1);
    this.height = ((this.width - this.AD * 3) / 4);
    paramInt1 = getChildCount();
    if (paramInt1 > 0) {
      getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(this.height, 1073741824), View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
    }
    if (paramInt1 > 1) {
      getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec(this.height, 1073741824), View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
    }
    if (paramInt1 > 2) {
      getChildAt(2).measure(View.MeasureSpec.makeMeasureSpec(this.height, 1073741824), View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
    }
    if (paramInt1 > 3) {
      getChildAt(3).measure(View.MeasureSpec.makeMeasureSpec(this.height, 1073741824), View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
    }
    setMeasuredDimension(this.width, this.height);
  }
  
  public void setBorderColor(int paramInt)
  {
    this.borderColor = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.borderWidth = paramInt;
  }
  
  public void setItemBg(Drawable paramDrawable)
  {
    this.fU = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplateBase
 * JD-Core Version:    0.7.0.1
 */