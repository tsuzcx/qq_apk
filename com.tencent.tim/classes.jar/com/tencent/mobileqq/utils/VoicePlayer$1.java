package com.tencent.mobileqq.utils;

import android.os.Handler;
import aqnt;
import aqnt.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VoicePlayer$1
  implements Runnable
{
  int eag = 0;
  
  public VoicePlayer$1(aqnt paramaqnt) {}
  
  public void run()
  {
    if ((aqnt.a(this.this$0) == 4) || (aqnt.a(this.this$0) == 5) || (aqnt.a(this.this$0) == 6) || (aqnt.a(this.this$0) == 8)) {
      this.eag = 0;
    }
    do
    {
      return;
      if (aqnt.a(this.this$0) == 3)
      {
        this.eag = aqnt.b(this.this$0);
        return;
      }
    } while (aqnt.a(this.this$0) == null);
    int k = aqnt.c(this.this$0);
    int i = aqnt.b(this.this$0);
    if (i < this.eag) {
      i = this.eag;
    }
    for (;;)
    {
      int j = k;
      if (this.eag != 0)
      {
        j = k;
        if (this.eag == i)
        {
          j = k;
          if (this.eag > k - 200)
          {
            QLog.d("Q.profilecard.VoicePlayer", 2, "change duration from " + i + " to " + i);
            j = i;
          }
        }
      }
      if (i > this.eag) {
        this.eag = i;
      }
      Iterator localIterator = aqnt.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((aqnt.a)localIterator.next()).c(aqnt.a(this.this$0), j, i);
      }
      if (aqnt.a(this.this$0) == null) {
        break;
      }
      aqnt.a(this.this$0).postDelayed(this, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */