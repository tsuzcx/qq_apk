package com.tencent.biz.TroopRedpoint;

import acbn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.qphone.base.util.QLog;
import jnv;

public class TroopRedTouchManager$2
  implements Runnable
{
  public TroopRedTouchManager$2(jnv paramjnv, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.this$0.aCp = MsgBoxListActivity.f(this.val$app, acbn.bkF, true);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "asyn nearbyMsgBoxUnReadNum=" + this.this$0.aCp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.2
 * JD-Core Version:    0.7.0.1
 */