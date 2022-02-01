package com.tencent.mobileqq.app;

import achs;
import android.util.Pair;
import java.util.Calendar;
import java.util.List;

public class MessageRoamManager$3
  implements Runnable
{
  public MessageRoamManager$3(achs paramachs, int paramInt) {}
  
  public void run()
  {
    Calendar localCalendar = Calendar.getInstance();
    int j = this.val$curIndex;
    int i = 8;
    while (j < this.this$0.xI.size())
    {
      localCalendar.setTimeInMillis(((Long)this.this$0.xI.get(j)).longValue());
      this.this$0.f(localCalendar);
      Pair localPair = this.this$0.a((Calendar)localCalendar.clone());
      int k = this.this$0.a(this.this$0.mFriendUin, ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
      if (i - k <= 0) {
        break;
      }
      j += 1;
      i -= k;
    }
    this.this$0.z(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.3
 * JD-Core Version:    0.7.0.1
 */