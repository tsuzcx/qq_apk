package com.tencent.biz.pubaccount.readinjoy.ad.utils;

import com.tencent.mobileqq.webprocess.WebProcessManager;
import kkz;
import knq;

public final class ReadInJoyAdUtils$1
  implements Runnable
{
  public void run()
  {
    boolean bool = WebProcessManager.aFS();
    Object localObject = knq.get(2);
    if ((localObject != null) && ((localObject instanceof kkz))) {
      ((kkz)localObject).agf = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyAdUtils.1
 * JD-Core Version:    0.7.0.1
 */