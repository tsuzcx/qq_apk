package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TabHost.OnTabChangeListener;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.qphone.base.util.QLog;
import csp;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Constants.LogoutReason;

public class FrameActivity
  extends BaseActivity
  implements TabHost.OnTabChangeListener, OnDrawCompleteListener
{
  long jdField_a_of_type_Long = -1L;
  protected ViewPager a;
  private Frame jdField_a_of_type_ComTencentMobileqqAppFrame;
  private final List jdField_a_of_type_JavaUtilList = new ArrayList(3);
  String m = null;
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
  }
  
  protected Frame a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqBaseActivity", 2, "mTabHost=null");
      }
      return null;
    }
    return ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem())).jdField_a_of_type_ComTencentMobileqqAppFrame;
  }
  
  protected Frame a(Class paramClass)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equals(paramClass.getName())) {}
    }
    for (;;)
    {
      return ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqAppFrame;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public Frame a(String paramString)
  {
    try
    {
      paramString = (Frame)Class.forName(paramString).newInstance();
      paramString.a(this);
      paramString.b(paramString.a(getLayoutInflater()));
      paramString.a();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, Class paramClass, View paramView)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131297297));
    }
    paramClass = new FrameActivity.TabInfo(this, paramClass.getName(), a(paramClass.getName()), paramView);
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramClass);
  }
  
  public String a_()
  {
    Frame localFrame = a();
    if (localFrame != null) {
      return localFrame.a();
    }
    return null;
  }
  
  public void d()
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    Log.i("AutoMonitor", this.m + "TabSwitch, cost=" + l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, this.m + "TabSwitch, cost=" + l);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Frame localFrame = a();
    if (localFrame != null)
    {
      localFrame.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    QLog.d("qqBaseActivity", 4, "FrameActivity:onActivityResult");
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqAppFrame.a(paramConfiguration);
      i += 1;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqAppFrame.e();
      i += 1;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.d();
    }
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    paramBundle = paramBundle.getString("currentTab");
    int i;
    if (paramBundle != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label109;
      }
      if (!((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.endsWith(paramBundle)) {
        break label102;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i);
      if (((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_AndroidViewView != null) {
        ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_AndroidViewView.setSelected(true);
      }
      return;
      label102:
      i += 1;
      break;
      label109:
      i = 0;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    Frame localFrame = a();
    if ((localFrame != null) && (localFrame.a())) {
      localFrame.a(false);
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    String str = ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem())).jdField_a_of_type_JavaLangString;
    if (str != null) {
      paramBundle.putString("currentTab", str);
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    Frame localFrame = a();
    if (localFrame != null)
    {
      localFrame.a(paramBoolean, this);
      return;
    }
    QLog.d("qqBaseActivity", 4, "FrameActivity:onWindowFocusChanged");
  }
  
  public int getPathNodeID()
  {
    Frame localFrame = a();
    if (localFrame != null) {
      return localFrame.a();
    }
    return 0;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131492887);
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    new Handler().post(new csp(this));
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqAppFrame.a(paramLogoutReason);
      i += 1;
    }
  }
  
  public void onTabChanged(String paramString)
  {
    int j;
    int i;
    if (paramString != null)
    {
      if (((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem())).jdField_a_of_type_JavaLangString.equals(paramString))
      {
        a().c();
        return;
      }
      j = this.jdField_a_of_type_JavaUtilList.size();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if (((FrameActivity.TabInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFrame != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppFrame.d();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrame = a();
        if (this.jdField_a_of_type_ComTencentMobileqqAppFrame == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrame.h();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameActivity
 * JD-Core Version:    0.7.0.1
 */