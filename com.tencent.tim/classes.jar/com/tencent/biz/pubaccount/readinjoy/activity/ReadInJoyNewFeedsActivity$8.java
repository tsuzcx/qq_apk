package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;

class ReadInJoyNewFeedsActivity$8
  implements Runnable
{
  ReadInJoyNewFeedsActivity$8(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity, GuideData paramGuideData) {}
  
  public void run()
  {
    if ("operation_guide".equals(this.c.business))
    {
      this.this$0.a(271, this.c.business, this.c);
      return;
    }
    this.this$0.a(261, "", this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.8
 * JD-Core Version:    0.7.0.1
 */