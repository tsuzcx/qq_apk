package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import com.tencent.token.global.e;
import com.tencent.token.ui.acn;
import com.tencent.token.x;

final class dx
  extends Handler
{
  dx(WtloginCaptchaDialog paramWtloginCaptchaDialog) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((WtloginCaptchaDialog.a(this.a) == null) || (WtloginCaptchaDialog.a(this.a).isFinishing()) || (WtloginCaptchaDialog.a() == null)) {
      return;
    }
    ((acn)WtloginCaptchaDialog.a(this.a)).dismissDialog();
    e.c("wtlogin : ret=" + paramMessage.arg1 + ", what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    case 4101: 
    case 4102: 
    case 4103: 
    default: 
      return;
    case 4099: 
      int i = paramMessage.arg1;
      if (i == 0)
      {
        Message localMessage = WtloginCaptchaDialog.a().obtainMessage(1019);
        localMessage.obj = paramMessage.obj;
        WtloginCaptchaDialog.a().sendMessage(localMessage);
        this.a.dismiss();
        return;
      }
      if (i == -1000)
      {
        this.a.a(2131361943);
        return;
      }
      if (i == 8192)
      {
        this.a.a(2131362089);
        return;
      }
      if (i == 2)
      {
        this.a.a(2131362088);
        this.a.a.b(WtloginCaptchaDialog.b(this.a), this.a.b);
        WtloginCaptchaDialog.c(this.a).setVisibility(0);
        WtloginCaptchaDialog.d(this.a).setText("");
        return;
      }
      if (i == 1)
      {
        this.a.a(2131362066);
        this.a.dismiss();
        return;
      }
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
      {
        this.a.a(WtloginCaptchaDialog.a(this.a).getResources().getString(2131362091) + ":" + paramMessage.getData().getString("loginerror"));
        return;
      }
      this.a.a(2131362091);
      return;
    case 4100: 
      e.b("K_MSGCODE_REFRESH_PICTURE ret=" + paramMessage.arg1);
      WtloginCaptchaDialog.e(this.a);
      return;
    }
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      this.a.a(WtloginCaptchaDialog.a(this.a).getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
      return;
    }
    this.a.a(2131362091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dx
 * JD-Core Version:    0.7.0.1
 */