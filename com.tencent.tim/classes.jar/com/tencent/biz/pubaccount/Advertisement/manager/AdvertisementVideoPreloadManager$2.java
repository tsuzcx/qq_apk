package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import jxo;

public class AdvertisementVideoPreloadManager$2
  implements Runnable
{
  public AdvertisementVideoPreloadManager$2(jxo paramjxo, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.jC.iterator();
    while (localIterator.hasNext()) {
      jxo.ly(((PAAdPreloadTask)localIterator.next()).mVideoVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.2
 * JD-Core Version:    0.7.0.1
 */