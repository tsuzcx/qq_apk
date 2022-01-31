package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ch;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.global.f;

class zz
  extends Handler
{
  zz(StartPwdGestureModifyActivity paramStartPwdGestureModifyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1008: 
      if (paramMessage.arg1 == 0)
      {
        this.a.dismissDialog();
        paramMessage = do.a().e();
        if (paramMessage == null)
        {
          ch.a().a(System.currentTimeMillis(), 23);
          StartPwdGestureModifyActivity.access$000(this.a, this.a, 2131231099, 2131231101);
          return;
        }
        this.a.dismissDialog();
        cp.a(this.a.getApplicationContext()).a(this.a, 523005419L, StartPwdGestureModifyActivity.access$100(this.a), paramMessage.mRealUin + "");
        return;
      }
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    case 4104: 
      this.a.dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      this.a.showToast(2131231411);
      return;
    }
    StartPwdGestureModifyActivity.access$200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zz
 * JD-Core Version:    0.7.0.1
 */