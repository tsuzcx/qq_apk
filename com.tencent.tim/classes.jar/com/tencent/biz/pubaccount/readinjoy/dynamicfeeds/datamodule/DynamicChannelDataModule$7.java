package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import java.util.List;
import lbe;
import lbg;

public class DynamicChannelDataModule$7
  implements Runnable
{
  public DynamicChannelDataModule$7(lbg paramlbg, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, List paramList) {}
  
  public void run()
  {
    if (this.aiR)
    {
      lbe.a().a(this.aHH, this.val$success, this.mt, this.gZ);
      return;
    }
    lbe.a().b(this.aHH, this.val$success, this.mt, this.gZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.7
 * JD-Core Version:    0.7.0.1
 */