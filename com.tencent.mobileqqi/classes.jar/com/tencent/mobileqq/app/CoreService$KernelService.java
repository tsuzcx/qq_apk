package com.tencent.mobileqq.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

public class CoreService$KernelService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    try
    {
      stopForeground(true);
      label5:
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "KernelService.onCreate");
      }
      super.onCreate();
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "KernelService.stopForegroundCompat: " + Build.VERSION.SDK_INT);
      }
      return;
    }
    catch (Exception localException)
    {
      break label5;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "KernelService.stopForegroundCompat: " + Build.VERSION.SDK_INT);
    }
    try
    {
      stopForeground(true);
      label38:
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "KernelService.onDestroy");
      }
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("NotificationID", 0) > 0) && (CoreService.jdField_a_of_type_ComTencentMobileqqAppCoreService != null)) {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "KernelService.startForegroundCompat: " + Build.VERSION.SDK_INT);
      }
    }
    try
    {
      CoreService.jdField_a_of_type_ComTencentMobileqqAppCoreService.startForeground(4587, new Notification());
      CoreService.jdField_a_of_type_ComTencentMobileqqAppCoreService.jdField_a_of_type_Boolean = true;
      startForeground(4587, new Notification());
      CoreService.jdField_a_of_type_ComTencentMobileqqAppCoreService.stopForeground(true);
      return 2;
    }
    catch (Exception paramIntent) {}
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CoreService.KernelService
 * JD-Core Version:    0.7.0.1
 */