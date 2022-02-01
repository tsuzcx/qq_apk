package com.tencent.qqmail.account.view;

import android.graphics.Bitmap;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.qmnetwork.qmuser.QMVerify;

class LoginVerifyCodeView$1$1
  implements Runnable
{
  LoginVerifyCodeView$1$1(LoginVerifyCodeView.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$bitmap != null)
    {
      DataCollector.logDetailEvent("DetailEvent_LoginVerifyCode", 0L, 0L, "");
      this.this$1.this$0.setVerifyImg(this.val$bitmap);
      return;
    }
    this.this$1.this$0.setVerifyError();
    QMLog.log(5, "LoginVerifyCodeView", "get verify image err:" + this.this$1.val$verify.getVurl());
    DataCollector.logDetailEvent("DetailEvent_LoginVerifyCode", 0L, 1L, "DetailEventError -- 验证码图片为空:email=" + this.this$1.val$qqmailAccount.getEmail() + ":url=" + this.this$1.val$verify.getVurl());
    QMLog.log(6, "LoginVerifyCodeView", "submitlog for verifycode err.");
    QMLogStream.submitLog(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.view.LoginVerifyCodeView.1.1
 * JD-Core Version:    0.7.0.1
 */