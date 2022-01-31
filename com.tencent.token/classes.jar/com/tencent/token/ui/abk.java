package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.SecondVerifyDialog;
import com.tencent.token.ui.base.dj;

class abk
  extends cb
{
  abk(UtilsAccountLockActivity paramUtilsAccountLockActivity)
  {
    super(paramUtilsAccountLockActivity);
  }
  
  public void handleMessage(Message paramMessage)
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
            UtilsAccountLockActivity.access$000(this.a).a(false);
            UtilsAccountLockActivity.access$000(this.a).c();
            return;
            i locali = UtilsAccountLockActivity.access$000(this.a);
            dj localdj = (dj)paramMessage.obj;
            if (paramMessage.arg1 == 1) {}
            for (;;)
            {
              locali.b(localdj, bool);
              return;
              bool = false;
            }
          } while (3 != paramMessage.arg1);
          paramMessage = new SecondVerifyDialog(this.a, 2131362182, this.a.mHandler, paramMessage.arg1);
          paramMessage.setCancelable(true);
          paramMessage.show();
          return;
        } while (3 != paramMessage.arg1);
        UtilsAccountLockActivity.access$000(this.a).a(false);
        UtilsAccountLockActivity.access$000(this.a).b();
        return;
      } while (UtilsAccountLockActivity.access$000(this.a) == null);
      UtilsAccountLockActivity.access$000(this.a).a();
      UtilsAccountLockActivity.access$000(this.a).notifyDataSetChanged();
      return;
      paramMessage = (dj)paramMessage.obj;
    } while ((paramMessage == null) || (UtilsAccountLockActivity.access$000(this.a) == null));
    UtilsAccountLockActivity.access$000(this.a).a(paramMessage, true);
    return;
    UtilsAccountLockActivity.access$102(this.a, false);
    if (paramMessage.arg1 == 0)
    {
      this.a.hideTip();
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("game lock load failed:" + paramMessage.a + "-" + paramMessage.b);
    if ((111 == paramMessage.a) || (110 == paramMessage.a) || (103 == paramMessage.a))
    {
      this.a.showTip(paramMessage.a, UtilsAccountLockActivity.access$200(this.a), UtilsAccountLockActivity.access$300(this.a), true);
      return;
    }
    this.a.showTip(paramMessage.a, paramMessage.c, null, false);
    return;
    if (paramMessage.arg1 == 0) {}
    for (paramMessage = new f(0);; paramMessage = (f)paramMessage.obj)
    {
      UtilsAccountLockActivity.access$000(this.a).a(paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abk
 * JD-Core Version:    0.7.0.1
 */