package com.tencent.mobileqq.app;

import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.startup.step.LoadDex;
import com.tencent.mobileqq.startup.step.Rdm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PeakAppInterface
  extends AppInterface
{
  private ProcessExitReceiver jdField_a_of_type_ComTencentMobileqqAppProcessExitReceiver = new ProcessExitReceiver(this);
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  
  public PeakAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
    localIntentFilter.addAction("mqq.i.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.i.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.i.intent.action.ACCOUNT_EXPIRED");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppProcessExitReceiver, localIntentFilter);
  }
  
  public int a()
  {
    return 0;
  }
  
  public EntityManagerFactory a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      QLog.init(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      new LoadDex().b();
      new Rdm().b();
      new InitMemoryCache().b();
      new InitUrlDrawable().b();
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "Application OnCreate complete");
      }
      a();
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("PEAK", 2, "init QLog error " + paramBundle, paramBundle);
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppProcessExitReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PEAK", 2, "unregisterReceiver: ", localIllegalArgumentException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */