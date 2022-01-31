package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.bb;
import com.tencent.token.bd;
import com.tencent.token.ea;
import com.tencent.token.fo;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class acq
  extends bo
{
  acq(UnbindUinActivity paramUnbindUinActivity)
  {
    super(paramUnbindUinActivity);
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
            e.a("msg.what=" + paramMessage.what + ", timetask=" + UnbindUinActivity.access$000(this.a));
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
          UnbindUinActivity.access$302(this.a, ea.c);
          if ((UnbindUinActivity.access$300(this.a) == null) || (UnbindUinActivity.access$300(this.a).length() <= 0))
          {
            this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362223), 2131361800, null);
            return;
          }
          if ((ea.d == null) || (ea.d.length() <= 0))
          {
            this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362224), 2131361800, null);
            return;
          }
          e.c("sms channel: " + UnbindUinActivity.access$300(this.a));
          this.a.sendUnBindUinSmsBySMSAPP(UnbindUinActivity.access$300(this.a), ea.d);
          this.a.showProgressDialog();
          return;
        }
        paramMessage = (d)paramMessage.obj;
        if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
          d.a(this.a.getResources(), paramMessage);
        }
        this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
        return;
      } while (!UnbindUinActivity.access$000(this.a));
      UnbindUinActivity.access$402(this.a, this.a.getString(2131361834));
      this.a.removeTimeTask();
      this.a.sendUnBindUinSmsBySMSAPP(UnbindUinActivity.access$300(this.a), ea.d);
      return;
      UnbindUinActivity.access$502(this.a, true);
      this.a.dismissDialog();
      this.a.removeTimeTask();
      ax.a().b(UnbindUinActivity.access$600(this.a));
      ax.a().n();
      ax.a();
      ax.b();
      bd.a().f.a(UnbindUinActivity.access$100(this.a));
      bb.a().f.a(UnbindUinActivity.access$100(this.a));
      AccountPageActivity.mNeedRefreshEval = true;
      SettingPageActivity.mNeedRefreshMbInfo = true;
      this.a.showUserDialog(2131361904, this.a.getString(2131361841) + Long.toString(UnbindUinActivity.access$200(this.a)) + this.a.getString(2131361906), 2131361800, UnbindUinActivity.access$700(this.a), UnbindUinActivity.access$800(this.a));
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
    UnbindUinActivity.access$402(this.a, this.a.getString(2131361952));
    UnbindUinActivity.access$900(this.a, UnbindUinActivity.access$400(this.a));
    return;
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      UnbindUinActivity.access$1000(this.a);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    this.a.showToast(paramMessage.c);
    return;
    if (paramMessage.arg1 == 0)
    {
      af.a().a(UnbindUinActivity.access$100(this.a), UnbindUinActivity.access$200(this.a), this.a.handler);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    if ((paramMessage.a == 146) && (this.a.mUnBindRetryTimes < 4))
    {
      postDelayed(this.a.mUnBindRunnable, 10000L);
      return;
    }
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
    return;
    if (paramMessage.arg1 == 0)
    {
      UnbindUinActivity.access$502(this.a, true);
      this.a.dismissDialog();
      this.a.removeTimeTask();
      ax.a().b(UnbindUinActivity.access$600(this.a));
      ax.a().n();
      bd.a().f.a(UnbindUinActivity.access$100(this.a));
      bb.a().f.a(UnbindUinActivity.access$100(this.a));
      AccountPageActivity.mNeedRefreshEval = true;
      SettingPageActivity.mNeedRefreshMbInfo = true;
      this.a.showUserDialog(2131361904, this.a.getString(2131361841) + Long.toString(UnbindUinActivity.access$200(this.a)) + this.a.getString(2131361906), 2131361800, UnbindUinActivity.access$700(this.a), UnbindUinActivity.access$800(this.a));
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    this.a.dismissDialog();
    this.a.removeTimeTask();
    UnbindUinActivity.access$900(this.a, paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acq
 * JD-Core Version:    0.7.0.1
 */