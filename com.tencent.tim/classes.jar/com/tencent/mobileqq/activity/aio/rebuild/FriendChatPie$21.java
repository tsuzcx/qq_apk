package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import ton;
import top;
import wkk;
import xys;

public class FriendChatPie$21
  implements Runnable
{
  public FriendChatPie$21(xys paramxys) {}
  
  public void run()
  {
    if (!top.V(this.this$0.app.a(this.this$0.sessionInfo.cZ).l(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ))) {}
    do
    {
      return;
      xys.a(this.this$0, SystemClock.uptimeMillis());
      ((wkk)xys.a(this.this$0).context).fU(xys.b(this.this$0));
      xys.b(this.this$0).aQi = false;
      xys.c(this.this$0).aQj = true;
    } while (xys.d(this.this$0).bCT != 0);
    QQMessageFacade.b localb = xys.e(this.this$0);
    localb.bCT += 1;
    this.this$0.app.b().a(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, 15, xys.f(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.21
 * JD-Core Version:    0.7.0.1
 */