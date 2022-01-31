package com.tencent.open.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class KeyboardDetectorRelativeLayout
  extends RelativeLayout
{
  protected Rect a;
  protected IKeyboardChanged a;
  
  public KeyboardDetectorRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_ComTencentOpenWidgetIKeyboardChanged = null;
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
  }
  
  public void a(IKeyboardChanged paramIKeyboardChanged)
  {
    this.jdField_a_of_type_ComTencentOpenWidgetIKeyboardChanged = paramIKeyboardChanged;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    Activity localActivity = (Activity)super.getContext();
    localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int j = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int k = localActivity.getWindowManager().getDefaultDisplay().getHeight();
    if ((this.jdField_a_of_type_ComTencentOpenWidgetIKeyboardChanged != null) && (i != 0))
    {
      if (k - j - i <= 100) {
        break label112;
      }
      this.jdField_a_of_type_ComTencentOpenWidgetIKeyboardChanged.a(Math.abs(this.jdField_a_of_type_AndroidGraphicsRect.height()) - getPaddingBottom() - getPaddingTop());
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      label112:
      this.jdField_a_of_type_ComTencentOpenWidgetIKeyboardChanged.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.widget.KeyboardDetectorRelativeLayout
 * JD-Core Version:    0.7.0.1
 */