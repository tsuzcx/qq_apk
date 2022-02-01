package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import mqq.os.MqqHandler;

class TroopRequestActivity$1
  implements Runnable
{
  TroopRequestActivity$1(TroopRequestActivity paramTroopRequestActivity, acff paramacff) {}
  
  public void run()
  {
    Card localCard = this.d.b(this.this$0.mUserUin);
    ThreadManager.getUIHandler().post(new TroopRequestActivity.1.1(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.1
 * JD-Core Version:    0.7.0.1
 */