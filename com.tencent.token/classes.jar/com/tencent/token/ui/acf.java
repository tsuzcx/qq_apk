package com.tencent.token.ui;

import android.os.Message;
import android.widget.ListView;
import com.tencent.token.dr;
import com.tencent.token.en;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.SecondVerifyDialog;
import com.tencent.token.ui.base.dj;

class acf
  extends cb
{
  acf(UtilsGameLockActivity paramUtilsGameLockActivity)
  {
    super(paramUtilsGameLockActivity);
  }
  
  public void handleMessage(Message paramMessage)
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
                    UtilsGameLockActivity.access$000(this.a).a(false);
                  }
                } while (3 != paramMessage.arg1);
                UtilsGameLockActivity.access$000(this.a).b();
                return;
              } while (3 != paramMessage.arg1);
              paramMessage = new SecondVerifyDialog(this.a, 2131362182, this.a.mHandler, paramMessage.arg1);
              paramMessage.setCancelable(true);
              paramMessage.show();
              return;
              UtilsGameLockActivity.access$000(this.a).a(false);
            } while (3 != paramMessage.arg1);
            UtilsGameLockActivity.access$000(this.a).a();
            return;
          } while (UtilsGameLockActivity.access$000(this.a) == null);
          UtilsGameLockActivity.access$000(this.a).notifyDataSetChanged();
          return;
          paramMessage = (dj)paramMessage.obj;
        } while ((paramMessage == null) || (UtilsGameLockActivity.access$000(this.a) == null));
        UtilsGameLockActivity.access$000(this.a).a(paramMessage, true);
        return;
        UtilsGameLockActivity.access$102(this.a, false);
        if (paramMessage.arg1 != 0) {
          break;
        }
        this.a.hideTip();
      } while (UtilsGameLockActivity.access$200(this.a) <= 0);
      i = dr.a().c.b(UtilsGameLockActivity.access$200(this.a)) - 1;
      h.b("want find indexID =" + UtilsGameLockActivity.access$200(this.a) + " result=" + i);
    } while (i <= 0);
    UtilsGameLockActivity.access$300(this.a).post(new acg(this, i));
    return;
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("game lock load failed:" + paramMessage.a + "-" + paramMessage.b);
    if ((111 == paramMessage.a) || (110 == paramMessage.a) || (103 == paramMessage.a))
    {
      this.a.showTip(paramMessage.a, UtilsGameLockActivity.access$400(this.a), UtilsGameLockActivity.access$500(this.a), true);
      return;
    }
    this.a.showTip(paramMessage.a, paramMessage.c, null, false);
    return;
    f localf;
    if (paramMessage.arg1 == 0)
    {
      localf = new f(0);
      paramMessage = localf;
      if (jy.b) {
        this.a.showOrangeToast(2131231544, 2130838017);
      }
    }
    for (paramMessage = localf;; paramMessage = (f)paramMessage.obj)
    {
      jy.b = false;
      UtilsGameLockActivity.access$000(this.a).a(paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acf
 * JD-Core Version:    0.7.0.1
 */