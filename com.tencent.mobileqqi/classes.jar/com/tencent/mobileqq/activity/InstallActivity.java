package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.SetSplash;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class InstallActivity
  extends AppActivity
  implements Runnable
{
  private SplashActivityCore jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore = null;
  boolean jdField_a_of_type_Boolean = false;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore = new SplashActivityCore(this);
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore = null;
    }
    try
    {
      setContentView(new LinearLayout(this));
      label35:
      this.mRuntime = null;
      return;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore.onResume();
  }
  
  protected void onResume()
  {
    super.onResume();
    BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler.post(this);
  }
  
  public boolean preloadData(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)) && (paramAppRuntime.isLogin()))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      return RecentDataListManager.a().a(paramAppRuntime, BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramBoolean);
    }
    return false;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources();
    SetSplash.a(this);
  }
  
  public boolean showPreview()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InstallActivity
 * JD-Core Version:    0.7.0.1
 */