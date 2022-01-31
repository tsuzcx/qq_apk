package com.tencent.token.ui;

import android.os.Message;
import android.widget.ListView;
import com.tencent.token.ba;
import com.tencent.token.fk;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.SecondVerifyDialog;
import com.tencent.token.ui.base.ds;

final class adr
  extends bo
{
  adr(UtilsGameLockActivity paramUtilsGameLockActivity)
  {
    super(paramUtilsGameLockActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.isFinishing())) {}
    int i;
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
              do
              {
                do
                {
                  return;
                  switch (paramMessage.what)
                  {
                  default: 
                    return;
                  case 1010: 
                  case 1012: 
                    UtilsGameLockActivity.access$000(this.a).a();
                  }
                } while (3 != paramMessage.arg1);
                UtilsGameLockActivity.access$000(this.a).c();
                return;
              } while (3 != paramMessage.arg1);
              paramMessage = new SecondVerifyDialog(this.a, this.a.mHandler, paramMessage.arg1);
              paramMessage.setCancelable(true);
              paramMessage.show();
              return;
              UtilsGameLockActivity.access$000(this.a).a();
            } while (3 != paramMessage.arg1);
            UtilsGameLockActivity.access$000(this.a).b();
            return;
          } while (UtilsGameLockActivity.access$000(this.a) == null);
          UtilsGameLockActivity.access$000(this.a).notifyDataSetChanged();
          return;
          paramMessage = (ds)paramMessage.obj;
        } while ((paramMessage == null) || (UtilsGameLockActivity.access$000(this.a) == null));
        UtilsGameLockActivity.access$000(this.a).a(paramMessage, true);
        return;
        UtilsGameLockActivity.access$102(this.a, false);
        if (paramMessage.arg1 != 0) {
          break;
        }
        this.a.hideTip();
      } while (UtilsGameLockActivity.access$200(this.a) <= 0);
      i = ba.a().c.a(UtilsGameLockActivity.access$200(this.a)) - 1;
      e.b("want find indexID =" + UtilsGameLockActivity.access$200(this.a) + " result=" + i);
    } while (i <= 0);
    UtilsGameLockActivity.access$300(this.a).post(new ads(this, i));
    return;
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("game lock load failed:" + paramMessage.a + "-" + paramMessage.b);
    if ((111 == paramMessage.a) || (110 == paramMessage.a) || (103 == paramMessage.a))
    {
      this.a.showTip(paramMessage.a, UtilsGameLockActivity.access$400(this.a), UtilsGameLockActivity.access$500(this.a), true);
      return;
    }
    this.a.showTip(paramMessage.a, paramMessage.c, null, false);
    return;
    d locald;
    if (paramMessage.arg1 == 0)
    {
      locald = new d();
      paramMessage = locald;
      if (ku.b) {
        this.a.showOrangeToast(2131362195, 2130837964);
      }
    }
    for (paramMessage = locald;; paramMessage = (d)paramMessage.obj)
    {
      ku.b = false;
      UtilsGameLockActivity.access$000(this.a).a(paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adr
 * JD-Core Version:    0.7.0.1
 */