package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.dr;
import com.tencent.token.global.f;

class aej
  extends cb
{
  aej(UtilsQbQdProtectActivity paramUtilsQbQdProtectActivity)
  {
    super(paramUtilsQbQdProtectActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.isFinishing())) {
      return;
    }
    Object localObject = dr.a().g();
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3001: 
      if (paramMessage.arg1 == 0)
      {
        UtilsQbQdProtectActivity.access$300(this.a);
        return;
      }
      break;
    case 3061: 
      ((com.tencent.token.core.bean.h)localObject).e = false;
      boolean bool;
      if (paramMessage.arg1 == 0) {
        if (!((com.tencent.token.core.bean.h)localObject).c)
        {
          bool = true;
          ((com.tencent.token.core.bean.h)localObject).c = bool;
          AccountPageActivity.mNeedRefreshEval = true;
        }
      }
      for (;;)
      {
        UtilsQbQdProtectActivity.access$300(this.a);
        return;
        bool = false;
        break;
        localObject = (f)paramMessage.obj;
        f.a(this.a.getResources(), (f)localObject);
        if ((111 == paramMessage.arg1) || (110 == paramMessage.arg1) || (103 == paramMessage.arg1))
        {
          UtilsQbQdProtectActivity.access$100(this.a, ((f)localObject).a, true);
        }
        else
        {
          f.a(this.a.getResources(), (f)localObject);
          UtilsQbQdProtectActivity.access$200(this.a, ((f)localObject).c);
        }
      }
    }
    if ((111 == paramMessage.arg1) || (110 == paramMessage.arg1) || (103 == paramMessage.arg1))
    {
      UtilsQbQdProtectActivity.access$100(this.a, paramMessage.arg1, true);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    com.tencent.token.global.h.c("safepage load failed:" + paramMessage.a + "-" + paramMessage.b);
    UtilsQbQdProtectActivity.access$100(this.a, paramMessage.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aej
 * JD-Core Version:    0.7.0.1
 */