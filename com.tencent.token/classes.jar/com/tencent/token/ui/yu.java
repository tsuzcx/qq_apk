package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.WtloginCaptchaDialog;

final class yu
  extends bo
{
  yu(ScanLoginBindActivity paramScanLoginBindActivity)
  {
    super(paramScanLoginBindActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    QQUser localQQUser;
    int i;
    do
    {
      do
      {
        return;
        localQQUser = ax.a().e();
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
    af.a().a(localQQUser.mRealUin, paramMessage, this.a.mHandler, 2);
    return;
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (UpgradeDeterminResult)paramMessage.obj;
      ScanLoginBindActivity.access$100(this.a, paramMessage);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    e.c("err " + paramMessage.a);
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
    return;
    byte[] arrayOfByte = (byte[])paramMessage.obj;
    ScanLoginBindActivity.access$202(this.a, arrayOfByte);
    if ((i == 0) && (arrayOfByte != null))
    {
      af.a().a(localQQUser.mRealUin, arrayOfByte, this.a.mHandler, 2);
      return;
    }
    if (i == 2)
    {
      new WtloginCaptchaDialog(this.a, this.a.mHandler, Long.toString(localQQUser.mRealUin)).show();
      return;
    }
    if (i == -1000)
    {
      this.a.dismissDialog();
      this.a.showToast(2131361943);
      return;
    }
    if (i == 8192)
    {
      this.a.dismissDialog();
      this.a.showToast(2131362089);
      return;
    }
    if ((i == 1) || (i == 15) || (i == 16))
    {
      this.a.dismissDialog();
      this.a.showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new yv(this));
      return;
    }
    this.a.dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
    {
      this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("loginerror"));
      return;
    }
    this.a.showToast(2131362091);
    return;
    if (i == 0)
    {
      af.a().a(localQQUser.mRealUin, ScanLoginBindActivity.access$200(this.a), this.a.mHandler);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    e.c("err " + paramMessage.a);
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showToast(paramMessage.c);
    return;
    this.a.dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
      return;
    }
    this.a.showToast(2131362091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yu
 * JD-Core Version:    0.7.0.1
 */