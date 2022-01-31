package com.tencent.token.ui.base;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.BaseActivity;

final class a
  extends Handler
{
  a(CaptchaDialog paramCaptchaDialog) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((CaptchaDialog.a(this.a) != null) && (CaptchaDialog.a(this.a).isFinishing())) {}
    do
    {
      return;
      if (this.a.a != null) {
        this.a.a.dismiss();
      }
      e.a("vry dialog msg.what=" + paramMessage.what + ", msg.arg1=" + paramMessage.arg1);
      switch (paramMessage.what)
      {
      default: 
        return;
      case -101: 
        CaptchaDialog.b(this.a).setVisibility(0);
        CaptchaDialog.e(this.a).setVisibility(4);
        CaptchaDialog.d(this.a).setVisibility(4);
        return;
      case -100: 
        CaptchaDialog.b(this.a).setVisibility(0);
        CaptchaDialog.d(this.a).setImageBitmap(CaptchaDialog.c(this.a));
        CaptchaDialog.e(this.a).setVisibility(4);
        CaptchaDialog.d(this.a).setVisibility(0);
        return;
      case 3072: 
        CaptchaDialog.a(this.a, false);
        if (paramMessage.arg1 == 0)
        {
          Message localMessage = new Message();
          localMessage.what = 3072;
          localMessage.arg1 = 0;
          localMessage.obj = paramMessage.obj;
          CaptchaDialog.f(this.a).sendMessage(localMessage);
          this.a.dismiss();
          return;
        }
        paramMessage = (d)paramMessage.obj;
        CaptchaDialog.a(this.a).showToast(paramMessage.c);
        return;
      }
      if (paramMessage.arg1 != 0) {
        break;
      }
      CaptchaDialog.a(this.a, (QueryCaptchaResult)paramMessage.obj);
    } while (!CaptchaDialog.g(this.a).mNeedCaptcha);
    this.a.a();
    return;
    paramMessage = (d)paramMessage.obj;
    CaptchaDialog.a(this.a).showToast(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.a
 * JD-Core Version:    0.7.0.1
 */