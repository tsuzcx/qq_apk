package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.qphone.base.util.QLog;
import fce;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.Constants.LogoutReason;

public class FrameActivity
  extends BaseActivity
  implements OnDrawCompleteListener
{
  long jdField_a_of_type_Long = -1L;
  public ViewPager a;
  private Frame jdField_a_of_type_ComTencentMobileqqAppFrame;
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap(3);
  String k = null;
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
  }
  
  public Frame a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      return (Frame)this.jdField_a_of_type_JavaUtilMap.get(a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem()));
    }
    return null;
  }
  
  public Frame a(Class paramClass)
  {
    Frame localFrame = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localFrame = (Frame)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
    }
    return localFrame;
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("FrameActivity", 2, "Error branch to get frame class name");
      }
      return "";
    case 0: 
      return Conversation.class.getName();
    case 1: 
      return Contacts.class.getName();
    }
    return Leba.class.getName();
  }
  
  protected String a_()
  {
    Frame localFrame = a();
    if (localFrame != null) {
      return localFrame.a();
    }
    return null;
  }
  
  public int d()
  {
    return getResources().getDimensionPixelSize(2131427376);
  }
  
  public void d()
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    Log.i("AutoMonitor", this.k + "TabSwitch, cost=" + l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, this.k + "TabSwitch, cost=" + l);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).a(paramConfiguration);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).e();
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
    int i = paramBundle.getInt("currentTab");
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i);
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
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {}
    for (int i = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();; i = 0)
    {
      paramBundle.putInt("currentTab", i);
      return;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 3) {
      return;
    }
    LayoutInflater localLayoutInflater = LayoutInflater.from(this);
    Object localObject = new Conversation();
    this.jdField_a_of_type_JavaUtilMap.put(Conversation.class.getName(), localObject);
    ((Frame)localObject).a(this);
    ((Frame)localObject).a(((Frame)localObject).a(localLayoutInflater));
    ((Frame)localObject).a();
    localObject = new Contacts();
    this.jdField_a_of_type_JavaUtilMap.put(Contacts.class.getName(), localObject);
    ((Frame)localObject).a(this);
    ((Frame)localObject).a(((Frame)localObject).a(localLayoutInflater));
    ((Frame)localObject).a();
    localObject = new Leba();
    this.jdField_a_of_type_JavaUtilMap.put(Leba.class.getName(), localObject);
    ((Frame)localObject).a(this);
    ((Frame)localObject).a(((Frame)localObject).a(localLayoutInflater));
    ((Frame)localObject).a();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrame = a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.a(true);
    }
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    Collection localCollection = this.jdField_a_of_type_JavaUtilMap.values();
    new Handler().post(new fce(this, localCollection));
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).a(paramLogoutReason);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameActivity
 * JD-Core Version:    0.7.0.1
 */