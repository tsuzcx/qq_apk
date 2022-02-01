package com.tencent.qqmail.account.fragment;

import android.text.TextUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class LoginVerifyFragment$6
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  LoginVerifyFragment$6(LoginVerifyFragment paramLoginVerifyFragment) {}
  
  private void onRecvCheckSMSResult(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    QMLog.log(4, "LoginVerifyFragment", String.format("onRecvCheckSMSResult seq[%d], uin[%s], ret[%d], err[%s], info[%s]", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), paramErrMsg, paramDevlockInfo }));
    if (paramInt2 == 0)
    {
      setSeq(paramInt1);
      return;
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      this.this$0.getTips().showError(paramErrMsg.getMessage());
      return;
    }
    this.this$0.getTips().showError(2131689624);
  }
  
  private void onRecvVerifyCode(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    QMLog.log(4, "LoginVerifyFragment", String.format("onRecvVerifyCode seq[%d], uin[%s], ret[%d], err[%s], info[%s]", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), paramErrMsg, paramDevlockInfo }));
    if (paramInt2 == 0)
    {
      setSeq(paramInt1);
      return;
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      this.this$0.getTips().showError(paramErrMsg.getMessage());
      return;
    }
    this.this$0.getTips().showError(2131689624);
  }
  
  public void onRecvNotice(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    QMLog.log(4, "LoginVerifyFragment", String.format("onRecvVerifyCode type[%s], seq[%d], uin[%s], ret[%d], err[%s], info[%s]", new Object[] { paramNotifyType, Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), paramErrMsg, paramDevlockInfo }));
    if (paramNotifyType == VerifyDevLockManager.NotifyType.NOTIFY_REFRESH_SMS_RESULT)
    {
      onRecvVerifyCode(paramInt1, paramString, paramInt2, paramErrMsg, paramDevlockInfo);
      return;
    }
    onRecvCheckSMSResult(paramInt1, paramString, paramInt2, paramErrMsg, paramDevlockInfo);
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    QMLog.log(4, "LoginVerifyFragment", String.format("onVerifyClose seq[%d], uin[%s], ret[%d], err[%s]", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), paramErrMsg }));
    Threads.runOnMainThread(new LoginVerifyFragment.6.1(this, paramInt2, paramErrMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginVerifyFragment.6
 * JD-Core Version:    0.7.0.1
 */