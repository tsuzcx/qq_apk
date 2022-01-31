package com.tencent.token.ui;

import android.os.Message;
import android.view.View;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class aga
  extends bo
{
  aga(UtilsTokenLabActivity paramUtilsTokenLabActivity)
  {
    super(paramUtilsTokenLabActivity);
  }
  
  public final void handleMessage(Message paramMessage)
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
        UtilsTokenLabActivity.access$400(this.a, paramMessage.arg1, UtilsTokenLabActivity.access$200(this.a), UtilsTokenLabActivity.access$300(this.a), true);
        return;
      }
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      e.c("mailprotect load failed:" + paramMessage.a + "-" + paramMessage.b);
      UtilsTokenLabActivity.access$400(this.a, paramMessage.a, paramMessage.c, null, false);
      return;
      this.a.dismissDialog();
      if (paramMessage.arg1 != 0) {
        break;
      }
      UtilsTokenLabActivity.access$102(this.a, (RealNameStatusResult)paramMessage.obj);
    } while (UtilsTokenLabActivity.access$100(this.a).mRealStatus != 1);
    UtilsTokenLabActivity.access$500(this.a).setVisibility(0);
    return;
    paramMessage = (d)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aga
 * JD-Core Version:    0.7.0.1
 */