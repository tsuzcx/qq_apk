package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.ui.base.WtloginCaptchaDialog;
import com.tencent.token.x;

final class aho
  extends bo
{
  aho(WtloginSigExpireActivity paramWtloginSigExpireActivity)
  {
    super(paramWtloginSigExpireActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.isFinishing())) {}
    int i;
    do
    {
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
            this.a.dismissDialog();
            if (WtloginSigExpireActivity.access$000(this.a) == 523005419L)
            {
              WtloginSigExpireActivity.access$002(this.a, 523005425L);
              WtloginSigExpireActivity.access$102(this.a, true);
              x.a(this.a).b(WtloginSigExpireActivity.access$200(this.a) + "", WtloginSigExpireActivity.access$300(this.a), WtloginSigExpireActivity.access$400(this.a), WtloginSigExpireActivity.access$000(this.a));
              return;
            }
            break;
          }
        } while (WtloginSigExpireActivity.access$000(this.a) != 523005425L);
        WtloginSigExpireActivity.access$500(this.a);
        return;
        if (i != 2) {
          break;
        }
        this.a.dismissDialog();
      } while (this.a.isFinishing());
      new WtloginCaptchaDialog(this.a, WtloginSigExpireActivity.access$400(this.a), Long.toString(WtloginSigExpireActivity.access$200(this.a))).show();
      return;
      if (i != 0) {
        break;
      }
      this.a.dismissDialog();
      if (WtloginSigExpireActivity.access$000(this.a) == 523005419L)
      {
        WtloginSigExpireActivity.access$002(this.a, 523005425L);
        WtloginSigExpireActivity.access$102(this.a, true);
        x.a(this.a).b(WtloginSigExpireActivity.access$200(this.a) + "", WtloginSigExpireActivity.access$300(this.a), WtloginSigExpireActivity.access$400(this.a), WtloginSigExpireActivity.access$000(this.a));
        return;
      }
    } while (WtloginSigExpireActivity.access$000(this.a) != 523005425L);
    WtloginSigExpireActivity.access$500(this.a);
    return;
    if (((i == 40) || (i == 42) || (i == 64)) && (WtloginSigExpireActivity.access$100(this.a)))
    {
      WtloginSigExpireActivity.access$500(this.a);
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
    if ((i == 1) || (paramMessage.arg1 == 15) || (paramMessage.arg1 == 16))
    {
      this.a.dismissDialog();
      this.a.showToast(2131362066);
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
 * Qualified Name:     com.tencent.token.ui.aho
 * JD-Core Version:    0.7.0.1
 */