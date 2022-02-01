package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import lbg;

public class DynamicChannelDataModule$10
  implements Runnable
{
  public DynamicChannelDataModule$10(lbg paramlbg, int paramInt) {}
  
  public void run()
  {
    boolean bool = lbg.a(this.this$0).execSQL("DELETE FROM " + DynamicChannelDataModel.class.getSimpleName() + " WHERE channelID = " + this.aHH);
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "clear dataModel from db, channelID = ", Integer.valueOf(this.aHH), ", res = ", Boolean.valueOf(bool) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.10
 * JD-Core Version:    0.7.0.1
 */