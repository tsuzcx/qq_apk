package com.tencent.mobileqq.equipmentlock;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ftt;
import ftu;
import mqq.observer.WtloginObserver;

public class EquipLockWebImpl
{
  public static final int a = 1;
  private static EquipLockWebImpl jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl = null;
  public static final String a = "uin";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final int b = 2;
  public static final String b = "mobileMask";
  public static final int c = 3;
  public static final String c = "state";
  public static final String d = "sppkey";
  public static final String e = "isBack";
  public static final String f = "isWaiting";
  public static final String g = "setMobileResult";
  public static final String h = "checkDevLockSms_ret";
  private static final String i = "EquipLockWebImpl";
  private Messenger jdField_a_of_type_AndroidOsMessenger = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ftt(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new ftu(this);
  
  public static EquipLockWebImpl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl == null) {
        jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl = new EquipLockWebImpl();
      }
      return jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl;
    }
  }
  
  private void a(int paramInt)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("checkDevLockSms_ret", paramInt);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "openEquipmentLock");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidOsMessenger != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 4);
      localMessage.setData(paramBundle);
      this.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
      if (QLog.isColorLevel()) {
        QLog.i("EquipLockWebImpl", 2, "resp to sever: ");
      }
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("isWaiting", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "setWaitingResponse");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  private void b(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("setMobileResult", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "setMobileResult");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  private void c(boolean paramBoolean)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putBoolean("isBack", paramBoolean);
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("cmd", "closeWeb");
    localBundle2.putInt("respkey", -1);
    localBundle2.putBundle("response", localBundle1);
    a(localBundle2);
  }
  
  public void a()
  {
    if (BaseActivity.a != null) {
      BaseActivity.a.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipLockWebImpl = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Messenger paramMessenger)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsMessenger = paramMessenger;
    if (BaseActivity.a != null) {
      BaseActivity.a.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, paramArrayOfByte, this.jdField_a_of_type_MqqObserverWtloginObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipLockWebImpl
 * JD-Core Version:    0.7.0.1
 */