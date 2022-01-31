package com.tencent.token.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.ScanDataResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.CaptchaDialog;

final class zp
  extends bo
{
  zp(SettingPageActivity paramSettingPageActivity)
  {
    super(paramSettingPageActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    SettingPageActivity localSettingPageActivity;
    Handler localHandler;
    do
    {
      do
      {
        return;
        e.c("utils mbinfo: " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          return;
        case 3025: 
          if (paramMessage.arg1 != 0) {
            break;
          }
          paramMessage = ag.c();
          paramMessage.i();
          paramMessage.n();
          af.a().h(this.a.mHandler);
          return;
        case 4000: 
          if (paramMessage.arg1 == 0)
          {
            af.a().f(0L, 3, this.a.mHandler);
            return;
          }
          break;
        }
      } while (ax.a().e() == null);
      paramMessage = (d)paramMessage.obj;
      e.c("err " + paramMessage.a);
      d.a(this.a.getResources(), paramMessage);
      e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new zq(this));
      return;
      if (paramMessage.arg1 != 0) {
        break label344;
      }
      paramMessage = (QueryCaptchaResult)paramMessage.obj;
      if (!paramMessage.mNeedCaptcha) {
        break;
      }
      localSettingPageActivity = this.a;
      localHandler = this.a.mHandler;
    } while ((localSettingPageActivity == null) || (localSettingPageActivity.isFinishing()));
    new CaptchaDialog(localSettingPageActivity, localHandler, paramMessage).show();
    return;
    af.a().d(this.a.mHandler);
    return;
    label344:
    paramMessage = (d)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
    return;
    paramMessage = (d)paramMessage.obj;
    e.c("err " + paramMessage.a);
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new zr(this));
    return;
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (ScanDataResult)paramMessage.obj;
      SettingPageActivity.access$600(this.a, paramMessage);
      RqdApplication.i().getSharedPreferences("sp_name_global", 0).edit().putBoolean("key_settint_showutilnew", false).commit();
      SettingPageActivity.mShowUtilNew = false;
      return;
    }
    paramMessage = (d)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      d.a(this.a.getResources(), paramMessage);
    }
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zp
 * JD-Core Version:    0.7.0.1
 */