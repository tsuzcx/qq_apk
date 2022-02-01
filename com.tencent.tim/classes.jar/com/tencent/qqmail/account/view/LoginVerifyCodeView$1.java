package com.tencent.qqmail.account.view;

import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.qmuser.QMVerify;
import com.tencent.qqmail.utilities.thread.Threads;

class LoginVerifyCodeView$1
  implements Runnable
{
  LoginVerifyCodeView$1(LoginVerifyCodeView paramLoginVerifyCodeView, QMVerify paramQMVerify, QQMailAccount paramQQMailAccount) {}
  
  public void run()
  {
    try
    {
      Threads.runOnMainThread(new LoginVerifyCodeView.1.1(this, ImageUtil.imageWithURL(this.val$verify.getVurl() + ".gif")));
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "LoginVerifyCodeView", "addacc. get verify img err : " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.view.LoginVerifyCodeView.1
 * JD-Core Version:    0.7.0.1
 */