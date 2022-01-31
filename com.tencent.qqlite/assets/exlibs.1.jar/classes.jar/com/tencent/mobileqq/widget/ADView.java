package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import exa;
import exb;

public class ADView
  extends LinearLayout
{
  private static final int e = -2;
  protected float a;
  protected int a;
  protected LinearLayout a;
  public WorkSpaceView a;
  private exb a;
  public boolean a;
  protected int b;
  private boolean b;
  protected int c = 2;
  protected int d = 0;
  
  public ADView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2130837519;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = null;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Exb = new exb(this);
  }
  
  public ADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2130837519;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = null;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Exb = new exb(this);
    setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
  }
  
  private void a(LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    localImageView = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams;
    if (this.d > 0)
    {
      localLayoutParams = new LinearLayout.LayoutParams((int)(this.d * this.jdField_a_of_type_Float), (int)(this.d * this.jdField_a_of_type_Float));
      localLayoutParams.setMargins(0, 0, (int)(this.c * this.jdField_a_of_type_Float), 0);
      localImageView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      try
      {
        localImageView.setImageDrawable(getContext().getResources().getDrawable(this.jdField_b_of_type_Int));
        if (!paramBoolean) {
          continue;
        }
        localImageView.setEnabled(true);
      }
      catch (Exception localException)
      {
        localImageView.setImageResource(this.jdField_a_of_type_Int);
        continue;
        int i = 4;
        continue;
      }
      paramLinearLayout.addView(localImageView);
      if (paramLinearLayout.getChildCount() <= 1) {
        continue;
      }
      i = 0;
      paramLinearLayout.setVisibility(i);
      return;
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      break;
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
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    if (localRelativeLayout != null) {
      return (WorkSpaceView)localRelativeLayout.getChildAt(0);
    }
    return null;
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
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      localObject = new LinearLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = new WorkSpaceView(getContext());
      setCircle(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setOnScreenChangeListener(new exa(this, (LinearLayout)localObject));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setId(100000);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView, localLayoutParams);
      a((LinearLayout)localObject);
      localRelativeLayout.addView((View)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.addView(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount());
        a((LinearLayout)localObject, bool);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent.banner", 4, "addViewToWorkspace");
        }
        return;
      }
      catch (Exception paramView) {}
      localObject = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = ((WorkSpaceView)((ViewGroup)localObject).getChildAt(0));
      localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
    }
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 100000);
    localLayoutParams.addRule(14, 100000);
    localLayoutParams.setMargins(0, 0, 0, (int)(6.0F * this.jdField_a_of_type_Float));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setBackgroundResource(2130838113);
    paramLinearLayout.setPadding((int)(4.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Exb.removeMessages(0);
    this.jdField_a_of_type_Exb.sendEmptyMessage(0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Exb.sendEmptyMessage(1);
  }
  
  public void setCircle(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setCircle(paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setIsCloseADView(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADView
 * JD-Core Version:    0.7.0.1
 */