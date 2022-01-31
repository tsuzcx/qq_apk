package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import com.tencent.token.cp;
import com.tencent.token.global.h;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.aax;

class do
  extends Handler
{
  do(WtloginCaptchaDialog paramWtloginCaptchaDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((WtloginCaptchaDialog.a(this.a) == null) || (WtloginCaptchaDialog.a(this.a).isFinishing()) || (WtloginCaptchaDialog.a() == null)) {
      return;
    }
    ((aax)WtloginCaptchaDialog.a(this.a)).dismissDialog();
    h.c("wtlogin : ret=" + paramMessage.arg1 + ", what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    case 4101: 
    case 4102: 
    case 4103: 
    default: 
      return;
    case 4099: 
      int i = paramMessage.arg1;
      long l2 = 523005419L;
      long l1 = l2;
      if (paramMessage.getData() != null)
      {
        l1 = l2;
        if (paramMessage.getData().getLong("appid") != 0L) {
          l1 = paramMessage.getData().getLong("appid");
        }
      }
      if (i == 0)
      {
        Message localMessage = WtloginCaptchaDialog.a().obtainMessage(1019);
        localMessage.obj = paramMessage.obj;
        paramMessage = new Bundle();
        paramMessage.putLong("appid", l1);
        localMessage.setData(paramMessage);
        WtloginCaptchaDialog.a().sendMessage(localMessage);
        this.a.dismiss();
        WtloginCaptchaDialog.a(null);
        WtloginCaptchaDialog.a(this.a, null);
        return;
      }
      if (i == -1000)
      {
        this.a.a(2131230960);
        return;
      }
      if (i == 8192)
      {
        this.a.a(2131231407);
        return;
      }
      if (i == 2)
      {
        this.a.a(2131231410);
        this.a.a.a(WtloginCaptchaDialog.b(this.a), this.a.b);
        WtloginCaptchaDialog.c(this.a).setVisibility(0);
        WtloginCaptchaDialog.d(this.a).setText("");
        return;
      }
      if (i == 1)
      {
        this.a.a(2131231405);
        this.a.dismiss();
        WtloginCaptchaDialog.a(null);
        WtloginCaptchaDialog.a(this.a, null);
        return;
      }
      if ((i == 40) || (i == 42) || (i == 64))
      {
        this.a.dismiss();
        ((BaseActivity)WtloginCaptchaDialog.a(this.a)).goToRemoveProtectH5(WtloginCaptchaDialog.a(this.a), paramMessage, i);
        return;
      }
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
      {
        this.a.a(WtloginCaptchaDialog.a(this.a).getResources().getString(2131231411) + ":" + paramMessage.getData().getString("loginerror"));
        return;
      }
      this.a.a(2131231411);
      return;
    case 4100: 
      h.b("K_MSGCODE_REFRESH_PICTURE ret=" + paramMessage.arg1);
      WtloginCaptchaDialog.e(this.a);
      return;
    }
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      this.a.a(WtloginCaptchaDialog.a(this.a).getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
      return;
    }
    this.a.a(2131231411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.do
 * JD-Core Version:    0.7.0.1
 */