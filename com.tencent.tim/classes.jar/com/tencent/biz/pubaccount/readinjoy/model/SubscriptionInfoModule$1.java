package com.tencent.biz.pubaccount.readinjoy.model;

import acja;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import liz;
import oan;

public class SubscriptionInfoModule$1
  implements Runnable
{
  public SubscriptionInfoModule$1(liz paramliz) {}
  
  public void run()
  {
    ((acja)this.this$0.mApp.getManager(56)).cLa();
    oan localoan = oan.a();
    localoan.ap((QQAppInterface)this.this$0.mApp);
    if (localoan.p((QQAppInterface)this.this$0.mApp)) {
      localoan.a(this.this$0.mEntityManager, (QQAppInterface)this.this$0.mApp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.1
 * JD-Core Version:    0.7.0.1
 */