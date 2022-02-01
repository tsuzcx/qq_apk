package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import jxo;
import kew;

public class AdvertisementVideoPreloadManager$3
  implements Runnable
{
  public AdvertisementVideoPreloadManager$3(jxo paramjxo) {}
  
  public void run()
  {
    kew localkew = jxo.a(this.this$0);
    if (localkew != null)
    {
      localkew.lY(PAAdPreloadTask.class.getSimpleName());
      Iterator localIterator = jxo.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        localkew.a((PAAdPreloadTask)localIterator.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.3
 * JD-Core Version:    0.7.0.1
 */