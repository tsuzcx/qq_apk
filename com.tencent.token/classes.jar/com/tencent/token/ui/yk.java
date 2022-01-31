package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.WtloginCaptchaDialog;

class yk
  extends cb
{
  yk(ScanLoginBindActivity paramScanLoginBindActivity)
  {
    super(paramScanLoginBindActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    QQUser localQQUser;
    int i;
    do
    {
      do
      {
        return;
        localQQUser = do.a().e();
      } while (localQQUser == null);
      i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1019: 
        paramMessage = (byte[])paramMessage.obj;
      }
    } while (paramMessage == null);
    ScanLoginBindActivity.access$202(this.a, paramMessage);
    cw.a().a(localQQUser.mRealUin, paramMessage, this.a.mHandler, ScanLoginBindActivity.access$000(this.a));
    return;
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      postDelayed(new yl(this, (DeterminVerifyFactorsResult)paramMessage.obj), 10L);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
    return;
    byte[] arrayOfByte = (byte[])paramMessage.obj;
    ScanLoginBindActivity.access$202(this.a, arrayOfByte);
    if ((i == 0) && (arrayOfByte != null))
    {
      cw.a().a(localQQUser.mRealUin, arrayOfByte, this.a.mHandler, ScanLoginBindActivity.access$000(this.a));
      return;
    }
    if (i == 2)
    {
      new WtloginCaptchaDialog(this.a, 2131362182, this.a.mHandler, Long.toString(localQQUser.mRealUin)).show();
      return;
    }
    if (i == -1000)
    {
      this.a.dismissDialog();
      this.a.showToast(2131230960);
      return;
    }
    if (i == 8192)
    {
      this.a.dismissDialog();
      this.a.showToast(2131231407);
      return;
    }
    if ((i == 1) || (i == 15) || (i == 16))
    {
      this.a.dismissDialog();
      this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new ym(this));
      return;
    }
    if ((i == 40) || (i == 42) || (i == 64))
    {
      this.a.dismissDialog();
      this.a.goToRemoveProtectH5(this.a, paramMessage, i);
      return;
    }
    this.a.dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
    {
      this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("loginerror"));
      return;
    }
    this.a.showToast(2131231411);
    return;
    if (i == 0)
    {
      cw.a().a(localQQUser.mRealUin, ScanLoginBindActivity.access$200(this.a), this.a.mHandler, ScanLoginBindActivity.access$000(this.a), 1);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showToast(paramMessage.c);
    return;
    this.a.dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
      return;
    }
    this.a.showToast(2131231411);
    return;
    ScanLoginBindActivity.access$300(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yk
 * JD-Core Version:    0.7.0.1
 */