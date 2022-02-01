package com.tencent.mobileqq.activity.aio.rebuild;

import ajpj;
import anov;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import ybt;
import ycc;

public class NearbyChatPieObserver$1
  implements Runnable
{
  public NearbyChatPieObserver$1(ycc paramycc, boolean paramBoolean, String paramString, ajpj paramajpj) {}
  
  public void run()
  {
    anov localanov = new anov(ycc.a(this.this$0).app).a("dc00899").b("grp_lbs").c("data_card");
    if (this.val$isSuccess) {}
    for (String str = "msg_suc";; str = "msg_fail")
    {
      localanov.d(str).e(ycc.a(this.this$0).sessionInfo.aTl).a(new String[] { this.aXh, String.valueOf(this.a.GA()) }).report();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPieObserver.1
 * JD-Core Version:    0.7.0.1
 */