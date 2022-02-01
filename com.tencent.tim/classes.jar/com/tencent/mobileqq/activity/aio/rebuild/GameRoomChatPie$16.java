package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import aree;
import mqq.os.MqqHandler;
import xzp;

public class GameRoomChatPie$16
  implements Runnable
{
  public GameRoomChatPie$16(xzp paramxzp) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (this.this$0.mActivity.isFinishing()) {
        return;
      }
      this.this$0.a.a(this.this$0.a(), this.this$0);
      xzp.a(this.this$0).post(new GameRoomChatPie.16.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.16
 * JD-Core Version:    0.7.0.1
 */