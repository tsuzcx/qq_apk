package com.tencent.mobileqq.activity;

import adue;
import android.os.SystemClock;
import aqmq;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;
import pvz;
import usm;

public class Conversation$31$1
  implements Runnable
{
  public Conversation$31$1(usm paramusm, boolean paramBoolean) {}
  
  public void run()
  {
    this.a.this$0.wK(true);
    if (this.a.this$0.aUR)
    {
      Conversation.a(this.a.this$0, 800L);
      Object localObject;
      label108:
      adue localadue;
      if (this.a.this$0.f != null)
      {
        localObject = this.a.this$0.f;
        if (this.val$isSuccess)
        {
          i = 0;
          ((PullRefreshHeader)localObject).tT(i);
        }
      }
      else
      {
        if (this.a.this$0.b != null)
        {
          localObject = this.a.this$0.b;
          if (!this.val$isSuccess) {
            break label185;
          }
          i = 0;
          ((pvz)localObject).tT(i);
        }
        if (this.a.this$0.pb == null) {
          break label195;
        }
        localObject = this.a.this$0.pb.iterator();
        label140:
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localadue = (adue)((Iterator)localObject).next();
        } while (localadue == null);
        if (!this.val$isSuccess) {
          break label190;
        }
      }
      label185:
      label190:
      for (int i = 0;; i = 2)
      {
        localadue.Lz(i);
        break label140;
        i = 2;
        break;
        i = 2;
        break label108;
      }
    }
    label195:
    if (this.a.this$0.FM > 0L) {
      aqmq.br("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.a.this$0.FM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.31.1
 * JD-Core Version:    0.7.0.1
 */