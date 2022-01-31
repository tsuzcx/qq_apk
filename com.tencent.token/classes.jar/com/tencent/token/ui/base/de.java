package com.tencent.token.ui.base;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.cw;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.BaseActivity;

class de
  extends Handler
{
  de(dd paramdd) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((dd.a(this.a) == null) || (dd.a(this.a).isFinishing())) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramMessage.arg1;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1019: 
          paramMessage = (byte[])paramMessage.obj;
        }
      } while (paramMessage == null);
      dd.a(this.a, paramMessage);
      cw.a().a(dd.b(this.a), paramMessage, this.a.a, dd.c(this.a));
      return;
      dd.a(this.a).dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        postDelayed(new df(this, (DeterminVerifyFactorsResult)paramMessage.obj), 10L);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      dd.a(this.a).showUserDialog(2131230843, paramMessage.c, 2131230897, null);
      return;
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      dd.a(this.a, arrayOfByte);
      if ((i == 0) && (arrayOfByte != null))
      {
        cw.a().a(dd.b(this.a), arrayOfByte, this.a.a, dd.c(this.a));
        return;
      }
      if (i != 2) {
        break;
      }
    } while (dd.a(this.a).isFinishing());
    new WtloginCaptchaDialog(dd.a(this.a), 2131362182, this.a.a, Long.toString(dd.b(this.a))).show();
    return;
    if (i == -1000)
    {
      dd.a(this.a).dismissDialog();
      dd.a(this.a).showToast(2131230960);
      return;
    }
    if (i == 8192)
    {
      dd.a(this.a).dismissDialog();
      dd.a(this.a).showToast(2131231407);
      return;
    }
    if ((i == 1) || (i == 15) || (i == 16))
    {
      dd.a(this.a).dismissDialog();
      dd.a(this.a).showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new dg(this));
      return;
    }
    if ((i == 40) || (i == 42) || (i == 64))
    {
      dd.a(this.a).dismissDialog();
      dd.a(this.a).goToRemoveProtectH5(dd.a(this.a), paramMessage, i);
      return;
    }
    dd.a(this.a).dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
    {
      dd.a(this.a).showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("loginerror"));
      return;
    }
    dd.a(this.a).showToast(2131231411);
    return;
    if (i == 0)
    {
      cw.a().a(dd.b(this.a), dd.e(this.a), this.a.a, dd.c(this.a), 1);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    dd.a(this.a).showToast(paramMessage.c);
    return;
    dd.a(this.a).dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      dd.a(this.a).showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
      return;
    }
    dd.a(this.a).showToast(2131231411);
    return;
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1) {}
      for (;;)
      {
        dd.a(this.a, bool1);
        return;
        bool1 = false;
      }
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    dd.a(this.a).showUserDialog(2131230779, paramMessage.c, 2131230897, null);
    return;
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        dd.a(this.a, bool1);
        return;
      }
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    dd.a(this.a).showUserDialog(2131230779, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.de
 * JD-Core Version:    0.7.0.1
 */