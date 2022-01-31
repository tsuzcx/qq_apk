package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class rd
  extends cb
{
  rd(NetActiveVryQuesActivity paramNetActiveVryQuesActivity)
  {
    super(paramNetActiveVryQuesActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3028: 
      if (paramMessage.arg1 == 0)
      {
        h.c("succ");
        if (!NetActiveVryQuesActivity.access$100(this.a).a(Integer.valueOf(NetActiveVryQuesActivity.access$000(this.a))))
        {
          abi.a().a(this.a, NetActiveVryQuesActivity.access$200(this.a), NetActiveVryQuesActivity.access$100(this.a), NetActiveVryQuesActivity.access$100(this.a).a(NetActiveVryQuesActivity.access$000(this.a)), false, NetActiveVryQuesActivity.access$300(this.a));
          return;
        }
        if (NetActiveVryQuesActivity.access$200(this.a).b())
        {
          NetActiveVryQuesActivity.access$400(this.a);
          return;
        }
        this.a.dismissDialog();
        paramMessage = new Intent(this.a, NetActiveSetDirBySeqActivity.class);
        paramMessage.putExtra("intent.qquser", NetActiveVryQuesActivity.access$500(this.a));
        paramMessage.putExtra("intent.determin_factors_result", NetActiveVryQuesActivity.access$200(this.a));
        paramMessage.putExtra("intent.determin_verify_type", NetActiveVryQuesActivity.access$100(this.a));
        paramMessage.putExtra("intent.determin_verify_factor_id", 7);
        this.a.startActivity(paramMessage);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
      return;
    case 4004: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        if (paramMessage.arg2 == 1) {
          bool = true;
        }
        NetActiveVryQuesActivity.access$600(this.a, bool);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      paramMessage = new Intent(this.a, UtilsModSetMobileStep1Activity.class);
      paramMessage.putExtra("op_type", 1);
      paramMessage.putExtra("title", this.a.getResources().getString(2131230788));
      paramMessage.putExtra("page_id", 10);
      this.a.startActivity(paramMessage);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    this.a.showToast(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rd
 * JD-Core Version:    0.7.0.1
 */