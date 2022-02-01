package com.tencent.mobileqq.activity;

import acff;
import aqmj;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class LikeRankingListActivity$4
  implements Runnable
{
  LikeRankingListActivity$4(LikeRankingListActivity paramLikeRankingListActivity, String paramString) {}
  
  public void run()
  {
    Card localCard = this.this$0.f.b(this.val$uin);
    if (localCard != null) {
      this.this$0.e(localCard);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListActivity", 2, "update cover card = null");
    }
    byte b = (byte)aqmj.aG(this.this$0.getApplication(), this.this$0.app.getCurrentAccountUin());
    this.this$0.c.a(this.this$0.mSelfUin, this.val$uin, 1, 0L, (byte)1, 0L, 0L, null, "", 0L | 1L | 0x20 | 0x2000, 3022, null, b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.4
 * JD-Core Version:    0.7.0.1
 */