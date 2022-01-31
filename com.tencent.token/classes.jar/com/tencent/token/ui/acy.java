package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.SecondVerifyDialog;
import com.tencent.token.ui.base.ds;

final class acy
  extends bo
{
  acy(UtilsAccountLockActivity paramUtilsAccountLockActivity)
  {
    super(paramUtilsAccountLockActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if ((this.a == null) || (this.a.isFinishing())) {}
    do
    {
      do
      {
        do
        {
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
            } while (3 != paramMessage.arg1);
            UtilsAccountLockActivity.access$000(this.a).b();
            UtilsAccountLockActivity.access$000(this.a).d();
            return;
            k localk = UtilsAccountLockActivity.access$000(this.a);
            ds localds = (ds)paramMessage.obj;
            if (paramMessage.arg1 == 1) {}
            for (;;)
            {
              localk.b(localds, bool);
              return;
              bool = false;
            }
          } while (3 != paramMessage.arg1);
          paramMessage = new SecondVerifyDialog(this.a, this.a.mHandler, paramMessage.arg1);
          paramMessage.setCancelable(true);
          paramMessage.show();
          return;
        } while (3 != paramMessage.arg1);
        UtilsAccountLockActivity.access$000(this.a).b();
        UtilsAccountLockActivity.access$000(this.a).c();
        return;
      } while (UtilsAccountLockActivity.access$000(this.a) == null);
      UtilsAccountLockActivity.access$000(this.a).a();
      UtilsAccountLockActivity.access$000(this.a).notifyDataSetChanged();
      return;
      paramMessage = (ds)paramMessage.obj;
    } while ((paramMessage == null) || (UtilsAccountLockActivity.access$000(this.a) == null));
    UtilsAccountLockActivity.access$000(this.a).a(paramMessage, true);
    return;
    UtilsAccountLockActivity.access$102(this.a, false);
    if (paramMessage.arg1 == 0)
    {
      this.a.hideTip();
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("game lock load failed:" + paramMessage.a + "-" + paramMessage.b);
    if ((111 == paramMessage.a) || (110 == paramMessage.a) || (103 == paramMessage.a))
    {
      this.a.showTip(paramMessage.a, UtilsAccountLockActivity.access$200(this.a), UtilsAccountLockActivity.access$300(this.a), true);
      return;
    }
    this.a.showTip(paramMessage.a, paramMessage.c, null, false);
    return;
    if (paramMessage.arg1 == 0) {}
    for (paramMessage = new d();; paramMessage = (d)paramMessage.obj)
    {
      UtilsAccountLockActivity.access$000(this.a).a(paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acy
 * JD-Core Version:    0.7.0.1
 */