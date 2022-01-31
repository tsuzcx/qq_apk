package com.tencent.token.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.af;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.CaptchaDialog;

final class ks
  extends bo
{
  ks(FindPasswdActivity paramFindPasswdActivity)
  {
    super(paramFindPasswdActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    Object localObject;
    QueryCaptchaResult localQueryCaptchaResult;
    do
    {
      return;
      e.c("FindPasswdActivity : ret=" + paramMessage.arg1 + ", what=" + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3071: 
        if (paramMessage.arg1 != 0) {
          break label184;
        }
        FindPasswdActivity.access$002(this.a, (QueryCaptchaResult)paramMessage.obj);
        if (!FindPasswdActivity.access$000(this.a).mNeedCaptcha) {
          break label162;
        }
        paramMessage = this.a;
        localObject = FindPasswdActivity.access$100(this.a);
        localQueryCaptchaResult = FindPasswdActivity.access$000(this.a);
      }
    } while ((paramMessage == null) || (paramMessage.isFinishing()));
    new CaptchaDialog(paramMessage, (Handler)localObject, localQueryCaptchaResult).show();
    return;
    label162:
    af.a().m(FindPasswdActivity.access$200(this.a), FindPasswdActivity.access$100(this.a));
    return;
    label184:
    if (paramMessage.arg1 == 101)
    {
      af.a().f(FindPasswdActivity.access$200(this.a), 5, FindPasswdActivity.access$100(this.a));
      return;
    }
    paramMessage = (d)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
    return;
    if (paramMessage.arg1 == 0)
    {
      FindPasswdActivity.access$302(this.a, (String)paramMessage.obj);
      af.a().m(FindPasswdActivity.access$200(this.a), FindPasswdActivity.access$100(this.a));
      return;
    }
    paramMessage = (d)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
    return;
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (RealNameQueryResult)paramMessage.obj;
      if ((paramMessage.a() == 1) || (paramMessage.f() == 1))
      {
        localObject = new Intent(this.a, RealNameFindActivity.class);
        ((Intent)localObject).putExtra("source_id", 1);
        ((Intent)localObject).putExtra("real_uin", FindPasswdActivity.access$200(this.a));
        if (paramMessage.f() == 1) {
          ((Intent)localObject).putExtra("ish5zzb", true);
        }
        ((Intent)localObject).putExtra("canchange_uin", FindPasswdActivity.access$400(this.a));
        ((Intent)localObject).putExtra("result", paramMessage);
        if (FindPasswdActivity.access$500(this.a).booleanValue()) {
          ((Intent)localObject).putExtra("not_showLockVerify", true);
        }
        this.a.startActivity((Intent)localObject);
        return;
      }
      paramMessage = new Intent(this.a, FindPasswdH5Activity.class);
      paramMessage.putExtra("real_uin", FindPasswdActivity.access$200(this.a));
      paramMessage.putExtra("source_id", 1);
      paramMessage.putExtra("captcha_sig", FindPasswdActivity.access$300(this.a));
      this.a.startActivity(paramMessage);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ks
 * JD-Core Version:    0.7.0.1
 */