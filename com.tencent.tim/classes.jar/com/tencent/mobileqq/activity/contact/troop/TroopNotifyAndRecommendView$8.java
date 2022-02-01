package com.tencent.mobileqq.activity.contact.troop;

import acrp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import yvp;

class TroopNotifyAndRecommendView$8
  implements Runnable
{
  TroopNotifyAndRecommendView$8(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void run()
  {
    if (this.this$0.app != null) {
      this.this$0.app.a().a().cOd();
    }
    if ((TroopNotifyAndRecommendView.a(this.this$0) > 0) && (TroopNotifyAndRecommendView.a(this.this$0) != null) && (TroopNotifyAndRecommendView.a(this.this$0).getRealItemCount() > 0)) {
      TroopNotifyAndRecommendView.d(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8
 * JD-Core Version:    0.7.0.1
 */