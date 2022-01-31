package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class ui
  extends cb
{
  ui(RealNameFindActivity paramRealNameFindActivity)
  {
    super(paramRealNameFindActivity);
  }
  
  private void a(Message paramMessage)
  {
    f localf = (f)paramMessage.obj;
    f.a(this.a.getResources(), localf);
    int i = paramMessage.arg1;
    if ((i == 193) || (i == 194))
    {
      this.a.showUserDialog(2131230843, localf.c, 2131231276, new up(this));
      return;
    }
    this.a.showUserDialog(2131230843, localf.c, 2131230881, 2131230886, new uq(this), new us(this));
  }
  
  public void handleMessage(Message paramMessage)
  {
    h.c("upload image what=" + paramMessage.what + ", arg1=" + paramMessage.arg1 + ", optype=" + RealNameFindActivity.access$000(this.a));
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3083: 
      if (paramMessage.arg1 == 0)
      {
        if (paramMessage.arg2 == 1)
        {
          RealNameFindActivity.access$102(this.a, true);
          return;
        }
        RealNameFindActivity.access$102(this.a, false);
        return;
      }
      RealNameFindActivity.access$102(this.a, false);
      return;
    case 3080: 
      RealNameFindActivity.access$200(this.a).setVisibility(4);
      f localf = (f)paramMessage.obj;
      if (paramMessage.arg1 != 0) {
        if ((localf.a == 250) || (localf.a == 251) || (localf.a == 252))
        {
          RealNameFindActivity.access$302(this.a, true);
          RealNameFindActivity.access$402(this.a, false);
          RealNameFindActivity.access$500(this.a).setVisibility(0);
          RealNameFindActivity.access$500(this.a).setText(localf.b);
          RealNameFindActivity.access$500(this.a).setTextColor(-65536);
        }
      }
      for (;;)
      {
        RealNameFindActivity.access$600(this.a);
        return;
        RealNameFindActivity.access$302(this.a, false);
        this.a.showUserDialog(localf.c);
        continue;
        RealNameFindActivity.access$302(this.a, true);
        RealNameFindActivity.access$500(this.a).setVisibility(0);
        RealNameFindActivity.access$500(this.a).setText(this.a.getResources().getString(2131231652));
        RealNameFindActivity.access$500(this.a).setTextColor(-7829368);
        RealNameFindActivity.access$402(this.a, true);
      }
    case 3067: 
      if (paramMessage.arg1 == 0)
      {
        if (RealNameFindActivity.access$700(this.a))
        {
          this.a.goNextVerify();
          return;
        }
        if (RealNameFindActivity.access$800(this.a) == null)
        {
          cw.a().e(RealNameFindActivity.access$900(this.a), 1, RealNameFindActivity.access$1000(this.a));
          return;
        }
        if (RealNameFindActivity.access$800(this.a).b() == 1)
        {
          cw.a().e(RealNameFindActivity.access$900(this.a), 4, RealNameFindActivity.access$1000(this.a));
          return;
        }
        if (RealNameFindActivity.access$800(this.a).b() == 2)
        {
          this.a.dismissDialog();
          paramMessage = new Intent(this.a, RealNameStep0VerifyMobileActivity.class);
          paramMessage.putExtra("scene_id", 1003);
          paramMessage.putExtra("realname_mobile", RealNameFindActivity.access$800(this.a).c());
          paramMessage.putExtra("real_uin", RealNameFindActivity.access$900(this.a));
          paramMessage.putExtra("page_id", 12);
          com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode.d = RealNameFindActivity.access$800(this.a).d();
          com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode.e = RealNameFindActivity.access$800(this.a).e();
          paramMessage.putExtra("source_id", RealNameFindActivity.access$1100(this.a));
          paramMessage.putExtra("mFrontPath", RealNameFindActivity.access$1200(this.a));
          paramMessage.putExtra("mBackPath", RealNameFindActivity.access$1300(this.a));
          paramMessage.putExtra("prontphotoinfo", RealNameFindActivity.access$1400(this.a));
          paramMessage.putExtra("backphotoinfo", RealNameFindActivity.access$1500(this.a));
          paramMessage.putExtra("mFaceData", RealNameFindActivity.access$1600(this.a));
          paramMessage.putExtra("canchange_uin", RealNameFindActivity.access$1700(this.a));
          paramMessage.putExtra("result", RealNameFindActivity.access$800(this.a));
          if (RealNameFindActivity.access$1800(this.a)) {
            paramMessage.putExtra("not_showLockVerify", true);
          }
          this.a.startActivity(paramMessage);
          return;
        }
        this.a.dismissDialog();
        paramMessage = new Intent(this.a, RealNameStep0VerifyMobileUpActivity.class);
        com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode.d = RealNameFindActivity.access$800(this.a).d();
        com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode.e = RealNameFindActivity.access$800(this.a).e();
        paramMessage.putExtra("realname_mobile", RealNameFindActivity.access$800(this.a).c());
        paramMessage.putExtra("scene_id", 1003);
        paramMessage.putExtra("real_uin", RealNameFindActivity.access$900(this.a));
        paramMessage.putExtra("source_id", RealNameFindActivity.access$1100(this.a));
        paramMessage.putExtra("mFrontPath", RealNameFindActivity.access$1200(this.a));
        paramMessage.putExtra("mBackPath", RealNameFindActivity.access$1300(this.a));
        paramMessage.putExtra("mFaceData", RealNameFindActivity.access$1600(this.a));
        paramMessage.putExtra("canchange_uin", RealNameFindActivity.access$1700(this.a));
        paramMessage.putExtra("result", RealNameFindActivity.access$800(this.a));
        if (RealNameFindActivity.access$1800(this.a)) {
          paramMessage.putExtra("not_showLockVerify", true);
        }
        this.a.startActivity(paramMessage);
        return;
      }
      a(paramMessage);
      return;
    case 3003: 
      this.a.dismissDialog();
      paramMessage = new Intent(this.a, VerifySuccActivity.class);
      paramMessage.putExtra("mRealUin", RealNameFindActivity.access$900(this.a));
      paramMessage.putExtra("mSourceId", RealNameFindActivity.access$1100(this.a));
      paramMessage.putExtra("ish5zzb", RealNameFindActivity.access$1900(this.a));
      this.a.startActivity(paramMessage);
      this.a.finish();
      return;
    case 3074: 
    case 4004: 
      if (paramMessage.arg1 == 0)
      {
        do.a().f(RealNameFindActivity.access$900(this.a));
        cw.a().b(RealNameFindActivity.access$1000(this.a));
        return;
      }
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      if (RealNameFindActivity.access$700(this.a))
      {
        this.a.showUserDialog(2131230843, paramMessage.c, 2131230881, 2131230886, new uj(this), new uk(this));
        return;
      }
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230881, 2131230886, new ul(this), new um(this));
      return;
    case 3071: 
      if (paramMessage.arg1 == 0)
      {
        paramMessage = (QueryCaptchaResult)paramMessage.obj;
        if (paramMessage.mNeedCaptcha)
        {
          this.a.gotoVerifyActivity(paramMessage);
          return;
        }
        cw.a().d(RealNameFindActivity.access$1000(this.a));
        return;
      }
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    case 3072: 
      if (paramMessage.arg1 == 0)
      {
        cw.a().d(RealNameFindActivity.access$1000(this.a));
        return;
      }
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    case 3025: 
      if (paramMessage.arg1 == 0)
      {
        paramMessage = cx.c();
        paramMessage.i();
        paramMessage.n();
        cw.a().a(0L, RealNameFindActivity.access$900(this.a), RealNameFindActivity.access$000(this.a), RealNameFindActivity.access$2400(this.a).getText().toString(), RealNameFindActivity.access$2500(this.a).getText().toString(), RealNameFindActivity.access$1600(this.a), RealNameFindActivity.access$2700(this.a, RealNameFindActivity.access$2600(this.a)), RealNameFindActivity.access$2700(this.a, RealNameFindActivity.access$2800(this.a)), RealNameFindActivity.access$1400(this.a), RealNameFindActivity.access$1500(this.a), RealNameFindActivity.access$1000(this.a));
        return;
      }
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230881, new un(this));
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      cw.a().d(0L, 3, RealNameFindActivity.access$1000(this.a));
      return;
    }
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230779, paramMessage.c, 2131230881, new uo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ui
 * JD-Core Version:    0.7.0.1
 */