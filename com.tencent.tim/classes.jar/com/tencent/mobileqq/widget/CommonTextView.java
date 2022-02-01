package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import arge;
import arge.a;

public class CommonTextView
  extends TextView
  implements arge.a
{
  private arge jdField_a_of_type_Arge;
  private a jdField_a_of_type_ComTencentMobileqqWidgetCommonTextView$a;
  
  public CommonTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void aX(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void aY(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Arge != null)
    {
      this.jdField_a_of_type_Arge.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Arge != null)
    {
      this.jdField_a_of_type_Arge.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCommonTextView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCommonTextView$a.onVisibilityChanged(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(arge paramarge)
  {
    arge localarge = this.jdField_a_of_type_Arge;
    if (localarge != null) {
      localarge.setView(null);
    }
    this.jdField_a_of_type_Arge = paramarge;
    if (paramarge != null) {
      paramarge.setView(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCommonTextView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onVisibilityChanged(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */