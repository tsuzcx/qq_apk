package com.tencent.biz.pubaccount.Advertisement.manager;

import java.util.ArrayList;
import java.util.Iterator;
import jxc;
import jxd;
import jxl;
import jxo;

public class AdvertisementRecentUserManager$1
  implements Runnable
{
  public AdvertisementRecentUserManager$1(jxl paramjxl, jxc paramjxc) {}
  
  public void run()
  {
    Iterator localIterator = this.b.jw.iterator();
    while (localIterator.hasNext()) {
      jxo.ly(((jxd)localIterator.next()).UC);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager.1
 * JD-Core Version:    0.7.0.1
 */