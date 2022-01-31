package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.ba;
import com.tencent.token.core.bean.g;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class afv
  extends bo
{
  afv(UtilsQbQdProtectActivity paramUtilsQbQdProtectActivity)
  {
    super(paramUtilsQbQdProtectActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.isFinishing())) {
      return;
    }
    Object localObject = ba.a().g();
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3001: 
      if (paramMessage.arg1 == 0)
      {
        UtilsQbQdProtectActivity.access$500(this.a);
        return;
      }
      break;
    case 3018: 
      ((g)localObject).e = false;
      boolean bool;
      if (paramMessage.arg1 == 0) {
        if (!((g)localObject).c)
        {
          bool = true;
          ((g)localObject).c = bool;
          AccountPageActivity.mNeedRefreshEval = true;
        }
      }
      for (;;)
      {
        UtilsQbQdProtectActivity.access$500(this.a);
        return;
        bool = false;
        break;
        localObject = (d)paramMessage.obj;
        d.a(this.a.getResources(), (d)localObject);
        if ((111 == paramMessage.arg1) || (110 == paramMessage.arg1) || (103 == paramMessage.arg1))
        {
          UtilsQbQdProtectActivity.access$300(this.a, ((d)localObject).a, UtilsQbQdProtectActivity.access$100(this.a), UtilsQbQdProtectActivity.access$200(this.a), true);
        }
        else
        {
          d.a(this.a.getResources(), (d)localObject);
          UtilsQbQdProtectActivity.access$400(this.a, ((d)localObject).c);
        }
      }
    }
    if ((111 == paramMessage.arg1) || (110 == paramMessage.arg1) || (103 == paramMessage.arg1))
    {
      UtilsQbQdProtectActivity.access$300(this.a, paramMessage.arg1, UtilsQbQdProtectActivity.access$100(this.a), UtilsQbQdProtectActivity.access$200(this.a), true);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("safepage load failed:" + paramMessage.a + "-" + paramMessage.b);
    UtilsQbQdProtectActivity.access$300(this.a, paramMessage.a, paramMessage.c, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afv
 * JD-Core Version:    0.7.0.1
 */