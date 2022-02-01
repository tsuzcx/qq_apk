package com.tencent.mobileqq.ar;

import adas;
import adat;
import adgl.a;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class ARGlobalConfigService
  extends AppService
{
  public adas a;
  private adgl.a a;
  QQAppInterface mApp = null;
  
  public ARGlobalConfigService()
  {
    this.jdField_a_of_type_Adgl$a = new adat(this);
  }
  
  public void onAccountChanged()
  {
    this.mApp = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
    this.jdField_a_of_type_Adas = ((adas)this.mApp.getManager(220));
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onAccountChanged");
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onBind");
    }
    return this.jdField_a_of_type_Adgl$a;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)this.app);
      this.jdField_a_of_type_Adas = ((adas)this.mApp.getManager(220));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onDestroy");
    }
    super.onDestroy();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalConfigService", 2, "onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGlobalConfigService
 * JD-Core Version:    0.7.0.1
 */