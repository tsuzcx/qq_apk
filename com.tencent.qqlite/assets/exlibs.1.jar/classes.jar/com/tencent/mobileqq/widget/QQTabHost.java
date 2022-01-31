package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.utils.StartupTracker;

public class QQTabHost
  extends TabHost
{
  private OnDrawCompleteListener jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener;
  private QQTabHost.OnTabSelectionListener jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener;
  private boolean jdField_a_of_type_Boolean = false;
  
  public QQTabHost(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    if ((paramContext instanceof OnDrawCompleteListener)) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = ((OnDrawCompleteListener)paramContext);
    }
  }
  
  public QQTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    if ((paramContext instanceof OnDrawCompleteListener)) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = ((OnDrawCompleteListener)paramContext);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean) {
      StartupTracker.a(null, "Recent_Draw");
    }
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      StartupTracker.a("Recent_Draw", null);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener.d();
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean) {
      StartupTracker.a(null, "Recent_OnLayout");
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Boolean) {
      StartupTracker.a("Recent_OnLayout", null);
    }
  }
  
  public void setCurrentTab(int paramInt)
  {
    int i = getTabWidget().getTabCount();
    if ((paramInt < 0) || (paramInt >= i)) {}
    do
    {
      return;
      i = getCurrentTab();
      super.setCurrentTab(paramInt);
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener.a(i, paramInt, this);
  }
  
  public void setFirstDrawTrue()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setOnTabSelectionListener(QQTabHost.OnTabSelectionListener paramOnTabSelectionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener = paramOnTabSelectionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabHost
 * JD-Core Version:    0.7.0.1
 */