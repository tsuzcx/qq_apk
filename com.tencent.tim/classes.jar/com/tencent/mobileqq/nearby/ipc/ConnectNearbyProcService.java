package com.tencent.mobileqq.nearby.ipc;

import ajqp;
import ajvb;
import ajvc;
import ajvi;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class ConnectNearbyProcService
  extends AppService
{
  private static ajvi jdField_a_of_type_Ajvi;
  private static Object mLock = new Object();
  private ajqp jdField_a_of_type_Ajqp;
  private ajvc jdField_a_of_type_Ajvc = new ajvb(this);
  
  private Message a(Message paramMessage)
  {
    if (this.jdField_a_of_type_Ajqp != null) {
      return this.jdField_a_of_type_Ajqp.a(this, paramMessage);
    }
    return null;
  }
  
  public static Object[] a(int paramInt)
  {
    return a(paramInt, new Object[0]);
  }
  
  public static Object[] a(int paramInt, Object... paramVarArgs)
  {
    if (jdField_a_of_type_Ajvi == null) {
      return null;
    }
    try
    {
      synchronized (mLock)
      {
        if (jdField_a_of_type_Ajvi == null) {
          return null;
        }
      }
      paramVarArgs = jdField_a_of_type_Ajvi.b(new BasicTypeDataParcel(paramInt, paramVarArgs));
    }
    catch (RemoteException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      return null;
    }
    if (paramVarArgs == null) {
      return null;
    }
    paramVarArgs = paramVarArgs.s;
    return paramVarArgs;
  }
  
  public static boolean arA()
  {
    for (;;)
    {
      synchronized (mLock)
      {
        if (jdField_a_of_type_Ajvi != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static Message b(Message paramMessage)
  {
    if ((jdField_a_of_type_Ajvi == null) || (paramMessage == null)) {
      return null;
    }
    try
    {
      synchronized (mLock)
      {
        if (jdField_a_of_type_Ajvi == null) {
          return null;
        }
      }
      paramMessage = jdField_a_of_type_Ajvi.d(paramMessage);
    }
    catch (RemoteException paramMessage)
    {
      paramMessage.printStackTrace();
      return null;
    }
    return paramMessage;
  }
  
  private Object[] b(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_Ajqp != null) {
      return this.jdField_a_of_type_Ajqp.a(this, paramInt, paramVarArgs);
    }
    return null;
  }
  
  private void initData()
  {
    if ((this.app == null) || (!(this.app instanceof QQAppInterface))) {
      throw new IllegalArgumentException("not QQAppInterface. wrong.");
    }
    this.jdField_a_of_type_Ajqp = ((QQAppInterface)this.app).a();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    initData();
    return this.jdField_a_of_type_Ajvc.asBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    synchronized (mLock)
    {
      jdField_a_of_type_Ajvi = null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "ConnectNearbyProcService onUnbind.");
      }
      this.jdField_a_of_type_Ajqp = null;
      return super.onUnbind(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService
 * JD-Core Version:    0.7.0.1
 */