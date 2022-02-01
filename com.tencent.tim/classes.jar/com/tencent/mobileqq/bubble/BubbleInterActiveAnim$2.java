package com.tencent.mobileqq.bubble;

import adxm;
import adxp;
import adxq;
import adyc;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import wja;

public class BubbleInterActiveAnim$2
  implements Runnable
{
  public BubbleInterActiveAnim$2(adxq paramadxq, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = wja.a(wja.a(adxq.a(this.this$0), wja.a(this.VJ, adxq.b(this.this$0).getAdapter())));
    if ((localObject1 != null) && ((localObject1 instanceof BaseBubbleBuilder.e))) {}
    for (localObject1 = (BaseBubbleBuilder.e)localObject1;; localObject1 = null)
    {
      Object localObject4 = wja.a(wja.a(adxq.c(this.this$0), wja.a(this.EC, adxq.d(this.this$0).getAdapter())));
      Object localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject2 = localObject3;
        if ((localObject4 instanceof BaseBubbleBuilder.e)) {
          localObject2 = (BaseBubbleBuilder.e)localObject4;
        }
      }
      if ((localObject1 == null) || (localObject2 == null) || (((BaseBubbleBuilder.e)localObject1).b == null) || (((BaseBubbleBuilder.e)localObject2).b == null)) {
        return;
      }
      int i;
      if ((this.this$0.b.aN(((BaseBubbleBuilder.e)localObject1).b.bubbleId, 8)) && (this.this$0.b.aN(((BaseBubbleBuilder.e)localObject2).b.bubbleId, 8))) {
        i = 1;
      }
      while (i != 0)
      {
        localObject3 = new Pair(Long.valueOf(this.VJ), Long.valueOf(this.EC));
        localObject4 = this.this$0.mAnimHandler.obtainMessage(1);
        ((Message)localObject4).obj = localObject3;
        this.this$0.mAnimHandler.sendMessage((Message)localObject4);
        localObject4 = this.this$0.b.a(((BaseBubbleBuilder.e)localObject1).b.bubbleId, false);
        localObject3 = this.this$0.b.a(((BaseBubbleBuilder.e)localObject2).b.bubbleId, false);
        localObject4 = ((adxm)localObject4).jO.values().iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            this.this$0.a((adyc)((Iterator)localObject4).next(), ((BaseBubbleBuilder.e)localObject1).b.bubbleId);
            continue;
            i = 0;
            break;
          }
        }
        this.this$0.a((adyc)((adxm)localObject3).jO.get("passive_animation"), ((BaseBubbleBuilder.e)localObject2).b.bubbleId);
        return;
      }
      QLog.e("BubbleInterActiveAnim", 1, "resource is not all ready, originalMsg: " + this.this$0.b.aN(((BaseBubbleBuilder.e)localObject1).b.bubbleId, 8) + ", target msg: " + this.this$0.b.aN(((BaseBubbleBuilder.e)localObject2).b.bubbleId, 8));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.2
 * JD-Core Version:    0.7.0.1
 */