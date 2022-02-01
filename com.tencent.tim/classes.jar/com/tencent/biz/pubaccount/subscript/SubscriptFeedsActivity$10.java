package com.tencent.biz.pubaccount.subscript;

import java.util.Iterator;
import java.util.List;
import oal;

class SubscriptFeedsActivity$10
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.val$list.iterator();
    while (localIterator.hasNext())
    {
      oal localoal = (oal)localIterator.next();
      if (localoal.aOr > 0) {
        localoal.bcT();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.10
 * JD-Core Version:    0.7.0.1
 */