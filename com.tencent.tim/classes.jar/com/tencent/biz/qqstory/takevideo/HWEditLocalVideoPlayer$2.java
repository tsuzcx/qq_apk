package com.tencent.biz.qqstory.takevideo;

import acbn;
import ambc;
import ambd;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.List;
import ram;
import rox;
import rpv;
import rpv.a;

class HWEditLocalVideoPlayer$2
  implements Runnable
{
  HWEditLocalVideoPlayer$2(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    if (this.this$0.aHm) {}
    Object localObject1;
    int i;
    for (long l1 = 10000L;; l1 = 2147483647L)
    {
      localObject1 = null;
      if (this.this$0.aHm) {
        localObject1 = rpv.b(HWEditLocalVideoPlayer.a(this.this$0), l1);
      }
      if (localObject1 != null) {
        break label641;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.this$0.mLocalMediaInfo.mDuration / l1)
      {
        ((ArrayList)localObject1).add(new rpv.a(i * l1, l1));
        i += 1;
      }
    }
    label641:
    for (;;)
    {
      if (((ArrayList)localObject1).size() <= 0) {
        ((ArrayList)localObject1).add(new rpv.a(0L, this.this$0.mLocalMediaInfo.mDuration));
      }
      long l3 = SystemClock.uptimeMillis();
      i = 0;
      Object localObject2;
      label371:
      int j;
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (rpv.a)((ArrayList)localObject1).get(i);
        long l4 = SystemClock.uptimeMillis();
        long l2 = Math.min(((rpv.a)localObject2).startTimeMs + ((rpv.a)localObject2).duration, this.this$0.mLocalMediaInfo.mDuration);
        l1 = l2;
        if (1000L + l2 > this.this$0.mLocalMediaInfo.mDuration) {
          l1 = this.this$0.mLocalMediaInfo.mDuration;
        }
        if (i == 5) {
          l1 = this.this$0.mLocalMediaInfo.mDuration;
        }
        HWEditLocalVideoPlayer.a locala = new HWEditLocalVideoPlayer.a(i, ambd.l(HWEditLocalVideoPlayer.a(this.this$0), (int)((rpv.a)localObject2).startTimeMs));
        HWEditLocalVideoPlayer.a.a(locala, ((rpv.a)localObject2).startTimeMs);
        HWEditLocalVideoPlayer.a.b(locala, l1);
        this.this$0.oG.add(locala);
        ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "create FRAGMENT info = %s, cost = %dms", locala, Long.valueOf(SystemClock.uptimeMillis() - l4));
        if (l1 < this.this$0.mLocalMediaInfo.mDuration) {}
      }
      else
      {
        ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.oG.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
        i = 0;
        if (i >= this.this$0.oG.size()) {
          break label621;
        }
        localObject1 = (HWEditLocalVideoPlayer.a)this.this$0.oG.get(i);
        localObject2 = rox.gl(HWEditLocalVideoPlayer.a(this.this$0));
        localObject2 = acbn.bnb + (String)localObject2 + "_" + i + ".IFrames.audio";
        j = ambc.a(HWEditLocalVideoPlayer.b(this.this$0), (String)localObject2, (float)HWEditLocalVideoPlayer.a.a((HWEditLocalVideoPlayer.a)localObject1) * 1.0F / (float)this.this$0.mLocalMediaInfo.mDuration, (float)HWEditLocalVideoPlayer.a.b((HWEditLocalVideoPlayer.a)localObject1) * 1.0F / (float)this.this$0.mLocalMediaInfo.mDuration);
        if (j != 0) {
          break label557;
        }
        ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
        ((HWEditLocalVideoPlayer.a)localObject1).azV = ((String)localObject2);
      }
      for (;;)
      {
        i += 1;
        break label371;
        i += 1;
        break;
        label557:
        ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localObject2, Long.valueOf(this.this$0.mLocalMediaInfo.mDuration), Long.valueOf(HWEditLocalVideoPlayer.a.a((HWEditLocalVideoPlayer.a)localObject1)), Long.valueOf(HWEditLocalVideoPlayer.a.b((HWEditLocalVideoPlayer.a)localObject1)) });
      }
      label621:
      HWEditLocalVideoPlayer.a(this.this$0).post(new HWEditLocalVideoPlayer.2.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */