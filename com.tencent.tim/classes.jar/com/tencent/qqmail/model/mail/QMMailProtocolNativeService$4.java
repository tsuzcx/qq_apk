package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.util.LoginUtility;
import com.tencent.moai.mailsdk.util.SPUtility;
import com.tencent.qqmail.model.mail.callback.LoginCallback;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import moai.oss.KvHelper;

class QMMailProtocolNativeService$4
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$4(QMMailProtocolNativeService paramQMMailProtocolNativeService, Profile paramProfile, LoginCallback paramLoginCallback) {}
  
  public void onLogin(ProtocolResult paramProtocolResult)
  {
    if (paramProtocolResult.error_code_ == 0) {
      if (this.val$profile.needVerifySend)
      {
        QMMailProtocolNativeService.access$000(this.this$0, this.val$profile, "verify_login", true, 0, "");
        SPUtility.removeSmtpLoginError(this.val$profile.mailAddress);
      }
    }
    for (;;)
    {
      if (this.val$callback != null) {
        this.val$callback.onSuccess(paramProtocolResult.protocol_info_list_);
      }
      return;
      QMMailProtocolNativeService.access$000(this.this$0, this.val$profile, "Login", true, 0, "");
      KvHelper.reportInOsslog(new double[0]);
      continue;
      if (this.val$callback != null) {
        this.val$callback.onError(paramProtocolResult.error_code_, paramProtocolResult.detail_code_, paramProtocolResult.result_);
      }
      if (this.val$profile.needVerifySend)
      {
        QMMailProtocolNativeService.access$000(this.this$0, this.val$profile, "verify_login", false, LoginUtility.getProtocolLoginError(paramProtocolResult.result_), paramProtocolResult.result_);
        SPUtility.setSmtpLoginError(this.val$profile.mailAddress);
      }
      else
      {
        QMMailProtocolNativeService.access$000(this.this$0, this.val$profile, "Login", false, LoginUtility.getProtocolLoginError(paramProtocolResult.result_), paramProtocolResult.result_);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.4
 * JD-Core Version:    0.7.0.1
 */