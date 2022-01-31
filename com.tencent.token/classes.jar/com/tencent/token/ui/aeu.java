package com.tencent.token.ui;

import android.os.Message;
import android.widget.EditText;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class aeu
  extends cb
{
  aeu(VerifyMobilePhoneActivity paramVerifyMobilePhoneActivity)
  {
    super(paramVerifyMobilePhoneActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3026: 
    case 4004: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        if (paramMessage.arg2 == 1) {
          bool = true;
        }
        VerifyMobilePhoneActivity.access$500(this.a, bool);
        return;
      }
      break;
    case 3085: 
      String str = VerifyMobilePhoneActivity.access$000(this.a).getText().toString();
      if (paramMessage.arg1 == 0)
      {
        if (!VerifyMobilePhoneActivity.access$200(this.a).a(Integer.valueOf(VerifyMobilePhoneActivity.access$400(this.a))))
        {
          abi.a().a(this.a, VerifyMobilePhoneActivity.access$300(this.a), VerifyMobilePhoneActivity.access$200(this.a), VerifyMobilePhoneActivity.access$200(this.a).a(VerifyMobilePhoneActivity.access$400(this.a)), false, null);
          return;
        }
        cw.a().b(VerifyMobilePhoneActivity.access$100(this.a).mRealUin, VerifyMobilePhoneActivity.access$200(this.a).a(), str, "", this.a.mHandler);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
      return;
    }
    if (paramMessage.arg1 == 160)
    {
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      this.a.showUserDialog(2131230843, paramMessage.c, 2131231504, 2131231507, new aev(this), new aew(this));
      return;
    }
    if (paramMessage.arg1 == 161)
    {
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      this.a.showUserDialog(2131230843, paramMessage.c, 2131231388, 2131231504, new aex(this), new aey(this));
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aeu
 * JD-Core Version:    0.7.0.1
 */