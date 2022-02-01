package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.List;
import kxm;
import lcc;
import lho;
import liy;

public class ChannelInfoModule$5
  implements Runnable
{
  public ChannelInfoModule$5(lho paramlho, boolean paramBoolean1, boolean paramBoolean2, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (!this.val$success)
    {
      lcc.a().k(false, null);
      return;
    }
    if (this.akl)
    {
      lcc.a().k(true, this.hW);
      return;
    }
    lho.a(this.this$0, true);
    this.this$0.a(this.hW, true);
    this.this$0.cv(this.hY);
    if (!kxm.AI())
    {
      List localList = this.this$0.O(this.hW);
      liy.a().cy(this.hY);
      liy.a().cz(localList);
      localList = this.this$0.aO();
      if (!this.hY.equals(localList)) {
        this.this$0.cu(this.this$0.aO());
      }
    }
    lcc.a().j(true, this.this$0.aM());
    if (!kxm.AI())
    {
      lcc.a().k(true, this.this$0.aN());
      return;
    }
    lcc.a().k(true, this.hW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.5
 * JD-Core Version:    0.7.0.1
 */