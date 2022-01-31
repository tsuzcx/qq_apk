package com.tencent.av.service;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import bio;
import com.tencent.qphone.base.util.QLog;

public class QavWrapper
{
  public static final String a = "QavWrapper";
  Context jdField_a_of_type_AndroidContentContext = null;
  bio jdField_a_of_type_Bio = new bio(this);
  public IAVServiceForQQ a;
  public QavWrapper.OnReadyListener a;
  
  public QavWrapper(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
    this.jdField_a_of_type_ComTencentAvServiceQavWrapper$OnReadyListener = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public IAVServiceForQQ a()
  {
    return this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvServiceQavWrapper$OnReadyListener = null;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null)
    {
      Intent localIntent = new Intent(paramContext, AVServiceForQQ.class);
      boolean bool = paramContext.getApplicationContext().bindService(localIntent, this.jdField_a_of_type_Bio, 1);
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "bindService result == " + bool);
      }
    }
  }
  
  public void a(QavWrapper.OnReadyListener paramOnReadyListener)
  {
    this.jdField_a_of_type_ComTencentAvServiceQavWrapper$OnReadyListener = paramOnReadyListener;
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void b(Context paramContext)
  {
    paramContext.getApplicationContext().unbindService(this.jdField_a_of_type_Bio);
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.b(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.service.QavWrapper
 * JD-Core Version:    0.7.0.1
 */