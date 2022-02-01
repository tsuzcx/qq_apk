package com.tencent.mobileqq.pic;

import akxl;
import akxq;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class PicPreDownloader$5
  implements Runnable
{
  PicPreDownloader$5(PicPreDownloader paramPicPreDownloader, int paramInt) {}
  
  public void run()
  {
    int k = 0;
    for (;;)
    {
      int j;
      int i;
      akxq localakxq;
      synchronized (this.this$0.Es)
      {
        Iterator localIterator = this.this$0.Es.iterator();
        j = 0;
        i = 0;
        if (!localIterator.hasNext()) {
          break label310;
        }
        localakxq = (akxq)localIterator.next();
        switch (localakxq.dpG)
        {
        case 4: 
          k += 1;
          localakxq.priority = localakxq.dpG;
          this.this$0.mp.put(localakxq.a.uuid, Integer.valueOf(localakxq.priority));
          this.this$0.Ev.add(0, localakxq);
          localakxq.priority = localakxq.dpG;
          this.this$0.mp.put(localakxq.a.uuid, Integer.valueOf(localakxq.priority));
        }
      }
      i += 1;
      localakxq.priority = localakxq.dpG;
      this.this$0.mp.put(localakxq.a.uuid, Integer.valueOf(localakxq.priority));
      this.this$0.Et.add(0, localakxq);
      continue;
      j += 1;
      localakxq.priority = localakxq.dpG;
      this.this$0.mp.put(localakxq.a.uuid, Integer.valueOf(localakxq.priority));
      this.this$0.Eu.add(0, localakxq);
      continue;
      label310:
      this.this$0.Es.clear();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): totalCount=" + this.val$size + " countOfC2C=" + i + " countOfDiscussion=" + j + " countOfGroup=" + k);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */