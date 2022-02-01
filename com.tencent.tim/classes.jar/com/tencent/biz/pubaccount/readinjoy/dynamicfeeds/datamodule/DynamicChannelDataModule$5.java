package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;
import lbg;

public class DynamicChannelDataModule$5
  implements Runnable
{
  public DynamicChannelDataModule$5(lbg paramlbg, int paramInt1, long paramLong, int paramInt2) {}
  
  public void run()
  {
    Object localObject = lbg.a(this.this$0);
    int i = this.aHH;
    long l = this.tl;
    int j = this.val$count;
    localObject = ((EntityManager)localObject).query(DynamicChannelDataModel.class, true, "channelID = ? and recommendSeq > ?", new String[] { String.valueOf(i), String.valueOf(l) }, null, null, "recommendSeq asc", String.valueOf(j));
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      lbg.a(this.this$0, this.aHH, 0);
      return;
    }
    localObject = lbg.a(this.this$0, this.aHH, (List)localObject, false);
    lbg.a(this.this$0, false, this.aHH, true, true, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.5
 * JD-Core Version:    0.7.0.1
 */