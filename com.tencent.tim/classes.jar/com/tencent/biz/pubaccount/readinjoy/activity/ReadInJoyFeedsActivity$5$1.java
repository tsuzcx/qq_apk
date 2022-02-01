package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import khz;

public class ReadInJoyFeedsActivity$5$1
  implements Runnable
{
  public ReadInJoyFeedsActivity$5$1(khz paramkhz) {}
  
  public void run()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.a.this$0.app.getManager(162);
    if (localKandianMergeManager != null) {
      localKandianMergeManager.aIJ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity.5.1
 * JD-Core Version:    0.7.0.1
 */