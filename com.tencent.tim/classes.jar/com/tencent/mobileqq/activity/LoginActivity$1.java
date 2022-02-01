package com.tencent.mobileqq.activity;

import aajt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

final class LoginActivity$1
  implements Runnable
{
  LoginActivity$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.val$app.QE = NetConnInfoCenter.getServerTime();
    aajt.a().a(this.val$app, BaseApplicationImpl.sApplication, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity.1
 * JD-Core Version:    0.7.0.1
 */