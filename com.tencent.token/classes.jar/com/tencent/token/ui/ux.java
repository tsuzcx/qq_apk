package com.tencent.token.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.bean.RealNameQueryResult;
import com.tencent.token.core.push.a;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.CaptchaDialog;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;

final class ux
  extends bo
{
  ux(RealNameFindActivity paramRealNameFindActivity)
  {
    super(paramRealNameFindActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    e.c("upload image what=" + paramMessage.what + ", arg1=" + paramMessage.arg1 + ", optype=" + RealNameFindActivity.access$000(this.a));
    switch (paramMessage.what)
    {
    default: 
    case 3083: 
    case 3067: 
    case 3074: 
    case 3071: 
      Object localObject;
      Handler localHandler;
      do
      {
        return;
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
        if (paramMessage.arg1 == 0)
        {
          if (RealNameFindActivity.access$200(this.a) == null)
          {
            af.a().g(RealNameFindActivity.access$300(this.a), 1, RealNameFindActivity.access$400(this.a));
            return;
          }
          if (RealNameFindActivity.access$200(this.a).b() == 1)
          {
            af.a().g(RealNameFindActivity.access$300(this.a), 4, RealNameFindActivity.access$400(this.a));
            return;
          }
          if (RealNameFindActivity.access$200(this.a).b() == 2)
          {
            this.a.dismissDialog();
            paramMessage = new Intent(this.a, RealNameStep0VerifyMobileActivity.class);
            paramMessage.putExtra("scene_id", 1003);
            paramMessage.putExtra("realname_mobile", RealNameFindActivity.access$200(this.a).c());
            paramMessage.putExtra("real_uin", RealNameFindActivity.access$300(this.a));
            paramMessage.putExtra("page_id", 12);
            com.tencent.token.db.c = RealNameFindActivity.access$200(this.a).d();
            com.tencent.token.db.d = RealNameFindActivity.access$200(this.a).e();
            paramMessage.putExtra("source_id", RealNameFindActivity.access$500(this.a));
            paramMessage.putExtra("mFrontPath", RealNameFindActivity.access$600(this.a));
            paramMessage.putExtra("mBackPath", RealNameFindActivity.access$700(this.a));
            paramMessage.putExtra("prontphotoinfo", RealNameFindActivity.access$800(this.a));
            paramMessage.putExtra("backphotoinfo", RealNameFindActivity.access$900(this.a));
            paramMessage.putExtra("mFaceData", RealNameFindActivity.access$1000(this.a));
            paramMessage.putExtra("canchange_uin", RealNameFindActivity.access$1100(this.a));
            paramMessage.putExtra("result", RealNameFindActivity.access$200(this.a));
            if (RealNameFindActivity.access$1200(this.a)) {
              paramMessage.putExtra("not_showLockVerify", true);
            }
            this.a.startActivity(paramMessage);
            return;
          }
          this.a.dismissDialog();
          paramMessage = new Intent(this.a, RealNameStep0VerifyMobileUpActivity.class);
          com.tencent.token.db.c = RealNameFindActivity.access$200(this.a).d();
          com.tencent.token.db.d = RealNameFindActivity.access$200(this.a).e();
          paramMessage.putExtra("realname_mobile", RealNameFindActivity.access$200(this.a).c());
          paramMessage.putExtra("scene_id", 1003);
          paramMessage.putExtra("real_uin", RealNameFindActivity.access$300(this.a));
          paramMessage.putExtra("source_id", RealNameFindActivity.access$500(this.a));
          paramMessage.putExtra("mFrontPath", RealNameFindActivity.access$600(this.a));
          paramMessage.putExtra("mBackPath", RealNameFindActivity.access$700(this.a));
          paramMessage.putExtra("mFaceData", RealNameFindActivity.access$1000(this.a));
          paramMessage.putExtra("canchange_uin", RealNameFindActivity.access$1100(this.a));
          paramMessage.putExtra("result", RealNameFindActivity.access$200(this.a));
          if (RealNameFindActivity.access$1200(this.a)) {
            paramMessage.putExtra("not_showLockVerify", true);
          }
          this.a.startActivity(paramMessage);
          return;
        }
        this.a.dismissDialog();
        if (paramMessage.arg1 == 169)
        {
          paramMessage = (d)paramMessage.obj;
          d.a(this.a.getResources(), paramMessage);
          localObject = new Intent(this.a, RealNameFindFailActivity.class);
          ((Intent)localObject).putExtra("err_info", paramMessage.c);
          ((Intent)localObject).putExtra("source_id", RealNameFindActivity.access$500(this.a));
          ((Intent)localObject).putExtra("real_uin", RealNameFindActivity.access$300(this.a));
          ((Intent)localObject).putExtra("canchange_uin", RealNameFindActivity.access$1100(this.a));
          this.a.startActivity((Intent)localObject);
          return;
        }
        paramMessage = (d)paramMessage.obj;
        d.a(this.a.getResources(), paramMessage);
        this.a.showUserDialog(2131361808, paramMessage.c, 2131361914, 2131361804, new uy(this), new va(this));
        return;
        if (paramMessage.arg1 == 0)
        {
          ax.a().f(RealNameFindActivity.access$300(this.a));
          af.a().b(RealNameFindActivity.access$400(this.a));
          this.a.dismissDialog();
          RealNameFindActivity.access$1802(this.a, true);
          this.a.setContentView(2130903050);
          this.a.setBackArrowHide();
          localObject = (TextView)this.a.findViewById(2131296396);
          paramMessage = (TextView)this.a.findViewById(2131296397);
          ((TextView)localObject).setText(2131362582);
          paramMessage.setVisibility(0);
          localObject = (Button)this.a.findViewById(2131296398);
          if (RealNameFindActivity.access$500(this.a) == 1)
          {
            ((Button)localObject).setText(2131361901);
            paramMessage.setText(2131362584);
          }
          for (;;)
          {
            ((Button)localObject).setOnClickListener(new vb(this));
            this.a.setTitle(2131361842);
            ((ImageView)this.a.findViewById(2131296395)).setImageDrawable(k.a(RealNameFindActivity.access$300(this.a) + "", s.f(RealNameFindActivity.access$300(this.a)) + " "));
            a.a().a(8);
            return;
            ((Button)localObject).setText(2131361840);
            paramMessage.setText(2131362583);
          }
        }
        paramMessage = (d)paramMessage.obj;
        d.a(this.a.getResources(), paramMessage);
        this.a.showUserDialog(2131361808, paramMessage.c, 2131361914, 2131361804, new vc(this), new vd(this));
        return;
        if (paramMessage.arg1 != 0) {
          break label1255;
        }
        paramMessage = (QueryCaptchaResult)paramMessage.obj;
        if (!paramMessage.mNeedCaptcha) {
          break;
        }
        localObject = this.a;
        localHandler = RealNameFindActivity.access$400(this.a);
      } while ((localObject == null) || (((BaseActivity)localObject).isFinishing()));
      new CaptchaDialog((BaseActivity)localObject, localHandler, paramMessage).show();
      return;
      af.a().d(RealNameFindActivity.access$400(this.a));
      return;
      paramMessage = (d)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    case 3072: 
      if (paramMessage.arg1 == 0)
      {
        af.a().d(RealNameFindActivity.access$400(this.a));
        this.a.dismissDialog();
        return;
      }
      paramMessage = (d)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    case 3025: 
      label1255:
      if (paramMessage.arg1 == 0)
      {
        paramMessage = ag.c();
        paramMessage.i();
        paramMessage.n();
        af.a().a(0L, RealNameFindActivity.access$300(this.a), RealNameFindActivity.access$000(this.a), "", "", RealNameFindActivity.access$1000(this.a), RealNameFindActivity.access$1600(this.a, RealNameFindActivity.access$1500(this.a)), RealNameFindActivity.access$1600(this.a, RealNameFindActivity.access$1700(this.a)), RealNameFindActivity.access$800(this.a), RealNameFindActivity.access$900(this.a), RealNameFindActivity.access$400(this.a));
        return;
      }
      paramMessage = (d)paramMessage.obj;
      e.c("err " + paramMessage.a);
      d.a(this.a.getResources(), paramMessage);
      e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new ve(this));
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      af.a().f(0L, 3, RealNameFindActivity.access$400(this.a));
      return;
    }
    paramMessage = (d)paramMessage.obj;
    e.c("err " + paramMessage.a);
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131361831, paramMessage.c, 2131361914, new vf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ux
 * JD-Core Version:    0.7.0.1
 */