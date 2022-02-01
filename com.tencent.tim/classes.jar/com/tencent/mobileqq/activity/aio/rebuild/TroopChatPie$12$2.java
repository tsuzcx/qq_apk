package com.tencent.mobileqq.activity.aio.rebuild;

import jof;
import jog;
import mqq.os.MqqHandler;
import yeh;

public class TroopChatPie$12$2
  implements Runnable
{
  public TroopChatPie$12$2(yeh paramyeh) {}
  
  public void run()
  {
    if (this.a.this$0.b != null) {
      this.a.this$0.b.dismiss();
    }
    this.a.this$0.zh(true);
    TroopChatPie.d(this.a.this$0).postDelayed(new TroopChatPie.12.2.1(this), 100L);
    if (!jof.a(this.a.this$0.mActivity, this.a.this$0.app)) {
      TroopChatPie.e(this.a.this$0).postDelayed(new TroopChatPie.12.2.2(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.2
 * JD-Core Version:    0.7.0.1
 */