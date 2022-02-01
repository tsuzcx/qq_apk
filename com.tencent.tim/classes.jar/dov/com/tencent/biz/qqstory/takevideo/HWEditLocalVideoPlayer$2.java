package dov.com.tencent.biz.qqstory.takevideo;

import acbn;
import android.os.SystemClock;
import ayzb;
import ayzc;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
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
        break label665;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.this$0.mLocalMediaInfo.mDuration / l1)
      {
        ((ArrayList)localObject1).add(new rpv.a(i * l1, l1));
        i += 1;
      }
    }
    label648:
    label665:
    for (;;)
    {
      if (((ArrayList)localObject1).size() <= 0) {
        ((ArrayList)localObject1).add(new rpv.a(0L, this.this$0.mLocalMediaInfo.mDuration));
      }
      long l3 = SystemClock.uptimeMillis();
      i = 0;
      Object localObject2;
      long l4;
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (rpv.a)((ArrayList)localObject1).get(i);
        l4 = SystemClock.uptimeMillis();
        long l2 = Math.min(((rpv.a)localObject2).startTimeMs + ((rpv.a)localObject2).duration, this.this$0.mLocalMediaInfo.mDuration);
        l1 = l2;
        if (1000L + l2 > this.this$0.mLocalMediaInfo.mDuration) {
          l1 = this.this$0.mLocalMediaInfo.mDuration;
        }
        if (i == 5) {
          l1 = this.this$0.mLocalMediaInfo.mDuration;
        }
      }
      for (;;)
      {
        int j;
        try
        {
          HWEditLocalVideoPlayer.a locala = new HWEditLocalVideoPlayer.a(i, ayzc.l(HWEditLocalVideoPlayer.a(this.this$0), (int)((rpv.a)localObject2).startTimeMs));
          HWEditLocalVideoPlayer.a.a(locala, ((rpv.a)localObject2).startTimeMs);
          HWEditLocalVideoPlayer.a.b(locala, l1);
          this.this$0.oG.add(locala);
          ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info = %s, cost = %dms", locala, Long.valueOf(SystemClock.uptimeMillis() - l4));
          if (l1 >= this.this$0.mLocalMediaInfo.mDuration)
          {
            ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.oG.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
            i = 0;
            if (i >= this.this$0.oG.size()) {
              break label648;
            }
            localObject1 = (HWEditLocalVideoPlayer.a)this.this$0.oG.get(i);
            localObject2 = rox.gl(HWEditLocalVideoPlayer.a(this.this$0));
            localObject2 = acbn.bnb + (String)localObject2 + "_" + i + ".IFrames.audio";
            HWEditLocalVideoPlayer.a(this.this$0, (String)localObject2);
            j = ayzb.a(HWEditLocalVideoPlayer.b(this.this$0), (String)localObject2, (float)HWEditLocalVideoPlayer.a.a((HWEditLocalVideoPlayer.a)localObject1) * 1.0F / (float)this.this$0.mLocalMediaInfo.mDuration, (float)HWEditLocalVideoPlayer.a.b((HWEditLocalVideoPlayer.a)localObject1) * 1.0F / (float)this.this$0.mLocalMediaInfo.mDuration);
            if (j != 0) {
              break label584;
            }
            ram.d("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
            ((HWEditLocalVideoPlayer.a)localObject1).azV = ((String)localObject2);
            i += 1;
            continue;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          QLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", 1, localRuntimeException, new Object[0]);
          continue;
          i += 1;
        }
        break;
        label584:
        ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localRuntimeException, Long.valueOf(this.this$0.mLocalMediaInfo.mDuration), Long.valueOf(HWEditLocalVideoPlayer.a.a((HWEditLocalVideoPlayer.a)localObject1)), Long.valueOf(HWEditLocalVideoPlayer.a.b((HWEditLocalVideoPlayer.a)localObject1)) });
      }
      this.this$0.l(new HWEditLocalVideoPlayer.2.1(this), 0L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */