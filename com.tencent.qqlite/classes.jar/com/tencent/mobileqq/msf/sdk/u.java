package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.remote.IBaseService.Stub;
import com.tencent.qphone.base.util.QLog;

class u
  implements ServiceConnection
{
  u(t paramt) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.RemoteServiceProxy", 2, "threadID:" + Thread.currentThread().getId() + " onServiceConnected service:" + paramComponentName);
    }
    this.a.d = IBaseService.Stub.asInterface(paramIBinder);
    this.a.d();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.RemoteServiceProxy", 2, " onServiceDisconnected " + paramComponentName);
    }
    this.a.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.u
 * JD-Core Version:    0.7.0.1
 */