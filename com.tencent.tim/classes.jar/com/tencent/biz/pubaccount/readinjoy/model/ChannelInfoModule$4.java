package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.List;
import lcc;
import lho;
import liy;

public class ChannelInfoModule$4
  implements Runnable
{
  public ChannelInfoModule$4(lho paramlho, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (!this.val$success)
    {
      lcc.a().l(false, null);
      return;
    }
    liy.a().cy(this.hX);
    this.this$0.cv(this.hX);
    lcc.a().l(this.val$success, this.hX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.4
 * JD-Core Version:    0.7.0.1
 */