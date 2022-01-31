package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetSMSChannel;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class cd
  extends cb
{
  cd(BindUinActivity paramBindUinActivity)
  {
    super(paramBindUinActivity);
  }
  
  public void handleMessage(Message paramMessage)
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
            h.c("msg what=" + paramMessage.what + "starttime=" + BindUinActivity.access$000(this.a));
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
          BindUinActivity.access$402(this.a, ProtoGetSMSChannel.d);
          if ((BindUinActivity.access$400(this.a) == null) || (BindUinActivity.access$400(this.a).length() <= 0))
          {
            this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231591), 2131230897, null);
            return;
          }
          if ((ProtoGetSMSChannel.e == null) || (ProtoGetSMSChannel.e.length() <= 0))
          {
            this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231592), 2131230897, null);
            return;
          }
          h.c("sms channel: " + BindUinActivity.access$400(this.a));
          BindUinActivity.access$500(this.a, BindUinActivity.access$400(this.a), ProtoGetSMSChannel.e);
          this.a.showProgressDialog();
          return;
        }
        paramMessage = (f)paramMessage.obj;
        if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
          f.a(this.a.getResources(), paramMessage);
        }
        this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
        return;
      } while (!BindUinActivity.access$000(this.a));
      h.c("removeTimeTask SendSmsFail");
      this.a.removeTimeTask();
      BindUinActivity.access$500(this.a, BindUinActivity.access$400(this.a), ProtoGetSMSChannel.e);
      return;
      this.a.dismissDialog();
      h.c("removeTimeTask BindUinToSeqSuccess");
      this.a.removeTimeTask();
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
    h.c("removeTimeTask BindUinToSeqFail");
    this.a.removeTimeTask();
    BindUinActivity.access$700(this.a, paramMessage);
    return;
    this.a.dismissDialog();
    h.c("removeTimeTask HttpError");
    this.a.removeTimeTask();
    BindUinActivity.access$700(this.a, this.a.getString(2131230964));
    return;
    i = paramMessage.getData().getInt("serTime");
    long l = System.currentTimeMillis();
    l = i * 1000L - l;
    cx.c().a(l);
    h.b("set time plus: " + l);
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
      cw.a().c(Long.parseLong(BindUinActivity.access$300(this.a)), BindUinActivity.access$800(this.a).f(), "", "", this.a.mHandler);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    if ((paramMessage.a == 146) && (BindUinActivity.access$100(this.a) < 4))
    {
      postDelayed(this.a.mBindRunnable, 10000L);
      return;
    }
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
    return;
    this.a.dismissDialog();
    this.a.removeTimeTask();
    if (paramMessage.arg1 == 0)
    {
      BindUinActivity.access$600(this.a);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("query up flow failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
    this.a.showUserDialog(2131230779, paramMessage.c, 2131230897, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cd
 * JD-Core Version:    0.7.0.1
 */