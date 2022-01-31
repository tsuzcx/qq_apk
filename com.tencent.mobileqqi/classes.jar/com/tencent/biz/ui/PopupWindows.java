package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import bof;

public class PopupWindows
{
  protected Context a;
  protected Drawable a;
  protected View a;
  protected WindowManager a;
  public PopupWindow a;
  
  public PopupWindows(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchInterceptor(new bof(this));
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      throw new IllegalStateException("setContentView was not called with a view to display.");
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_AndroidViewView);
      return;
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
  }
  
  public void b(int paramInt)
  {
    b(((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(paramInt, null));
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.PopupWindows
 * JD-Core Version:    0.7.0.1
 */