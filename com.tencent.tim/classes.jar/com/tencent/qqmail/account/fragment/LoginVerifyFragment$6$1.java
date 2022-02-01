package com.tencent.qqmail.account.fragment;

import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.QMTopBar;
import oicq.wlogin_sdk.tools.ErrMsg;

class LoginVerifyFragment$6$1
  implements Runnable
{
  LoginVerifyFragment$6$1(LoginVerifyFragment.6 param6, int paramInt, ErrMsg paramErrMsg) {}
  
  public void run()
  {
    if (this.val$ret == 0)
    {
      if (this.this$1.this$0.isAttachedToActivity())
      {
        QMLog.log(4, "LoginVerifyFragment", "onVerifyClose backToLoginAccountFragment");
        this.this$1.this$0.backToLoginAccountFragment();
      }
      return;
    }
    QMTips localQMTips = this.this$1.this$0.getTips();
    if ((this.val$errMsg != null) && (!TextUtils.isEmpty(this.val$errMsg.getMessage()))) {}
    for (String str = this.val$errMsg.getMessage();; str = this.this$1.this$0.getString(2131689623))
    {
      localQMTips.showError(str);
      LoginVerifyFragment.access$200(this.this$1.this$0).setText("");
      LoginVerifyFragment.access$300(this.this$1.this$0).showLoading(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginVerifyFragment.6.1
 * JD-Core Version:    0.7.0.1
 */