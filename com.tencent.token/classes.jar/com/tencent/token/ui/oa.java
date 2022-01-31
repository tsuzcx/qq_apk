package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.ax;
import com.tencent.token.bb;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SecurityReporterResult;
import com.tencent.token.fo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.x;

final class oa
  extends bo
{
  oa(LoginMsgActivity paramLoginMsgActivity)
  {
    super(paramLoginMsgActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a.isFinishing()) || (LoginMsgActivity.access$000(this.a) == null)) {}
    do
    {
      do
      {
        return;
        e.a("mbtoken3_get_msg: +" + paramMessage.what);
        int i = paramMessage.arg1;
        Object localObject;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 3005: 
          localObject = bb.a();
          if (paramMessage.arg1 == 0)
          {
            LoginMsgActivity.access$408(this.a);
            LoginMsgActivity.access$500(this.a).c();
            if ((((bb)localObject).e()) && (LoginMsgActivity.access$400(this.a) <= 5))
            {
              LoginMsgActivity.access$612(this.a, ((bb)localObject).g());
              bb.a().a(LoginMsgActivity.access$200(this.a), LoginMsgActivity.mSkey, this.a.mHandler);
              return;
            }
          }
        case 4097: 
        case 4098: 
          LoginMsgActivity.access$102(this.a, false);
          localObject = (byte[])paramMessage.obj;
          if ((i == 0) && (localObject != null) && (localObject.length > 0))
          {
            LoginMsgActivity.mSkey = s.a((byte[])localObject);
            LoginMsgActivity.access$102(this.a, true);
            bb.a().a(LoginMsgActivity.access$200(this.a), LoginMsgActivity.mSkey, this.a.mHandler);
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
          if ((i == 1) || (i == 15) || (i == 16) || (i == 2))
          {
            this.a.dismissDialog();
            this.a.showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new ob(this));
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
        case 4104: 
          this.a.dismissDialog();
          if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
          {
            this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
            return;
          }
          this.a.showToast(2131362091);
          return;
        case 3056: 
          if (paramMessage.arg1 == 0) {
            this.a.showOrangeToast(2131362065, 2130837964);
          }
          for (;;)
          {
            LoginMsgActivity.access$302(this.a, true);
            LoginMsgActivity.access$000(this.a).a(bb.a().f, bb.a().b);
            LoginMsgActivity.access$000(this.a).notifyDataSetChanged();
            break;
            localObject = (d)paramMessage.obj;
            d.a(this.a.getResources(), (d)localObject);
            this.a.showUserDialog(2131361808, ((d)localObject).c, 2131361800, null);
          }
          LoginMsgActivity.access$402(this.a, 0);
          if (((bb)localObject).g() > 0)
          {
            LoginMsgActivity.access$000(this.a).a(bb.a().f, bb.a().b);
            LoginMsgActivity.access$000(this.a).a();
          }
          LoginMsgActivity.access$612(this.a, ((bb)localObject).g());
          this.a.finishRefresh();
          if (LoginMsgActivity.access$500(this.a).g() <= 0)
          {
            LoginMsgActivity.access$000(this.a).b();
            LoginMsgActivity.access$000(this.a).e();
            LoginMsgActivity.access$000(this.a).g();
          }
          for (;;)
          {
            LoginMsgActivity.access$000(this.a).a(bb.a().f, bb.a().b);
            LoginMsgActivity.access$000(this.a).notifyDataSetChanged();
            LoginMsgActivity.access$102(this.a, false);
            return;
            if (paramMessage.arg1 != 185) {
              break;
            }
            x.a(RqdApplication.i()).a(this.a, "" + ax.a().e().mRealUin, this.a.mHandler, true);
            return;
            LoginMsgActivity.access$000(this.a).c();
            i = LoginMsgActivity.access$500(this.a).g();
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
        this.a.dismissDialog();
        if (paramMessage.arg1 != 0) {
          break;
        }
        LoginMsgActivity.access$702(this.a, (SecurityReporterResult)paramMessage.obj);
      } while (LoginMsgActivity.access$700(this.a).type == 2);
      paramMessage = this.a;
      ax.a();
      LoginMsgActivity.access$802(paramMessage, ax.c);
      if (ax.a().e() != null) {
        LoginMsgActivity.access$902(this.a, ax.a().e().mUin);
      }
      LoginMsgActivity.access$1002(this.a, true);
      paramMessage = new Intent(this.a, SecurityReporterActivity.class);
      paramMessage.putExtra("result", LoginMsgActivity.access$700(this.a));
      this.a.startActivity(paramMessage);
      return;
    } while ((LoginMsgActivity.access$700(this.a) == null) || (LoginMsgActivity.access$700(this.a).type != 1));
    paramMessage = (d)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      d.a(this.a.getResources(), paramMessage);
    }
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.oa
 * JD-Core Version:    0.7.0.1
 */