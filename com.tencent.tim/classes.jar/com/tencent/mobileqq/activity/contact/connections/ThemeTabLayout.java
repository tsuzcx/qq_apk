package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import aqnm;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.b;
import java.util.ArrayList;
import yrh;

public class ThemeTabLayout
  extends FrameLayout
{
  private ConnectionsTabLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout;
  private TabThemeMaskView jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabThemeMaskView;
  public float mLastX;
  public float mLastY;
  public float mf;
  public float mg;
  
  public ThemeTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ThemeTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ThemeTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  public void Ew(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.Ew(paramInt);
  }
  
  public float aM()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.getScrollX();
    }
    return 0.0F;
  }
  
  public void b(TabLayoutCompat.b paramb)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.b(paramb);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.mg = 0.0F;
      this.mf = 0.0F;
      this.mLastX = paramMotionEvent.getX();
      this.mLastY = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mf += Math.abs(f1 - this.mLastX);
      this.mg += Math.abs(f2 - this.mLastY);
      this.mLastX = f1;
      this.mLastY = f2;
      if (this.mf <= this.mg) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  public void initView()
  {
    Object localObject = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561507, this, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout = ((ConnectionsTabLayout)((RelativeLayout)localObject).findViewById(2131365235));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = aqnm.dip2px(10.0F);
    addView((View)localObject, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabThemeMaskView = new TabThemeMaskView(getContext());
    localObject = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabThemeMaskView, (ViewGroup.LayoutParams)localObject);
  }
  
  public void removeAllTabs()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.removeAllTabs();
  }
  
  public void setOnTabSelectedListener(TabLayoutCompat.b paramb)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabThemeMaskView == null)) {}
    while (paramb == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.a(paramb);
  }
  
  public void setScrollPosition(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.setScrollX((int)paramFloat);
    }
  }
  
  public void v(ArrayList<yrh> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.v(paramArrayList, paramInt);
  }
  
  public void w(ArrayList<yrh> paramArrayList, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTabThemeMaskView == null)) {}
    while ((paramArrayList == null) || (paramInt < 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsConnectionsTabLayout.u(paramArrayList, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout
 * JD-Core Version:    0.7.0.1
 */