package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class AccountOnlineStateActivity$3
  implements Runnable
{
  AccountOnlineStateActivity$3(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void run()
  {
    CardHandler localCardHandler = (CardHandler)AccountOnlineStateActivity.a(this.this$0).getBusinessHandler(2);
    if (localCardHandler != null) {
      localCardHandler.cHO();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.3
 * JD-Core Version:    0.7.0.1
 */