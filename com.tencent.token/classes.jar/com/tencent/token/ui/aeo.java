package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class aeo
  extends cb
{
  aeo(UtilsTokenLabActivity paramUtilsTokenLabActivity)
  {
    super(paramUtilsTokenLabActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.isFinishing())) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        }
      } while (paramMessage.arg1 == 0);
      if ((111 == paramMessage.arg1) || (110 == paramMessage.arg1) || (103 == paramMessage.arg1))
      {
        UtilsTokenLabActivity.access$200(this.a, paramMessage.arg1, true);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      h.c("mailprotect load failed:" + paramMessage.a + "-" + paramMessage.b);
      UtilsTokenLabActivity.access$200(this.a, paramMessage.a, false);
      return;
      this.a.dismissDialog();
      if (paramMessage.arg1 != 0) {
        break;
      }
      UtilsTokenLabActivity.access$102(this.a, (RealNameStatusResult)paramMessage.obj);
    } while (UtilsTokenLabActivity.access$100(this.a).mRealStatus != 1);
    UtilsTokenLabActivity.access$300(this.a).setVisibility(0);
    return;
    paramMessage = (f)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
    return;
    this.a.dismissDialog();
    if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
    {
      this.a.showUserDialog(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
      return;
    }
    this.a.showUserDialog(this.a.getResources().getString(2131231411));
    return;
    UtilsTokenLabActivity.access$400(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aeo
 * JD-Core Version:    0.7.0.1
 */