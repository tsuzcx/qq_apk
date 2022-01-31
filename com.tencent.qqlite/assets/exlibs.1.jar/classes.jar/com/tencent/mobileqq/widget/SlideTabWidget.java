package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TabWidget;
import com.tencent.common.app.BaseApplicationImpl;
import ezi;
import ezj;

public class SlideTabWidget
  extends TabWidget
{
  private static int jdField_c_of_type_Int = (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 3.0F + 0.5F);
  private static final int d = 10;
  private static final int e = 0;
  private static final int f = 1;
  private static final int g = 2;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Handler jdField_a_of_type_AndroidOsHandler = new ezi(this);
  private SlideTabWidget.OnTabSlideCompleteListener jdField_a_of_type_ComTencentMobileqqWidgetSlideTabWidget$OnTabSlideCompleteListener;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean jdField_c_of_type_Boolean = false;
  
  public SlideTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131427474));
  }
  
  public SlideTabWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131427474));
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_Float >= 1.0F) || (this.jdField_b_of_type_Int == this.jdField_a_of_type_Int))) {}
    do
    {
      return;
      View localView1 = getChildTabViewAt(this.jdField_b_of_type_Int);
      if (localView1 != null)
      {
        int k = localView1.getLeft();
        int m = localView1.getRight();
        int j = m;
        int i = k;
        if (this.jdField_a_of_type_Float > 0.0F)
        {
          View localView2 = getChildAt(this.jdField_a_of_type_Int);
          j = m;
          i = k;
          if (localView2 != null)
          {
            i = (int)(localView1.getLeft() + this.jdField_a_of_type_Float * (localView2.getLeft() - localView1.getLeft()));
            float f1 = localView1.getRight();
            float f2 = this.jdField_a_of_type_Float;
            j = (int)(f1 + (localView2.getRight() - localView1.getRight()) * f2);
          }
        }
        paramCanvas.drawRect(i, getHeight() - jdField_c_of_type_Int, j, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideTabWidget$OnTabSlideCompleteListener == null) || (!this.jdField_c_of_type_Boolean));
    this.jdField_c_of_type_Boolean = false;
    post(new ezj(this));
  }
  
  public void setCurrentTab(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getTabCount()) || (paramInt == this.jdField_b_of_type_Int)) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
    for (;;)
    {
      super.setCurrentTab(paramInt);
      return;
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    }
  }
  
  public void setOnTabSlideCompleteListener(SlideTabWidget.OnTabSlideCompleteListener paramOnTabSlideCompleteListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideTabWidget$OnTabSlideCompleteListener = paramOnTabSlideCompleteListener;
  }
  
  public void setSlideAnimaPlay(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideTabWidget
 * JD-Core Version:    0.7.0.1
 */