package com.tencent.av.service;

import android.content.Intent;
import android.os.IBinder;
import bih;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class AVServiceForQQ
  extends AppService
{
  private bih jdField_a_of_type_Bih = null;
  public VideoAppInterface a;
  String jdField_a_of_type_JavaLangString = "AVServiceForQQ";
  
  public AVServiceForQQ()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((this.app instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    }
    return this.jdField_a_of_type_Bih;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.jdField_a_of_type_Bih == null) {
      this.jdField_a_of_type_Bih = new bih(this, null);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onStartCommand");
    }
    if ((this.app instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ
 * JD-Core Version:    0.7.0.1
 */