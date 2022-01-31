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

final class bi
  extends Handler
{
  bi(bh parambh) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((bh.a(this.a) == null) || (bh.a(this.a).isFinishing())) {}
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
      bh.a(this.a, paramMessage);
      af.a().a(bh.c(this.a), paramMessage, this.a.a, 2);
      return;
      bh.a(this.a).dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        bh.a(this.a, (UpgradeDeterminResult)paramMessage.obj);
        bh.b(this.a, bh.b(this.a));
        return;
      }
      paramMessage = (d)paramMessage.obj;
      e.c("err " + paramMessage.a);
      d.a(this.a.getResources(), paramMessage);
      e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      bh.a(this.a).showUserDialog(2131361831, paramMessage.c, 2131361800, null);
      return;
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      bh.a(this.a, arrayOfByte);
      if ((i == 0) && (arrayOfByte != null))
      {
        af.a().a(bh.c(this.a), arrayOfByte, this.a.a, 2);
        return;
      }
      if (i != 2) {
        break;
      }
    } while (bh.a(this.a).isFinishing());
    new WtloginCaptchaDialog(bh.a(this.a), this.a.a, Long.toString(bh.c(this.a))).show();
    return;
    if (i == -1000)
    {
      bh.a(this.a).dismissDialog();
      bh.a(this.a).showToast(2131361943);
      return;
    }
    if (i == 8192)
    {
      bh.a(this.a).dismissDialog();
      bh.a(this.a).showToast(2131362089);
      return;
    }
    if ((i == 1) || (i == 15) || (i == 16))
    {
      bh.a(this.a).dismissDialog();
      bh.a(this.a).showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new bj(this));
      return;
    }
    bh.a(this.a).dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
    {
      bh.a(this.a).showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("loginerror"));
      return;
    }
    bh.a(this.a).showToast(2131362091);
    return;
    if (i == 0)
    {
      af.a().a(bh.c(this.a), bh.e(this.a), this.a.a);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    e.c("err " + paramMessage.a);
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    bh.a(this.a).showToast(paramMessage.c);
    return;
    bh.a(this.a).dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      bh.a(this.a).showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
      return;
    }
    bh.a(this.a).showToast(2131362091);
    return;
    bh.a(this.a).dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      bh.f(this.a);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    bh.a(this.a).showUserDialog(2131361831, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bi
 * JD-Core Version:    0.7.0.1
 */