package dov.com.tencent.biz.qqstory.takevideo;

import acbn;
import alwy;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import ayis;
import ayis.a;
import aypl;
import ayzb;
import ayzc;
import ayzc.a;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.List;
import ram;
import rop;
import rox;
import rpv;
import rpv.a;

public class HWEditImportVideoPlayer$2
  implements Runnable
{
  public HWEditImportVideoPlayer$2(ayis paramayis) {}
  
  public void run()
  {
    ram.w("Q.qqstory.record.HWEditImportVideoPlayer", "thumb get start");
    if (this.this$0.aHm) {}
    Object localObject2;
    int i;
    for (long l1 = 10000L;; l1 = 2147483647L)
    {
      localObject2 = rpv.b(ayis.a(this.this$0), l1);
      if (localObject2 != null) {
        break label956;
      }
      localObject2 = new ArrayList();
      i = 0;
      while (i < this.this$0.mLocalMediaInfo.mDuration / l1)
      {
        ((ArrayList)localObject2).add(new rpv.a(i * l1, l1));
        i += 1;
      }
    }
    label687:
    label956:
    for (;;)
    {
      if (((ArrayList)localObject2).size() <= 0) {
        ((ArrayList)localObject2).add(new rpv.a(0L, this.this$0.mLocalMediaInfo.mDuration));
      }
      long l3 = SystemClock.uptimeMillis();
      i = 0;
      Object localObject1;
      int j;
      if (i < ((ArrayList)localObject2).size())
      {
        localObject1 = (rpv.a)((ArrayList)localObject2).get(i);
        long l4 = SystemClock.uptimeMillis();
        long l2 = Math.min(ayis.a(this.this$0) + ((rpv.a)localObject1).duration, this.this$0.mLocalMediaInfo.mDuration);
        l1 = l2;
        if (1000L + l2 > this.this$0.mLocalMediaInfo.mDuration) {
          l1 = this.this$0.mLocalMediaInfo.mDuration;
        }
        if (i == 5) {
          l1 = this.this$0.mLocalMediaInfo.mDuration;
        }
        Object localObject3 = ayzc.l(ayis.a(this.this$0), ayis.a(this.this$0));
        localObject1 = localObject3;
        if (i == 0)
        {
          localObject1 = localObject3;
          if (localObject3 != null)
          {
            float f = aypl.a((Bitmap)localObject3);
            ram.d("Q.qqstory.record.HWEditImportVideoPlayer", "blackPrecent = %f start fix black frame.", Float.valueOf(f));
            localObject1 = localObject3;
            if (f > 0.9F)
            {
              ayzc.a locala = ayzc.a(ayis.a(this.this$0), ayis.a(this.this$0));
              localObject1 = localObject3;
              if (locala.thumbnail != null)
              {
                localObject1 = localObject3;
                if (locala.Ce > 0L)
                {
                  localObject1 = localObject3;
                  if (aypl.a(locala.thumbnail) <= 0.9F)
                  {
                    if (!((Bitmap)localObject3).isRecycled()) {
                      ((Bitmap)localObject3).recycle();
                    }
                    localObject1 = locala.thumbnail;
                    ayis.a(this.this$0, (int)(locala.Ce / 1000L));
                    ram.w("Q.qqstory.record.HWEditImportVideoPlayer", "Fix black frame. adjust star time to " + ayis.a(this.this$0));
                  }
                }
              }
            }
          }
        }
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          j = alwy.iN(((Bitmap)localObject1).getWidth());
          int k = alwy.iN(((Bitmap)localObject1).getHeight());
          if (j == ((Bitmap)localObject1).getWidth())
          {
            localObject3 = localObject1;
            if (k == ((Bitmap)localObject1).getHeight()) {}
          }
          else
          {
            ram.w("Q.qqstory.record.HWEditImportVideoPlayer", "origin bitmap width:%d, height:%d, should change size to w:%d, h:%d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()), Integer.valueOf(j), Integer.valueOf(j) });
            localObject3 = rop.a((Bitmap)localObject1, new Rect(0, 0, j, k), true);
          }
        }
        localObject1 = new ayis.a(i, (Bitmap)localObject3);
        ayis.a.a((ayis.a)localObject1, ayis.a(this.this$0));
        ayis.a.b((ayis.a)localObject1, ayis.b(this.this$0));
        this.this$0.oG.add(localObject1);
        ram.d("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info = %s, cost = %dms", localObject1, Long.valueOf(SystemClock.uptimeMillis() - l4));
        if (l1 < this.this$0.mLocalMediaInfo.mDuration) {}
      }
      else
      {
        ram.d("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.oG.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
        i = 0;
        if (i >= this.this$0.oG.size()) {
          break label939;
        }
        localObject1 = (ayis.a)this.this$0.oG.get(i);
        localObject2 = rox.gl(ayis.a(this.this$0));
        localObject2 = acbn.bnb + (String)localObject2 + "_" + i + ".IFrames.audio";
        j = ayzb.a(ayis.b(this.this$0), (String)localObject2, (float)ayis.a.a((ayis.a)localObject1) * 1.0F / (float)this.this$0.mLocalMediaInfo.mDuration, (float)ayis.a.b((ayis.a)localObject1) * 1.0F / (float)this.this$0.mLocalMediaInfo.mDuration);
        if (j != 0) {
          break label874;
        }
        ram.d("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile finished audioFilePath" + (String)localObject2);
        ((ayis.a)localObject1).azV = ((String)localObject2);
      }
      for (;;)
      {
        i += 1;
        break label687;
        i += 1;
        break;
        label874:
        ram.e("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localObject2, Long.valueOf(this.this$0.mLocalMediaInfo.mDuration), Long.valueOf(ayis.a.a((ayis.a)localObject1)), Long.valueOf(ayis.a.b((ayis.a)localObject1)) });
      }
      this.this$0.l(new HWEditImportVideoPlayer.2.1(this), 0L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */