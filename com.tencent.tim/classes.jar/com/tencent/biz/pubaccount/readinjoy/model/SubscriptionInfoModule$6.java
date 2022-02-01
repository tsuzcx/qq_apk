package com.tencent.biz.pubaccount.readinjoy.model;

import aalb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import liz;
import ocp;

public class SubscriptionInfoModule$6
  implements Runnable
{
  public SubscriptionInfoModule$6(liz paramliz, String paramString) {}
  
  public void run()
  {
    int i = ocp.e((QQAppInterface)this.this$0.mApp, this.val$uin);
    aalb.l((QQAppInterface)this.this$0.mApp, this.val$uin, i);
    ((QQAppInterface)this.this$0.mApp).b().ca(this.val$uin, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.6
 * JD-Core Version:    0.7.0.1
 */