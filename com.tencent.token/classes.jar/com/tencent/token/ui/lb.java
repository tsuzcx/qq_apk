package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;

class lb
  extends cb
{
  lb(HelpActivity paramHelpActivity)
  {
    super(paramHelpActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      HelpActivity.access$100(this.a, HelpActivity.access$000(this.a));
      return;
    }
    QQUser localQQUser = do.a().e();
    if (localQQUser != null)
    {
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      if ((paramMessage.arg1 == 0) && (arrayOfByte != null))
      {
        HelpActivity.access$002(this.a, "https://ssl.ptlogin2.qq.com/jump?keyindex=19&clientuin=" + localQQUser.mRealUin + "&clientkey=" + w.a(arrayOfByte) + "&u1=" + HelpActivity.access$000(this.a));
        h.c("skey: url=" + HelpActivity.access$000(this.a));
      }
    }
    HelpActivity.access$100(this.a, HelpActivity.access$000(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.lb
 * JD-Core Version:    0.7.0.1
 */