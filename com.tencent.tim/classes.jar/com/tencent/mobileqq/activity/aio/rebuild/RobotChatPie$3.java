package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import android.os.Message;
import mqq.os.MqqHandler;
import ydw;

public class RobotChatPie$3
  implements Runnable
{
  public RobotChatPie$3(ydw paramydw) {}
  
  public void run()
  {
    Message localMessage = ydw.a(this.this$0).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    ydw.b(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie.3
 * JD-Core Version:    0.7.0.1
 */