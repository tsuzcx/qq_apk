package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.kingkong.Common;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.CaptchaDialog;
import com.tencent.token.ui.base.WtloginCaptchaDialog;
import com.tencent.token.x;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

final class ahb
  extends bo
{
  ahb(WtLoginAccountInput paramWtLoginAccountInput)
  {
    super(paramWtLoginAccountInput);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (this.a.isFinishing()) {}
    do
    {
      return;
      i = paramMessage.arg1;
      e.c("wtlogin : ret=" + paramMessage.arg1 + ", what=" + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1019: 
        paramMessage = (byte[])paramMessage.obj;
        if (WtLoginAccountInput.access$300(this.a) == 523005425L) {
          WtLoginAccountInput.access$502(this.a, paramMessage);
        }
        break;
      }
    } while (paramMessage == null);
    paramMessage = new QQUser();
    Object localObject = WtLoginAccountInput.access$400(this.a).c(WtLoginAccountInput.access$100(this.a).getText().toString());
    WtLoginAccountInput.access$602(this.a, ((WloginSimpleInfo)localObject)._uin);
    paramMessage.mRealUin = WtLoginAccountInput.access$600(this.a);
    paramMessage.mIsBinded = false;
    if (localObject != null) {
      paramMessage.mNickName = new String(((WloginSimpleInfo)localObject)._nick);
    }
    WtLoginAccountInput.access$700(this.a).a(paramMessage);
    if (WtLoginAccountInput.access$300(this.a) != 523005419L) {}
    for (int i = 2;; i = 1)
    {
      if (WtLoginAccountInput.access$800(this.a))
      {
        WtLoginAccountInput.access$900(this.a);
        return;
        if (paramMessage.arg1 == 0)
        {
          paramMessage = (QueryCaptchaResult)paramMessage.obj;
          if (paramMessage.mNeedCaptcha)
          {
            localObject = this.a;
            Handler localHandler = WtLoginAccountInput.access$000(this.a);
            if ((localObject == null) || (((BaseActivity)localObject).isFinishing())) {
              break;
            }
            new CaptchaDialog((BaseActivity)localObject, localHandler, paramMessage).show();
            return;
          }
          af.a().d(WtLoginAccountInput.access$000(this.a));
          return;
        }
        paramMessage = (d)paramMessage.obj;
        this.a.showUserDialog(paramMessage.c);
        return;
        if (paramMessage.arg1 == 0)
        {
          af.a().d(WtLoginAccountInput.access$000(this.a));
          this.a.dismissDialog();
          return;
        }
        paramMessage = (d)paramMessage.obj;
        this.a.showUserDialog(paramMessage.c);
        return;
        if (paramMessage.arg1 == 0)
        {
          paramMessage = ag.c();
          paramMessage.i();
          paramMessage.n();
          WtLoginAccountInput.access$400(this.a).b(WtLoginAccountInput.access$100(this.a).getText().toString(), WtLoginAccountInput.access$200(this.a), WtLoginAccountInput.access$000(this.a), WtLoginAccountInput.access$300(this.a));
          return;
        }
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
        e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new ahc(this));
        return;
        if (paramMessage.arg1 == 0)
        {
          af.a().f(0L, 3, WtLoginAccountInput.access$000(this.a));
          return;
        }
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
        e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new ahd(this));
        return;
      }
      WtLoginAccountInput.access$1000(this.a).a(WtLoginAccountInput.access$600(this.a), WtLoginAccountInput.access$500(this.a), WtLoginAccountInput.access$000(this.a), i);
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      return;
      if (i == 2)
      {
        this.a.dismissDialog();
        if (this.a.isFinishing()) {
          break;
        }
        new WtloginCaptchaDialog(this.a, WtLoginAccountInput.access$000(this.a), Long.toString(WtLoginAccountInput.access$600(this.a))).show();
        return;
      }
      if (i == 0)
      {
        paramMessage = (byte[])paramMessage.obj;
        if (WtLoginAccountInput.access$300(this.a) == 523005425L) {
          WtLoginAccountInput.access$502(this.a, paramMessage);
        }
        if (paramMessage == null) {
          break;
        }
        paramMessage = new QQUser();
        localObject = WtLoginAccountInput.access$400(this.a).c(WtLoginAccountInput.access$100(this.a).getText().toString());
        WtLoginAccountInput.access$602(this.a, ((WloginSimpleInfo)localObject)._uin);
        Common.OnLogin(this.a, WtLoginAccountInput.access$600(this.a) + "");
        paramMessage.mRealUin = WtLoginAccountInput.access$600(this.a);
        paramMessage.mIsBinded = false;
        if (localObject != null) {
          paramMessage.mNickName = new String(((WloginSimpleInfo)localObject)._nick);
        }
        WtLoginAccountInput.access$700(this.a).a(paramMessage);
        if (WtLoginAccountInput.access$300(this.a) == 523005419L) {
          break label1998;
        }
      }
      label1998:
      for (i = 2;; i = 1)
      {
        if (WtLoginAccountInput.access$800(this.a))
        {
          WtLoginAccountInput.access$900(this.a);
          return;
        }
        WtLoginAccountInput.access$1000(this.a).a(WtLoginAccountInput.access$600(this.a), WtLoginAccountInput.access$500(this.a), WtLoginAccountInput.access$000(this.a), i);
        return;
        if (((i == 40) || (i == 42) || (i == 64)) && (WtLoginAccountInput.access$800(this.a)))
        {
          WtLoginAccountInput.access$900(this.a);
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
        if (i == 1)
        {
          this.a.dismissDialog();
          this.a.showToast(2131362066);
          return;
        }
        if (((i == 40) || (i == 42) || (i == 64)) && (WtLoginAccountInput.access$1100(this.a) != 5) && (WtLoginAccountInput.access$1100(this.a) != 6))
        {
          this.a.dismissDialog();
          WtLoginAccountInput.access$302(this.a, 523005425L);
          WtLoginAccountInput.access$1300(this.a).onClick(WtLoginAccountInput.access$1200(this.a));
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
          if (WtLoginAccountInput.access$300(this.a) == 523005425L)
          {
            WtLoginAccountInput.access$302(this.a, 523005419L);
            WtLoginAccountInput.access$400(this.a).b(WtLoginAccountInput.access$600(this.a) + "", WtLoginAccountInput.access$200(this.a), WtLoginAccountInput.access$000(this.a), WtLoginAccountInput.access$300(this.a));
          }
          for (;;)
          {
            WtLoginAccountInput.access$802(this.a, true);
            return;
            WtLoginAccountInput.access$302(this.a, 523005425L);
            WtLoginAccountInput.access$400(this.a).b(WtLoginAccountInput.access$600(this.a) + "", WtLoginAccountInput.access$200(this.a), WtLoginAccountInput.access$000(this.a), WtLoginAccountInput.access$300(this.a));
          }
        }
        this.a.dismissDialog();
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
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
          this.a.dismissDialog();
          paramMessage = (UpgradeDeterminResult)paramMessage.obj;
          WtLoginAccountInput.access$1400(this.a, paramMessage);
          return;
        }
        this.a.dismissDialog();
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
        e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
        return;
        this.a.dismissDialog();
        if (paramMessage.arg1 == 0)
        {
          if (paramMessage.arg2 == 1) {}
          for (;;)
          {
            WtLoginAccountInput.access$1500(this.a, bool);
            return;
            bool = false;
          }
        }
        paramMessage = (d)paramMessage.obj;
        d.a(this.a.getResources(), paramMessage);
        e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ahb
 * JD-Core Version:    0.7.0.1
 */