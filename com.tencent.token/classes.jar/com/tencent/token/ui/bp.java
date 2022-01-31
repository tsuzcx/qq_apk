package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.cw;
import com.tencent.token.dm;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.DualMsgShowDialog;

class bp
  extends cb
{
  bp(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    int i;
    try
    {
      h.a("dualmsg,what=" + paramMessage.what + ", ret=" + paramMessage.arg1);
      i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      case 3069: 
        if ((paramMessage.arg1 != 0) || (dm.a().b() <= 0)) {
          break label841;
        }
        bool = RqdApplication.b;
        if (bool) {
          break label841;
        }
        try
        {
          new DualMsgShowDialog(this.a, 2131362156, 0, false, 0L).show();
          return;
        }
        catch (Exception paramMessage)
        {
          return;
        }
      case 4003: 
        BaseActivity.access$100(this.a).dismissDialog();
        if (paramMessage.arg1 == 0)
        {
          paramMessage = (DeterminVerifyFactorsResult)paramMessage.obj;
          if (BaseActivity.access$200(this.a) == 25) {
            DeterminVerifyFactorsResult.a(2);
          }
          postDelayed(new bq(this, paramMessage), 10L);
          return;
        }
        break;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      return;
    }
    paramMessage = (f)paramMessage.obj;
    h.c("err " + paramMessage.a);
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    BaseActivity.access$100(this.a).showUserDialog(2131230843, paramMessage.c, 2131230897, null);
    return;
    paramMessage = (byte[])paramMessage.obj;
    if (paramMessage != null)
    {
      this.a.mAqSig = paramMessage;
      cw.a().a(this.a.mUin, paramMessage, this.a.fHandler, BaseActivity.access$300(this.a));
      return;
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      this.a.mAqSig = arrayOfByte;
      if ((i == 0) && (arrayOfByte != null))
      {
        this.a.getA2Succ();
        return;
      }
      this.a.getA2Fail(paramMessage, i);
      return;
      if (i == 0)
      {
        cw.a().a(this.a.mUin, this.a.mAqSig, this.a.fHandler, BaseActivity.access$300(this.a), 1);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      h.c("err " + paramMessage.a);
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      BaseActivity.access$100(this.a).showToast(paramMessage.c);
      return;
      BaseActivity.access$100(this.a).dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        BaseActivity.access$100(this.a).showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      BaseActivity.access$100(this.a).showToast(2131231411);
      return;
      if (paramMessage.arg1 == 0) {
        if (paramMessage.arg2 != 1) {
          break label842;
        }
      }
    }
    for (;;)
    {
      paramMessage = new Intent(BaseActivity.access$100(this.a), NoCheckWithAuthActivity.class);
      paramMessage.putExtra("bindTokenSucc", true);
      paramMessage.putExtra("bindMobileSucc", bool);
      BaseActivity.access$100(this.a).startActivity(paramMessage);
      return;
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      BaseActivity.access$100(this.a).showUserDialog(2131230779, paramMessage.c, 2131230897, null);
      return;
      label841:
      return;
      label842:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bp
 * JD-Core Version:    0.7.0.1
 */