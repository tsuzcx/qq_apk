package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetSMSChannel;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.ds;
import com.tencent.token.du;
import com.tencent.token.er;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class aba
  extends cb
{
  aba(UnbindUinActivity paramUnbindUinActivity)
  {
    super(paramUnbindUinActivity);
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
            h.a("msg.what=" + paramMessage.what + ", timetask=" + UnbindUinActivity.access$000(this.a));
            switch (paramMessage.what)
            {
            default: 
              return;
            }
          } while (!UnbindUinActivity.access$000(this.a));
          this.a.mUnBindRetryTimes = 0;
          postDelayed(this.a.mUnBindRunnable, 10000L);
          return;
        } while (!UnbindUinActivity.access$000(this.a));
        if (paramMessage.arg1 == 0)
        {
          UnbindUinActivity.access$302(this.a, ProtoGetSMSChannel.d);
          if ((UnbindUinActivity.access$300(this.a) == null) || (UnbindUinActivity.access$300(this.a).length() <= 0))
          {
            this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231591), 2131230897, null);
            return;
          }
          if ((ProtoGetSMSChannel.e == null) || (ProtoGetSMSChannel.e.length() <= 0))
          {
            this.a.showUserDialog(2131230843, this.a.getResources().getString(2131231592), 2131230897, null);
            return;
          }
          h.c("sms channel: " + UnbindUinActivity.access$300(this.a));
          this.a.sendUnBindUinSmsBySMSAPP(UnbindUinActivity.access$300(this.a), ProtoGetSMSChannel.e);
          this.a.showProgressDialog();
          return;
        }
        paramMessage = (f)paramMessage.obj;
        if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
          f.a(this.a.getResources(), paramMessage);
        }
        this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
        return;
      } while (!UnbindUinActivity.access$000(this.a));
      UnbindUinActivity.access$402(this.a, this.a.getString(2131230791));
      this.a.removeTimeTask();
      this.a.sendUnBindUinSmsBySMSAPP(UnbindUinActivity.access$300(this.a), ProtoGetSMSChannel.e);
      return;
      UnbindUinActivity.access$502(this.a, true);
      this.a.dismissDialog();
      this.a.removeTimeTask();
      do.a().b(UnbindUinActivity.access$600(this.a));
      do.a().n();
      do.a().b();
      du.a().f.a(UnbindUinActivity.access$100(this.a));
      ds.a().f.a(UnbindUinActivity.access$100(this.a));
      AccountPageActivity.mNeedRefreshEval = true;
      this.a.showUserDialog(0, this.a.getString(2131230763) + Long.toString(UnbindUinActivity.access$200(this.a)) + this.a.getString(2131231511), 2131230897, UnbindUinActivity.access$700(this.a), UnbindUinActivity.access$800(this.a));
      return;
    } while (!UnbindUinActivity.access$000(this.a));
    paramMessage = paramMessage.getData();
    int i = paramMessage.getInt("errCode");
    paramMessage = paramMessage.getString("error");
    if ((1 == i) && (this.a.mUnBindRetryTimes < 4))
    {
      postDelayed(this.a.mUnBindRunnable, 10000L);
      return;
    }
    UnbindUinActivity.access$402(this.a, paramMessage);
    this.a.dismissDialog();
    this.a.removeTimeTask();
    UnbindUinActivity.access$900(this.a, UnbindUinActivity.access$400(this.a));
    return;
    this.a.dismissDialog();
    this.a.removeTimeTask();
    UnbindUinActivity.access$402(this.a, this.a.getString(2131230964));
    UnbindUinActivity.access$900(this.a, UnbindUinActivity.access$400(this.a));
    return;
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      UnbindUinActivity.access$1000(this.a);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    this.a.showToast(paramMessage.c);
    return;
    if (paramMessage.arg1 == 0)
    {
      cw.a().a(UnbindUinActivity.access$100(this.a), UnbindUinActivity.access$200(this.a), 1, this.a.handler);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    if ((paramMessage.a == 146) && (this.a.mUnBindRetryTimes < 4))
    {
      postDelayed(this.a.mUnBindRunnable, 10000L);
      return;
    }
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
    return;
    if (paramMessage.arg1 == 0)
    {
      UnbindUinActivity.access$502(this.a, true);
      this.a.dismissDialog();
      this.a.removeTimeTask();
      do.a().b(UnbindUinActivity.access$600(this.a));
      do.a().n();
      du.a().f.a(UnbindUinActivity.access$100(this.a));
      ds.a().f.a(UnbindUinActivity.access$100(this.a));
      AccountPageActivity.mNeedRefreshEval = true;
      this.a.showUserDialog(0, this.a.getString(2131231512) + Long.toString(UnbindUinActivity.access$200(this.a)) + this.a.getString(2131231511), 2131230897, UnbindUinActivity.access$700(this.a), UnbindUinActivity.access$800(this.a));
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    this.a.dismissDialog();
    this.a.removeTimeTask();
    UnbindUinActivity.access$900(this.a, paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aba
 * JD-Core Version:    0.7.0.1
 */