package com.tencent.av.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class UtilsServiceForAV
  extends AppService
{
  static final int jdField_a_of_type_Int = 32;
  static final String jdField_a_of_type_JavaLangString = "UtilsServiceForAV";
  final IBinder jdField_a_of_type_AndroidOsIBinder = new UtilsServiceForAV.LocalBinder(this);
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "toggleProximityWakeLock turnOn = " + paramBoolean);
    }
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((this.app instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    }
    return this.jdField_a_of_type_AndroidOsIBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "onCreate");
    }
    PowerManager localPowerManager = (PowerManager)getSystemService("power");
    try
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = localPowerManager.newWakeLock(32, "QQLitePower");
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
      {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.setReferenceCounted(false);
        a(true);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("UtilsServiceForAV", 2, "Exception", localException);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
      a(false);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UtilsServiceForAV", 2, "onStartCommand");
    }
    if ((this.app instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.service.UtilsServiceForAV
 * JD-Core Version:    0.7.0.1
 */