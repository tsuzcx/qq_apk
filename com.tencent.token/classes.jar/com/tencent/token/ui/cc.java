package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.af;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.WtloginCaptchaDialog;

final class cc
  extends bo
{
  cc(CommonVerifyActivity paramCommonVerifyActivity)
  {
    super(paramCommonVerifyActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (this.a.isFinishing()) {}
    int i;
    do
    {
      do
      {
        return;
        e.c("CommonVerifyActivity mbinfo: " + paramMessage.what);
        i = paramMessage.arg1;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1019: 
          paramMessage = (byte[])paramMessage.obj;
        }
      } while (paramMessage == null);
      CommonVerifyActivity.access$302(this.a, paramMessage);
      af.a().a(CommonVerifyActivity.access$400(this.a), paramMessage, CommonVerifyActivity.access$500(this.a), 2);
      return;
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        CommonVerifyActivity.access$102(this.a, (UpgradeDeterminResult)paramMessage.obj);
        CommonVerifyActivity.access$200(this.a, CommonVerifyActivity.access$100(this.a));
        return;
      }
      paramMessage = (d)paramMessage.obj;
      e.c("err " + paramMessage.a);
      d.a(this.a.getResources(), paramMessage);
      e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
      return;
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      CommonVerifyActivity.access$302(this.a, arrayOfByte);
      if ((i == 0) && (arrayOfByte != null))
      {
        af.a().a(CommonVerifyActivity.access$400(this.a), arrayOfByte, CommonVerifyActivity.access$500(this.a), 2);
        return;
      }
      if (i != 2) {
        break;
      }
    } while (this.a.isFinishing());
    new WtloginCaptchaDialog(this.a, CommonVerifyActivity.access$500(this.a), Long.toString(CommonVerifyActivity.access$400(this.a))).show();
    return;
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
      this.a.showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new cd(this));
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
      af.a().a(CommonVerifyActivity.access$400(this.a), CommonVerifyActivity.access$300(this.a), CommonVerifyActivity.access$500(this.a));
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
    return;
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1) {}
      for (;;)
      {
        CommonVerifyActivity.access$700(this.a, bool);
        return;
        bool = false;
      }
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cc
 * JD-Core Version:    0.7.0.1
 */