package com.tencent.mobileqq.app;

import achs;
import aczx;
import android.util.Pair;
import java.util.Calendar;

public class MessageRoamManager$4
  implements Runnable
{
  public MessageRoamManager$4(achs paramachs, Calendar paramCalendar) {}
  
  public void run()
  {
    Pair localPair = this.this$0.a((Calendar)this.y.clone());
    int i = this.this$0.a(this.this$0.mFriendUin, ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
    if (i >= 8)
    {
      this.this$0.z(0, null);
      return;
    }
    this.this$0.a.a(this.this$0.mFriendUin, (Calendar)this.y.clone(), true, 8 - i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.4
 * JD-Core Version:    0.7.0.1
 */