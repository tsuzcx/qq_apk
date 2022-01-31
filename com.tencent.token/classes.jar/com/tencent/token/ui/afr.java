package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class afr
  extends cb
{
  afr(WtLoginAccountInput paramWtLoginAccountInput)
  {
    super(paramWtLoginAccountInput);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (this.a.isFinishing()) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramMessage.arg1;
        h.c("wtlogin : ret=" + paramMessage.arg1 + ", what=" + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          return;
        case 3024: 
          if (i != 0) {
            break;
          }
          WtLoginAccountInput.access$800(this.a);
          return;
        case 4109: 
          h.c("K_MSGCODE_QUICK_LOGIN_SUCC" + WtLoginAccountInput.access$000(this.a));
          paramMessage = paramMessage.getData();
          WtLoginAccountInput.access$102(this.a, paramMessage.getString("uin"));
          paramMessage = paramMessage.getByteArray("sig");
          WtLoginAccountInput.access$202(this.a, paramMessage);
          WtLoginAccountInput.access$302(this.a, true);
        }
      } while (!WtLoginAccountInput.access$000(this.a));
      WtLoginAccountInput.access$400(this.a);
      return;
      h.c("K_MSGCODE_QUICK_LOGIN_back");
      this.a.dismissDialog();
    } while ((i == 5000) || (paramMessage.obj == null));
    this.a.showOrangeToast(paramMessage.obj.toString(), 0);
    return;
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (QueryCaptchaResult)paramMessage.obj;
      if (paramMessage.mNeedCaptcha)
      {
        this.a.gotoVerifyActivity(paramMessage);
        return;
      }
      cw.a().d(WtLoginAccountInput.access$500(this.a));
      return;
    }
    paramMessage = (f)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
    return;
    if (paramMessage.arg1 == 0)
    {
      cw.a().d(WtLoginAccountInput.access$500(this.a));
      return;
    }
    paramMessage = (f)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
    return;
    if (paramMessage.arg1 == 0)
    {
      paramMessage = cx.c();
      paramMessage.i();
      paramMessage.n();
      if (WtLoginAccountInput.access$600(this.a))
      {
        cp.a(this.a.getApplicationContext()).a(this.a, 523005419L, WtLoginAccountInput.access$500(this.a));
        this.a.showProDialog(this.a, 2131230843, 2131231298, null);
        return;
      }
      cp.a(this.a.getApplicationContext()).a(this.a, 523005419L, WtLoginAccountInput.access$500(this.a), WtLoginAccountInput.access$700(this.a) + "");
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230779, paramMessage.c, 2131230881, new afs(this));
    return;
    if (paramMessage.arg1 == 0)
    {
      cw.a().d(0L, 3, WtLoginAccountInput.access$500(this.a));
      return;
    }
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230779, paramMessage.c, 2131230881, new aft(this));
    return;
    this.a.dismissDialog();
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
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
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (DeterminVerifyFactorsResult)paramMessage.obj;
      paramMessage.a(true);
      postDelayed(new afu(this, paramMessage), 10L);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
    return;
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1) {
        bool1 = true;
      }
      WtLoginAccountInput.access$900(this.a, bool1);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
    return;
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        WtLoginAccountInput.access$900(this.a, bool1);
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
 * Qualified Name:     com.tencent.token.ui.afr
 * JD-Core Version:    0.7.0.1
 */