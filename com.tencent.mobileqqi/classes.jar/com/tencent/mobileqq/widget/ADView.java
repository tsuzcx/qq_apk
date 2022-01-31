package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import hey;
import hez;

public class ADView
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = -2;
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public WorkSpaceView a;
  private hez jdField_a_of_type_Hez = new hez(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 2130837615;
  private int c = this.b;
  
  public ADView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = null;
  }
  
  public ADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = null;
    setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
  }
  
  private void a(LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    i = 0;
    localImageView = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, 0, (int)(2.0F * this.jdField_a_of_type_Float), 0);
    localImageView.setLayoutParams(localLayoutParams);
    for (;;)
    {
      try
      {
        localImageView.setImageDrawable(getContext().getResources().getDrawable(this.c));
        if (!paramBoolean) {
          continue;
        }
        localImageView.setEnabled(true);
      }
      catch (Exception localException)
      {
        localImageView.setImageResource(this.b);
        continue;
        i = 4;
        continue;
      }
      paramLinearLayout.addView(localImageView);
      if (paramLinearLayout.getChildCount() <= 1) {
        continue;
      }
      paramLinearLayout.setVisibility(i);
      return;
      localImageView.setEnabled(false);
    }
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    while (paramInt >= this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount()) {
      return 0;
    }
    Object localObject = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    if (localObject != null) {}
    for (localObject = (WorkSpaceView)((RelativeLayout)localObject).getChildAt(0);; localObject = null)
    {
      if (localObject != null) {}
      for (paramInt = ((WorkSpaceView)localObject).getChildCount();; paramInt = 0) {
        return paramInt;
      }
    }
  }
  
  public ViewGroup a(int paramInt)
  {
    return (WorkSpaceView)((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt)).getChildAt(0);
  }
  
  public void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
    if (localRelativeLayout == null) {
      return;
    }
    ((WorkSpaceView)localRelativeLayout.getChildAt(0)).removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
    WorkSpaceView localWorkSpaceView = (WorkSpaceView)localLinearLayout.getChildAt(0);
    localWorkSpaceView.removeViewAt(paramInt2);
    localLinearLayout = (LinearLayout)localLinearLayout.getChildAt(1);
    localLinearLayout.removeViewAt(paramInt2);
    if (localLinearLayout.getChildCount() > 1) {}
    for (paramInt1 = i;; paramInt1 = 4)
    {
      localLinearLayout.setVisibility(paramInt1);
      if (paramInt2 > 0) {
        localWorkSpaceView.a(paramInt2 - 1);
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, View paramView)
  {
    int i = 0;
    try
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
      WorkSpaceView localWorkSpaceView = (WorkSpaceView)localRelativeLayout.getChildAt(0);
      localWorkSpaceView.removeView(paramView);
      paramView = (LinearLayout)localRelativeLayout.getChildAt(1);
      paramView.removeViewAt(paramInt2);
      if (paramView.getChildCount() > 1) {}
      for (paramInt1 = i;; paramInt1 = 4)
      {
        paramView.setVisibility(paramInt1);
        if (paramInt2 > 0) {
          localWorkSpaceView.a(paramInt2 - 1);
        }
        return;
      }
      return;
    }
    catch (Exception paramView) {}
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject1;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      localObject1 = new LinearLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = new WorkSpaceView(getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setOnScreenChangeListener(new hey(this, (LinearLayout)localObject1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setId(100000);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 100000);
      ((RelativeLayout.LayoutParams)localObject2).addRule(14, 100000);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, 0, (int)(6.0F * this.jdField_a_of_type_Float));
      ((LinearLayout)localObject1).setGravity(16);
      ((LinearLayout)localObject1).setBackgroundResource(2130838097);
      ((LinearLayout)localObject1).setPadding((int)(4.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float), 0);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localRelativeLayout.addView((View)localObject1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.addView(paramView, paramInt);
        a((LinearLayout)localObject1, bool);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent.banner", 4, "addViewToWorkspace");
        }
        return;
      }
      catch (Exception paramView) {}
      localObject1 = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = ((WorkSpaceView)((ViewGroup)localObject1).getChildAt(0));
      localObject1 = (LinearLayout)((ViewGroup)localObject1).getChildAt(1);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Hez.removeMessages(0);
    this.jdField_a_of_type_Hez.sendEmptyMessage(0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Hez.sendEmptyMessage(1);
  }
  
  public void setIsCloseADView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADView
 * JD-Core Version:    0.7.0.1
 */