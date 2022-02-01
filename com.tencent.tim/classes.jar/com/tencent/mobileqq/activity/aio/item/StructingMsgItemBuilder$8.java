package com.tencent.mobileqq.activity.aio.item;

import aqxg;
import aqxh;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;

class StructingMsgItemBuilder$8
  implements Runnable
{
  StructingMsgItemBuilder$8(StructingMsgItemBuilder paramStructingMsgItemBuilder, aqxg paramaqxg, aqxh paramaqxh) {}
  
  public void run()
  {
    if ((this.a.status == 1L) && (this.a.senderuin.equalsIgnoreCase(this.this$0.sessionInfo.aTl)))
    {
      this.b.E(6L, this.a.uniseq);
      ((BaseActivity)this.this$0.mContext).runOnUiThread(new StructingMsgItemBuilder.8.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */