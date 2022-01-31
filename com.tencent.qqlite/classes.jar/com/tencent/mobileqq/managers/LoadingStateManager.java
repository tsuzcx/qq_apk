package com.tencent.mobileqq.managers;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class LoadingStateManager
{
  public static final int a = 0;
  private static LoadingStateManager jdField_a_of_type_ComTencentMobileqqManagersLoadingStateManager;
  public static final String a = "LoadingStateManager";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private int f = 1;
  
  private LoadingStateManager()
  {
    if (NetConnInfoCenter.socketConnState == 4) {
      this.f = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoadingStateManager", 2, "LoadingStateManager init loadingstate = " + this.f);
    }
  }
  
  public static LoadingStateManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqManagersLoadingStateManager == null) {
      jdField_a_of_type_ComTencentMobileqqManagersLoadingStateManager = new LoadingStateManager();
    }
    return jdField_a_of_type_ComTencentMobileqqManagersLoadingStateManager;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqManagersLoadingStateManager = null;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, QQAppInterface paramQQAppInterface)
  {
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getAttribute("_tag_socket") == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel())
          {
            QLog.d("LoadingStateManager", 2, "notifyIsNotIllegalNetWork mShowIllegalNetworkBar=" + this.jdField_a_of_type_Boolean);
            QLog.d("LoadingStateManager", 2, "changeConversationLoadingState mShowErrorNetworkBar=" + this.b);
          }
        } while ((!this.jdField_a_of_type_Boolean) && (!this.b));
        if (!this.b) {
          break;
        }
        paramFromServiceMsg = paramQQAppInterface.a(Conversation.class);
      } while (paramFromServiceMsg == null);
      paramFromServiceMsg.obtainMessage(10002, null).sendToTarget();
      return;
      if (!d()) {
        a(0);
      }
      QLog.d("LoadingStateManager", 2, "notifyIsNotIllegalNetWork");
      paramFromServiceMsg = paramQQAppInterface.a(Conversation.class);
    } while (paramFromServiceMsg == null);
    paramFromServiceMsg.obtainMessage(1134012, null).sendToTarget();
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    return (this.f == 1) || (this.f == 2);
  }
  
  public boolean d()
  {
    return this.f == 3;
  }
  
  public boolean e()
  {
    return this.f == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.LoadingStateManager
 * JD-Core Version:    0.7.0.1
 */