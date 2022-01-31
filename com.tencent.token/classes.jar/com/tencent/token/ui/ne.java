package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.ds;
import com.tencent.token.er;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;

class ne
  extends cb
{
  ne(LoginMsgActivity paramLoginMsgActivity)
  {
    super(paramLoginMsgActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.isFinishing()) || (LoginMsgActivity.access$000(this.a) == null)) {}
    do
    {
      return;
      h.a("mbtoken3_get_msg: +" + paramMessage.what);
      i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3005: 
        localObject = ds.a();
        if (paramMessage.arg1 != 0) {
          break label997;
        }
        LoginMsgActivity.access$608(this.a);
        LoginMsgActivity.access$700(this.a).c();
        if ((!((ds)localObject).e()) || (LoginMsgActivity.access$600(this.a) > 5)) {
          break label831;
        }
        paramMessage = this.a;
        i = LoginMsgActivity.access$800(this.a);
        LoginMsgActivity.access$802(paramMessage, ((ds)localObject).f() + i);
        ds.a().a(LoginMsgActivity.access$300(this.a), LoginMsgActivity.mSkey, this.a.mHandler);
        return;
      }
    } while (i != 2);
    paramMessage = cp.a(this.a);
    Object localObject = do.a().e().mRealUin + "";
    if (!paramMessage.b((String)localObject, 523005419L))
    {
      paramMessage.a((String)localObject, this.a.mHandler, 523005419L, 64);
      return;
    }
    LoginMsgActivity.access$100(this.a);
    return;
    LoginMsgActivity.access$202(this.a, false);
    localObject = (byte[])paramMessage.obj;
    if ((i == 0) && (localObject != null) && (localObject.length > 0))
    {
      LoginMsgActivity.mSkey = w.a((byte[])localObject);
      LoginMsgActivity.access$202(this.a, true);
      ds.a().a(LoginMsgActivity.access$300(this.a), LoginMsgActivity.mSkey, this.a.mHandler);
      return;
    }
    if (i == -1000)
    {
      this.a.dismissDialog();
      this.a.showToast(2131230960);
      this.a.finishRefresh();
      LoginMsgActivity.access$000(this.a).notifyDataSetChanged();
      LoginMsgActivity.access$202(this.a, false);
      return;
    }
    if (i == 8192)
    {
      this.a.dismissDialog();
      this.a.showToast(2131231407);
      this.a.finishRefresh();
      LoginMsgActivity.access$000(this.a).notifyDataSetChanged();
      LoginMsgActivity.access$202(this.a, false);
      return;
    }
    if ((i == 40) || (i == 42) || (i == 64))
    {
      this.a.dismissDialog();
      this.a.finishRefresh();
      LoginMsgActivity.access$000(this.a).notifyDataSetChanged();
      LoginMsgActivity.access$202(this.a, false);
      this.a.goToRemoveProtectH5(this.a, paramMessage, i);
      return;
    }
    this.a.dismissDialog();
    this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new nf(this));
    this.a.finishRefresh();
    LoginMsgActivity.access$000(this.a).notifyDataSetChanged();
    LoginMsgActivity.access$202(this.a, false);
    return;
    this.a.dismissDialog();
    this.a.finishRefresh();
    LoginMsgActivity.access$000(this.a).notifyDataSetChanged();
    LoginMsgActivity.access$202(this.a, false);
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
      return;
    }
    this.a.showToast(2131231411);
    return;
    LoginMsgActivity.access$400(this.a);
    return;
    if (paramMessage.arg1 == 0) {
      this.a.showOrangeToast(2131231279, 2130838017);
    }
    for (;;)
    {
      LoginMsgActivity.access$502(this.a, true);
      LoginMsgActivity.access$000(this.a).a(ds.a().f, ds.a().b);
      LoginMsgActivity.access$000(this.a).notifyDataSetChanged();
      break;
      localObject = (f)paramMessage.obj;
      f.a(this.a.getResources(), (f)localObject);
      this.a.showUserDialog(2131230843, ((f)localObject).c, 2131230897, null);
    }
    label831:
    LoginMsgActivity.access$602(this.a, 0);
    if (((ds)localObject).f() > 0)
    {
      LoginMsgActivity.access$000(this.a).a(ds.a().f, ds.a().b);
      LoginMsgActivity.access$000(this.a).a();
    }
    paramMessage = this.a;
    int i = LoginMsgActivity.access$800(this.a);
    LoginMsgActivity.access$802(paramMessage, ((ds)localObject).f() + i);
    this.a.finishRefresh();
    if (LoginMsgActivity.access$700(this.a).g() <= 0)
    {
      LoginMsgActivity.access$000(this.a).b();
      LoginMsgActivity.access$000(this.a).e();
      LoginMsgActivity.access$000(this.a).g();
    }
    for (;;)
    {
      LoginMsgActivity.access$000(this.a).a(ds.a().f, ds.a().b);
      LoginMsgActivity.access$000(this.a).notifyDataSetChanged();
      LoginMsgActivity.access$202(this.a, false);
      return;
      label997:
      if (paramMessage.arg1 != 185) {
        break;
      }
      LoginMsgActivity.access$900(this.a);
      return;
      LoginMsgActivity.access$000(this.a).c();
      i = LoginMsgActivity.access$700(this.a).g();
      int j = LoginMsgActivity.access$000(this.a).c;
      LoginMsgActivity.access$000(this.a).getClass();
      if (i >= j * 15)
      {
        LoginMsgActivity.access$000(this.a).d();
        LoginMsgActivity.access$000(this.a).g();
      }
      else
      {
        LoginMsgActivity.access$000(this.a).e();
        LoginMsgActivity.access$000(this.a).f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ne
 * JD-Core Version:    0.7.0.1
 */