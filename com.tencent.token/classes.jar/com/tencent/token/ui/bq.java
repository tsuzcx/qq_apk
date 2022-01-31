package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.ea;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class bq
  extends bo
{
  bq(BindUinActivity paramBindUinActivity)
  {
    super(paramBindUinActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            e.c("msg what=" + paramMessage.what + "starttime=" + BindUinActivity.access$000(this.a));
            switch (paramMessage.what)
            {
            default: 
              return;
            }
          } while (!BindUinActivity.access$000(this.a));
          BindUinActivity.access$102(this.a, 0);
          postDelayed(this.a.mBindRunnable, 10000L);
          return;
        } while (!BindUinActivity.access$000(this.a));
        if (paramMessage.arg1 == 0)
        {
          BindUinActivity.access$402(this.a, ea.c);
          if ((BindUinActivity.access$400(this.a) == null) || (BindUinActivity.access$400(this.a).length() <= 0))
          {
            this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362223), 2131361800, null);
            return;
          }
          if ((ea.d == null) || (ea.d.length() <= 0))
          {
            this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362224), 2131361800, null);
            return;
          }
          e.c("sms channel: " + BindUinActivity.access$400(this.a));
          BindUinActivity.access$500(this.a, BindUinActivity.access$400(this.a), ea.d);
          this.a.showProgressDialog();
          return;
        }
        paramMessage = (d)paramMessage.obj;
        if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
          d.a(this.a.getResources(), paramMessage);
        }
        this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
        return;
      } while (!BindUinActivity.access$000(this.a));
      e.c("removeTimeTask SendSmsFail");
      this.a.removeTimeTask(1);
      BindUinActivity.access$500(this.a, BindUinActivity.access$400(this.a), ea.d);
      return;
      this.a.dismissDialog();
      e.c("removeTimeTask BindUinToSeqSuccess");
      this.a.removeTimeTask(2);
      BindUinActivity.access$600(this.a);
      return;
    } while (!BindUinActivity.access$000(this.a));
    paramMessage = paramMessage.getData();
    int i = paramMessage.getInt("errCode");
    paramMessage = paramMessage.getString("error");
    if ((1 == i) && (BindUinActivity.access$100(this.a) < 4))
    {
      postDelayed(this.a.mBindRunnable, 10000L);
      return;
    }
    this.a.dismissDialog();
    e.c("removeTimeTask BindUinToSeqFail");
    this.a.removeTimeTask(3);
    BindUinActivity.access$700(this.a, paramMessage);
    return;
    this.a.dismissDialog();
    e.c("removeTimeTask HttpError");
    this.a.removeTimeTask(4);
    BindUinActivity.access$700(this.a, this.a.getString(2131361952));
    return;
    i = paramMessage.getData().getInt("serTime");
    long l = System.currentTimeMillis();
    l = i * 1000L - l;
    ag.c().a(l);
    e.b("set time plus: " + l);
    return;
    if (paramMessage.arg1 == 0)
    {
      if (BindUinActivity.access$200(this.a) == 13)
      {
        paramMessage = new Intent(this.a, VryMobileForStrategyActivity.class);
        paramMessage.putExtra("succ", true);
        paramMessage.setFlags(67108864);
        this.a.startActivity(paramMessage);
        this.a.finish();
        return;
      }
      af.a().c(Long.parseLong(BindUinActivity.access$300(this.a)), BindUinActivity.access$800(this.a).a(), "", "", this.a.mHandler);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    if ((paramMessage.a == 146) && (BindUinActivity.access$100(this.a) < 4))
    {
      postDelayed(this.a.mBindRunnable, 10000L);
      return;
    }
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
    return;
    this.a.dismissDialog();
    this.a.removeTimeTask(2);
    if (paramMessage.arg1 == 0)
    {
      BindUinActivity.access$600(this.a);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131361831, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bq
 * JD-Core Version:    0.7.0.1
 */