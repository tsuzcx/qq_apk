package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.p;
import com.tencent.token.ui.base.WtloginCaptchaDialog;
import com.tencent.token.x;

final class abg
  extends Handler
{
  abg(StartPwdGestureForgetActivity paramStartPwdGestureForgetActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    switch (paramMessage.what)
    {
    default: 
    case 1019: 
    case 4098: 
      do
      {
        do
        {
          return;
          if (StartPwdGestureForgetActivity.access$300(this.a) == 523005425L)
          {
            StartPwdGestureForgetActivity.access$302(this.a, 523005419L);
            x.a(this.a).b("" + StartPwdGestureForgetActivity.access$400(this.a).mRealUin, StartPwdGestureForgetActivity.access$000(this.a).getText().toString(), StartPwdGestureForgetActivity.access$500(this.a), StartPwdGestureForgetActivity.access$300(this.a));
            return;
          }
          this.a.dismissDialog();
          StartPwdGestureForgetActivity.access$600(this.a);
          return;
          if (i != 2) {
            break;
          }
          this.a.dismissDialog();
        } while (this.a.isFinishing());
        new WtloginCaptchaDialog(this.a, StartPwdGestureForgetActivity.access$500(this.a), "" + StartPwdGestureForgetActivity.access$400(this.a).mRealUin).show();
        return;
        if (i == 0)
        {
          if (StartPwdGestureForgetActivity.access$300(this.a) == 523005425L)
          {
            StartPwdGestureForgetActivity.access$302(this.a, 523005419L);
            x.a(this.a).b("" + StartPwdGestureForgetActivity.access$400(this.a).mRealUin, StartPwdGestureForgetActivity.access$000(this.a).getText().toString(), StartPwdGestureForgetActivity.access$500(this.a), StartPwdGestureForgetActivity.access$300(this.a));
            return;
          }
          this.a.dismissDialog();
          StartPwdGestureForgetActivity.access$600(this.a);
          return;
        }
        if (((i == 40) || (i == 42) || (i == 64)) && (StartPwdGestureForgetActivity.access$300(this.a) == 523005419L))
        {
          this.a.dismissDialog();
          StartPwdGestureForgetActivity.access$600(this.a);
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
        if (i != 1) {
          break;
        }
        this.a.dismissDialog();
        this.a.showToast(2131362066);
      } while ((StartPwdGestureForgetActivity.access$700(this.a) == 0) || ((StartPwdGestureForgetActivity.access$700(this.a) != 4) && (StartPwdGestureForgetActivity.access$700(this.a) != 5)));
      p.a().a(System.currentTimeMillis(), 96);
      return;
      this.a.dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
      {
        this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("loginerror"));
        return;
      }
      this.a.showToast(2131362091);
      return;
    case 4104: 
      this.a.dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      this.a.showToast(2131362091);
      return;
    }
    if (i == 0)
    {
      this.a.dismissDialog();
      StartPwdGestureForgetActivity.access$402(this.a, ax.a().e());
      if (StartPwdGestureForgetActivity.access$400(this.a) == null)
      {
        p.a().a(System.currentTimeMillis(), 23);
        StartPwdGestureForgetActivity.access$800(this.a, this.a, 2131362161, 2131362144);
        return;
      }
      StartPwdGestureForgetActivity.access$900(this.a);
      return;
    }
    this.a.dismissDialog();
    this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362165), 2131361914, new abh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abg
 * JD-Core Version:    0.7.0.1
 */