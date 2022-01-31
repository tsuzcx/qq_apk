package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.af;
import com.tencent.token.av;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.DualMsgShowDialog;

final class bd
  extends bo
{
  bd(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    e.a("dualmsg,what=" + paramMessage.what + ", ret=" + paramMessage.arg1);
    int i = paramMessage.arg1;
    switch (paramMessage.what)
    {
    default: 
    case 3069: 
    case 3030: 
    case 1019: 
      do
      {
        do
        {
          return;
        } while ((paramMessage.arg1 != 0) || (av.a().b() <= 0) || (RqdApplication.b));
        try
        {
          new DualMsgShowDialog(this.a, false, 0L).show();
          return;
        }
        catch (Exception paramMessage)
        {
          return;
        }
        BaseActivity.access$100(this.a).dismissDialog();
        if (paramMessage.arg1 == 0)
        {
          BaseActivity.access$202(this.a, (UpgradeDeterminResult)paramMessage.obj);
          BaseActivity.access$300(this.a, BaseActivity.access$200(this.a));
          return;
        }
        paramMessage = (d)paramMessage.obj;
        e.c("err " + paramMessage.a);
        d.a(this.a.getResources(), paramMessage);
        e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
        BaseActivity.access$100(this.a).showUserDialog(2131361831, paramMessage.c, 2131361800, null);
        return;
        paramMessage = (byte[])paramMessage.obj;
      } while (paramMessage == null);
      this.a.mAqSig = paramMessage;
      af.a().a(this.a.mUin, paramMessage, this.a.fHandler, 2);
      return;
    case 4097: 
    case 4098: 
      paramMessage = (byte[])paramMessage.obj;
      this.a.mAqSig = paramMessage;
      if ((i == 0) && (paramMessage != null))
      {
        this.a.getA2Succ();
        return;
      }
      this.a.getA2Fail(i);
      return;
    case 3024: 
      if (i == 0)
      {
        af.a().a(this.a.mUin, this.a.mAqSig, this.a.fHandler);
        return;
      }
      paramMessage = (d)paramMessage.obj;
      e.c("err " + paramMessage.a);
      d.a(this.a.getResources(), paramMessage);
      e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      BaseActivity.access$100(this.a).showToast(paramMessage.c);
      return;
    case 4104: 
      BaseActivity.access$100(this.a).dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        BaseActivity.access$100(this.a).showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      BaseActivity.access$100(this.a).showToast(2131362091);
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      if (paramMessage.arg2 == 1) {
        bool = true;
      }
      paramMessage = new Intent(BaseActivity.access$100(this.a), NoCheckWithAuthActivity.class);
      paramMessage.putExtra("bindTokenSucc", true);
      paramMessage.putExtra("bindMobileSucc", bool);
      BaseActivity.access$100(this.a).startActivity(paramMessage);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    BaseActivity.access$100(this.a).showUserDialog(2131361831, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bd
 * JD-Core Version:    0.7.0.1
 */