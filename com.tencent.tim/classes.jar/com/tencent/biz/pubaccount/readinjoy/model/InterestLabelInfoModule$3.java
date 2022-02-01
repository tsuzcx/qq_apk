package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import java.util.Iterator;
import java.util.List;
import lcc;
import lif;

public class InterestLabelInfoModule$3
  implements Runnable
{
  public InterestLabelInfoModule$3(lif paramlif, List paramList) {}
  
  public void run()
  {
    lif.a(this.this$0).clear();
    Iterator localIterator = this.ie.iterator();
    while (localIterator.hasNext())
    {
      InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)localIterator.next();
      lif.a(this.this$0).add(localInterestLabelInfo);
    }
    lcc.a().cc(lif.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.3
 * JD-Core Version:    0.7.0.1
 */