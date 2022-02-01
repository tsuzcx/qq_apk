package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;
import lbg;

public class DynamicChannelDataModule$2
  implements Runnable
{
  public DynamicChannelDataModule$2(lbg paramlbg, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = lbg.a(this.this$0);
    int i = this.aHH;
    int j = this.val$count;
    localObject = ((EntityManager)localObject).query(DynamicChannelDataModel.class, true, "channelID = ?", new String[] { String.valueOf(i) }, null, null, "recommendSeq asc", String.valueOf(j));
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      lbg.a(this.this$0, this.aHH, 2);
      return;
    }
    localObject = lbg.a(this.this$0, this.aHH, (List)localObject, false);
    lbg.a(this.this$0).post(new DynamicChannelDataModule.2.1(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.2
 * JD-Core Version:    0.7.0.1
 */