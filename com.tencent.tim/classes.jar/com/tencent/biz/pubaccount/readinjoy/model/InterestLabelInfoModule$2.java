package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lif;

public class InterestLabelInfoModule$2
  implements Runnable
{
  public void run()
  {
    if ((this.ie != null) && (!this.ie.isEmpty()))
    {
      lif.a(this.this$0).clear();
      Iterator localIterator = this.ie.iterator();
      while (localIterator.hasNext())
      {
        InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)localIterator.next();
        this.this$0.a(localInterestLabelInfo);
        lif.a(this.this$0).put(Integer.valueOf(localInterestLabelInfo.mInterestLabelID), localInterestLabelInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.2
 * JD-Core Version:    0.7.0.1
 */