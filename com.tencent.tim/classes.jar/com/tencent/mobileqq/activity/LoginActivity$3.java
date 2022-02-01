package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class LoginActivity$3
  implements Runnable
{
  LoginActivity$3(LoginActivity paramLoginActivity, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "-->login success(finish after ls), go to AgentActivity, account:" + this.val$account);
    }
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity.3
 * JD-Core Version:    0.7.0.1
 */