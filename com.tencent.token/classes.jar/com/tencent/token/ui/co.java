package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.cw;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.WtloginCaptchaDialog;

class co
  extends cb
{
  co(CommonVerifyActivity paramCommonVerifyActivity)
  {
    super(paramCommonVerifyActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.a.isFinishing()) {}
    int i;
    do
    {
      do
      {
        return;
        h.c("CommonVerifyActivity mbinfo: " + paramMessage.what);
        i = paramMessage.arg1;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1019: 
          paramMessage = (byte[])paramMessage.obj;
        }
      } while (paramMessage == null);
      CommonVerifyActivity.access$202(this.a, paramMessage);
      cw.a().a(CommonVerifyActivity.access$300(this.a), paramMessage, CommonVerifyActivity.access$100(this.a), CommonVerifyActivity.access$400(this.a));
      return;
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        postDelayed(new cp(this, (DeterminVerifyFactorsResult)paramMessage.obj), 10L);
        return;
      }
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
      return;
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      CommonVerifyActivity.access$202(this.a, arrayOfByte);
      if ((i == 0) && (arrayOfByte != null))
      {
        cw.a().a(CommonVerifyActivity.access$300(this.a), arrayOfByte, CommonVerifyActivity.access$100(this.a), CommonVerifyActivity.access$400(this.a));
        return;
      }
      if (i != 2) {
        break;
      }
    } while (this.a.isFinishing());
    new WtloginCaptchaDialog(this.a, 2131362182, CommonVerifyActivity.access$100(this.a), Long.toString(CommonVerifyActivity.access$300(this.a))).show();
    return;
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
      this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new cq(this));
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
      cw.a().a(CommonVerifyActivity.access$300(this.a), CommonVerifyActivity.access$200(this.a), CommonVerifyActivity.access$100(this.a), CommonVerifyActivity.access$400(this.a), 1);
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
    CommonVerifyActivity.access$600(this.a);
    return;
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1) {}
      for (;;)
      {
        CommonVerifyActivity.access$700(this.a, bool1);
        return;
        bool1 = false;
      }
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
    return;
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        CommonVerifyActivity.access$700(this.a, bool1);
        return;
      }
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.co
 * JD-Core Version:    0.7.0.1
 */