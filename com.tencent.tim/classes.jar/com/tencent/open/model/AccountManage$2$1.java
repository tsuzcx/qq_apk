package com.tencent.open.model;

import android.os.Bundle;
import asaw;
import asax;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.WtloginManager;
import mqq.os.MqqHandler;

public class AccountManage$2$1
  implements Runnable
{
  public AccountManage$2$1(asax paramasax, String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    Manager localManager = asaw.a(this.a.this$0).getManager(1);
    if (localManager != null)
    {
      long l = System.currentTimeMillis();
      ((WtloginManager)localManager).RefreshMemorySig();
      QLog.d("open_log", 1, new Object[] { "refreshMemorySig cost : ", Long.valueOf(System.currentTimeMillis() - l) });
    }
    ThreadManager.getUIHandler().post(new AccountManage.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.model.AccountManage.2.1
 * JD-Core Version:    0.7.0.1
 */