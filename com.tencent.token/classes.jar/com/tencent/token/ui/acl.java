package com.tencent.token.ui;

import android.os.Message;
import android.widget.ListView;
import com.tencent.token.dr;
import com.tencent.token.eo;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class acl
  extends cb
{
  acl(UtilsGameProtectActivity paramUtilsGameProtectActivity)
  {
    super(paramUtilsGameProtectActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.isFinishing())) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 3001: 
            this.a.mIsIniting = false;
            if (paramMessage.arg1 != 0) {
              break label183;
            }
            this.a.hideTip();
          }
        } while (UtilsGameProtectActivity.access$100(this.a) <= 0);
        i = dr.a().d.b(UtilsGameProtectActivity.access$100(this.a)) - 1;
        h.b("want find indexID =" + UtilsGameProtectActivity.access$100(this.a) + " result=" + i);
      } while (i <= 0);
      UtilsGameProtectActivity.access$200(this.a).post(new acm(this, i));
      return;
    } while (UtilsGameProtectActivity.access$000(this.a) == null);
    UtilsGameProtectActivity.access$000(this.a).notifyDataSetChanged();
    return;
    label183:
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("game protect load failed:" + paramMessage.a + "-" + paramMessage.b);
    if ((111 == paramMessage.a) || (110 == paramMessage.a) || (103 == paramMessage.a))
    {
      this.a.showTip(paramMessage.a, UtilsGameProtectActivity.access$300(this.a), UtilsGameProtectActivity.access$400(this.a), true);
      return;
    }
    this.a.showTip(paramMessage.a, paramMessage.c, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acl
 * JD-Core Version:    0.7.0.1
 */