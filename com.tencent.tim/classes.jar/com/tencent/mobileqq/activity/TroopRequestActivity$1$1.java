package com.tencent.mobileqq.activity;

import aqmj;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class TroopRequestActivity$1$1
  implements Runnable
{
  TroopRequestActivity$1$1(TroopRequestActivity.1 param1, Card paramCard) {}
  
  public void run()
  {
    if (this.a.this$0.isFinishing()) {}
    CardHandler localCardHandler;
    do
    {
      do
      {
        return;
        if (this.c != null) {
          TroopRequestActivity.a(this.a.this$0, this.c);
        }
      } while ((this.c != null) && (this.c.iQQLevel > 0));
      localCardHandler = (CardHandler)this.a.this$0.app.getBusinessHandler(2);
    } while (localCardHandler == null);
    byte b = (byte)aqmj.aG(this.a.this$0.getApplication(), this.a.this$0.app.getCurrentAccountUin());
    localCardHandler.a(this.a.this$0.app.getCurrentAccountUin(), this.a.this$0.mUserUin, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", 1L, 10004, new byte[] { 0 }, b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.1.1
 * JD-Core Version:    0.7.0.1
 */