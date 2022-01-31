package com.tencent.token.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class qo
  extends cb
{
  qo(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity)
  {
    super(paramNetActiveVryMobileNoSmsActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      h.c("unknown msg: " + paramMessage.what);
      return;
    case -100: 
      NetActiveVryMobileNoSmsActivity.access$400(this.a);
      return;
    case 100: 
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      return;
    case 3031: 
      if (paramMessage.arg1 != 0)
      {
        paramMessage = (f)paramMessage.obj;
        h.c("err " + paramMessage.a);
        f.a(this.a.getResources(), paramMessage);
        h.c("get mobile code failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        this.a.mHandler.removeMessages(-100);
        if (124 == paramMessage.a)
        {
          NetActiveVryMobileNoSmsActivity.access$1100(this.a, paramMessage.c);
          return;
        }
        this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
        return;
      }
      this.a.setContentView(2130968704);
      NetActiveVryMobileNoSmsActivity.access$1200(this.a);
      return;
    case 3029: 
      if (paramMessage.arg1 == 0)
      {
        if (!NetActiveVryMobileNoSmsActivity.access$200(this.a).a(Integer.valueOf(NetActiveVryMobileNoSmsActivity.access$300(this.a))))
        {
          abi.a().a(this.a, NetActiveVryMobileNoSmsActivity.access$100(this.a), NetActiveVryMobileNoSmsActivity.access$200(this.a), NetActiveVryMobileNoSmsActivity.access$200(this.a).a(NetActiveVryMobileNoSmsActivity.access$300(this.a)), false, this.a.mHandler);
          return;
        }
        if (NetActiveVryMobileNoSmsActivity.access$100(this.a).b())
        {
          NetActiveVryMobileNoSmsActivity.access$1300(this.a);
          return;
        }
        this.a.dismissDialog();
        paramMessage = new Intent(this.a, NetActiveSetDirBySeqActivity.class);
        paramMessage.putExtra("intent.qquser", NetActiveVryMobileNoSmsActivity.access$000(this.a));
        paramMessage.putExtra("intent.determin_factors_result", NetActiveVryMobileNoSmsActivity.access$100(this.a));
        paramMessage.putExtra("intent.determin_verify_type", NetActiveVryMobileNoSmsActivity.access$200(this.a));
        paramMessage.putExtra("intent.determin_verify_factor_id", 3);
        this.a.startActivity(paramMessage);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      NetActiveVryMobileNoSmsActivity.access$1400(this.a, paramMessage.c);
      return;
    case 3026: 
    case 4004: 
      if (paramMessage.arg1 == 0)
      {
        NetActiveVryMobileNoSmsActivity.access$1500(this.a);
        return;
      }
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      NetActiveVryMobileNoSmsActivity.access$1400(this.a, paramMessage.c);
      return;
    }
    this.a.dismissDialog();
    paramMessage = new Intent(this.a, VerifySuccActivity.class);
    paramMessage.putExtra("mRealUin", NetActiveVryMobileNoSmsActivity.access$000(this.a).mRealUin);
    if ((NetActiveVryMobileNoSmsActivity.access$100(this.a) != null) && (NetActiveVryMobileNoSmsActivity.access$100(this.a).c() == 2)) {
      paramMessage.putExtra("mSourceId", 1);
    }
    this.a.startActivity(paramMessage);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qo
 * JD-Core Version:    0.7.0.1
 */