package com.tencent.mobileqq.businessCard.activity;

import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;

class BusinessCardEditActivity$11
  implements Runnable
{
  BusinessCardEditActivity$11(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void run()
  {
    if (this.this$0.b != null) {
      BusinessCardEditActivity.a(this.this$0, this.this$0.b.cardName, this.this$0.b.company, this.this$0.b.mobilesNum);
    }
    while (this.this$0.a == null) {
      return;
    }
    BusinessCardEditActivity.a(this.this$0, this.this$0.a.name, null, this.this$0.a.mobilesNum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.11
 * JD-Core Version:    0.7.0.1
 */