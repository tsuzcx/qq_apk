package com.tencent.token.ui.base;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.af;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.BaseActivity;

final class dl
  extends Handler
{
  dl(dk paramdk) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((dk.a(this.a) == null) || (dk.a(this.a).isFinishing())) {}
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
      dk.a(this.a, paramMessage);
      af.a().a(dk.c(this.a), paramMessage, this.a.a, 2);
      return;
      dk.a(this.a).dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        dk.a(this.a, (UpgradeDeterminResult)paramMessage.obj);
        dk.b(this.a, dk.b(this.a));
        return;
      }
      paramMessage = (d)paramMessage.obj;
      e.c("err " + paramMessage.a);
      d.a(this.a.getResources(), paramMessage);
      e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      dk.a(this.a).showUserDialog(2131361831, paramMessage.c, 2131361800, null);
      return;
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      dk.a(this.a, arrayOfByte);
      if ((i == 0) && (arrayOfByte != null))
      {
        af.a().a(dk.c(this.a), arrayOfByte, this.a.a, 2);
        return;
      }
      if (i != 2) {
        break;
      }
    } while (dk.a(this.a).isFinishing());
    new WtloginCaptchaDialog(dk.a(this.a), this.a.a, Long.toString(dk.c(this.a))).show();
    return;
    if (i == -1000)
    {
      dk.a(this.a).dismissDialog();
      dk.a(this.a).showToast(2131361943);
      return;
    }
    if (i == 8192)
    {
      dk.a(this.a).dismissDialog();
      dk.a(this.a).showToast(2131362089);
      return;
    }
    if ((i == 1) || (i == 15) || (i == 16))
    {
      dk.a(this.a).dismissDialog();
      dk.a(this.a).showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new dm(this));
      return;
    }
    dk.a(this.a).dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
    {
      dk.a(this.a).showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("loginerror"));
      return;
    }
    dk.a(this.a).showToast(2131362091);
    return;
    if (i == 0)
    {
      af.a().a(dk.c(this.a), dk.e(this.a), this.a.a);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    e.c("err " + paramMessage.a);
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    dk.a(this.a).showToast(paramMessage.c);
    return;
    dk.a(this.a).dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      dk.a(this.a).showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
      return;
    }
    dk.a(this.a).showToast(2131362091);
    return;
    if (paramMessage.arg1 == 0)
    {
      dk.f(this.a);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    dk.a(this.a).showUserDialog(2131361831, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dl
 * JD-Core Version:    0.7.0.1
 */