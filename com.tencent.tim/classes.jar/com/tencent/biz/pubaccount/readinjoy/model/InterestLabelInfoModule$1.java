package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;
import lif;

public class InterestLabelInfoModule$1
  implements Runnable
{
  public InterestLabelInfoModule$1(lif paramlif) {}
  
  public void run()
  {
    List localList = this.this$0.mEntityManager.query(InterestLabelInfo.class, true, null, null, null, null, null, null);
    this.this$0.cw(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.1
 * JD-Core Version:    0.7.0.1
 */