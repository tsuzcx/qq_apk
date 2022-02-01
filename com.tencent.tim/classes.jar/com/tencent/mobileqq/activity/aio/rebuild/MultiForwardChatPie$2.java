package com.tencent.mobileqq.activity.aio.rebuild;

import ajlc;
import android.os.Message;
import java.util.List;
import mqq.os.MqqHandler;
import ybl;

public class MultiForwardChatPie$2
  implements Runnable
{
  public MultiForwardChatPie$2(ybl paramybl) {}
  
  public void run()
  {
    List localList = ajlc.a().a(this.this$0.app, this.this$0.uniseq);
    Message localMessage = this.this$0.x.obtainMessage(0);
    localMessage.obj = localList;
    this.this$0.x.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.2
 * JD-Core Version:    0.7.0.1
 */