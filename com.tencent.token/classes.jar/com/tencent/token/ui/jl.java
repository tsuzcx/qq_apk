package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.cw;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class jl
  extends cb
{
  jl(FindPasswdActivity paramFindPasswdActivity)
  {
    super(paramFindPasswdActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    h.c("FindPasswdActivity : ret=" + paramMessage.arg1 + ", what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3071: 
      if (paramMessage.arg1 == 0)
      {
        FindPasswdActivity.access$002(this.a, (QueryCaptchaResult)paramMessage.obj);
        if (FindPasswdActivity.access$000(this.a).mNeedCaptcha)
        {
          this.a.dismissDialog();
          this.a.gotoVerifyActivity(FindPasswdActivity.access$000(this.a));
          return;
        }
        cw.a().k(FindPasswdActivity.access$100(this.a), FindPasswdActivity.access$200(this.a));
        return;
      }
      if (paramMessage.arg1 == 101)
      {
        cw.a().d(FindPasswdActivity.access$100(this.a), 5, FindPasswdActivity.access$200(this.a));
        return;
      }
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    case 3072: 
      if (paramMessage.arg1 == 0)
      {
        FindPasswdActivity.access$302(this.a, (String)paramMessage.obj);
        cw.a().k(FindPasswdActivity.access$100(this.a), FindPasswdActivity.access$200(this.a));
        return;
      }
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    case 3073: 
      if (paramMessage.arg1 == 0)
      {
        if (((RealNameQueryResult)paramMessage.obj).a() == 1)
        {
          postDelayed(new jm(this), 10L);
          return;
        }
        this.a.dismissDialog();
        paramMessage = new Intent(this.a, FindPasswdH5Activity.class);
        paramMessage.putExtra("real_uin", FindPasswdActivity.access$100(this.a));
        paramMessage.putExtra("source_id", 1);
        paramMessage.putExtra("captcha_sig", FindPasswdActivity.access$300(this.a));
        this.a.startActivity(paramMessage);
        return;
      }
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      postDelayed(new jn(this, (DeterminVerifyFactorsResult)paramMessage.obj), 10L);
      return;
    }
    this.a.dismissDialog();
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jl
 * JD-Core Version:    0.7.0.1
 */